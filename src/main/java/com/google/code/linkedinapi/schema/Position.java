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
 *         &lt;element ref="{}id" minOccurs="0"/>
 *         &lt;element ref="{}title"/>
 *         &lt;element ref="{}summary" minOccurs="0"/>
 *         &lt;element ref="{}start-date" minOccurs="0"/>
 *         &lt;element ref="{}end-date" minOccurs="0"/>
 *         &lt;sequence minOccurs="0">
 *           &lt;element ref="{}is-current"/>
 *           &lt;element ref="{}company"/>
 *         &lt;/sequence>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
public interface Position
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
     * Gets the value of the summary property.
     *
     * @return possible object is
     *         {@link String }
     */
    String getSummary();

    /**
     * Sets the value of the summary property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setSummary(String value);

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

    /**
     * Gets the value of the isCurrent property.
     *
     * @return possible object is
     *         {@link Boolean }
     */
    Boolean isIsCurrent();

    /**
     * Sets the value of the isCurrent property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    void setIsCurrent(Boolean value);

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
