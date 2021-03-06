/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package com.google.code.linkedinapi.schema.xpp;

import com.google.code.linkedinapi.schema.Facets;
import com.google.code.linkedinapi.schema.People;
import com.google.code.linkedinapi.schema.PeopleSearch;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;

public class PeopleSearchImpl
        extends BaseSchemaEntity
        implements PeopleSearch {

    private final static long serialVersionUID = 2461660169443089969L;
    protected Long numResults;
    protected PeopleImpl people;
    protected FacetsImpl facets;

    public Long getNumResults() {
        return numResults;
    }

    public void setNumResults(Long value) {
        this.numResults = value;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People value) {
        this.people = ((PeopleImpl) value);
    }

    public Facets getFacets() {
        return facets;
    }

    public void setFacets(Facets value) {
        this.facets = ((FacetsImpl) value);
    }

    @Override
    public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);

        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();

            if (name.equals("num-results")) {
                setNumResults(XppUtils.getElementValueAsLongFromNode(parser));
            } else if (name.equals("people")) {
                PeopleImpl people = new PeopleImpl();
                people.init(parser);
                setPeople(people);
            } else if (name.equals("facets")) {
                FacetsImpl facets = new FacetsImpl();
                facets.init(parser);
                setFacets(facets);
            } else {
                // Consume something we don't understand.
                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
        }
    }

    @Override
    public void toXml(XmlSerializer serializer) throws IOException {
        XmlSerializer element = serializer.startTag(null, "people-search");
        XppUtils.setElementValueToNode(element, "num-results", getNumResults());
        if (getPeople() != null) {
            ((PeopleImpl) getPeople()).toXml(serializer);
        }
        if (getFacets() != null) {
            ((FacetsImpl) getFacets()).toXml(serializer);
        }
        serializer.endTag(null, "people-search");
    }
}
