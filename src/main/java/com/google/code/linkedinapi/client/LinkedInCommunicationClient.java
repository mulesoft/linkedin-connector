/**
 * Mule LinkedIn Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package com.google.code.linkedinapi.client;

import java.util.Locale;
import java.util.Map;

/**
 * The Interface LinkedInCommunicationClient.
 *
 * @author Nabeel Mukhtar
 */
public interface LinkedInCommunicationClient {

    /**
     * Sets the request headers.
     *
     * @param requestHeaders the request headers
     */
    public void setRequestHeaders(Map<String, String> requestHeaders);

    /**
     * Gets the request headers.
     *
     * @return the request headers
     */
    public Map<String, String> getRequestHeaders();

    /**
     * Adds the request header.
     *
     * @param headerName  the header name
     * @param headerValue the header value
     */
    public void addRequestHeader(String headerName, String headerValue);

    /**
     * Removes the request header.
     *
     * @param headerName the header name
     */
    public void removeRequestHeader(String headerName);

    public void addLocale(Locale locale);
}
