/**
 * Mule LinkedIn Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package com.google.code.linkedinapi.schema.xpp;

import com.google.code.linkedinapi.schema.Authorization;
import com.google.code.linkedinapi.schema.InvitationRequest;
import com.google.code.linkedinapi.schema.InviteConnectType;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;

public class InvitationRequestImpl
        extends BaseSchemaEntity
        implements InvitationRequest {

    /**
     *
     */
    private static final long serialVersionUID = -4777671180159209124L;
    protected InviteConnectType connectType;
    protected AuthorizationImpl authorization;

    public InviteConnectType getConnectType() {
        return connectType;
    }

    public void setConnectType(InviteConnectType value) {
        this.connectType = value;
    }

    public Authorization getAuthorization() {
        return authorization;
    }

    public void setAuthorization(Authorization value) {
        this.authorization = ((AuthorizationImpl) value);
    }

    @Override
    public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);

        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();

            if (name.equals("authorization")) {
                AuthorizationImpl authImpl = new AuthorizationImpl();
                authImpl.init(parser);
                setAuthorization(authImpl);
            } else if (name.equals("connect-type")) {
                String connectTypeStr = XppUtils.getElementValueFromNode(parser);
                if (connectTypeStr != null) {
                    setConnectType(InviteConnectType.fromValue(connectTypeStr));
                }
            } else {
                // Consume something we don't understand.
                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
        }
    }

    @Override
    public void toXml(XmlSerializer serializer) throws IOException {
        XmlSerializer element = serializer.startTag(null, "invitation-request");
        if (getConnectType() != null) {
            XppUtils.setElementValueToNode(element, "connect-type", getConnectType().value());
        }

        if (getAuthorization() != null) {
            ((AuthorizationImpl) getAuthorization()).toXml(serializer);
        }
        serializer.endTag(null, "invitation-request");
    }
}
