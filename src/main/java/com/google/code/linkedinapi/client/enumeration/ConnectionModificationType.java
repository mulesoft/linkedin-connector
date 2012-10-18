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
public enum ConnectionModificationType implements FieldEnum {

    /**
     * update and new.
     */
    ALL(""),

    /**
     * new.
     */
    NEW("new"),

    /**
     * updated.
     */
    UPDATED("updated");

    /**
     * Field Description.
     */
    private static final Map<String, ConnectionModificationType> stringToEnum = new HashMap<String, ConnectionModificationType>();

    static { // Initialize map from constant name to enum constant
        for (ConnectionModificationType op : values()) {
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
    ConnectionModificationType(String name) {
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
    public static ConnectionModificationType fromString(String symbol) {
        return stringToEnum.get(symbol);
    }
}
