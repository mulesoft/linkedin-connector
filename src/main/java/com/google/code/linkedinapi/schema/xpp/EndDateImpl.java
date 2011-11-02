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

import com.google.code.linkedinapi.schema.EndDate;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;

public class EndDateImpl
        extends BaseSchemaEntity
        implements EndDate {

    /**
     *
     */
    private static final long serialVersionUID = -8815338299095045227L;
    protected Long year;
    protected Long month;
    protected Long day;

    public Long getYear() {
        return year;
    }

    public void setYear(Long value) {
        this.year = value;
    }

    public Long getMonth() {
        return month;
    }

    public void setMonth(Long value) {
        this.month = value;
    }

    public Long getDay() {
        return day;
    }

    public void setDay(Long value) {
        this.day = value;
    }

    @Override
    public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);

        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();

            if (name.equals("year")) {
                setYear(XppUtils.getElementValueAsLongFromNode(parser));
            } else if (name.equals("month")) {
                setMonth(XppUtils.getElementValueAsLongFromNode(parser));
            } else if (name.equals("day")) {
                setDay(XppUtils.getElementValueAsLongFromNode(parser));
            } else {
                // Consume something we don't understand.
                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
        }
    }

    @Override
    public void toXml(XmlSerializer serializer) throws IOException {
        XmlSerializer element = serializer.startTag(null, "end-date");
        XppUtils.setElementValueToNode(element, "month", getMonth());
        XppUtils.setElementValueToNode(element, "year", getYear());
        XppUtils.setElementValueToNode(element, "day", getDay());
        serializer.endTag(null, "end-date");
    }
}
