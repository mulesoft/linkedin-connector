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

import com.google.code.linkedinapi.schema.NameType;
import com.google.code.linkedinapi.schema.Proficiency;
import com.google.code.linkedinapi.schema.Skill;
import com.google.code.linkedinapi.schema.Years;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "proficiency",
        "years",
        "id",
        "skill"
})
@XmlRootElement(name = "skill")
public class SkillImpl
        implements Serializable, Skill {

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(required = true, type = ProficiencyImpl.class)
    protected ProficiencyImpl proficiency;
    @XmlElement(required = true, type = YearsImpl.class)
    protected YearsImpl years;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String id;
    @XmlElement(required = true, type = NameTypeImpl.class)
    protected NameTypeImpl skill;

    public Proficiency getProficiency() {
        return proficiency;
    }

    public void setProficiency(Proficiency value) {
        this.proficiency = ((ProficiencyImpl) value);
    }

    public Years getYears() {
        return years;
    }

    public void setYears(Years value) {
        this.years = ((YearsImpl) value);
    }

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public NameType getSkill() {
        return skill;
    }

    public void setSkill(NameType value) {
        this.skill = ((NameTypeImpl) value);
    }

}
