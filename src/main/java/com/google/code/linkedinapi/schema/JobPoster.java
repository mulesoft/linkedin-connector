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
 *         &lt;element ref="{}first-name"/>
 *         &lt;element ref="{}last-name"/>
 *         &lt;element ref="{}headline"/>
 *         &lt;element ref="{}api-standard-profile-request"/>
 *         &lt;element ref="{}site-standard-profile-request"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
public interface JobPoster
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
     * Gets the value of the firstName property.
     *
     * @return possible object is
     *         {@link String }
     */
    String getFirstName();

    /**
     * Sets the value of the firstName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setFirstName(String value);

    /**
     * Gets the value of the lastName property.
     *
     * @return possible object is
     *         {@link String }
     */
    String getLastName();

    /**
     * Sets the value of the lastName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setLastName(String value);

    /**
     * Gets the value of the headline property.
     *
     * @return possible object is
     *         {@link String }
     */
    String getHeadline();

    /**
     * Sets the value of the headline property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setHeadline(String value);

    /**
     * Gets the value of the apiStandardProfileRequest property.
     *
     * @return possible object is
     *         {@link ApiStandardProfileRequest }
     */
    ApiStandardProfileRequest getApiStandardProfileRequest();

    /**
     * Sets the value of the apiStandardProfileRequest property.
     *
     * @param value allowed object is
     *              {@link ApiStandardProfileRequest }
     */
    void setApiStandardProfileRequest(ApiStandardProfileRequest value);

    /**
     * Gets the value of the siteStandardProfileRequest property.
     *
     * @return possible object is
     *         {@link SiteStandardProfileRequest }
     */
    SiteStandardProfileRequest getSiteStandardProfileRequest();

    /**
     * Sets the value of the siteStandardProfileRequest property.
     *
     * @param value allowed object is
     *              {@link SiteStandardProfileRequest }
     */
    void setSiteStandardProfileRequest(SiteStandardProfileRequest value);

}
