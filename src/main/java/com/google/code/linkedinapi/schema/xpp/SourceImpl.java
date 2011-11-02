/**
 * Mule LinkedIn Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package com.google.code.linkedinapi.schema.xpp;

import com.google.code.linkedinapi.schema.Application;
import com.google.code.linkedinapi.schema.ServiceProvider;
import com.google.code.linkedinapi.schema.Source;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;

public class SourceImpl
        extends BaseSchemaEntity
        implements Source {

    private final static long serialVersionUID = 2461660169443089969L;
    protected ServiceProviderImpl serviceProvider;
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

    @Override
    public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);

        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();

            if (name.equals("service-provider")) {
                ServiceProviderImpl sp = new ServiceProviderImpl();
                sp.init(parser);
                setServiceProvider(sp);
            } else if (name.equals("application")) {
                ApplicationImpl app = new ApplicationImpl();
                app.init(parser);
                setApplication(app);
            } else {
                // Consume something we don't understand.
                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
        }
    }

    @Override
    public void toXml(XmlSerializer serializer) throws IOException {
        serializer.startTag(null, "source");
        if (getServiceProvider() != null) {
            ((ServiceProviderImpl) getServiceProvider()).toXml(serializer);
        }
        if (getApplication() != null) {
            ((ApplicationImpl) getApplication()).toXml(serializer);
        }
        serializer.endTag(null, "source");
    }

}
