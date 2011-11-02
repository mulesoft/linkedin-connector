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
import com.google.code.linkedinapi.schema.Headers;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;

public class ApiStandardProfileRequestImpl
        extends BaseSchemaEntity
        implements ApiStandardProfileRequest {

    /**
     *
     */
    private static final long serialVersionUID = 8959695220558645456L;
    protected String url;
    protected HeadersImpl headers;

    public String getUrl() {
        return url;
    }

    public void setUrl(String value) {
        this.url = value;
    }

    public Headers getHeaders() {
        return headers;
    }

    public void setHeaders(Headers value) {
        this.headers = ((HeadersImpl) value);
    }

    @Override
    public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);

        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();
            if (name.equals("url")) {
                setUrl(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("headers")) {
                HeadersImpl headerImpl = new HeadersImpl();
                headerImpl.init(parser);
                setHeaders(headerImpl);
            } else {
                // Consume something we don't understand.
                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
        }
    }

    @Override
    public void toXml(XmlSerializer serializer) throws IOException {
        XmlSerializer element = serializer.startTag(null, "api-standard-profile-request");
        XppUtils.setElementValueToNode(element, "url", getUrl());
        if (getHeaders() != null) {
            ((HeadersImpl) getHeaders()).toXml(serializer);
        }
        element.endTag(null, "api-standard-profile-request");
    }
}
