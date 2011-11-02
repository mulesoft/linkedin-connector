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

import com.google.code.linkedinapi.schema.Recommendation;
import com.google.code.linkedinapi.schema.RecommendationType;
import com.google.code.linkedinapi.schema.Recommendee;
import com.google.code.linkedinapi.schema.Recommender;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "id",
        "recommendationType",
        "recommendationText",
        "recommendationSnippet",
        "recommender",
        "recommendee",
        "webUrl"
})
@XmlRootElement(name = "recommendation")
public class RecommendationImpl
        implements Serializable, Recommendation {

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String id;
    @XmlElement(name = "recommendation-type", required = true, type = RecommendationTypeImpl.class)
    protected RecommendationTypeImpl recommendationType;
    @XmlElement(name = "recommendation-text")
    protected String recommendationText;
    @XmlElement(name = "recommendation-snippet")
    protected String recommendationSnippet;
    @XmlElement(type = RecommenderImpl.class)
    protected RecommenderImpl recommender;
    @XmlElement(type = RecommendeeImpl.class)
    protected RecommendeeImpl recommendee;
    @XmlElement(name = "web-url")
    protected String webUrl;

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public RecommendationType getRecommendationType() {
        return recommendationType;
    }

    public void setRecommendationType(RecommendationType value) {
        this.recommendationType = ((RecommendationTypeImpl) value);
    }

    public String getRecommendationText() {
        return recommendationText;
    }

    public void setRecommendationText(String value) {
        this.recommendationText = value;
    }

    public String getRecommendationSnippet() {
        return recommendationSnippet;
    }

    public void setRecommendationSnippet(String value) {
        this.recommendationSnippet = value;
    }

    public Recommender getRecommender() {
        return recommender;
    }

    public void setRecommender(Recommender value) {
        this.recommender = ((RecommenderImpl) value);
    }

    public Recommendee getRecommendee() {
        return recommendee;
    }

    public void setRecommendee(Recommendee value) {
        this.recommendee = ((RecommendeeImpl) value);
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String value) {
        this.webUrl = value;
    }

}
