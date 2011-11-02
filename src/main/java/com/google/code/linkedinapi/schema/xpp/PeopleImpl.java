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

import com.google.code.linkedinapi.schema.People;
import com.google.code.linkedinapi.schema.Person;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PeopleImpl
        extends BaseSchemaEntity
        implements People {

    /**
     *
     */
    private static final long serialVersionUID = 2040264547587096712L;
    protected List<Person> personList;
    protected Long count;
    protected Long start;
    protected Long total;

    public List<Person> getPersonList() {
        if (personList == null) {
            personList = new ArrayList<Person>();
        }
        return this.personList;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long value) {
        this.count = value;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long value) {
        this.start = value;
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
        setStart(XppUtils.getAttributeValueAsLongFromNode(parser, "start"));
        setCount(XppUtils.getAttributeValueAsLongFromNode(parser, "count"));

        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();

            if (name.equals("person")) {
                PersonImpl personImpl = new PersonImpl();
                personImpl.init(parser);
                getPersonList().add(personImpl);
            } else {
                // Consume something we don't understand.
                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
        }
    }

    @Override
    public void toXml(XmlSerializer serializer) throws IOException {
        XmlSerializer element = serializer.startTag(null, "people");
        XppUtils.setAttributeValueToNode(element, "total", getTotal());
        XppUtils.setAttributeValueToNode(element, "start", getStart());
        XppUtils.setAttributeValueToNode(element, "count", getCount());
        for (Person person : getPersonList()) {
            ((PersonImpl) person).toXml(serializer);
        }
        serializer.endTag(null, "people");
    }
}
