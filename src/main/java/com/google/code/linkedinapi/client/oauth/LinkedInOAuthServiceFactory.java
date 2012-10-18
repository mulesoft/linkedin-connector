/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package com.google.code.linkedinapi.client.oauth;


/**
 * A factory for creating LinkedInOAuthService objects.
 *
 * @author Nabeel Mukhtar
 */
public class LinkedInOAuthServiceFactory {

    /**
     * The instance.
     */
    private static LinkedInOAuthServiceFactory instance;

    /**
     * Instantiates a new linked in o auth service factory.
     */
    private LinkedInOAuthServiceFactory() {
    }

    /**
     * Gets the single instance of LinkedInOAuthServiceFactory.
     *
     * @return single instance of LinkedInOAuthServiceFactory
     */
    public static synchronized LinkedInOAuthServiceFactory getInstance() {
        if (instance == null) {
            instance = new LinkedInOAuthServiceFactory();
        }

        return instance;
    }

    /**
     * Creates a new LinkedInOAuthService object.
     *
     * @param consumerKey    the consumer key
     * @param consumerSecret the consumer secret
     * @return the linked in o auth service
     */
    public LinkedInOAuthService createLinkedInOAuthService(String consumerKey, String consumerSecret) {
        return createLinkedInOAuthService(new LinkedInApiConsumer(consumerKey, consumerSecret));
    }

    /**
     * Creates a new LinkedInOAuthService object.
     *
     * @param apiConsumer the api consumer
     * @return the linked in o auth service
     */
    public LinkedInOAuthService createLinkedInOAuthService(LinkedInApiConsumer apiConsumer) {
        validateConsumerKey(apiConsumer);
        return new LinkedInOAuthServiceImpl(apiConsumer);
    }

    /**
     *
     */
    private void validateConsumerKey(LinkedInApiConsumer apiConsumer) {
        if (apiConsumer == null) {
            throw new IllegalArgumentException("api consumer cannot be null.");
        }
        if (apiConsumer.getConsumerKey() == null || apiConsumer.getConsumerKey().length() == 0) {
            throw new IllegalArgumentException("consumer key cannot be null or empty.");
        }
        if (apiConsumer.getConsumerSecret() == null || apiConsumer.getConsumerSecret().length() == 0) {
            throw new IllegalArgumentException("consumer secret cannot be null or empty.");
        }
    }
}
