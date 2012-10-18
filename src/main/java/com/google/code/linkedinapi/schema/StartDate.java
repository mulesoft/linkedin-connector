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
 *         &lt;element ref="{}year"/>
 *         &lt;element ref="{}month" minOccurs="0"/>
 *         &lt;element ref="{}day" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
public interface StartDate
        extends SchemaEntity {


    /**
     * Gets the value of the year property.
     *
     * @return possible object is
     *         {@link String }
     */
    Long getYear();

    /**
     * Sets the value of the year property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setYear(Long value);

    /**
     * Gets the value of the month property.
     *
     * @return possible object is
     *         {@link String }
     */
    Long getMonth();

    /**
     * Sets the value of the month property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setMonth(Long value);

    /**
     * Gets the value of the day property.
     *
     * @return possible object is
     *         {@link String }
     */
    Long getDay();

    /**
     * Sets the value of the day property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setDay(Long value);

}
