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

import com.google.code.linkedinapi.schema.Answers;
import com.google.code.linkedinapi.schema.Author;
import com.google.code.linkedinapi.schema.Question;
import com.google.code.linkedinapi.schema.QuestionCategories;

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
        "title",
        "author",
        "questionCategories",
        "webUrl",
        "answers"
})
@XmlRootElement(name = "question")
public class QuestionImpl
        implements Serializable, Question {

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String id;
    @XmlElement(required = true)
    protected String title;
    @XmlElement(required = true, type = AuthorImpl.class)
    protected AuthorImpl author;
    @XmlElement(name = "question-categories", required = true, type = QuestionCategoriesImpl.class)
    protected QuestionCategoriesImpl questionCategories;
    @XmlElement(name = "web-url")
    protected String webUrl;
    @XmlElement(type = AnswersImpl.class)
    protected AnswersImpl answers;

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author value) {
        this.author = ((AuthorImpl) value);
    }

    public QuestionCategories getQuestionCategories() {
        return questionCategories;
    }

    public void setQuestionCategories(QuestionCategories value) {
        this.questionCategories = ((QuestionCategoriesImpl) value);
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String value) {
        this.webUrl = value;
    }

    public Answers getAnswers() {
        return answers;
    }

    public void setAnswers(Answers value) {
        this.answers = ((AnswersImpl) value);
    }

}
