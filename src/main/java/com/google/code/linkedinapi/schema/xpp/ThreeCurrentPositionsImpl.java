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

import com.google.code.linkedinapi.schema.Position;
import com.google.code.linkedinapi.schema.ThreeCurrentPositions;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ThreeCurrentPositionsImpl
        extends BaseSchemaEntity
        implements ThreeCurrentPositions {

    private final static long serialVersionUID = 2461660169443089969L;
    protected List<Position> position;
    protected Long total;

    public List<Position> getPositionList() {
        if (position == null) {
            position = new ArrayList<Position>();
        }
        return this.position;
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

            if (name.equals("position")) {
                PositionImpl positionImpl = new PositionImpl();
                positionImpl.init(parser);
                getPositionList().add(positionImpl);
            } else {
                // Consume something we don't understand.
                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
        }
    }

    @Override
    public void toXml(XmlSerializer serializer) throws IOException {
        XmlSerializer element = serializer.startTag(null, "three-current-positions");
        XppUtils.setAttributeValueToNode(element, "total", getTotal());
        for (Position position : getPositionList()) {
            ((PositionImpl) position).toXml(serializer);
        }
        serializer.endTag(null, "positions");
    }
}
