/**
 * Mule LinkedIn Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package com.google.code.linkedinapi.schema.impl;

import com.google.code.linkedinapi.schema.Authors;
import com.google.code.linkedinapi.schema.Date;
import com.google.code.linkedinapi.schema.Publication;
import com.google.code.linkedinapi.schema.Publisher;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "date",
        "id",
        "summary",
        "title",
        "url",
        "authors",
        "publisher"
})
@XmlRootElement(name = "publication")
public class PublicationImpl
        implements Serializable, Publication {

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(type = DateImpl.class)
    protected DateImpl date;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String id;
    protected String summary;
    protected String title;
    protected String url;
    @XmlElement(type = AuthorsImpl.class)
    protected AuthorsImpl authors;
    @XmlElement(type = PublisherImpl.class)
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

}
