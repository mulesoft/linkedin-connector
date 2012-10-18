/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.module.linkedin.schema;


/**
 * Class used as wrapper for {@link VisibilityType}
 * @author Mulesoft Inc
 *
 */
public enum LinkedInVisibilityType {

    ANYONE("anyone"),
    ALL_MEMBERS("all-members"),
    CONNECTIONS_ONLY("connections-only");
    private final String value;

    LinkedInVisibilityType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LinkedInVisibilityType fromValue(String v) {
        for (LinkedInVisibilityType c : LinkedInVisibilityType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v.toString());
    }

}
