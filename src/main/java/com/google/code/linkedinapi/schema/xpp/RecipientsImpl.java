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

import com.google.code.linkedinapi.schema.Recipient;
import com.google.code.linkedinapi.schema.Recipients;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RecipientsImpl
        extends BaseSchemaEntity
        implements Recipients {

    /**
     *
     */
    private static final long serialVersionUID = 5874984453850790428L;
    protected List<Recipient> recipientList;

    public List<Recipient> getRecipientList() {
        if (recipientList == null) {
            recipientList = new ArrayList<Recipient>();
        }
        return this.recipientList;
    }

    @Override
    public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);

        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();

            if (name.equals("recipient")) {
                RecipientImpl recipientImpl = new RecipientImpl();
                recipientImpl.init(parser);
                getRecipientList().add(recipientImpl);
            } else {
                // Consume something we don't understand.
                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
        }
    }

    @Override
    public void toXml(XmlSerializer serializer) throws IOException {
        XmlSerializer element = serializer.startTag(null, "recipients");
        for (Recipient recepient : getRecipientList()) {
            ((RecipientImpl) recepient).toXml(element);
        }
        serializer.endTag(null, "recipients");
    }
}
