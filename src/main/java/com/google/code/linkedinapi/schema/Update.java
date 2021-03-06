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
 *         &lt;element ref="{}timestamp"/>
 *         &lt;element ref="{}update-key"/>
 *         &lt;element ref="{}update-type"/>
 *         &lt;element ref="{}update-content"/>
 *         &lt;element ref="{}is-commentable"/>
 *         &lt;element ref="{}is-likable"/>
 *         &lt;element ref="{}is-liked"/>
 *         &lt;element ref="{}num-likes"/>
 *         &lt;element ref="{}update-comments" minOccurs="0"/>
 *         &lt;element ref="{}likes" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
public interface Update
        extends SchemaEntity {


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
     * Gets the value of the updateKey property.
     *
     * @return possible object is
     *         {@link String }
     */
    String getUpdateKey();

    /**
     * Sets the value of the updateKey property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setUpdateKey(String value);

    /**
     * Gets the value of the updateType property.
     *
     * @return possible object is
     *         {@link NetworkUpdateReturnType }
     */
    NetworkUpdateReturnType getUpdateType();

    /**
     * Sets the value of the updateType property.
     *
     * @param value allowed object is
     *              {@link NetworkUpdateReturnType }
     */
    void setUpdateType(NetworkUpdateReturnType value);

    /**
     * Gets the value of the updateContent property.
     *
     * @return possible object is
     *         {@link UpdateContent }
     */
    UpdateContent getUpdateContent();

    /**
     * Sets the value of the updateContent property.
     *
     * @param value allowed object is
     *              {@link UpdateContent }
     */
    void setUpdateContent(UpdateContent value);

    /**
     * Gets the value of the isCommentable property.
     */
    boolean isIsCommentable();

    /**
     * Sets the value of the isCommentable property.
     */
    void setIsCommentable(boolean value);

    /**
     * Gets the value of the isLikable property.
     */
    boolean isIsLikable();

    /**
     * Sets the value of the isLikable property.
     */
    void setIsLikable(boolean value);

    /**
     * Gets the value of the isLiked property.
     */
    boolean isIsLiked();

    /**
     * Sets the value of the isLiked property.
     */
    void setIsLiked(boolean value);

    /**
     * Gets the value of the numLikes property.
     *
     * @return possible object is
     *         {@link String }
     */
    Long getNumLikes();

    /**
     * Sets the value of the numLikes property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setNumLikes(Long value);

    /**
     * Gets the value of the updateComments property.
     *
     * @return possible object is
     *         {@link UpdateComments }
     */
    UpdateComments getUpdateComments();

    /**
     * Sets the value of the updateComments property.
     *
     * @param value allowed object is
     *              {@link UpdateComments }
     */
    void setUpdateComments(UpdateComments value);

    /**
     * Gets the value of the likes property.
     *
     * @return possible object is
     *         {@link Likes }
     */
    Likes getLikes();

    /**
     * Sets the value of the likes property.
     *
     * @param value allowed object is
     *              {@link Likes }
     */
    void setLikes(Likes value);

}
