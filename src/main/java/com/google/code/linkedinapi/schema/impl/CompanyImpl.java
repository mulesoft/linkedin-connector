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

import com.google.code.linkedinapi.schema.Adapter1;
import com.google.code.linkedinapi.schema.Company;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "type",
        "name",
        "industry",
        "size",
        "ticker"
})
@XmlRootElement(name = "company")
public class CompanyImpl
        implements Serializable, Company {

    private final static long serialVersionUID = 2461660169443089969L;
    protected String type;
    @XmlElement(required = true)
    protected String name;
    protected String industry;
    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(Adapter1.class)
    protected Long size;
    protected String ticker;

    public String getType() {
        return type;
    }

    public void setType(String value) {
        this.type = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String value) {
        this.industry = value;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long value) {
        this.size = value;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String value) {
        this.ticker = value;
    }

}
