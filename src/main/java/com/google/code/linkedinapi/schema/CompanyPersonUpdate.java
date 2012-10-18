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
 *         &lt;element ref="{}person"/>
 *         &lt;element ref="{}action"/>
 *         &lt;element ref="{}old-position"/>
 *         &lt;element ref="{}new-position"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
public interface CompanyPersonUpdate
        extends SchemaEntity {


    /**
     * Gets the value of the person property.
     *
     * @return possible object is
     *         {@link Person }
     */
    Person getPerson();

    /**
     * Sets the value of the person property.
     *
     * @param value allowed object is
     *              {@link Person }
     */
    void setPerson(Person value);

    /**
     * Gets the value of the action property.
     *
     * @return possible object is
     *         {@link Action }
     */
    Action getAction();

    /**
     * Sets the value of the action property.
     *
     * @param value allowed object is
     *              {@link Action }
     */
    void setAction(Action value);

    /**
     * Gets the value of the oldPosition property.
     *
     * @return possible object is
     *         {@link OldPosition }
     */
    OldPosition getOldPosition();

    /**
     * Sets the value of the oldPosition property.
     *
     * @param value allowed object is
     *              {@link OldPosition }
     */
    void setOldPosition(OldPosition value);

    /**
     * Gets the value of the newPosition property.
     *
     * @return possible object is
     *         {@link NewPosition }
     */
    NewPosition getNewPosition();

    /**
     * Sets the value of the newPosition property.
     *
     * @param value allowed object is
     *              {@link NewPosition }
     */
    void setNewPosition(NewPosition value);

}
