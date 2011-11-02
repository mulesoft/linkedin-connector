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

import com.google.code.linkedinapi.schema.ImAccount;
import com.google.code.linkedinapi.schema.ImAccountType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "imAccountType",
        "imAccountName"
})
@XmlRootElement(name = "im-account")
public class ImAccountImpl
        implements Serializable, ImAccount {

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(name = "im-account-type", required = true)
    protected ImAccountType imAccountType;
    @XmlElement(name = "im-account-name", required = true)
    protected String imAccountName;

    public ImAccountType getImAccountType() {
        return imAccountType;
    }

    public void setImAccountType(ImAccountType value) {
        this.imAccountType = value;
    }

    public String getImAccountName() {
        return imAccountName;
    }

    public void setImAccountName(String value) {
        this.imAccountName = value;
    }

}
