/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package com.google.code.linkedinapi.client.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Nabeel Mukhtar
 */
public enum HttpMethod implements FieldEnum {

    /**
     * HTTP Get Method
     */
    GET("GET"),

    /**
     * HTTP Put Method
     */
    PUT("PUT"),

    /**
     * HTTP Post Method
     */
    POST("POST"),

    /**
     * HTTP Delete Method
     */
    DELETE("DELETE");

    /**
     * Field Description.
     */
    private static final Map<String, HttpMethod> stringToEnum = new HashMap<String, HttpMethod>();

    static { // Initialize map from constant name to enum constant
        for (HttpMethod op : values()) {
            stringToEnum.put(op.fieldName(), op);
        }
    }

    /**
     * Field description
     */
    private final String fieldName;

    /**
     * Constructs ...
     *
     * @param name
     */
    HttpMethod(String name) {
        this.fieldName = name;
    }

    /**
     * @return the name of the field
     */
    public String fieldName() {
        return this.fieldName;
    }

    /**
     * Method description
     *
     * @return
     */
    @Override
    public String toString() {
        return fieldName();
    }

    /**
     * @return Returns HttpMethod for string, or null if string is invalid
     */
    public static HttpMethod fromString(String symbol) {
        return stringToEnum.get(symbol);
    }
}
