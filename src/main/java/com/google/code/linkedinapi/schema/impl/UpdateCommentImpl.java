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
import com.google.code.linkedinapi.schema.Person;
import com.google.code.linkedinapi.schema.UpdateComment;

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
        "id",
        "sequenceNumber",
        "comment",
        "person",
        "timestamp"
})
@XmlRootElement(name = "update-comment")
public class UpdateCommentImpl
        implements Serializable, UpdateComment {

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String id;
    @XmlElement(name = "sequence-number", type = String.class)
    @XmlJavaTypeAdapter(Adapter1.class)
    protected Long sequenceNumber;
    @XmlElement(required = true)
    protected String comment;
    @XmlElement(type = PersonImpl.class)
    protected PersonImpl person;
    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(Adapter1.class)
    protected Long timestamp;

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public Long getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Long value) {
        this.sequenceNumber = value;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String value) {
        this.comment = value;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person value) {
        this.person = ((PersonImpl) value);
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long value) {
        this.timestamp = value;
    }

}
