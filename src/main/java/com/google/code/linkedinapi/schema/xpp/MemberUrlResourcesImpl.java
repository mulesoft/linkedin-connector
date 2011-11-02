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

import com.google.code.linkedinapi.schema.MemberUrl;
import com.google.code.linkedinapi.schema.MemberUrlResources;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MemberUrlResourcesImpl
        extends BaseSchemaEntity
        implements MemberUrlResources {

    /**
     *
     */
    private static final long serialVersionUID = -4293798758625787079L;
    protected List<MemberUrl> memberUrlList;

    public List<MemberUrl> getMemberUrlList() {
        if (memberUrlList == null) {
            memberUrlList = new ArrayList<MemberUrl>();
        }
        return this.memberUrlList;
    }

    @Override
    public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);

        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();

            if (name.equals("member-url")) {
                MemberUrlImpl memberUrlImpl = new MemberUrlImpl();
                memberUrlImpl.init(parser);
                getMemberUrlList().add(memberUrlImpl);
            } else {
                // Consume something we don't understand.
                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
        }
    }

    @Override
    public void toXml(XmlSerializer serializer) throws IOException {
        XmlSerializer element = serializer.startTag(null, "member-url-resources");
        for (MemberUrl memberUrl : getMemberUrlList()) {
            ((MemberUrlImpl) memberUrl).toXml(element);
        }
        serializer.endTag(null, "member-url-resources");
    }
}
