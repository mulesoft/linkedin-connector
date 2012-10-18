/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package com.google.code.linkedinapi.client;

import com.google.code.linkedinapi.client.constant.ApplicationConstants;
import com.google.code.linkedinapi.client.impl.AsyncLinkedInApiClientAdapter;
import com.google.code.linkedinapi.client.oauth.LinkedInAccessToken;
import com.google.code.linkedinapi.client.oauth.LinkedInApiConsumer;

import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * A factory for creating LinkedInApiClient objects.
 *
 * @author Nabeel Mukhtar
 */
public class LinkedInApiClientFactory {

    /**
     * The Constant factoriesMap.
     */
    private static final Map<LinkedInApiConsumer, LinkedInApiClientFactory> factoriesMap =
            new ConcurrentHashMap<LinkedInApiConsumer, LinkedInApiClientFactory>();

    /**
     * The task executor.
     */
    private ExecutorService taskExecutor = Executors.newCachedThreadPool();

    /**
     * The api consumer.
     */
    private LinkedInApiConsumer apiConsumer;

    /**
     * The default client impl.
     */
    private Constructor<? extends LinkedInApiClient> defaultClientImpl;

    /**
     * Instantiates a new linked in api client factory.
     *
     * @param apiConsumer the api consumer
     */
    private LinkedInApiClientFactory(LinkedInApiConsumer apiConsumer) {
        this.apiConsumer = apiConsumer;
    }

    /**
     * Sets the task executor to be used for asynchronous API calls.
     *
     * @param taskExecutor the task executor
     */
    public void setTaskExecutor(ExecutorService taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    /**
     * New instance.
     *
     * @param consumerKey    the consumer key
     * @param consumerSecret the consumer secret
     * @return the linked in api client factory
     */
    public static LinkedInApiClientFactory newInstance(String consumerKey, String consumerSecret) {
        return newInstance(new LinkedInApiConsumer(consumerKey, consumerSecret));
    }

    /**
     * New instance.
     *
     * @param apiConsumer the api consumer
     * @return the linked in api client factory
     */
    public static synchronized LinkedInApiClientFactory newInstance(LinkedInApiConsumer apiConsumer) {
        validateConsumerKey(apiConsumer);

        LinkedInApiClientFactory factory = factoriesMap.get(apiConsumer);

        if (factory == null) {
            factory = new LinkedInApiClientFactory(apiConsumer);
            factoriesMap.put(apiConsumer, factory);
        }

        return factory;
    }

    /**
     * Creates a new LinkedInApiClient object.
     *
     * @param accessToken the access token
     * @return the linked in api client
     */
    @SuppressWarnings("unchecked")
    public LinkedInApiClient createLinkedInApiClient(LinkedInAccessToken accessToken) {
        validateAccessToken(accessToken);
        try {
            if (defaultClientImpl == null) {
                Class<? extends LinkedInApiClient> clazz = (Class<? extends LinkedInApiClient>) Class.forName(ApplicationConstants.CLIENT_DEFAULT_IMPL);

                defaultClientImpl = clazz.getConstructor(String.class, String.class);
            }

            final LinkedInApiClient client = defaultClientImpl.newInstance(apiConsumer.getConsumerKey(), apiConsumer.getConsumerSecret());

            client.setAccessToken(accessToken);

            return client;
        } catch (Exception e) {
            throw new LinkedInApiClientException(e);
        }
    }

    /**
     * Creates a new LinkedInApiClient object.
     *
     * @param accessToken the access token
     * @return the linked in api client
     */
    public LinkedInApiClient createLinkedInApiClient(Class<? extends LinkedInApiClient> implClass, LinkedInAccessToken accessToken) {
        validateAccessToken(accessToken);
        try {
            final LinkedInApiClient client = implClass.getConstructor(String.class, String.class).newInstance(apiConsumer.getConsumerKey(), apiConsumer.getConsumerSecret());

            client.setAccessToken(accessToken);

            return client;
        } catch (Exception e) {
            throw new LinkedInApiClientException(e);
        }
    }

    /**
     * Creates a new LinkedInApiClient object.
     *
     * @param accessToken the access token
     * @return the async linked in api client
     */
    public AsyncLinkedInApiClient createAsyncLinkedInApiClient(LinkedInAccessToken accessToken) {
        validateAccessToken(accessToken);
        final LinkedInApiClient client = createLinkedInApiClient(accessToken);

        return new AsyncLinkedInApiClientAdapter(client, taskExecutor);
    }

    /**
     * Creates a new LinkedInApiClient object.
     *
     * @param token       the token
     * @param tokenSecret the token secret
     * @return the linked in api client
     */
    public LinkedInApiClient createLinkedInApiClient(String token, String tokenSecret) {
        return createLinkedInApiClient(new LinkedInAccessToken(token, tokenSecret));
    }

    /**
     * Creates a new LinkedInApiClient object.
     *
     * @param token       the token
     * @param tokenSecret the token secret
     * @return the async linked in api client
     */
    public AsyncLinkedInApiClient createAsyncLinkedInApiClient(String token, String tokenSecret) {
        return createAsyncLinkedInApiClient(new LinkedInAccessToken(token, tokenSecret));
    }

    /**
     *
     */
    private static void validateConsumerKey(LinkedInApiConsumer apiConsumer) {
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

    /**
     *
     */
    private void validateAccessToken(LinkedInAccessToken accessToken) {
        if (accessToken == null) {
            throw new IllegalArgumentException("access token cannot be null.");
        }
        if (accessToken.getToken() == null || accessToken.getToken().length() == 0) {
            throw new IllegalArgumentException("access token cannot be null or empty.");
        }
        if (accessToken.getTokenSecret() == null || accessToken.getTokenSecret().length() == 0) {
            throw new IllegalArgumentException("access token secret cannot be null or empty.");
        }
    }
}
