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

import com.google.code.linkedinapi.schema.Authority;
import com.google.code.linkedinapi.schema.Certification;
import com.google.code.linkedinapi.schema.EndDate;
import com.google.code.linkedinapi.schema.StartDate;

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
        "name",
        "authority",
        "number",
        "startDate",
        "endDate"
})
@XmlRootElement(name = "certification")
public class CertificationImpl
        implements Serializable, Certification {

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String id;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true, type = AuthorityImpl.class)
    protected AuthorityImpl authority;
    @XmlElement(required = true)
    protected String number;
    @XmlElement(name = "start-date", required = true, type = StartDateImpl.class)
    protected StartDateImpl startDate;
    @XmlElement(name = "end-date", required = true, type = EndDateImpl.class)
    protected EndDateImpl endDate;

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority value) {
        this.authority = ((AuthorityImpl) value);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String value) {
        this.number = value;
    }

    public StartDate getStartDate() {
        return startDate;
    }

    public void setStartDate(StartDate value) {
        this.startDate = ((StartDateImpl) value);
    }

    public EndDate getEndDate() {
        return endDate;
    }

    public void setEndDate(EndDate value) {
        this.endDate = ((EndDateImpl) value);
    }

}
