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

import com.google.code.linkedinapi.schema.Authorization;
import com.google.code.linkedinapi.schema.InvitationRequest;
import com.google.code.linkedinapi.schema.InviteConnectType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "connectType",
        "authorization"
})
@XmlRootElement(name = "invitation-request")
public class InvitationRequestImpl
        implements Serializable, InvitationRequest {

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(name = "connect-type", required = true)
    protected InviteConnectType connectType;
    @XmlElement(required = true, type = AuthorizationImpl.class)
    protected AuthorizationImpl authorization;

    public InviteConnectType getConnectType() {
        return connectType;
    }

    public void setConnectType(InviteConnectType value) {
        this.connectType = value;
    }

    public Authorization getAuthorization() {
        return authorization;
    }

    public void setAuthorization(Authorization value) {
        this.authorization = ((AuthorizationImpl) value);
    }

}
