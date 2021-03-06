/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package com.google.code.linkedinapi.schema;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class Adapter1
        extends XmlAdapter<String, Long> {


    public Long unmarshal(String value) {
        return new Long(value);
    }

    public String marshal(Long value) {
        return value.toString();
    }

}
