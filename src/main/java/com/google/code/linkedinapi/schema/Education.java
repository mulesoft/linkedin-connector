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
 *         &lt;element ref="{}id"/>
 *         &lt;element ref="{}school-name"/>
 *         &lt;element ref="{}degree"/>
 *         &lt;element ref="{}notes"/>
 *         &lt;element ref="{}activities"/>
 *         &lt;element ref="{}field-of-study"/>
 *         &lt;element ref="{}start-date"/>
 *         &lt;element ref="{}end-date"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
public interface Education
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
     * Gets the value of the schoolName property.
     *
     * @return possible object is
     *         {@link String }
     */
    String getSchoolName();

    /**
     * Sets the value of the schoolName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setSchoolName(String value);

    /**
     * Gets the value of the degree property.
     *
     * @return possible object is
     *         {@link String }
     */
    String getDegree();

    /**
     * Sets the value of the degree property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setDegree(String value);

    /**
     * Gets the value of the notes property.
     *
     * @return possible object is
     *         {@link String }
     */
    String getNotes();

    /**
     * Sets the value of the notes property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setNotes(String value);

    /**
     * Gets the value of the activities property.
     *
     * @return possible object is
     *         {@link String }
     */
    String getActivities();

    /**
     * Sets the value of the activities property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setActivities(String value);

    /**
     * Gets the value of the fieldOfStudy property.
     *
     * @return possible object is
     *         {@link String }
     */
    String getFieldOfStudy();

    /**
     * Sets the value of the fieldOfStudy property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setFieldOfStudy(String value);

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
