/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
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
 *         &lt;element ref="{}url"/>
 *         &lt;element ref="{}headers"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
public interface ApiStandardProfileRequest
        extends SchemaEntity {


    /**
     * Gets the value of the url property.
     *
     * @return possible object is
     *         {@link String }
     */
    String getUrl();

    /**
     * Sets the value of the url property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setUrl(String value);

    /**
     * Gets the value of the headers property.
     *
     * @return possible object is
     *         {@link Headers }
     */
    Headers getHeaders();

    /**
     * Sets the value of the headers property.
     *
     * @param value allowed object is
     *              {@link Headers }
     */
    void setHeaders(Headers value);

}
