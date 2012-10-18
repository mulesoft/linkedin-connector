/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package com.google.code.linkedinapi.client.oauth;

import com.google.code.linkedinapi.client.LinkedInCommunicationClient;

import java.net.HttpURLConnection;

/**
 * The Interface LinkedInOAuthService.
 *
 * @author Nabeel Mukhtar
 */
public interface LinkedInOAuthService extends LinkedInCommunicationClient {

    /**
     * Gets the o auth request token.
     *
     * @return the o auth request token
     */
    public LinkedInRequestToken getOAuthRequestToken();

    /**
     * Gets the o auth request token.
     *
     * @param callBackUrl the callback url.
     * @return the o auth request token
     */
    public LinkedInRequestToken getOAuthRequestToken(String callBackUrl);

    /**
     * Gets the o auth access token.
     *
     * @param requestToken  the request token
     * @param oauthVerifier the oauthVerifier
     * @return the o auth access token
     */
    public LinkedInAccessToken getOAuthAccessToken(LinkedInRequestToken requestToken, String oauthVerifier);

    /**
     * Sign request with token.
     *
     * @param request     the request
     * @param accessToken the access token
     */
    public void signRequestWithToken(HttpURLConnection request, LinkedInAccessToken accessToken);

    /**
     * Invalidate Token.
     *
     * @param accessToken the access token
     */
    public void invalidateAccessToken(LinkedInAccessToken accessToken);
}
