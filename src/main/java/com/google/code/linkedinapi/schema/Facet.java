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
 *         &lt;element ref="{}name"/>
 *         &lt;element name="code">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="location"/>
 *               &lt;enumeration value="industry"/>
 *               &lt;enumeration value="network"/>
 *               &lt;enumeration value="language"/>
 *               &lt;enumeration value="current-company"/>
 *               &lt;enumeration value="past-company"/>
 *               &lt;enumeration value="school"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element ref="{}buckets" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
public interface Facet
        extends SchemaEntity {


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
     * Gets the value of the code property.
     *
     * @return possible object is
     *         {@link FacetType }
     */
    FacetType getCode();

    /**
     * Sets the value of the code property.
     *
     * @param value allowed object is
     *              {@link FacetType }
     */
    void setCode(FacetType value);

    /**
     * Gets the value of the buckets property.
     *
     * @return possible object is
     *         {@link Buckets }
     */
    Buckets getBuckets();

    /**
     * Sets the value of the buckets property.
     *
     * @param value allowed object is
     *              {@link Buckets }
     */
    void setBuckets(Buckets value);

}
