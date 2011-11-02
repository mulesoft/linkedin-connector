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

import com.google.code.linkedinapi.schema.Authority;
import com.google.code.linkedinapi.schema.Certification;
import com.google.code.linkedinapi.schema.EndDate;
import com.google.code.linkedinapi.schema.StartDate;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;

public class CertificationImpl
        extends BaseSchemaEntity
        implements Certification {

    private final static long serialVersionUID = 2461660169443089969L;
    protected String id;
    protected String name;
    protected AuthorityImpl authority;
    protected String number;
    protected StartDateImpl startDate;
    protected EndDateImpl endDate;

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority value) {
        this.authority = ((AuthorityImpl) value);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String value) {
        this.number = value;
    }

    public StartDate getStartDate() {
        return startDate;
    }

    public void setStartDate(StartDate value) {
        this.startDate = ((StartDateImpl) value);
    }

    public EndDate getEndDate() {
        return endDate;
    }

    public void setEndDate(EndDate value) {
        this.endDate = ((EndDateImpl) value);
    }

    @Override
    public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);

        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();

            if (name.equals("id")) {
                setId(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("name")) {
                setName(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("number")) {
                setNumber(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("authority")) {
                AuthorityImpl authority = new AuthorityImpl();
                authority.init(parser);
                setAuthority(authority);
            } else if (name.equals("start-date")) {
                StartDateImpl startDate = new StartDateImpl();
                startDate.init(parser);
                setStartDate(startDate);
            } else if (name.equals("end-date")) {
                EndDateImpl endDate = new EndDateImpl();
                endDate.init(parser);
                setEndDate(endDate);
            } else {
                // Consume something we don't understand.
                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
        }
    }

    @Override
    public void toXml(XmlSerializer serializer) throws IOException {
        XmlSerializer element = serializer.startTag(null, "certification");
        XppUtils.setElementValueToNode(element, "id", getId());
        XppUtils.setElementValueToNode(element, "name", getName());
        XppUtils.setElementValueToNode(element, "number", getNumber());
        if (getAuthority() != null) {
            ((AuthorityImpl) getAuthority()).toXml(serializer);
        }
        if (getStartDate() != null) {
            ((StartDateImpl) getStartDate()).toXml(serializer);
        }
        if (getEndDate() != null) {
            ((EndDateImpl) getEndDate()).toXml(serializer);
        }
        element.endTag(null, "certification");
        ;
    }
}
