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

import com.google.code.linkedinapi.schema.Action;
import com.google.code.linkedinapi.schema.OriginalUpdate;
import com.google.code.linkedinapi.schema.UpdateAction;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;

public class UpdateActionImpl
        extends BaseSchemaEntity
        implements UpdateAction {

    private final static long serialVersionUID = 2461660169443089969L;
    protected ActionImpl action;
    protected OriginalUpdateImpl originalUpdate;

    public Action getAction() {
        return action;
    }

    public void setAction(Action value) {
        this.action = ((ActionImpl) value);
    }

    public OriginalUpdate getOriginalUpdate() {
        return originalUpdate;
    }

    public void setOriginalUpdate(OriginalUpdate value) {
        this.originalUpdate = ((OriginalUpdateImpl) value);
    }

    @Override
    public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);

        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();

            if (name.equals("action")) {
                ActionImpl actionImpl = new ActionImpl();
                actionImpl.init(parser);
                setAction(actionImpl);
            } else if (name.equals("original-update")) {
                OriginalUpdateImpl updateImpl = new OriginalUpdateImpl();
                updateImpl.init(parser);
                setOriginalUpdate(updateImpl);
            } else {
                // Consume something we don't understand.
                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
        }
    }

    @Override
    public void toXml(XmlSerializer serializer) throws IOException {
        serializer.startTag(null, "update-action");

        if (getAction() != null) {
            ((ActionImpl) getAction()).toXml(serializer);
        }
        if (getOriginalUpdate() != null) {
            ((OriginalUpdateImpl) getOriginalUpdate()).toXml(serializer);
        }
        serializer.endTag(null, "update-action");
    }
}
