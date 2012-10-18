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
 *         &lt;element ref="{}timestamp" minOccurs="0"/>
 *         &lt;element ref="{}content-type" minOccurs="0"/>
 *         &lt;element ref="{}body"/>
 *         &lt;element ref="{}app-id" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="locale" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
public interface Activity
        extends SchemaEntity {


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
     * Gets the value of the contentType property.
     *
     * @return possible object is
     *         {@link NetworkUpdateContentType }
     */
    NetworkUpdateContentType getContentType();

    /**
     * Sets the value of the contentType property.
     *
     * @param value allowed object is
     *              {@link NetworkUpdateContentType }
     */
    void setContentType(NetworkUpdateContentType value);

    /**
     * Gets the value of the body property.
     *
     * @return possible object is
     *         {@link String }
     */
    String getBody();

    /**
     * Sets the value of the body property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setBody(String value);

    /**
     * Gets the value of the appId property.
     *
     * @return possible object is
     *         {@link String }
     */
    String getAppId();

    /**
     * Sets the value of the appId property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setAppId(String value);

    /**
     * Gets the value of the locale property.
     *
     * @return possible object is
     *         {@link String }
     */
    String getLocale();

    /**
     * Sets the value of the locale property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setLocale(String value);

}
