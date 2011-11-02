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
import com.google.code.linkedinapi.schema.Publication;
import com.google.code.linkedinapi.schema.Publications;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "publicationList"
})
@XmlRootElement(name = "publications")
public class PublicationsImpl
        implements Serializable, Publications {

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(name = "publication", required = true, type = PublicationImpl.class)
    protected List<Publication> publicationList;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(Adapter1.class)
    protected Long total;

    public List<Publication> getPublicationList() {
        if (publicationList == null) {
            publicationList = new ArrayList<Publication>();
        }
        return this.publicationList;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long value) {
        this.total = value;
    }

}
