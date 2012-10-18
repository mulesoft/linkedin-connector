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
public class LinkedInOAuthServiceException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = -4345556572105572685L;

    /**
     * Constructs ...
     */
    public LinkedInOAuthServiceException() {
        super();
    }

    /**
     * Constructs ...
     *
     * @param message
     */
    public LinkedInOAuthServiceException(String message) {
        super(message);
    }

    /**
     * Constructs ...
     *
     * @param cause
     */
    public LinkedInOAuthServiceException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs ...
     *
     * @param message
     * @param cause
     */
    public LinkedInOAuthServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
