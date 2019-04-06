/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davido.managedBeans;

import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author davidortega
 */
@Named(value = "indexs_MB")
@ViewScoped
public class index_MB implements Serializable {
    
    private String siteTitle;
    private String siteDescription;

    public String getSiteTitle() {
        return siteTitle;
    }

    public void setSiteTitle(String siteTitle) {
        this.siteTitle = siteTitle;
    }

    public String getSiteDescription() {
        return siteDescription;
    }

    public void setSiteDescription(String siteDescription) {
        this.siteDescription = siteDescription;
    }
    

    /**
     * Creates a new instance of index_MB
     */
    public index_MB() {
        siteTitle = "Hello, world!";
        siteDescription = "This is a template for a simple marketing or informational website. "
                + "It includes a large callout called a jumbotron and three supporting pieces of content. "
                + "Use it as a starting point to create something more unique.";
    }
    
    
    
}
