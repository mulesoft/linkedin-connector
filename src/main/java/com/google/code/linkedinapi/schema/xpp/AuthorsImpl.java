/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package com.google.code.linkedinapi.schema.xpp;

import com.google.code.linkedinapi.schema.Authors;
import com.google.code.linkedinapi.schema.PublicationAuthor;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AuthorsImpl
        extends BaseSchemaEntity
        implements Authors {

    private final static long serialVersionUID = 2461660169443089969L;
    protected List<PublicationAuthor> authorList;
    protected Long total;

    public List<PublicationAuthor> getAuthorList() {
        if (authorList == null) {
            authorList = new ArrayList<PublicationAuthor>();
        }
        return this.authorList;
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

            if (name.equals("author")) {
                PublicationAuthorImpl authorImpl = new PublicationAuthorImpl();
                authorImpl.init(parser);
                getAuthorList().add(authorImpl);
            } else {
                // Consume something we don't understand.
                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
        }
    }

    @Override
    public void toXml(XmlSerializer serializer) throws IOException {
        XmlSerializer element = serializer.startTag(null, "authors");
        XppUtils.setAttributeValueToNode(element, "total", getTotal());
        for (PublicationAuthor author : getAuthorList()) {
            ((PublicationAuthorImpl) author).toXml(serializer);
        }
        serializer.endTag(null, "authors");
    }
}
