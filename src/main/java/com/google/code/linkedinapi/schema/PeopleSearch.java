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
 *         &lt;element ref="{}num-results"/>
 *         &lt;element ref="{}people" minOccurs="0"/>
 *         &lt;element ref="{}facets" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
public interface PeopleSearch
        extends SchemaEntity {


    /**
     * Gets the value of the numResults property.
     *
     * @return possible object is
     *         {@link String }
     */
    Long getNumResults();

    /**
     * Sets the value of the numResults property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setNumResults(Long value);

    /**
     * Gets the value of the people property.
     *
     * @return possible object is
     *         {@link People }
     */
    People getPeople();

    /**
     * Sets the value of the people property.
     *
     * @param value allowed object is
     *              {@link People }
     */
    void setPeople(People value);

    /**
     * Gets the value of the facets property.
     *
     * @return possible object is
     *         {@link Facets }
     */
    Facets getFacets();

    /**
     * Sets the value of the facets property.
     *
     * @param value allowed object is
     *              {@link Facets }
     */
    void setFacets(Facets value);

}
