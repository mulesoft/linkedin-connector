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
import com.google.code.linkedinapi.schema.CompanyProfileUpdate;
import com.google.code.linkedinapi.schema.Editor;
import com.google.code.linkedinapi.schema.ProfileField;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "editor",
        "action",
        "profileField"
})
@XmlRootElement(name = "company-profile-update")
public class CompanyProfileUpdateImpl
        implements Serializable, CompanyProfileUpdate {

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(required = true, type = EditorImpl.class)
    protected EditorImpl editor;
    @XmlElement(required = true, type = ActionImpl.class)
    protected ActionImpl action;
    @XmlElement(name = "profile-field", required = true, type = ProfileFieldImpl.class)
    protected ProfileFieldImpl profileField;

    public Editor getEditor() {
        return editor;
    }

    public void setEditor(Editor value) {
        this.editor = ((EditorImpl) value);
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action value) {
        this.action = ((ActionImpl) value);
    }

    public ProfileField getProfileField() {
        return profileField;
    }

    public void setProfileField(ProfileField value) {
        this.profileField = ((ProfileFieldImpl) value);
    }

}
