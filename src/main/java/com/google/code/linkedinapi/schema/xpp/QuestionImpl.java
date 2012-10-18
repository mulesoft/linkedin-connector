/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package com.google.code.linkedinapi.schema.xpp;

import com.google.code.linkedinapi.schema.Answers;
import com.google.code.linkedinapi.schema.Author;
import com.google.code.linkedinapi.schema.Question;
import com.google.code.linkedinapi.schema.QuestionCategories;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;

public class QuestionImpl
        extends BaseSchemaEntity
        implements Question {

    private final static long serialVersionUID = 2461660169443089969L;
    protected String id;
    protected String title;
    protected AuthorImpl author;
    protected QuestionCategoriesImpl questionCategories;
    protected String webUrl;
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

    @Override
    public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);

        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();

            if (name.equals("id")) {
                setId(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("title")) {
                setTitle(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("web-url")) {
                setWebUrl(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("author")) {
                AuthorImpl author = new AuthorImpl();
                author.init(parser);
                setAuthor(author);
            } else if (name.equals("question-categories")) {
                QuestionCategoriesImpl categories = new QuestionCategoriesImpl();
                categories.init(parser);
                setQuestionCategories(categories);
            } else if (name.equals("answers")) {
                AnswersImpl answers = new AnswersImpl();
                answers.init(parser);
                setAnswers(answers);
            } else {
                // Consume something we don't understand.
                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
        }
    }

    @Override
    public void toXml(XmlSerializer serializer) throws IOException {
        XmlSerializer element = serializer.startTag(null, "question");
        XppUtils.setElementValueToNode(element, "id", getId());
        XppUtils.setElementValueToNode(element, "title", getTitle());
        XppUtils.setElementValueToNode(element, "web-url", getWebUrl());
        if (getAuthor() != null) {
            ((AuthorImpl) getAuthor()).toXml(serializer);
        }
        if (getQuestionCategories() != null) {
            ((QuestionCategoriesImpl) getQuestionCategories()).toXml(serializer);
        }
        if (getAnswers() != null) {
            ((AnswersImpl) getAnswers()).toXml(serializer);
        }
        serializer.endTag(null, "question");
    }
}
