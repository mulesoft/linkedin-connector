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
 *         &lt;element ref="{}id"/>
 *         &lt;element ref="{}name"/>
 *         &lt;element ref="{}authority"/>
 *         &lt;element ref="{}number"/>
 *         &lt;element ref="{}start-date"/>
 *         &lt;element ref="{}end-date"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
public interface Certification
        extends SchemaEntity {


    /**
     * Gets the value of the id property.
     *
     * @return possible object is
     *         {@link String }
     */
    String getId();

    /**
     * Sets the value of the id property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setId(String value);

    /**
     * Gets the value of the name property.
     *
     * @return possible object is
     *         {@link String }
     */
    String getName();

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setName(String value);

    /**
     * Gets the value of the authority property.
     *
     * @return possible object is
     *         {@link Authority }
     */
    Authority getAuthority();

    /**
     * Sets the value of the authority property.
     *
     * @param value allowed object is
     *              {@link Authority }
     */
    void setAuthority(Authority value);

    /**
     * Gets the value of the number property.
     *
     * @return possible object is
     *         {@link String }
     */
    String getNumber();

    /**
     * Sets the value of the number property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setNumber(String value);

    /**
     * Gets the value of the startDate property.
     *
     * @return possible object is
     *         {@link StartDate }
     */
    StartDate getStartDate();

    /**
     * Sets the value of the startDate property.
     *
     * @param value allowed object is
     *              {@link StartDate }
     */
    void setStartDate(StartDate value);

    /**
     * Gets the value of the endDate property.
     *
     * @return possible object is
     *         {@link EndDate }
     */
    EndDate getEndDate();

    /**
     * Sets the value of the endDate property.
     *
     * @param value allowed object is
     *              {@link EndDate }
     */
    void setEndDate(EndDate value);

}
