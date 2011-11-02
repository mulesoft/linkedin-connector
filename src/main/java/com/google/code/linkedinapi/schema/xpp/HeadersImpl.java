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

import com.google.code.linkedinapi.schema.Headers;
import com.google.code.linkedinapi.schema.HttpHeader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HeadersImpl
        extends BaseSchemaEntity
        implements Headers {

    /**
     *
     */
    private static final long serialVersionUID = -2641335452688934142L;
    protected List<HttpHeader> httpHeaderList;
    protected Long total;

    public List<HttpHeader> getHttpHeaderList() {
        if (httpHeaderList == null) {
            httpHeaderList = new ArrayList<HttpHeader>();
        }
        return this.httpHeaderList;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long value) {
        this.total = value;
    }

    @Override
    public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);
        setTotal(XppUtils.getAttributeValueAsLongFromNode(parser, "total"));

        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();

            if (name.equals("http-header")) {
                HttpHeaderImpl httpHeaderImpl = new HttpHeaderImpl();
                httpHeaderImpl.init(parser);
                getHttpHeaderList().add(httpHeaderImpl);
            } else {
                // Consume something we don't understand.
                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
        }
    }

    @Override
    public void toXml(XmlSerializer serializer) throws IOException {
        XmlSerializer element = serializer.startTag(null, "headers");
        XppUtils.setAttributeValueToNode(element, "total", getTotal());
        for (HttpHeader httpHeader : getHttpHeaderList()) {
            ((HttpHeaderImpl) httpHeader).toXml(serializer);
        }
        serializer.endTag(null, "headers");
    }
}
