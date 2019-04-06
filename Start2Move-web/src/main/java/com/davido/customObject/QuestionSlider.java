/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davido.customObject;

import java.util.List;

/**
 *
 * @author davidortega
 */
public class QuestionSlider {
    
    private String header;
    private String question;
    private String leftLabel;
    private String leftValue;
    private String rightLabel;
    private String rightValue;
    private String hint;
    private String button;
    private List<String> listOfValues;

    public QuestionSlider() {
    }

    public QuestionSlider(String header, String question, String leftLabel, String leftValue, String rightLabel, String rightValue, String hint, String button, List<String> listOfValues) {
        this.header = header;
        this.question = question;
        this.leftLabel = leftLabel;
        this.leftValue = leftValue;
        this.rightLabel = rightLabel;
        this.rightValue = rightValue;
        this.hint = hint;
        this.button = button;
        this.listOfValues = listOfValues;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getLeftLabel() {
        return leftLabel;
    }

    public void setLeftLabel(String leftLabel) {
        this.leftLabel = leftLabel;
    }

    public String getRightLabel() {
        return rightLabel;
    }

    public void setRightLabel(String rightLabel) {
        this.rightLabel = rightLabel;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }

    public List<String> getListOfValues() {
        return listOfValues;
    }

    public void setListOfValues(List<String> listOfValues) {
        this.listOfValues = listOfValues;
    }

    public String getLeftValue() {
        return leftValue;
    }

    public void setLeftValue(String leftValue) {
        this.leftValue = leftValue;
    }

    public String getRightValue() {
        return rightValue;
    }

    public void setRightValue(String rightValue) {
        this.rightValue = rightValue;
    }
    
}
