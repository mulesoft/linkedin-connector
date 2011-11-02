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

import com.google.code.linkedinapi.schema.Network;
import com.google.code.linkedinapi.schema.NetworkStats;
import com.google.code.linkedinapi.schema.Updates;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;

public class NetworkImpl
        extends BaseSchemaEntity
        implements Network {

    /**
     *
     */
    private static final long serialVersionUID = 6143437997201279562L;
    protected NetworkStatsImpl networkStats;
    protected UpdatesImpl updates;

    public NetworkStats getNetworkStats() {
        return networkStats;
    }

    public void setNetworkStats(NetworkStats value) {
        this.networkStats = ((NetworkStatsImpl) value);
    }

    public Updates getUpdates() {
        return updates;
    }

    public void setUpdates(Updates value) {
        this.updates = ((UpdatesImpl) value);
    }

    @Override
    public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);

        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();

            if (name.equals("network-stats")) {
                NetworkStatsImpl networkStatsImpl = new NetworkStatsImpl();
                networkStatsImpl.init(parser);
                setNetworkStats(networkStatsImpl);
            } else if (name.equals("updates")) {
                UpdatesImpl updateImpl = new UpdatesImpl();
                updateImpl.init(parser);
                setUpdates(updateImpl);
            } else {
                // Consume something we don't understand.
                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
        }
    }

    @Override
    public void toXml(XmlSerializer serializer) throws IOException {
        XmlSerializer element = serializer.startTag(null, "network");
        if (getNetworkStats() != null) {
            ((NetworkStatsImpl) getNetworkStats()).toXml(element);
        }
        if (getUpdates() != null) {
            ((UpdatesImpl) getUpdates()).toXml(element);
        }
        serializer.endTag(null, "network");
    }
}
