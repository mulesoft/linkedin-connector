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

import com.google.code.linkedinapi.schema.Authors;
import com.google.code.linkedinapi.schema.Date;
import com.google.code.linkedinapi.schema.Publication;
import com.google.code.linkedinapi.schema.Publisher;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;

public class PublicationImpl
        extends BaseSchemaEntity
        implements Publication {

    private final static long serialVersionUID = 2461660169443089969L;
    protected DateImpl date;
    protected String id;
    protected String summary;
    protected String title;
    protected String url;
    protected AuthorsImpl authors;
    protected PublisherImpl publisher;

    public Date getDate() {
        return date;
    }

    public void setDate(Date value) {
        this.date = ((DateImpl) value);
    }

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String value) {
        this.summary = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String value) {
        this.url = value;
    }

    public Authors getAuthors() {
        return authors;
    }

    public void setAuthors(Authors value) {
        this.authors = ((AuthorsImpl) value);
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher value) {
        this.publisher = ((PublisherImpl) value);
    }

    @Override
    public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);

        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();

            if (name.equals("id")) {
                setId(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("title")) {
                setTitle(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("url")) {
                setUrl(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("summary")) {
                setSummary(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("date")) {
                DateImpl author = new DateImpl();
                author.init(parser);
                setDate(author);
            } else if (name.equals("authors")) {
                AuthorsImpl author = new AuthorsImpl();
                author.init(parser);
                setAuthors(author);
            } else if (name.equals("publisher")) {
                PublisherImpl author = new PublisherImpl();
                author.init(parser);
                setPublisher(author);
            } else {
                // Consume something we don't understand.
                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
        }
    }

    @Override
    public void toXml(XmlSerializer serializer) throws IOException {
        XmlSerializer element = serializer.startTag(null, "publication");
        XppUtils.setElementValueToNode(element, "id", getId());
        XppUtils.setElementValueToNode(element, "title", getTitle());
        XppUtils.setElementValueToNode(element, "url", getUrl());
        XppUtils.setElementValueToNode(element, "summary", getSummary());
        if (getDate() != null) {
            ((DateImpl) getDate()).toXml(serializer);
        }
        if (getAuthors() != null) {
            ((AuthorsImpl) getAuthors()).toXml(serializer);
        }
        if (getPublisher() != null) {
            ((PublisherImpl) getPublisher()).toXml(serializer);
        }
        element.endTag(null, "publication");
    }
}
