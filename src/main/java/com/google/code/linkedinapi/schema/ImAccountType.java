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
 *     &lt;enumeration value="aim"/>
 *     &lt;enumeration value="gtalk"/>
 *     &lt;enumeration value="icq"/>
 *     &lt;enumeration value="msn"/>
 *     &lt;enumeration value="skype"/>
 *     &lt;enumeration value="yahoo"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlEnum
public enum ImAccountType {

    @XmlEnumValue("aim")
    AIM("aim"),
    @XmlEnumValue("gtalk")
    GTALK("gtalk"),
    @XmlEnumValue("icq")
    ICQ("icq"),
    @XmlEnumValue("msn")
    MSN("msn"),
    @XmlEnumValue("skype")
    SKYPE("skype"),
    @XmlEnumValue("yahoo")
    YAHOO("yahoo");
    private final String value;

    ImAccountType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ImAccountType fromValue(String v) {
        for (ImAccountType c : ImAccountType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v.toString());
    }

}
