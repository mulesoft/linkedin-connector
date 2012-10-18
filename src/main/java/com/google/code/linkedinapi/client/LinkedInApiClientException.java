/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package com.google.code.linkedinapi.client;

import java.util.Date;

/**
 * Class description
 */
public class LinkedInApiClientException extends RuntimeException {
    private int statusCode;
    private String errorCode;
    private Date timestamp;

    /**
     *
     */
    private static final long serialVersionUID = -4345556572105572685L;

    /**
     * Constructs ...
     */
    public LinkedInApiClientException() {
        super();
    }

    /**
     * Constructs ...
     *
     * @param message
     */
    public LinkedInApiClientException(String message) {
        super(message);
    }

    /**
     * Constructs ...
     *
     * @param cause
     */
    public LinkedInApiClientException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs ...
     *
     * @param message
     * @param cause
     */
    public LinkedInApiClientException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs ...
     *
     * @param message
     * @param cause
     */
    public LinkedInApiClientException(String message, int statusCode, String errorCode, Date timestamp) {
        super(message);
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.timestamp = timestamp;
    }

    /**
     * @return the statusCode
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * @param statusCode the statusCode to set
     */
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * @return the errorCode
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * @param errorCode the errorCode to set
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * @return the timestamp
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
