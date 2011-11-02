/**
 * Mule LinkedIn Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package com.google.code.linkedinapi.client.oauth;

/**
 * Class description
 */
public class LinkedInAccessToken extends LinkedInOAuthToken {

    /**
     *
     */
    private static final long serialVersionUID = 9086158442025329174L;

    /**
     * Constructs ...
     *
     * @param token
     * @param tokenSecret
     */
    public LinkedInAccessToken(String token, String tokenSecret) {
        super(token, tokenSecret);
    }
}
