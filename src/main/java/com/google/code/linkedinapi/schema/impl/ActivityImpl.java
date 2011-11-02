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

import com.google.code.linkedinapi.schema.Activity;
import com.google.code.linkedinapi.schema.Adapter1;
import com.google.code.linkedinapi.schema.NetworkUpdateContentType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "timestamp",
        "contentType",
        "body",
        "appId"
})
@XmlRootElement(name = "activity")
public class ActivityImpl
        implements Serializable, Activity {

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(Adapter1.class)
    protected Long timestamp;
    @XmlElement(name = "content-type")
    protected NetworkUpdateContentType contentType;
    @XmlElement(required = true)
    protected String body;
    @XmlElement(name = "app-id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String appId;
    @XmlAttribute(required = true)
    protected String locale;

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long value) {
        this.timestamp = value;
    }

    public NetworkUpdateContentType getContentType() {
        return contentType;
    }

    public void setContentType(NetworkUpdateContentType value) {
        this.contentType = value;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String value) {
        this.body = value;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String value) {
        this.appId = value;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String value) {
        this.locale = value;
    }

}
