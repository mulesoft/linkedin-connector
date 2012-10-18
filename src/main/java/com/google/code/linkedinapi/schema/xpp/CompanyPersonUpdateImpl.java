/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package com.google.code.linkedinapi.schema.xpp;

import com.google.code.linkedinapi.schema.Action;
import com.google.code.linkedinapi.schema.CompanyPersonUpdate;
import com.google.code.linkedinapi.schema.NewPosition;
import com.google.code.linkedinapi.schema.OldPosition;
import com.google.code.linkedinapi.schema.Person;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;

public class CompanyPersonUpdateImpl
        extends BaseSchemaEntity
        implements CompanyPersonUpdate {

    private final static long serialVersionUID = 2461660169443089969L;
    protected PersonImpl person;
    protected ActionImpl action;
    protected OldPositionImpl oldPosition;
    protected NewPositionImpl newPosition;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person value) {
        this.person = ((PersonImpl) value);
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action value) {
        this.action = ((ActionImpl) value);
    }

    public OldPosition getOldPosition() {
        return oldPosition;
    }

    public void setOldPosition(OldPosition value) {
        this.oldPosition = ((OldPositionImpl) value);
    }

    public NewPosition getNewPosition() {
        return newPosition;
    }

    public void setNewPosition(NewPosition value) {
        this.newPosition = ((NewPositionImpl) value);
    }

    @Override
    public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);

        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();

            if (name.equals("person")) {
                PersonImpl author = new PersonImpl();
                author.init(parser);
                setPerson(author);
            } else if (name.equals("action")) {
                ActionImpl author = new ActionImpl();
                author.init(parser);
                setAction(author);
            } else if (name.equals("old-position")) {
                OldPositionImpl author = new OldPositionImpl();
                author.init(parser);
                setOldPosition(author);
            } else if (name.equals("new-position")) {
                NewPositionImpl author = new NewPositionImpl();
                author.init(parser);
                setNewPosition(author);
            } else {
                // Consume something we don't understand.
                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
        }
    }

    @Override
    public void toXml(XmlSerializer serializer) throws IOException {
        XmlSerializer element = serializer.startTag(null, "company-person-update");
        if (getPerson() != null) {
            ((PersonImpl) getPerson()).toXml(serializer);
        }
        if (getAction() != null) {
            ((ActionImpl) getAction()).toXml(serializer);
        }
        if (getOldPosition() != null) {
            ((OldPositionImpl) getOldPosition()).toXml(serializer);
        }
        if (getNewPosition() != null) {
            ((NewPositionImpl) getNewPosition()).toXml(serializer);
        }
        element.endTag(null, "company-person-update");
        ;
    }
}
