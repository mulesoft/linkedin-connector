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
 *         &lt;element ref="{}related-connections"/>
 *         &lt;element ref="{}distance"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
public interface RelationToViewer
        extends SchemaEntity {


    /**
     * Gets the value of the relatedConnections property.
     *
     * @return possible object is
     *         {@link RelatedConnections }
     */
    RelatedConnections getRelatedConnections();

    /**
     * Sets the value of the relatedConnections property.
     *
     * @param value allowed object is
     *              {@link RelatedConnections }
     */
    void setRelatedConnections(RelatedConnections value);

    /**
     * Gets the value of the distance property.
     *
     * @return possible object is
     *         {@link String }
     */
    Long getDistance();

    /**
     * Sets the value of the distance property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setDistance(Long value);

}
