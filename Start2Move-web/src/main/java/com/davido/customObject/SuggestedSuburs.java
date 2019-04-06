/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davido.customObject;

/**
 *
 * @author davidortega
 */
public class SuggestedSuburs {
    
    private String postCode;
    private String suburbName;
    private String questionOneSuburbValue;

    public SuggestedSuburs() {
    }

    public SuggestedSuburs(String postCode, String suburbName, String questionOneSuburbValue) {
        this.postCode = postCode;
        this.suburbName = suburbName;
        this.questionOneSuburbValue = questionOneSuburbValue;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getSuburbName() {
        return suburbName;
    }

    public void setSuburbName(String suburbName) {
        this.suburbName = suburbName;
    }

    public String getQuestionOneSuburbValue() {
        return questionOneSuburbValue;
    }

    public void setQuestionOneSuburbValue(String questionOneSuburbValue) {
        this.questionOneSuburbValue = questionOneSuburbValue;
    }

   
    
}
