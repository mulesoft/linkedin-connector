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

import com.google.code.linkedinapi.schema.SchemaEntity;

import java.util.concurrent.Future;

/**
 * The Abstract class AsyncResponseHandler.
 *
 * @param <T>
 * @author nmukhtar
 */
public abstract class AsyncResponseHandler<T extends SchemaEntity> {

    private Future<T> future;

    /**
     * Set future
     *
     * @param future the future
     */
    public void setFuture(Future<T> future) {
        this.future = future;
    }

    /**
     * Get a reference to the future.
     */
    public Future<T> getFuture() {
        return future;
    }

    /**
     * Handle response.
     *
     * @param response the response
     */
    public abstract void handleResponse(T response);
}
