/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package com.google.code.linkedinapi.schema.xpp;

import com.google.code.linkedinapi.schema.Buckets;
import com.google.code.linkedinapi.schema.Facet;
import com.google.code.linkedinapi.schema.FacetType;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;

public class FacetImpl
        extends BaseSchemaEntity
        implements Facet {

    private final static long serialVersionUID = 2461660169443089969L;
    protected String name;
    protected FacetType code;
    protected BucketsImpl buckets;

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public FacetType getCode() {
        return code;
    }

    public void setCode(FacetType value) {
        this.code = value;
    }

    public Buckets getBuckets() {
        return buckets;
    }

    public void setBuckets(Buckets value) {
        this.buckets = ((BucketsImpl) value);
    }

    @Override
    public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);

        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();

            if (name.equals("code")) {
                setCode(FacetType.fromValue(XppUtils.getElementValueFromNode(parser)));
            } else if (name.equals("name")) {
                setName(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("buckets")) {
                BucketsImpl buckets = new BucketsImpl();
                buckets.init(parser);
                setBuckets(buckets);
            } else {
                // Consume something we don't understand.
                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
        }
    }

    @Override
    public void toXml(XmlSerializer serializer) throws IOException {
        XmlSerializer element = serializer.startTag(null, "facet");
        XppUtils.setElementValueToNode(element, "name", getName());
        XppUtils.setElementValueToNode(element, "code", getCode().value());
        if (getBuckets() != null) {
            ((BucketsImpl) getBuckets()).toXml(serializer);
        }
        serializer.endTag(null, "facet");
    }
}
