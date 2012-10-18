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
 *         &lt;element ref="{}content" minOccurs="0"/>
 *         &lt;element ref="{}visibility"/>
 *         &lt;element ref="{}comment"/>
 *         &lt;element ref="{}attribution" minOccurs="0"/>
 *         &lt;element ref="{}id" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
public interface Share
        extends SchemaEntity {


    /**
     * Gets the value of the content property.
     *
     * @return possible object is
     *         {@link Content }
     */
    Content getContent();

    /**
     * Sets the value of the content property.
     *
     * @param value allowed object is
     *              {@link Content }
     */
    void setContent(Content value);

    /**
     * Gets the value of the visibility property.
     *
     * @return possible object is
     *         {@link Visibility }
     */
    Visibility getVisibility();

    /**
     * Sets the value of the visibility property.
     *
     * @param value allowed object is
     *              {@link Visibility }
     */
    void setVisibility(Visibility value);

    /**
     * Gets the value of the comment property.
     *
     * @return possible object is
     *         {@link String }
     */
    String getComment();

    /**
     * Sets the value of the comment property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setComment(String value);

    /**
     * Gets the value of the attribution property.
     *
     * @return possible object is
     *         {@link Attribution }
     */
    Attribution getAttribution();

    /**
     * Sets the value of the attribution property.
     *
     * @param value allowed object is
     *              {@link Attribution }
     */
    void setAttribution(Attribution value);

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

}
