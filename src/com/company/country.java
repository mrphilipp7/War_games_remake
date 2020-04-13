package com.company;

import java.util.LinkedList;
import java.util.List;

public class country {

    protected String name;
    protected int numberOfStates;
    protected int totalPopulation;
    protected int totalCash;
    protected int missleType1;
    protected int missleType2;
    protected int missleType3;

    protected country(country origin){

    }

    public country(String name){
        numberOfStates = 0;
        totalPopulation = 0;
        totalCash = 0;
        missleType1 = 0;
        missleType2 = 0;
        missleType3 = 0;
        this.name = name;
    }

    public int getNumberOfStates() {
        return numberOfStates;
    }

    public void setNumberOfStates(int numberOfStates) {
        this.numberOfStates = numberOfStates;
    }

    public int getTotalPopulation() {
        return totalPopulation;
    }

    public void setTotalPopulation(int totalPopulation) {
        this.totalPopulation = totalPopulation;
    }

    public int getTotalCash() {
        return totalCash;
    }

    public void setTotalCash(int totalCash) {
        this.totalCash = totalCash;
    }

    public int getMissleType1() {
        return missleType1;
    }

    public void setMissleType1(int missleType1) {
        this.missleType1 = missleType1;
    }

    public int getMissleType2() {
        return missleType2;
    }

    public void setMissleType2(int missleType2) {
        this.missleType2 = missleType2;
    }

    public int getMissleType3() {
        return missleType3;
    }

    public void setMissleType3(int missleType3) {
        this.missleType3 = missleType3;
    }

    public boolean checkIfAlive(){
        if(totalPopulation <= 0){
            System.out.println("Game is over, you lose");
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

}
