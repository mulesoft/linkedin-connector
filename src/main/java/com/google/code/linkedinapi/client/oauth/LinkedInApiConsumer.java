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
public class LinkedInApiConsumer extends LinkedInOAuthToken {

    /**
     *
     */
    private static final long serialVersionUID = -508151196474695320L;

    /**
     * Constructs ...
     *
     * @param consumerKey
     * @param consumerSecret
     */
    public LinkedInApiConsumer(String consumerKey, String consumerSecret) {
        super(consumerKey, consumerSecret);
    }

    /**
     * {@see LinkedInOAuthToken#getToken()}
     */
    public String getConsumerKey() {
        return getToken();
    }

    /**
     * {@see LinkedInOAuthToken#setToken()}
     */
    public void setConsumerKey(String consumerKey) {
        setToken(consumerKey);
    }

    /**
     * {@see LinkedInOAuthToken#getTokenSecret()}
     */
    public String getConsumerSecret() {
        return getTokenSecret();
    }

    /**
     * {@see LinkedInOAuthToken#setTokenSecret()}
     */
    public void setConsumerSecret(String consumerSecret) {
        setTokenSecret(consumerSecret);
    }
}
