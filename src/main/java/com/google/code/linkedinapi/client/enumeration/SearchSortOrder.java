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
public enum SearchSortOrder implements FieldEnum {


    /**
     * Number of connections per person, from largest to smallest.
     */
    CONNECTIONS("connections"),

    /**
     * Orders the returns by number of ensorsers each of the search returns has.
     */
    RECOMMENDERS("recommenders"),

    /**
     * Orders the returns based on the ascending degree of separation within a member's network, with first degree connections first.
     */
    DISTANCE("distance"),

    /**
     * Orders the returns based on relevance for the keywords provided.
     */
    RELEVANCE("relevance");

    /**
     * Field Description.
     */
    private static final Map<String, SearchSortOrder> stringToEnum = new HashMap<String, SearchSortOrder>();

    static { // Initialize map from constant name to enum constant
        for (SearchSortOrder op : values()) {
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
    SearchSortOrder(String name) {
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
     * @return Returns SearchSortOrder for string, or null if string is invalid
     */
    public static SearchSortOrder fromString(String symbol) {
        return stringToEnum.get(symbol);
    }
}
