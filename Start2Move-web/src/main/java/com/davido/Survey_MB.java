/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davido;


import com.davido.ejb.DbViewFacadeLocal;
import com.davido.entities.DbView;
import customObject.QuestionDropdown;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author davidortega
 */
@Named(value = "Survey_MB")
@ViewScoped
public class Survey_MB implements Serializable {

    @EJB
    private DbViewFacadeLocal dbViewFacade;

    private QuestionDropdown questionOneObj;

    public QuestionDropdown getQuestionOneObj() {
        return questionOneObj;
    }
    
    

    /**
     * Creates a new instance of survey_MB
     */
    public Survey_MB() {
    }

    @PostConstruct
    public void init() {
        questionOneObj = buildQuestionOne();
    }
    
    private QuestionDropdown buildQuestionOne(){
        QuestionDropdown QuestionOneObj = convertToDropDownObj(dbViewFacade.findByName("viewPageSection", "question1"));
        List<Object[]> listOfObj = dbViewFacade.findStopsPostCode();
        List<String> listofString = new ArrayList<>();
        for (Object[] item: listOfObj){
            listofString.add(item[0].toString());
        }
        QuestionOneObj.setListOfValues(listofString);
        return QuestionOneObj;
    }

    private QuestionDropdown convertToDropDownObj(List<DbView> listOfObj) {
        QuestionDropdown resultantObj = new QuestionDropdown();
        for (DbView item : listOfObj) {
            switch (item.getViewFieldName()) {
                case "header":
                    resultantObj.setHeader(item.getViewFieldContent());
                    break;
                case "question":
                    resultantObj.setQuestion(item.getViewFieldContent());
                    break;
                case "label":
                    resultantObj.setLabel(item.getViewFieldContent());
                    break;
                case "hint":
                    resultantObj.setHint(item.getViewFieldContent());  
                    break;
                case "button":
                    resultantObj.setButton(item.getViewFieldContent());
                    break;
                default:
                    System.err.println("Question1: There is not a coincidence field creating the object for fieldName: " + item.getViewFieldName());
            }
        }   
        return resultantObj;
    }

}
