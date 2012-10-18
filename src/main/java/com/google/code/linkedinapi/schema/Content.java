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
 *         &lt;element ref="{}id" minOccurs="0"/>
 *         &lt;element ref="{}title"/>
 *         &lt;element ref="{}submitted-url"/>
 *         &lt;element ref="{}shortened-url" minOccurs="0"/>
 *         &lt;element ref="{}submitted-image-url"/>
 *         &lt;element ref="{}thumbnail-url" minOccurs="0"/>
 *         &lt;element ref="{}resolved-url" minOccurs="0"/>
 *         &lt;element ref="{}eyebrow-url" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
public interface Content
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
     * Gets the value of the title property.
     *
     * @return possible object is
     *         {@link String }
     */
    String getTitle();

    /**
     * Sets the value of the title property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setTitle(String value);

    /**
     * Gets the value of the submittedUrl property.
     *
     * @return possible object is
     *         {@link String }
     */
    String getSubmittedUrl();

    /**
     * Sets the value of the submittedUrl property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setSubmittedUrl(String value);

    /**
     * Gets the value of the shortenedUrl property.
     *
     * @return possible object is
     *         {@link String }
     */
    String getShortenedUrl();

    /**
     * Sets the value of the shortenedUrl property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setShortenedUrl(String value);

    /**
     * Gets the value of the submittedImageUrl property.
     *
     * @return possible object is
     *         {@link String }
     */
    String getSubmittedImageUrl();

    /**
     * Sets the value of the submittedImageUrl property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setSubmittedImageUrl(String value);

    /**
     * Gets the value of the thumbnailUrl property.
     *
     * @return possible object is
     *         {@link String }
     */
    String getThumbnailUrl();

    /**
     * Sets the value of the thumbnailUrl property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setThumbnailUrl(String value);

    /**
     * Gets the value of the resolvedUrl property.
     *
     * @return possible object is
     *         {@link String }
     */
    String getResolvedUrl();

    /**
     * Sets the value of the resolvedUrl property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setResolvedUrl(String value);

    /**
     * Gets the value of the eyebrowUrl property.
     *
     * @return possible object is
     *         {@link String }
     */
    String getEyebrowUrl();

    /**
     * Sets the value of the eyebrowUrl property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setEyebrowUrl(String value);

}
