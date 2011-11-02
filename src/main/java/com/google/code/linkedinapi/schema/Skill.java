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
 *         &lt;element ref="{}proficiency"/>
 *         &lt;element ref="{}years"/>
 *         &lt;element ref="{}id"/>
 *         &lt;element name="skill" type="{}name-type"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
public interface Skill
        extends SchemaEntity {


    /**
     * Gets the value of the proficiency property.
     *
     * @return possible object is
     *         {@link Proficiency }
     */
    Proficiency getProficiency();

    /**
     * Sets the value of the proficiency property.
     *
     * @param value allowed object is
     *              {@link Proficiency }
     */
    void setProficiency(Proficiency value);

    /**
     * Gets the value of the years property.
     *
     * @return possible object is
     *         {@link Years }
     */
    Years getYears();

    /**
     * Sets the value of the years property.
     *
     * @param value allowed object is
     *              {@link Years }
     */
    void setYears(Years value);

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
     * Gets the value of the skill property.
     *
     * @return possible object is
     *         {@link NameType }
     */
    NameType getSkill();

    /**
     * Sets the value of the skill property.
     *
     * @param value allowed object is
     *              {@link NameType }
     */
    void setSkill(NameType value);

}
