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

import com.google.code.linkedinapi.schema.Action;
import com.google.code.linkedinapi.schema.CompanyJobUpdate;
import com.google.code.linkedinapi.schema.Job;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "job",
        "action"
})
@XmlRootElement(name = "company-job-update")
public class CompanyJobUpdateImpl
        implements Serializable, CompanyJobUpdate {

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(required = true, type = JobImpl.class)
    protected JobImpl job;
    @XmlElement(required = true, type = ActionImpl.class)
    protected ActionImpl action;

    public Job getJob() {
        return job;
    }

    public void setJob(Job value) {
        this.job = ((JobImpl) value);
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action value) {
        this.action = ((ActionImpl) value);
    }

}
