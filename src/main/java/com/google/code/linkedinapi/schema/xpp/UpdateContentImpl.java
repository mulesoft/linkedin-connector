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

import com.google.code.linkedinapi.schema.Company;
import com.google.code.linkedinapi.schema.CompanyJobUpdate;
import com.google.code.linkedinapi.schema.CompanyPersonUpdate;
import com.google.code.linkedinapi.schema.CompanyProfileUpdate;
import com.google.code.linkedinapi.schema.Job;
import com.google.code.linkedinapi.schema.Person;
import com.google.code.linkedinapi.schema.Question;
import com.google.code.linkedinapi.schema.UpdateAction;
import com.google.code.linkedinapi.schema.UpdateContent;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;

public class UpdateContentImpl
        extends BaseSchemaEntity
        implements UpdateContent {

    /**
     *
     */
    private static final long serialVersionUID = 8557807037014197165L;
    protected PersonImpl person;
    protected UpdateActionImpl updateAction;
    protected JobImpl job;
    protected QuestionImpl question;
    protected CompanyImpl company;
    protected CompanyJobUpdateImpl companyJobUpdate;
    protected CompanyPersonUpdateImpl companyPersonUpdate;
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

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question value) {
        this.question = ((QuestionImpl) value);
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job value) {
        this.job = ((JobImpl) value);
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

    @Override
    public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);

        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();

            if (name.equals("person")) {
                PersonImpl personImpl = new PersonImpl();
                personImpl.init(parser);
                setPerson(personImpl);
            } else if (name.equals("job")) {
                JobImpl jobImpl = new JobImpl();
                jobImpl.init(parser);
                setJob(jobImpl);
            } else if (name.equals("update-action")) {
                UpdateActionImpl updateActionImpl = new UpdateActionImpl();
                updateActionImpl.init(parser);
                setUpdateAction(updateActionImpl);
            } else if (name.equals("question")) {
                QuestionImpl questionImpl = new QuestionImpl();
                questionImpl.init(parser);
                setQuestion(questionImpl);
            } else if (name.equals("company")) {
                CompanyImpl companyImpl = new CompanyImpl();
                companyImpl.init(parser);
                setCompany(companyImpl);
            } else if (name.equals("company-job-update")) {
                CompanyJobUpdateImpl companyJobUpdate = new CompanyJobUpdateImpl();
                companyJobUpdate.init(parser);
                setCompanyJobUpdate(companyJobUpdate);
            } else if (name.equals("company-person-update")) {
                CompanyPersonUpdateImpl companyPersonUpdate = new CompanyPersonUpdateImpl();
                companyPersonUpdate.init(parser);
                setCompanyPersonUpdate(companyPersonUpdate);
            } else if (name.equals("company-profile-update")) {
                CompanyProfileUpdateImpl companyProfileUpdate = new CompanyProfileUpdateImpl();
                companyProfileUpdate.init(parser);
                setCompanyProfileUpdate(companyProfileUpdate);
            } else {
                // Consume something we don't understand.
                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
        }
    }

    @Override
    public void toXml(XmlSerializer serializer) throws IOException {
        XmlSerializer element = serializer.startTag(null, "update-content");
        if (getPerson() != null) {
            ((PersonImpl) getPerson()).toXml(element);
        }
        if (getJob() != null) {
            ((JobImpl) getJob()).toXml(element);
        }
        if (getUpdateAction() != null) {
            ((UpdateActionImpl) getUpdateAction()).toXml(element);
        }
        if (getQuestion() != null) {
            ((QuestionImpl) getQuestion()).toXml(element);
        }
        if (getCompany() != null) {
            ((CompanyImpl) getCompany()).toXml(element);
        }
        if (getCompanyJobUpdate() != null) {
            ((CompanyJobUpdateImpl) getCompanyJobUpdate()).toXml(element);
        }
        if (getCompanyPersonUpdate() != null) {
            ((CompanyPersonUpdateImpl) getCompanyPersonUpdate()).toXml(element);
        }
        if (getCompanyProfileUpdate() != null) {
            ((CompanyProfileUpdateImpl) getCompanyProfileUpdate()).toXml(element);
        }
        serializer.endTag(null, "update-content");
    }
}
