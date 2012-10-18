/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package com.google.code.linkedinapi.schema.xpp;

import com.google.code.linkedinapi.schema.Action;
import com.google.code.linkedinapi.schema.CompanyJobUpdate;
import com.google.code.linkedinapi.schema.Job;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;

public class CompanyJobUpdateImpl
        extends BaseSchemaEntity
        implements CompanyJobUpdate {

    private final static long serialVersionUID = 2461660169443089969L;
    protected JobImpl job;
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

    @Override
    public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);

        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();

            if (name.equals("job")) {
                JobImpl job = new JobImpl();
                job.init(parser);
                setJob(job);
            } else if (name.equals("action")) {
                ActionImpl action = new ActionImpl();
                action.init(parser);
                setAction(action);
            } else {
                // Consume something we don't understand.
                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
        }
    }

    @Override
    public void toXml(XmlSerializer serializer) throws IOException {
        XmlSerializer element = serializer.startTag(null, "company-job-update");
        if (getJob() != null) {
            ((JobImpl) getJob()).toXml(serializer);
        }
        if (getAction() != null) {
            ((ActionImpl) getAction()).toXml(serializer);
        }
        element.endTag(null, "company-job-update");
        ;
    }
}
