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
 *         &lt;element ref="{}editor"/>
 *         &lt;element ref="{}action"/>
 *         &lt;element ref="{}profile-field"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
public interface CompanyProfileUpdate
        extends SchemaEntity {


    /**
     * Gets the value of the editor property.
     *
     * @return possible object is
     *         {@link Editor }
     */
    Editor getEditor();

    /**
     * Sets the value of the editor property.
     *
     * @param value allowed object is
     *              {@link Editor }
     */
    void setEditor(Editor value);

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
     * Gets the value of the profileField property.
     *
     * @return possible object is
     *         {@link ProfileField }
     */
    ProfileField getProfileField();

    /**
     * Sets the value of the profileField property.
     *
     * @param value allowed object is
     *              {@link ProfileField }
     */
    void setProfileField(ProfileField value);

}
