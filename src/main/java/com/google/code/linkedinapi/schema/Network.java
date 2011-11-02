/**
 * Mule LinkedIn Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package com.google.code.linkedinapi.schema;


/**
 * <p>Java class for anonymous complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}network-stats"/>
 *         &lt;element ref="{}updates"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
public interface Network
        extends SchemaEntity {


    /**
     * Gets the value of the networkStats property.
     *
     * @return possible object is
     *         {@link NetworkStats }
     */
    NetworkStats getNetworkStats();

    /**
     * Sets the value of the networkStats property.
     *
     * @param value allowed object is
     *              {@link NetworkStats }
     */
    void setNetworkStats(NetworkStats value);

    /**
     * Gets the value of the updates property.
     *
     * @return possible object is
     *         {@link Updates }
     */
    Updates getUpdates();

    /**
     * Sets the value of the updates property.
     *
     * @param value allowed object is
     *              {@link Updates }
     */
    void setUpdates(Updates value);

}
