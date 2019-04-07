/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davido.managedBeans;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author davidortega
 */
@Named(value = "result_MB")
@ViewScoped
public class Result_MB implements Serializable {

    private String postCodeSuggested;

    public String getPostCodeSuggested() {
        return postCodeSuggested;
    }

    public void setPostCodeSuggested(String postCodeSuggested) {
        this.postCodeSuggested = postCodeSuggested;
    }
    
    /**
     * Creates a new instance of Result_MB
     */
    public Result_MB() {
    }
    
    @PostConstruct
    private void init() {
        postCodeSuggested = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("suggestedPostCode");
    }
    
}
