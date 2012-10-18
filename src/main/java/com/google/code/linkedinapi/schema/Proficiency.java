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
 *         &lt;element ref="{}level"/>
 *         &lt;element ref="{}name"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
public interface Proficiency
        extends SchemaEntity {


    /**
     * Gets the value of the level property.
     *
     * @return possible object is
     *         {@link ProficiencyLevelType }
     */
    ProficiencyLevelType getLevel();

    /**
     * Sets the value of the level property.
     *
     * @param value allowed object is
     *              {@link ProficiencyLevelType }
     */
    void setLevel(ProficiencyLevelType value);

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

}
