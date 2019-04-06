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
public class QuestionMultipleChoice {
    
    private String header;
    private String question;
    private List<String> options;
    private String Button;

    public QuestionMultipleChoice() {
    }

    public QuestionMultipleChoice(String header, String question, List<String> options, String Button) {
        this.header = header;
        this.question = question;
        this.options = options;
        this.Button = Button;
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

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
    
    public String getButton() {
        return Button;
    }

    public void setButton(String Button) {
        this.Button = Button;
    }
    
}
