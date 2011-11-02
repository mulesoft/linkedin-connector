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

/**
 * The Interface CompositeEnum.
 *
 * @param <Parent>
 */
public interface CompositeEnum<Parent extends CompositeEnum<Parent>> extends FieldEnum {

    /**
     * Parent.
     *
     * @return the parent
     */
    public Parent parent();
}
