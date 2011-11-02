/**
 * Mule LinkedIn Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package com.google.code.linkedinapi.schema.impl;

import com.google.code.linkedinapi.schema.Adapter1;
import com.google.code.linkedinapi.schema.Likes;
import com.google.code.linkedinapi.schema.NetworkUpdateReturnType;
import com.google.code.linkedinapi.schema.OriginalUpdate;
import com.google.code.linkedinapi.schema.UpdateComments;
import com.google.code.linkedinapi.schema.UpdateContent;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "timestamp",
        "updateKey",
        "updateType",
        "updateContent",
        "isCommentable",
        "updateComments",
        "isLikable",
        "isLiked",
        "numLikes",
        "likes"
})
@XmlRootElement(name = "original-update")
public class OriginalUpdateImpl
        implements Serializable, OriginalUpdate {

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1.class)
    protected Long timestamp;
    @XmlElement(name = "update-key", required = true)
    protected String updateKey;
    @XmlElement(name = "update-type", required = true)
    protected NetworkUpdateReturnType updateType;
    @XmlElement(name = "update-content", required = true, type = UpdateContentImpl.class)
    protected UpdateContentImpl updateContent;
    @XmlElement(name = "is-commentable")
    protected boolean isCommentable;
    @XmlElement(name = "update-comments", type = UpdateCommentsImpl.class)
    protected UpdateCommentsImpl updateComments;
    @XmlElement(name = "is-likable")
    protected boolean isLikable;
    @XmlElement(name = "is-liked")
    protected boolean isLiked;
    @XmlElement(name = "num-likes", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1.class)
    protected Long numLikes;
    @XmlElement(type = LikesImpl.class)
    protected LikesImpl likes;

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long value) {
        this.timestamp = value;
    }

    public String getUpdateKey() {
        return updateKey;
    }

    public void setUpdateKey(String value) {
        this.updateKey = value;
    }

    public NetworkUpdateReturnType getUpdateType() {
        return updateType;
    }

    public void setUpdateType(NetworkUpdateReturnType value) {
        this.updateType = value;
    }

    public UpdateContent getUpdateContent() {
        return updateContent;
    }

    public void setUpdateContent(UpdateContent value) {
        this.updateContent = ((UpdateContentImpl) value);
    }

    public boolean isIsCommentable() {
        return isCommentable;
    }

    public void setIsCommentable(boolean value) {
        this.isCommentable = value;
    }

    public UpdateComments getUpdateComments() {
        return updateComments;
    }

    public void setUpdateComments(UpdateComments value) {
        this.updateComments = ((UpdateCommentsImpl) value);
    }

    public boolean isIsLikable() {
        return isLikable;
    }

    public void setIsLikable(boolean value) {
        this.isLikable = value;
    }

    public boolean isIsLiked() {
        return isLiked;
    }

    public void setIsLiked(boolean value) {
        this.isLiked = value;
    }

    public Long getNumLikes() {
        return numLikes;
    }

    public void setNumLikes(Long value) {
        this.numLikes = value;
    }

    public Likes getLikes() {
        return likes;
    }

    public void setLikes(Likes value) {
        this.likes = ((LikesImpl) value);
    }

}
