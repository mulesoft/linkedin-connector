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

import com.google.code.linkedinapi.schema.Attribution;
import com.google.code.linkedinapi.schema.Share;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;

public class AttributionImpl
        extends BaseSchemaEntity
        implements Attribution {

    private final static long serialVersionUID = 2461660169443089969L;
    protected ShareImpl share;

    public Share getShare() {
        return share;
    }

    public void setShare(Share value) {
        this.share = ((ShareImpl) value);
    }

    @Override
    public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);

        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();

            if (name.equals("share")) {
                ShareImpl share = new ShareImpl();
                share.init(parser);
                setShare(share);
            } else {
                // Consume something we don't understand.
                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
        }
    }

    @Override
    public void toXml(XmlSerializer serializer) throws IOException {
        serializer.startTag(null, "attribution");
        if (getShare() != null) {
            ((ShareImpl) getShare()).toXml(serializer);
        }
        serializer.endTag(null, "attribution");
    }
}
