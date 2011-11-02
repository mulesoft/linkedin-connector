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

import com.google.code.linkedinapi.schema.Attribution;
import com.google.code.linkedinapi.schema.Share;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "share"
})
@XmlRootElement(name = "attribution")
public class AttributionImpl
        implements Serializable, Attribution {

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(required = true, type = ShareImpl.class)
    protected ShareImpl share;

    public Share getShare() {
        return share;
    }

    public void setShare(Share value) {
        this.share = ((ShareImpl) value);
    }

}
