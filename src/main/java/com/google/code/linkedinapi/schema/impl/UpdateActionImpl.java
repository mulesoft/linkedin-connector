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

import com.google.code.linkedinapi.schema.Action;
import com.google.code.linkedinapi.schema.OriginalUpdate;
import com.google.code.linkedinapi.schema.UpdateAction;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "action",
        "originalUpdate"
})
@XmlRootElement(name = "update-action")
public class UpdateActionImpl
        implements Serializable, UpdateAction {

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(required = true, type = ActionImpl.class)
    protected ActionImpl action;
    @XmlElement(name = "original-update", required = true, type = OriginalUpdateImpl.class)
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

}
