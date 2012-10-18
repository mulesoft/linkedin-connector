/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package com.google.code.linkedinapi.client;

import com.google.code.linkedinapi.client.oauth.LinkedInAccessToken;
import com.google.code.linkedinapi.client.oauth.LinkedInApiConsumer;

/**
 * @author Nabeel Mukhtar
 */
public interface LinkedInAuthenticationClient extends LinkedInCommunicationClient {

    /**
     * Method description
     *
     * @param apiConsumer
     */
    public void setApiConsumer(LinkedInApiConsumer apiConsumer);

    /**
     * Method description
     *
     * @return
     */
    public LinkedInApiConsumer getApiConsumer();

    /**
     * Method description
     *
     * @param accessToken
     */
    public void setAccessToken(LinkedInAccessToken accessToken);

    /**
     * Method description
     *
     * @return
     */
    public LinkedInAccessToken getAccessToken();
}
