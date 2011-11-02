/**
 * Mule LinkedIn Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package com.google.code.linkedinapi.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for null.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;simpleType>
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="business-partner"/>
 *     &lt;enumeration value="colleague"/>
 *     &lt;enumeration value="education"/>
 *     &lt;enumeration value="service-provider"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlEnum
public enum RecommendationCode {

    @XmlEnumValue("business-partner")
    BUSINESS_PARTNER("business-partner"),
    @XmlEnumValue("colleague")
    COLLEAGUE("colleague"),
    @XmlEnumValue("education")
    EDUCATION("education"),
    @XmlEnumValue("service-provider")
    SERVICE_PROVIDER("service-provider");
    private final String value;

    RecommendationCode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RecommendationCode fromValue(String v) {
        for (RecommendationCode c : RecommendationCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v.toString());
    }

}
