/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package com.google.code.linkedinapi.schema.impl;

import com.google.code.linkedinapi.schema.Attribution;
import com.google.code.linkedinapi.schema.Content;
import com.google.code.linkedinapi.schema.Share;
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
        "content",
        "visibility",
        "comment",
        "attribution",
        "id"
})
@XmlRootElement(name = "share")
public class ShareImpl
        implements Serializable, Share {

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(type = ContentImpl.class)
    protected ContentImpl content;
    @XmlElement(required = true, type = VisibilityImpl.class)
    protected VisibilityImpl visibility;
    @XmlElement(required = true)
    protected String comment;
    @XmlElement(type = AttributionImpl.class)
    protected AttributionImpl attribution;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String id;

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

    public String getComment() {
        return comment;
    }

    public void setComment(String value) {
        this.comment = value;
    }

    public Attribution getAttribution() {
        return attribution;
    }

    public void setAttribution(Attribution value) {
        this.attribution = ((AttributionImpl) value);
    }

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

}
