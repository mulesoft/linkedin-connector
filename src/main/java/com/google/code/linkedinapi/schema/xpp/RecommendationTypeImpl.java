/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package com.google.code.linkedinapi.schema.xpp;

import com.google.code.linkedinapi.schema.RecommendationCode;
import com.google.code.linkedinapi.schema.RecommendationType;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;

public class RecommendationTypeImpl
        extends BaseSchemaEntity
        implements RecommendationType {

    private final static long serialVersionUID = 2461660169443089969L;
    protected RecommendationCode code;

    public RecommendationCode getCode() {
        return code;
    }

    public void setCode(RecommendationCode value) {
        this.code = value;
    }

    @Override
    public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);

        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();

            if (name.equals("code")) {
                setCode(RecommendationCode.fromValue(XppUtils.getElementValueFromNode(parser)));
            } else {
                // Consume something we don't understand.
                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
        }
    }

    @Override
    public void toXml(XmlSerializer serializer) throws IOException {
        XmlSerializer element = serializer.startTag(null, "recommendation-type");
        XppUtils.setElementValueToNode(element, "code", getCode().value());
        element.endTag(null, "recommendation-type");
    }
}
