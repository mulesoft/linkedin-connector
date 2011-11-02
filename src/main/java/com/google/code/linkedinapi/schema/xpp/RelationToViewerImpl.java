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

import com.google.code.linkedinapi.schema.RelatedConnections;
import com.google.code.linkedinapi.schema.RelationToViewer;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;

public class RelationToViewerImpl
        extends BaseSchemaEntity
        implements RelationToViewer {

    /**
     *
     */
    private static final long serialVersionUID = -5385043041125747824L;
    protected RelatedConnectionsImpl relatedConnections;
    protected Long distance;


    public RelatedConnections getRelatedConnections() {
        return relatedConnections;
    }

    public void setRelatedConnections(RelatedConnections value) {
        this.relatedConnections = ((RelatedConnectionsImpl) value);
    }

    public Long getDistance() {
        return distance;
    }

    public void setDistance(Long value) {
        this.distance = value;
    }

    @Override
    public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();

            if (name.equals("related-connections")) {
                RelatedConnectionsImpl relatedConnections = new RelatedConnectionsImpl();
                relatedConnections.init(parser);
                setRelatedConnections(relatedConnections);
            } else if (name.equals("distance")) {
                setDistance(XppUtils.getElementValueAsLongFromNode(parser));
            } else {
                // Consume something we don't understand.
                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
        }
    }

    @Override
    public void toXml(XmlSerializer serializer) throws IOException {
        XmlSerializer element = serializer.startTag(null, "relation-to-viewer");
        if (getRelatedConnections() != null) {
            ((RelatedConnectionsImpl) getRelatedConnections()).toXml(serializer);
        }
        XppUtils.setElementValueToNode(element, "distance", getDistance());
        serializer.endTag(null, "relation-to-viewer");
    }
}
