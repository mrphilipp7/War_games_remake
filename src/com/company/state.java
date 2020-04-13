package com.company;

public class state extends country {
    private String stateName;
    private int popualtion;
    private int cashGenerated;

    public state(country orig, int popualtion, int cashGenerated,String stateName) {
        super(orig);
        this.popualtion = popualtion;
        this.cashGenerated = cashGenerated;
        this.stateName = stateName;
    }



    public String getStateName() {
        return stateName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopualtion() {
        return popualtion;
    }

    public void setPopualtion(int popualtion) {
        this.popualtion = popualtion;
    }

    public int getCashGenerated() {
        return cashGenerated;
    }

    public void setCashGenerated(int cashGenerated) {
        this.cashGenerated = cashGenerated;
    }





}
