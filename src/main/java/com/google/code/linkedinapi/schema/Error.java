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
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element ref="{}timestamp"/>
 *         &lt;element ref="{}error-code"/>
 *         &lt;element ref="{}message"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
public interface Error
        extends SchemaEntity {


    /**
     * Gets the value of the status property.
     *
     * @return possible object is
     *         {@link String }
     */
    Long getStatus();

    /**
     * Sets the value of the status property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setStatus(Long value);

    /**
     * Gets the value of the timestamp property.
     *
     * @return possible object is
     *         {@link String }
     */
    Long getTimestamp();

    /**
     * Sets the value of the timestamp property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setTimestamp(Long value);

    /**
     * Gets the value of the errorCode property.
     *
     * @return possible object is
     *         {@link String }
     */
    String getErrorCode();

    /**
     * Sets the value of the errorCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setErrorCode(String value);

    /**
     * Gets the value of the message property.
     *
     * @return possible object is
     *         {@link String }
     */
    String getMessage();

    /**
     * Sets the value of the message property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setMessage(String value);

}
