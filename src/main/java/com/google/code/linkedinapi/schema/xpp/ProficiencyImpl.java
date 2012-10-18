/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package com.google.code.linkedinapi.schema.xpp;

import com.google.code.linkedinapi.schema.Proficiency;
import com.google.code.linkedinapi.schema.ProficiencyLevelType;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;

public class ProficiencyImpl
        extends BaseSchemaEntity
        implements Proficiency {

    private final static long serialVersionUID = 2461660169443089969L;
    protected ProficiencyLevelType level;
    protected String name;

    public ProficiencyLevelType getLevel() {
        return level;
    }

    public void setLevel(ProficiencyLevelType value) {
        this.level = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    @Override
    public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);

        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();

            if (name.equals("name")) {
                setName(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("level")) {
                setLevel(ProficiencyLevelType.fromValue(XppUtils.getElementValueFromNode(parser)));
            } else {
                // Consume something we don't understand.
                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
        }
    }

    @Override
    public void toXml(XmlSerializer serializer) throws IOException {
        XmlSerializer element = serializer.startTag(null, "proficiency");
        XppUtils.setElementValueToNode(element, "level", getLevel().value());
        XppUtils.setElementValueToNode(element, "name", getName());
        element.endTag(null, "proficiency");
    }
}
