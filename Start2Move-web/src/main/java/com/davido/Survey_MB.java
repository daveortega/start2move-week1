/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davido;


import com.davido.ejb.DbViewFacadeLocal;
import com.davido.ejb.DbbusStopFacadeLocal;
import com.davido.entities.DbView;
import customObject.QuestionDropdown;
import customObject.SuggestedSuburs;
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
    private DbbusStopFacadeLocal dbbusStopFacade;
    @EJB
    private DbViewFacadeLocal dbViewFacade;
    
    
    private QuestionDropdown questionOneObj;
    private String answerQuestionOne;
    private List<SuggestedSuburs> listOfSuggestions; 

    public QuestionDropdown getQuestionOneObj() {
        return questionOneObj;
    }

    public String getAnswerQuestionOne() {
        return answerQuestionOne;
    }

    public void setAnswerQuestionOne(String answerQuestionOne) {
        this.answerQuestionOne = answerQuestionOne;
    }
    
    
    

    /**
     * Creates a new instance of survey_MB
     */
    public Survey_MB() {
    }

    @PostConstruct
    public void init() {
        buildSurvey();
    }
    
    private void buildSurvey(){
        questionOneObj = buildQuestionOne();
    }
    
    // This method creates the object with the first question (Bus Stops)
    private QuestionDropdown buildQuestionOne(){
        QuestionDropdown QuestionOneObj = convertToDropDownObj(dbViewFacade.findByName("viewPageSection", "question1"));
        List<Object[]> listOfObj = dbbusStopFacade.findStopsPostCode();
        List<String> listofString = new ArrayList<>();
        for (Object item: listOfObj){
            listofString.add(item.toString());
        }
        QuestionOneObj.setListOfValues(listofString);
        listOfSuggestions = CastObjsToSuggestions(dbbusStopFacade.getAllBusStops());
        return QuestionOneObj;
    }
    
    
    // This method converts a ViewList to an DropDown question type
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
    
    // This method casts an object to a list of suggestions
    private List<SuggestedSuburs> CastObjsToSuggestions(List<Object[]> listOfObjects){
        List<SuggestedSuburs> resultantList = new ArrayList<>();
        listOfObjects.forEach(item -> {
            resultantList.add(new SuggestedSuburs(item[0].toString(), item[1].toString(), item[2].toString()));
         });
        return resultantList;
    }

}
