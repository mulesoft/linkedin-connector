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
 *         &lt;element ref="{}timestamp"/>
 *         &lt;element ref="{}comment"/>
 *         &lt;element ref="{}content"/>
 *         &lt;element ref="{}visibility"/>
 *         &lt;element ref="{}source"/>
 *         &lt;element ref="{}author"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
public interface CurrentShare
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
     * Gets the value of the timestamp property.
     *
     * @return possible object is
     *         {@link String }
     */
    Long getTimestamp();

    /**
     * Sets the value of the timestamp property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setTimestamp(Long value);

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
     * Gets the value of the source property.
     *
     * @return possible object is
     *         {@link Source }
     */
    Source getSource();

    /**
     * Sets the value of the source property.
     *
     * @param value allowed object is
     *              {@link Source }
     */
    void setSource(Source value);

    /**
     * Gets the value of the author property.
     *
     * @return possible object is
     *         {@link Author }
     */
    Author getAuthor();

    /**
     * Sets the value of the author property.
     *
     * @param value allowed object is
     *              {@link Author }
     */
    void setAuthor(Author value);

}
