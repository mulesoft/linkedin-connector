/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package com.google.code.linkedinapi.client.oauth;

/**
 * Class description
 */
public class LinkedInRequestToken extends LinkedInOAuthToken {

    /**
     *
     */
    private static final long serialVersionUID = 1427085882101705465L;
    /**
     * Field description
     */
    private String authorizationUrl;

    /**
     * Constructs ...
     *
     * @param token
     * @param tokenSecret
     */
    public LinkedInRequestToken(String token, String tokenSecret) {
        super(token, tokenSecret);
    }

    /**
     * Method description
     *
     * @return
     */
    public String getAuthorizationUrl() {
        return authorizationUrl;
    }

    /**
     * Method description
     *
     * @param authorizationUrl
     */
    public void setAuthorizationUrl(String authorizationUrl) {
        this.authorizationUrl = authorizationUrl;
    }
}
