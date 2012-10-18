/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package com.google.code.linkedinapi.schema.xpp;

import com.google.code.linkedinapi.schema.Skill;
import com.google.code.linkedinapi.schema.Skills;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SkillsImpl
        extends BaseSchemaEntity
        implements Skills {

    private final static long serialVersionUID = 2461660169443089969L;
    protected List<Skill> skillList;
    protected Long total;

    public List<Skill> getSkillList() {
        if (skillList == null) {
            skillList = new ArrayList<Skill>();
        }
        return this.skillList;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long value) {
        this.total = value;
    }

    @Override
    public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);
        setTotal(XppUtils.getAttributeValueAsLongFromNode(parser, "total"));

        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();

            if (name.equals("skill")) {
                SkillImpl skillImpl = new SkillImpl();
                skillImpl.init(parser);
                getSkillList().add(skillImpl);
            } else {
                // Consume something we don't understand.
                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
        }
    }

    @Override
    public void toXml(XmlSerializer serializer) throws IOException {
        XmlSerializer element = serializer.startTag(null, "skills");
        XppUtils.setAttributeValueToNode(element, "total", getTotal());
        for (Skill skill : getSkillList()) {
            ((SkillImpl) skill).toXml(serializer);
        }
        serializer.endTag(null, "skills");
    }
}
