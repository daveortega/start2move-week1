/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davido.managedBeans;

import com.davido.ejb.DbViewFacadeLocal;
import com.davido.ejb.DbbusStopFacadeLocal;
import com.davido.entities.DbView;
import com.davido.customObject.QuestionDropdown;
import com.davido.customObject.QuestionSlider;
import com.davido.customObject.SuggestedSuburs;
import com.davido.ejb.DbHospitalFacadeLocal;
import com.davido.ejb.DbcrimeRateFacadeLocal;
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
    private DbcrimeRateFacadeLocal dbcrimeRateFacade;
    @EJB
    private DbHospitalFacadeLocal dbHospitalFacade;
    @EJB
    private DbbusStopFacadeLocal dbbusStopFacade;
    @EJB
    private DbViewFacadeLocal dbViewFacade;

    private QuestionDropdown questionOneObj;
    private QuestionDropdown questionTwoObj;
    private QuestionSlider questionThreeObj;
    private String answerQuestionOne;
    private String answerQuestionTwo;
    private String answerQuestionThree;
    private List<SuggestedSuburs> listOfSuggestions;
    private boolean enableQuestionOne = false;
    private boolean enableQuestionTwo = false;
    private boolean enableQuestionThree = false;
    private boolean enableQuestionFour = false;
    private boolean enableQuestionFive = false;
    private boolean enableQuestionSix = false;
    private boolean enableQuestionSeven = false;
    private boolean enableQuestionEight = false;

    // Getters and Setters
    public QuestionDropdown getQuestionOneObj() {
        return questionOneObj;
    }

    public QuestionDropdown getQuestionTwoObj() {
        return questionTwoObj;
    }

    public QuestionSlider getQuestionThreeObj() {
        return questionThreeObj;
    }

    public String getAnswerQuestionOne() {
        return answerQuestionOne;
    }

    public void setAnswerQuestionOne(String answerQuestionOne) {
        this.answerQuestionOne = answerQuestionOne;
    }

    public String getAnswerQuestionTwo() {
        return answerQuestionTwo;
    }

    public void setAnswerQuestionTwo(String answerQuestionTwo) {
        this.answerQuestionTwo = answerQuestionTwo;
    }

    public String getAnswerQuestionThree() {
        return answerQuestionThree;
    }

    public void setAnswerQuestionThree(String answerQuestionThree) {
        this.answerQuestionThree = answerQuestionThree;
    }

    public boolean isEnableQuestionOne() {
        return enableQuestionOne;
    }

    public boolean isEnableQuestionTwo() {
        return enableQuestionTwo;
    }

    public boolean isEnableQuestionThree() {
        return enableQuestionThree;
    }

    public boolean isEnableQuestionFour() {
        return enableQuestionFour;
    }

    public boolean isEnableQuestionFive() {
        return enableQuestionFive;
    }

    public boolean isEnableQuestionSix() {
        return enableQuestionSix;
    }

    public boolean isEnableQuestionSeven() {
        return enableQuestionSeven;
    }

    public boolean isEnableQuestionEight() {
        return enableQuestionEight;
    }

    /**
     * Creates a new instance of survey_MB
     */
    public Survey_MB() {
    }

    // Class methods
    @PostConstruct
    public void init() {
        buildSurvey("q1");
    }

    public void buildSurvey(String Instruction) {
        switch (Instruction) {
            case "q1":
                questionOneObj = builQuestionOne();
                enableQuestionOne = true;
                break;
            case "q2":
                enableQuestionOne = false;
                questionTwoObj = buildQuestionTwo();
                enableQuestionTwo = true;
                break;
            case "q3":
                enableQuestionTwo = false;
                questionThreeObj = buildQuestionThree();
                enableQuestionThree = true;
                break;
        }

    }

    // This method creates the object with the busStops information (Bus Stops)
    private QuestionDropdown builQuestionOne() {
        QuestionDropdown QuestionOneObj = convertToDropDownObj(dbViewFacade.findByName("viewPageSection", "question1"));
        List<Object[]> listOfObj = dbbusStopFacade.findStopsPostCode();
        List<String> listofString = new ArrayList<>();
        for (Object item : listOfObj) {
            listofString.add(item.toString());
        }
        QuestionOneObj.setListOfValues(listofString);
        listOfSuggestions = CastObjsToSuggestions(dbbusStopFacade.getAllBusStops());
        return QuestionOneObj;
    }

    // This method creates the object with the hospitals question (Bus Stops)
    private QuestionDropdown buildQuestionTwo() {
        QuestionDropdown QuestionTwoObj = convertToDropDownObj(dbViewFacade.findByName("viewPageSection", "question2"));
        List<String> listOfPostCodes = new ArrayList<>();
        listOfSuggestions.forEach(item -> {
            if (answerQuestionOne.equals(item.getQuestionOneSuburbValue())) {
                listOfPostCodes.add(item.getPostCode());
            }
        });
        if (!listOfPostCodes.isEmpty()) {
            List<Object[]> listOfObj = dbHospitalFacade.findHospitals(listOfPostCodes);
            List<String> listOfString = new ArrayList<>();
            for (Object item : listOfObj) {
                listOfString.add(item.toString());
            }
            QuestionTwoObj.setListOfValues(listOfString);
            List<SuggestedSuburs> tmpListOfSuggestions = CastObjsToSuggestions(dbHospitalFacade.getAllHospitals(listOfPostCodes));
            if (!tmpListOfSuggestions.isEmpty()) {
                listOfSuggestions = tmpListOfSuggestions;
            }
        }
        return QuestionTwoObj;
    }

    // This method creates the object with the crime question (Criminal tolerance)
    private QuestionSlider buildQuestionThree() {
        QuestionSlider QuestionThreeObj = convertToSliderObj(dbViewFacade.findByName("viewPageSection", "question3"));
        List<String> listOfPostCodes = new ArrayList<>();
        listOfSuggestions.forEach(item -> {
            if (answerQuestionTwo.equals(item.getQuestionOneSuburbValue())) {
                listOfPostCodes.add(item.getPostCode());
            }
        });
        if (!listOfPostCodes.isEmpty()) {
            List<Object[]> listOfObj = dbcrimeRateFacade.findCrime(listOfPostCodes);
            QuestionThreeObj.setLeftValue(listOfObj.get(0)[0].toString());
            QuestionThreeObj.setRightValue(listOfObj.get(0)[1].toString());

        }

        return QuestionThreeObj;
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

    // This method converts a ViewList to an DropDown question type
    private QuestionSlider convertToSliderObj(List<DbView> listOfObj) {
        QuestionSlider resultantObj = new QuestionSlider();
        for (DbView item : listOfObj) {
            switch (item.getViewFieldName()) {
                case "header":
                    resultantObj.setHeader(item.getViewFieldContent());
                    break;
                case "question":
                    resultantObj.setQuestion(item.getViewFieldContent());
                    break;
                case "leftLabel":
                    resultantObj.setLeftLabel(item.getViewFieldContent());
                    break;
                case "rightLabel":
                    resultantObj.setRightLabel(item.getViewFieldContent());
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
    private List<SuggestedSuburs> CastObjsToSuggestions(List<Object[]> listOfObjects) {
        List<SuggestedSuburs> resultantList = new ArrayList<>();
        listOfObjects.forEach(item -> {
            resultantList.add(new SuggestedSuburs(item[0].toString(), item[1].toString(), item[2].toString()));
        });
        return resultantList;
    }

}
