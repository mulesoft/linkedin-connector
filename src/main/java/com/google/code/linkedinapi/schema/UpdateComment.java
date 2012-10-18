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
 *         &lt;sequence minOccurs="0">
 *           &lt;element ref="{}id"/>
 *           &lt;element ref="{}sequence-number"/>
 *         &lt;/sequence>
 *         &lt;element ref="{}comment"/>
 *         &lt;sequence minOccurs="0">
 *           &lt;element ref="{}person"/>
 *           &lt;element ref="{}timestamp"/>
 *         &lt;/sequence>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
public interface UpdateComment
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
     * Gets the value of the sequenceNumber property.
     *
     * @return possible object is
     *         {@link String }
     */
    Long getSequenceNumber();

    /**
     * Sets the value of the sequenceNumber property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setSequenceNumber(Long value);

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

}
