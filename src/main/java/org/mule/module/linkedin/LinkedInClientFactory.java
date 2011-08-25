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