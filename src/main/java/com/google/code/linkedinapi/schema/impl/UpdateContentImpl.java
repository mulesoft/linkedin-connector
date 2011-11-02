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

import com.google.code.linkedinapi.schema.Company;
import com.google.code.linkedinapi.schema.CompanyJobUpdate;
import com.google.code.linkedinapi.schema.CompanyPersonUpdate;
import com.google.code.linkedinapi.schema.CompanyProfileUpdate;
import com.google.code.linkedinapi.schema.Job;
import com.google.code.linkedinapi.schema.Person;
import com.google.code.linkedinapi.schema.Question;
import com.google.code.linkedinapi.schema.UpdateAction;
import com.google.code.linkedinapi.schema.UpdateContent;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "person",
        "updateAction",
        "job",
        "question",
        "company",
        "companyJobUpdate",
        "companyPersonUpdate",
        "companyProfileUpdate"
})
@XmlRootElement(name = "update-content")
public class UpdateContentImpl
        implements Serializable, UpdateContent {

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(type = PersonImpl.class)
    protected PersonImpl person;
    @XmlElement(name = "update-action", type = UpdateActionImpl.class)
    protected UpdateActionImpl updateAction;
    @XmlElement(type = JobImpl.class)
    protected JobImpl job;
    @XmlElement(type = QuestionImpl.class)
    protected QuestionImpl question;
    @XmlElement(type = CompanyImpl.class)
    protected CompanyImpl company;
    @XmlElement(name = "company-job-update", type = CompanyJobUpdateImpl.class)
    protected CompanyJobUpdateImpl companyJobUpdate;
    @XmlElement(name = "company-person-update", type = CompanyPersonUpdateImpl.class)
    protected CompanyPersonUpdateImpl companyPersonUpdate;
    @XmlElement(name = "company-profile-update", type = CompanyProfileUpdateImpl.class)
    protected CompanyProfileUpdateImpl companyProfileUpdate;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person value) {
        this.person = ((PersonImpl) value);
    }

    public UpdateAction getUpdateAction() {
        return updateAction;
    }

    public void setUpdateAction(UpdateAction value) {
        this.updateAction = ((UpdateActionImpl) value);
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job value) {
        this.job = ((JobImpl) value);
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question value) {
        this.question = ((QuestionImpl) value);
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company value) {
        this.company = ((CompanyImpl) value);
    }

    public CompanyJobUpdate getCompanyJobUpdate() {
        return companyJobUpdate;
    }

    public void setCompanyJobUpdate(CompanyJobUpdate value) {
        this.companyJobUpdate = ((CompanyJobUpdateImpl) value);
    }

    public CompanyPersonUpdate getCompanyPersonUpdate() {
        return companyPersonUpdate;
    }

    public void setCompanyPersonUpdate(CompanyPersonUpdate value) {
        this.companyPersonUpdate = ((CompanyPersonUpdateImpl) value);
    }

    public CompanyProfileUpdate getCompanyProfileUpdate() {
        return companyProfileUpdate;
    }

    public void setCompanyProfileUpdate(CompanyProfileUpdate value) {
        this.companyProfileUpdate = ((CompanyProfileUpdateImpl) value);
    }

}
