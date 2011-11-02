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

import com.google.code.linkedinapi.schema.ApiStandardProfileRequest;
import com.google.code.linkedinapi.schema.Editor;
import com.google.code.linkedinapi.schema.SiteStandardProfileRequest;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;

public class EditorImpl
        extends BaseSchemaEntity
        implements Editor {

    private final static long serialVersionUID = 2461660169443089969L;
    protected String id;
    protected String firstName;
    protected String lastName;
    protected String headline;
    protected ApiStandardProfileRequestImpl apiStandardProfileRequest;
    protected SiteStandardProfileRequestImpl siteStandardProfileRequest;

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String value) {
        this.firstName = value;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String value) {
        this.lastName = value;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String value) {
        this.headline = value;
    }

    public ApiStandardProfileRequest getApiStandardProfileRequest() {
        return apiStandardProfileRequest;
    }

    public void setApiStandardProfileRequest(ApiStandardProfileRequest value) {
        this.apiStandardProfileRequest = ((ApiStandardProfileRequestImpl) value);
    }

    public SiteStandardProfileRequest getSiteStandardProfileRequest() {
        return siteStandardProfileRequest;
    }

    public void setSiteStandardProfileRequest(SiteStandardProfileRequest value) {
        this.siteStandardProfileRequest = ((SiteStandardProfileRequestImpl) value);
    }

    @Override
    public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);

        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();

            if (name.equals("id")) {
                setId(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("first-name")) {
                setFirstName(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("last-name")) {
                setLastName(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("headline")) {
                setHeadline(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("api-standard-profile-request")) {
                ApiStandardProfileRequestImpl apiRequest = new ApiStandardProfileRequestImpl();
                apiRequest.init(parser);
                setApiStandardProfileRequest(apiRequest);
            } else if (name.equals("site-standard-profile-request")) {
                SiteStandardProfileRequestImpl apiRequest = new SiteStandardProfileRequestImpl();
                apiRequest.init(parser);
                setSiteStandardProfileRequest(apiRequest);
            } else {
                // Consume something we don't understand.
                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
        }
    }

    @Override
    public void toXml(XmlSerializer serializer) throws IOException {
        XmlSerializer element = serializer.startTag(null, "editor");
        XppUtils.setElementValueToNode(element, "id", getId());
        XppUtils.setElementValueToNode(element, "first-name", getFirstName());
        XppUtils.setElementValueToNode(element, "last-name", getLastName());
        XppUtils.setElementValueToNode(element, "headline", getHeadline());
        if (getApiStandardProfileRequest() != null) {
            ((ApiStandardProfileRequestImpl) getApiStandardProfileRequest()).toXml(serializer);
        }
        if (getSiteStandardProfileRequest() != null) {
            ((SiteStandardProfileRequestImpl) getSiteStandardProfileRequest()).toXml(serializer);
        }
        serializer.endTag(null, "editor");
    }
}
