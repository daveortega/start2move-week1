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
public class QuestionDropdown {
    
    private String header;
    private String question;
    private String label;
    private String hint;
    private String button;
    private List<String> listOfValues;

    public QuestionDropdown() {
    }

    public QuestionDropdown(String header, String question, String label, String hint, String button, List<String> listOfValues) {
        this.header = header;
        this.question = question;
        this.label = label;
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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
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
    
    
    
}
