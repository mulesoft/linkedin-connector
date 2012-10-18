/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package com.google.code.linkedinapi.schema.impl;

import com.google.code.linkedinapi.schema.Application;
import com.google.code.linkedinapi.schema.ServiceProvider;
import com.google.code.linkedinapi.schema.Source;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "serviceProvider",
        "application"
})
@XmlRootElement(name = "source")
public class SourceImpl
        implements Serializable, Source {

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(name = "service-provider", required = true, type = ServiceProviderImpl.class)
    protected ServiceProviderImpl serviceProvider;
    @XmlElement(required = true, type = ApplicationImpl.class)
    protected ApplicationImpl application;

    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(ServiceProvider value) {
        this.serviceProvider = ((ServiceProviderImpl) value);
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application value) {
        this.application = ((ApplicationImpl) value);
    }

}
