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

import com.google.code.linkedinapi.schema.Content;

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
        "title",
        "submittedUrl",
        "shortenedUrl",
        "submittedImageUrl",
        "thumbnailUrl",
        "resolvedUrl",
        "eyebrowUrl"
})
@XmlRootElement(name = "content")
public class ContentImpl
        implements Serializable, Content {

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String id;
    @XmlElement(required = true)
    protected String title;
    @XmlElement(name = "submitted-url", required = true)
    protected String submittedUrl;
    @XmlElement(name = "shortened-url")
    protected String shortenedUrl;
    @XmlElement(name = "submitted-image-url", required = true)
    protected String submittedImageUrl;
    @XmlElement(name = "thumbnail-url")
    protected String thumbnailUrl;
    @XmlElement(name = "resolved-url")
    protected String resolvedUrl;
    @XmlElement(name = "eyebrow-url")
    protected String eyebrowUrl;

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public String getSubmittedUrl() {
        return submittedUrl;
    }

    public void setSubmittedUrl(String value) {
        this.submittedUrl = value;
    }

    public String getShortenedUrl() {
        return shortenedUrl;
    }

    public void setShortenedUrl(String value) {
        this.shortenedUrl = value;
    }

    public String getSubmittedImageUrl() {
        return submittedImageUrl;
    }

    public void setSubmittedImageUrl(String value) {
        this.submittedImageUrl = value;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String value) {
        this.thumbnailUrl = value;
    }

    public String getResolvedUrl() {
        return resolvedUrl;
    }

    public void setResolvedUrl(String value) {
        this.resolvedUrl = value;
    }

    public String getEyebrowUrl() {
        return eyebrowUrl;
    }

    public void setEyebrowUrl(String value) {
        this.eyebrowUrl = value;
    }

}
