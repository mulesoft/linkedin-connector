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

import com.google.code.linkedinapi.schema.Activity;
import com.google.code.linkedinapi.schema.PersonActivities;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonActivitiesImpl
        extends BaseSchemaEntity
        implements PersonActivities {

    private final static long serialVersionUID = 2461660169443089969L;
    protected List<Activity> activityList;
    protected Long count;

    public List<Activity> getActivityList() {
        if (activityList == null) {
            activityList = new ArrayList<Activity>();
        }
        return this.activityList;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long value) {
        this.count = value;
    }

    @Override
    public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);
        setCount(XppUtils.getAttributeValueAsLongFromNode(parser, "count"));

        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();

            if (name.equals("activity")) {
                ActivityImpl activityImpl = new ActivityImpl();
                activityImpl.init(parser);
                getActivityList().add(activityImpl);
            } else {
                // Consume something we don't understand.
                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
        }
    }

    @Override
    public void toXml(XmlSerializer serializer) throws IOException {
        XmlSerializer element = serializer.startTag(null, "person-activities");
        XppUtils.setAttributeValueToNode(element, "count", getCount());
        for (Activity activity : getActivityList()) {
            ((ActivityImpl) activity).toXml(serializer);
        }
        serializer.endTag(null, "person-activities");
    }
}
