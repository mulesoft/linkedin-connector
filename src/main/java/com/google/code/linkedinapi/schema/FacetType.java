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

public enum FacetType {

    LOCATION("location"),
    INDUSTRY("industry"),
    NETWORK("network"),
    LANGUAGE("language"),
    CURRENT_COMPANY("current-company"),
    PAST_COMPANY("past-company"),
    SCHOOL("school");
    private final String value;

    FacetType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FacetType fromValue(String v) {
        for (FacetType c : FacetType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v.toString());
    }

}
