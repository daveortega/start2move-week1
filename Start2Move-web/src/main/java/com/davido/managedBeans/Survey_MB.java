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
import com.davido.customObject.QuestionMultipleChoice;
import com.davido.customObject.QuestionSlider;
import com.davido.customObject.SuggestedSuburs;
import com.davido.ejb.DbHospitalFacadeLocal;
import com.davido.ejb.DbSchoolFacadeLocal;
import com.davido.ejb.DbcrimeRateFacadeLocal;
import com.davido.ejb.DbhouseBuyingFacadeLocal;
import com.davido.ejb.DbhouseRentFacadeLocal;
import com.davido.ejb.DblandPriceFacadeLocal;
import java.io.IOException;
import java.io.Serializable;
import java.text.DecimalFormat;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 *
 * @author davidortega
 */
@Named(value = "Survey_MB")
@ViewScoped
public class Survey_MB implements Serializable {

    @EJB
    private DbSchoolFacadeLocal dbSchoolFacade;
    @EJB
    private DblandPriceFacadeLocal dblandPriceFacade;
    @EJB
    private DbhouseRentFacadeLocal dbhouseRentFacade;
    @EJB
    private DbhouseBuyingFacadeLocal dbhouseBuyingFacade;
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
    private QuestionDropdown questionThreeObj;
    private QuestionMultipleChoice questionFourObj;
    private QuestionDropdown questionFiveObj;
    private QuestionDropdown questionSixObj;
    private QuestionMultipleChoice questionSevenObj;
    private String answerQuestionOne;
    private String answerQuestionTwo;
    private String answerQuestionThree;
    private String answerQuestionFour;
    private String answerQuestionFive;
    private String answerQuestionSix;
    private String answerQuestionSeven;
    private String answerTypeFive;
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

    public QuestionDropdown getQuestionThreeObj() {
        return questionThreeObj;
    }

    public QuestionMultipleChoice getQuestionFourObj() {
        return questionFourObj;
    }

    public QuestionDropdown getQuestionFiveObj() {
        return questionFiveObj;
    }

    public QuestionDropdown getQuestionSixObj() {
        return questionSixObj;
    }

    public QuestionMultipleChoice getQuestionSevenObj() {
        return questionSevenObj;
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

    public String getAnswerQuestionFour() {
        return answerQuestionFour;
    }

    public void setAnswerQuestionFour(String answerQuestionFour) {
        this.answerQuestionFour = answerQuestionFour;
    }

    public String getAnswerQuestionFive() {
        return answerQuestionFive;
    }

    public void setAnswerQuestionFive(String answerQuestionFive) {
        this.answerQuestionFive = answerQuestionFive;
    }

    public String getAnswerQuestionSix() {
        return answerQuestionSix;
    }

    public void setAnswerQuestionSix(String answerQuestionSix) {
        this.answerQuestionSix = answerQuestionSix;
    }

    public String getAnswerQuestionSeven() {
        return answerQuestionSeven;
    }

    public void setAnswerQuestionSeven(String answerQuestionSeven) {
        this.answerQuestionSeven = answerQuestionSeven;
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
            case "q4":
                enableQuestionThree = false;
                questionFourObj = buildQuestionFour();
                enableQuestionFour = true;
                break;
            case "q5":
                if (!answerQuestionFour.equals("")) {
                    enableQuestionFour = false;
                    questionFiveObj = buildQuestionFive();
                    enableQuestionFive = true;
                }
                break;
            case "q7":
                enableQuestionSix = false;
                enableQuestionFive = false;
                questionSevenObj = buildQuestionSeven();
                enableQuestionSeven = true;
                break;
            case "q8":
                enableQuestionSeven = false;
                buildFinalAnswer("Survey");
                break;
            default:
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
    private QuestionDropdown buildQuestionThree() {
        QuestionDropdown QuestionThreeObj = convertToDropDownObj(dbViewFacade.findByName("viewPageSection", "question3"));
        List<String> listOfPostCodes = new ArrayList<>();
        listOfSuggestions.forEach(item -> {
            if (answerQuestionTwo.equals(item.getQuestionOneSuburbValue())) {
                listOfPostCodes.add(item.getPostCode());
            }
        });
        if (!listOfPostCodes.isEmpty()) {
            List<Object[]> listOfObj = dbcrimeRateFacade.findCrime(listOfPostCodes);
            // QuestionThreeObj.setLeftValue(listOfObj.get(0)[0].toString());
            // QuestionThreeObj.setRightValue(listOfObj.get(0)[1].toString());
            // QuestionThreeObj.setSliderValue("0.1");
            QuestionThreeObj.setListOfValues(listOfValues(listOfObj.get(0)[0].toString(), listOfObj.get(0)[1].toString(), "0.1", "decimal"));
            List<SuggestedSuburs> tmpListOfSuggestions = CastObjsToSuggestions(dbcrimeRateFacade.getAllCrime(listOfPostCodes));
            if (!tmpListOfSuggestions.isEmpty()) {
                listOfSuggestions = tmpListOfSuggestions;
            }
        }

        return QuestionThreeObj;
    }

    // This method creates the object with the type of house (Rent - Lease)
    private QuestionMultipleChoice buildQuestionFour() {
        QuestionMultipleChoice QuestionFourObj = convertToMultpleChoiceObj(dbViewFacade.findByName("viewPageSection", "question4"));
        return QuestionFourObj;
    }

    // This method creates the object for Rent - Buy Home (Rent - Lease)
    private QuestionDropdown buildQuestionFive() {
        QuestionDropdown QuestionFiveObj = convertToDropDownObj(dbViewFacade.findByName("viewPageSection", "question5"));
        List<String> listOfPostCodes = new ArrayList<>();
        listOfSuggestions.forEach(item -> {
            if (Double.parseDouble(item.getQuestionOneSuburbValue()) <= Double.parseDouble(answerQuestionThree) + 1
                    && Double.parseDouble(item.getQuestionOneSuburbValue()) >= Double.parseDouble(answerQuestionThree) - 1) {
                listOfPostCodes.add(item.getPostCode());
            }
        });
        if (!listOfPostCodes.isEmpty()) {
            if (answerQuestionFour.equals("Buy a House")) {
                answerTypeFive = "Buy a House";
                List<Object[]> listOfObj = dbhouseBuyingFacade.findHouseBuy(listOfPostCodes);
                // QuestionFiveObj.setLeftValue(listOfObj.get(0)[0].toString());
                // QuestionFiveObj.setRightValue(listOfObj.get(0)[1].toString());
                // QuestionFiveObj.setSliderValue("5000");
                QuestionFiveObj.setListOfValues(listOfValues(listOfObj.get(0)[0].toString(), listOfObj.get(0)[1].toString(), "5000", "integer"));
                List<SuggestedSuburs> tmpListOfSuggestions = CastObjsToSuggestions(dbhouseBuyingFacade.getAllHouseBuy(listOfPostCodes));
                if (!tmpListOfSuggestions.isEmpty()) {
                    listOfSuggestions = tmpListOfSuggestions;
                }
            } else if (answerQuestionFour.equals("Rent a House")) {
                answerTypeFive = "Rent a House";
                List<Object[]> listOfObj = dbhouseRentFacade.findHouseRent(listOfPostCodes);
                // QuestionFiveObj.setLeftValue(listOfObj.get(0)[0].toString());
                // QuestionFiveObj.setRightValue(listOfObj.get(0)[1].toString());
                // QuestionFiveObj.setSliderValue("10");
                QuestionFiveObj.setListOfValues(listOfValues(listOfObj.get(0)[0].toString(), listOfObj.get(0)[1].toString(), "10", "integer"));
                List<SuggestedSuburs> tmpListOfSuggestions = CastObjsToSuggestions(dbhouseRentFacade.getAllHouseRent(listOfPostCodes));
                if (!tmpListOfSuggestions.isEmpty()) {
                    listOfSuggestions = tmpListOfSuggestions;
                }
            } else if (answerQuestionFour.equals("Buy a piece of land")) {
                answerTypeFive = "Buy a piece of land";
                List<Object[]> listOfObj = dblandPriceFacade.findLandBuy(listOfPostCodes);
                // QuestionFiveObj.setLeftValue(listOfObj.get(0)[0].toString());
                // QuestionFiveObj.setRightValue(listOfObj.get(0)[1].toString());
                // QuestionFiveObj.setSliderValue("10000");
                QuestionFiveObj.setListOfValues(listOfValues(listOfObj.get(0)[0].toString(), listOfObj.get(0)[1].toString(), "10000", "integer"));
                List<SuggestedSuburs> tmpListOfSuggestions = CastObjsToSuggestions(dblandPriceFacade.getAllLandBuy(listOfPostCodes));
                if (!tmpListOfSuggestions.isEmpty()) {
                    listOfSuggestions = tmpListOfSuggestions;
                }
            }
        }
        return QuestionFiveObj;
    }

    // This method creates the object for buy Land
    private QuestionDropdown buildQuestionSix() {
        QuestionDropdown QuestionSixObj = convertToDropDownObj(dbViewFacade.findByName("viewPageSection", "question6"));
        List<String> listOfPostCodes = new ArrayList<>();
        listOfSuggestions.forEach(item -> {
            if (Double.parseDouble(item.getQuestionOneSuburbValue()) <= Double.parseDouble(answerQuestionThree) + 1
                    && Double.parseDouble(item.getQuestionOneSuburbValue()) >= Double.parseDouble(answerQuestionThree) - 1) {
                listOfPostCodes.add(item.getPostCode());
            }
        });
        if (!listOfPostCodes.isEmpty()) {
            List<Object[]> listOfObj = dblandPriceFacade.findLandBuy(listOfPostCodes);
        }
        return QuestionSixObj;
    }

    private QuestionMultipleChoice buildQuestionSeven() {
        QuestionMultipleChoice QuestionSevenObj = convertToMultpleChoiceObj(dbViewFacade.findByName("viewPageSection", "question7"));
        List<String> listOfPostCodes = new ArrayList<>();
        int amountToIncrease = 0;
        if (answerTypeFive.equals("Buy a House")) {
            amountToIncrease = 30000;
        } else if (answerTypeFive.equals("Rent a House")) {
            amountToIncrease = 100;
        } else if (answerTypeFive.equals("Buy a piece of land")) {
            amountToIncrease = 50000;
        }
        final int a = amountToIncrease;
        listOfSuggestions.forEach(item -> {
            if (Integer.parseInt(item.getQuestionOneSuburbValue()) <= Integer.parseInt(answerQuestionFive) + a
                    && Integer.parseInt(item.getQuestionOneSuburbValue()) >= Integer.parseInt(answerQuestionFive) - a) {
                listOfPostCodes.add(item.getPostCode());
            }
        });
        if (!listOfPostCodes.isEmpty()) {
            List<Object[]> listOfObj = dbSchoolFacade.findSchools(listOfPostCodes);
            List<String> listOfString = new ArrayList<>();
            for (Object item : listOfObj) {
                listOfString.add(item.toString());
            }
            QuestionSevenObj.setOptions(listOfString);
            List<SuggestedSuburs> tmpListOfSuggestions = CastObjsToSuggestions(dbSchoolFacade.getAllSchools(listOfPostCodes));
            if (!tmpListOfSuggestions.isEmpty()) {
                listOfSuggestions = tmpListOfSuggestions;
            }
        }
        return QuestionSevenObj;
    }

    // This method finds the best suburb and redirects to the final page.
    private String buildFinalAnswer(String callType) {
        if (callType.equals("Survey")) {
            List<String> listOfPostCodes = new ArrayList<>();
            listOfSuggestions.forEach(item -> {
                if (answerQuestionSeven.equals(item.getQuestionOneSuburbValue())) {
                   listOfPostCodes.add(item.getPostCode());
                }
            });
            try { 
                if (!listOfPostCodes.isEmpty()) {
                    // code to finish when there is coincidence on school
                    String postCodeSuggested = listOfPostCodes.get(0);
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("suggestedPostCode", postCodeSuggested);
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/version1/app/result.xhtml");
                } else {
                    // code to finish when there is no coincidence
                    String postCodeSuggested = listOfSuggestions.get(0).getPostCode();
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("suggestedPostCode", postCodeSuggested);
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/version1/app/result.xhtml");
                }
            } catch (IOException e) { 
                System.err.println(e);
            }  
        } else if (callType.equals("Exit")) {
            
        }
        return null;
    }

    // This method converts a ViewList to an dropDown question type
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
                    System.err.println("There is not a coincidence field creating the object for fieldName: " + item.getViewFieldName());
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
                    System.err.println("There is not a coincidence field creating the object for fieldName: " + item.getViewFieldName());
            }
        }
        return resultantObj;
    }

    // This method converts a ViewList to an DropDown question type
    private QuestionMultipleChoice convertToMultpleChoiceObj(List<DbView> listOfObj) {
        QuestionMultipleChoice resultantObj = new QuestionMultipleChoice();
        List<String> tmpList = new ArrayList<>();
        for (DbView item : listOfObj) {
            switch (item.getViewFieldName()) {
                case "header":
                    resultantObj.setHeader(item.getViewFieldContent());
                    break;
                case "question":
                    resultantObj.setQuestion(item.getViewFieldContent());
                    break;
                case "optionA":
                    tmpList.add(item.getViewFieldContent());
                    break;
                case "optionB":
                    tmpList.add(item.getViewFieldContent());
                    break;
                case "optionC":
                    tmpList.add(item.getViewFieldContent());
                    break;
                case "optionD":
                    tmpList.add(item.getViewFieldContent());
                    break;
                case "button":
                    resultantObj.setButton(item.getViewFieldContent());
                    break;
                default:
                    System.err.println("There is not a coincidence field creating the object for fieldName: " + item.getViewFieldName());
            }
        }
        resultantObj.setOptions(tmpList);
        return resultantObj;
    }
    
    // This method creates a range from one inital value to other one.
    private List<String> listOfValues(String initialValue, String finalValue, String step, String type){
        List<String> resultantList = new ArrayList<>();
        if (type.equals("integer")) {
            int initalV = Integer.parseInt(initialValue);
            int finalV = Integer.parseInt(finalValue);
            int stepV = Integer.parseInt(step);
            for (int i = initalV; i <= finalV; i += stepV) {
                resultantList.add(Integer.toString(i));
            }
        } else if (type.equals("decimal")) {
            DecimalFormat df2 = new DecimalFormat(".#");
            Double initalV = Double.parseDouble(initialValue);
            Double finalV = Double.parseDouble(finalValue);
            Double stepV = Double.parseDouble(step);
            for (Double i = initalV; i <= finalV; i += stepV) {
                resultantList.add(df2.format(i));
            }
        }
        return resultantList;
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
