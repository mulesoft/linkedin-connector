/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package com.google.code.linkedinapi.schema.impl;

import com.google.code.linkedinapi.schema.Adapter1;
import com.google.code.linkedinapi.schema.Author;
import com.google.code.linkedinapi.schema.Content;
import com.google.code.linkedinapi.schema.CurrentShare;
import com.google.code.linkedinapi.schema.Source;
import com.google.code.linkedinapi.schema.Visibility;

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
        "id",
        "timestamp",
        "comment",
        "content",
        "visibility",
        "source",
        "author"
})
@XmlRootElement(name = "current-share")
public class CurrentShareImpl
        implements Serializable, CurrentShare {

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String id;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1.class)
    protected Long timestamp;
    @XmlElement(required = true)
    protected String comment;
    @XmlElement(required = true, type = ContentImpl.class)
    protected ContentImpl content;
    @XmlElement(required = true, type = VisibilityImpl.class)
    protected VisibilityImpl visibility;
    @XmlElement(required = true, type = SourceImpl.class)
    protected SourceImpl source;
    @XmlElement(required = true, type = AuthorImpl.class)
    protected AuthorImpl author;

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long value) {
        this.timestamp = value;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String value) {
        this.comment = value;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content value) {
        this.content = ((ContentImpl) value);
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility value) {
        this.visibility = ((VisibilityImpl) value);
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source value) {
        this.source = ((SourceImpl) value);
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author value) {
        this.author = ((AuthorImpl) value);
    }

}
