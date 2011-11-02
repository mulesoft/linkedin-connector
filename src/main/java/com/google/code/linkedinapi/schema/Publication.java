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
 *       &lt;sequence minOccurs="0">
 *         &lt;element ref="{}date"/>
 *         &lt;element ref="{}id"/>
 *         &lt;element ref="{}summary"/>
 *         &lt;element ref="{}title"/>
 *         &lt;element ref="{}url"/>
 *         &lt;element ref="{}authors"/>
 *         &lt;element ref="{}publisher"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
public interface Publication
        extends SchemaEntity {


    /**
     * Gets the value of the date property.
     *
     * @return possible object is
     *         {@link Date }
     */
    Date getDate();

    /**
     * Sets the value of the date property.
     *
     * @param value allowed object is
     *              {@link Date }
     */
    void setDate(Date value);

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
     * Gets the value of the authors property.
     *
     * @return possible object is
     *         {@link Authors }
     */
    Authors getAuthors();

    /**
     * Sets the value of the authors property.
     *
     * @param value allowed object is
     *              {@link Authors }
     */
    void setAuthors(Authors value);

    /**
     * Gets the value of the publisher property.
     *
     * @return possible object is
     *         {@link Publisher }
     */
    Publisher getPublisher();

    /**
     * Sets the value of the publisher property.
     *
     * @param value allowed object is
     *              {@link Publisher }
     */
    void setPublisher(Publisher value);

}
