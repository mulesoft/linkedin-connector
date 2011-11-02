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
 *         &lt;element ref="{}title"/>
 *         &lt;element ref="{}company"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
public interface NewPosition
        extends SchemaEntity {


    /**
     * Gets the value of the title property.
     *
     * @return possible object is
     *         {@link String }
     */
    String getTitle();

    /**
     * Sets the value of the title property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setTitle(String value);

    /**
     * Gets the value of the company property.
     *
     * @return possible object is
     *         {@link Company }
     */
    Company getCompany();

    /**
     * Sets the value of the company property.
     *
     * @param value allowed object is
     *              {@link Company }
     */
    void setCompany(Company value);

}
