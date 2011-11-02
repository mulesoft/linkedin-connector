/**
 * Mule LinkedIn Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package com.google.code.linkedinapi.schema.xpp;

import com.google.code.linkedinapi.schema.Company;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;

public class CompanyImpl
        extends BaseSchemaEntity
        implements Company {

    /**
     *
     */
    private static final long serialVersionUID = -6951793253375914262L;
    protected String type;
    protected String name;
    protected String industry;
    protected Long size;
    protected String ticker;

    public String getType() {
        return type;
    }

    public void setType(String value) {
        this.type = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String value) {
        this.industry = value;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long value) {
        this.size = value;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String value) {
        this.ticker = value;
    }

    @Override
    public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);

        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();

            if (name.equals("name")) {
                setName(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("type")) {
                setType(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("industry")) {
                setIndustry(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("size")) {
                setSize(XppUtils.getElementValueAsLongFromNode(parser));
            } else if (name.equals("ticker")) {
                setTicker(XppUtils.getElementValueFromNode(parser));
            } else {
                // Consume something we don't understand.
                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
        }
    }

    @Override
    public void toXml(XmlSerializer serializer) throws IOException {
        XmlSerializer element = serializer.startTag(null, "company");
        XppUtils.setElementValueToNode(element, "name", getName());
        XppUtils.setElementValueToNode(element, "type", getType());
        XppUtils.setElementValueToNode(element, "industry", getIndustry());
        XppUtils.setElementValueToNode(element, "size", getSize());
        XppUtils.setElementValueToNode(element, "ticker", getTicker());
        serializer.endTag(null, "company");
    }
}
