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

import java.io.Serializable;
import java.util.Date;

/**
 * Class description
 */
public abstract class LinkedInOAuthToken implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 4249791194912997698L;

    /**
     * Access Token
     */
    private String token;

    /**
     * Token Secret
     */
    private String tokenSecret;

    /**
     * Token Secret
     */
    private Date expirationTime;

    /**
     * Constructs ...
     *
     * @param token       token
     * @param tokenSecret token secret
     */
    public LinkedInOAuthToken(String token, String tokenSecret) {
        this.token = token;
        this.tokenSecret = tokenSecret;
    }

    /**
     * /**
     * Method description
     *
     * @return
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((token == null)
                ? 0
                : token.hashCode());
        result = prime * result + ((tokenSecret == null)
                ? 0
                : tokenSecret.hashCode());

        return result;
    }

    /**
     * Method description
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final LinkedInOAuthToken other = (LinkedInOAuthToken) obj;

        if (token == null) {
            if (other.token != null) {
                return false;
            }
        } else if (!token.equals(other.token)) {
            return false;
        }

        if (tokenSecret == null) {
            if (other.tokenSecret != null) {
                return false;
            }
        } else if (!tokenSecret.equals(other.tokenSecret)) {
            return false;
        }

        return true;
    }

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * @return the tokenSecret
     */
    public String getTokenSecret() {
        return tokenSecret;
    }

    /**
     * @param tokenSecret the tokenSecret to set
     */
    public void setTokenSecret(String tokenSecret) {
        this.tokenSecret = tokenSecret;
    }

    /**
     * @return the expirationTime
     */
    public Date getExpirationTime() {
        return expirationTime;
    }

    /**
     * @param expirationTime the expirationTime to set
     */
    public void setExpirationTime(Date expirationTime) {
        this.expirationTime = expirationTime;
    }
}
