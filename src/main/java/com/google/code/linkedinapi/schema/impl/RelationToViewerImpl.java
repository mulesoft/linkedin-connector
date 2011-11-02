/**
 * Mule LinkedIn Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package com.google.code.linkedinapi.schema.impl;

import com.google.code.linkedinapi.schema.Adapter1;
import com.google.code.linkedinapi.schema.RelatedConnections;
import com.google.code.linkedinapi.schema.RelationToViewer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "relatedConnections",
        "distance"
})
@XmlRootElement(name = "relation-to-viewer")
public class RelationToViewerImpl
        implements Serializable, RelationToViewer {

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(name = "related-connections", required = true, type = RelatedConnectionsImpl.class)
    protected RelatedConnectionsImpl relatedConnections;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1.class)
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

}
