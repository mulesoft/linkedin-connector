/**
 * Mule LinkedIn Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package com.google.code.linkedinapi.client.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Nabeel Mukhtar
 */
public enum ProfileType implements FieldEnum {

    /**
     * standard profile.
     */
    STANDARD(""),

    /**
     * public profile.
     */
    PUBLIC("public");

    /**
     * Field Description.
     */
    private static final Map<String, ProfileType> stringToEnum = new HashMap<String, ProfileType>();

    static { // Initialize map from constant name to enum constant
        for (ProfileType op : values()) {
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
    ProfileType(String name) {
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
     * @return Returns ProfileType for string, or null if string is invalid
     */
    public static ProfileType fromString(String symbol) {
        return stringToEnum.get(symbol);
    }
}
