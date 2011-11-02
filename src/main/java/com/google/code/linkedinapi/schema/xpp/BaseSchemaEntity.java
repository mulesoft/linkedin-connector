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

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Logger;

/**
 * The Class BaseSchemaEntity.
 *
 * @author Nabeel Mukhtar
 */
public abstract class BaseSchemaEntity implements Serializable {

    protected final Logger LOG = Logger.getLogger(getClass().getCanonicalName());

    /**
     *
     */
    private static final long serialVersionUID = 4249791194912997698L;

    /**
     * To xml.
     *
     * @param serializer the document
     * @throws IOException TODO
     */
    public abstract void toXml(XmlSerializer serializer) throws IOException;

    /**
     * Inits the.
     *
     * @param parser the element
     * @throws IOException            TODO
     * @throws XmlPullParserException TODO
     */
    public abstract void init(XmlPullParser parser) throws IOException, XmlPullParserException;


}
