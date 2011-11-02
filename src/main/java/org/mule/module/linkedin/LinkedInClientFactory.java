/**
 * Mule LinkedIn Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.module.linkedin;

import com.google.code.linkedinapi.client.LinkedInApiClient;

public class LinkedInClientFactory {

    private static LinkedInApiClient defaultClient;

    public static LinkedInApiClient getClient(String apiKey, String apiSecret, String accessToken, String accessTokenSecret) {
        if (defaultClient != null) {
            return defaultClient;
        }
        com.google.code.linkedinapi.client.LinkedInApiClientFactory factory = com.google.code.linkedinapi.client.LinkedInApiClientFactory.newInstance(apiKey, apiSecret);
        return factory.createLinkedInApiClient(accessToken, accessTokenSecret);
    }

    public static void setDefaultClient(LinkedInApiClient defaultClient) {
        LinkedInClientFactory.defaultClient = defaultClient;
    }
}