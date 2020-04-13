/*
......
This is a remake of "thermonuclear warfare game"
......

2019 Dec 2
Author: Zach Philipp


 */
package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*
        lines 20 - 60 are establishing the beginning of the game.
        the code will add the 2 new players 'Russia' and 'USA'
        the code will assign 'state' objects which will be sub-objects of the superclasses 'country'
        'state' object will contain info fore it's String name, int popuation, and int cashGenerated
         */

        //creating new player 'Russia'
        country Russia = new country("Russia");
        //territories of player 'Russia'

        //these 3 statements add "moscow" to the object 'Russia' along with it's population and money generated
        state moscow = new state(Russia, 70845, 75,"Moscow");
        Russia.setNumberOfStates(Russia.getNumberOfStates() + 1);

        //these 3 statements add "kazan" to the object 'Russia' along with it's population and money generated
        state Voronezh = new state(Russia,40629,60,"Voronezh");
        Russia.setNumberOfStates(Russia.getNumberOfStates() + 1);

        //these 3 statements add "Magdan" to the object 'Russia' along with it's population and money generated
        state magdan = new state(Russia,25956,50,"Magdan");
        Russia.setNumberOfStates(Russia.getNumberOfStates() +1);



        //creating new player 'USA'
        country USA = new country("USA");
        //territories of player 'USA'

        //these 3 statements add "Seattle" to the object 'USA' along with it's population and money generated
        state seatle = new state(USA, 70845,75,"Seattle");
        USA.setNumberOfStates(USA.getNumberOfStates() + 1);

        //these 3 statements add "Denver" to the object 'USA' along with it's population and money generated
        state denver = new state(USA,40629,60,"Denver");
        USA.setNumberOfStates(USA.getNumberOfStates() + 1);

        //these 3 statements add "Atlanta" to the object 'USA' along with it's population and money generated
        state atlanta = new state(USA,25956,50,"Atlanta");
        USA.setNumberOfStates(USA.getNumberOfStates() + 1);


        while (true){
            CountryTakeTurn(Russia,moscow,Voronezh,magdan);
            CountryTakeTurn(USA,seatle,denver,atlanta);
        }


    }



    /*
    Lines below will display the information that is needed for the country to begin it's turn
    works by plugging in the country and it's associated states and their information that is attached
    */
    public static void CountryTakeTurn(country mainCountry, state state1, state state2, state state3){
        //DisplayPlayersCountryInfo(mainCountry,state1,state2,state3);
        //System.out.println("Options: [A] Attack  [B] Purchase weapons  [C]  End turn");
        Scanner input = new Scanner(System.in);
        while(true){
            DisplayPlayersCountryInfo(mainCountry,state1,state2,state3);
            System.out.println("Options: [A] Attack  [B] Purchase weapons  [C]  End turn");
            String userChoice = input.next();
            if("a".equals(userChoice.toLowerCase())){
                //use attack method
            }
            else if ("b".equals(userChoice.toLowerCase())){
                //use purchase method
                purchaseWeapons(mainCountry);
            }
            else if("c".equals(userChoice.toLowerCase())){
                //ends turn moving on to next player
                clearScreen();
                return;
            }
            else {
                //if user selects an option that is not available from the given list
                System.out.println("Your selection is not an option");
            }
        }
    }


    /*
    lines 110 - 162 are part of the method 'DisplayPlayersCountryInfo' method.
    It is the beginning part of the method 'CountryTakeTurn'
    It will return the basic info regarding the country's total population
    along with state information on individual population size
     */
    public static void DisplayPlayersCountryInfo(country Country, state state1, state state2, state state3){
        /*
        lines 93 - 113 will update country's info regarding state population.
        If 'totalPopulation' variable in the Country object equals 0, the system will shut down announcing the winner
         */
        checkStatePopulation(Country, state1);
        checkStatePopulation(Country, state2);
        checkStatePopulation(Country, state3);
        Country.setTotalPopulation(state1.getPopualtion()+ state2.getPopualtion()+ state3.getPopualtion());
        if(Country.getTotalPopulation() == 0){
            System.out.println("Game over! You lost! Your population has reached zero! Other player has won!");
            System.exit(0);
        }
        Country.setTotalCash(Country.getTotalCash()+state1.getCashGenerated()+state2.getCashGenerated()+state3.getCashGenerated());

        /*
        lines 124 - 147
        This is the main part of 'DisplayPlayersCountryInfo' method.
        It first prints the Country's total amount to states
        It then prints each states' individual population
         */
        System.out.println(Country.getName() + " currently owns " + Country.getNumberOfStates() + " city(s)");


        /*
        lines 122-124 will call method 'displayStatePopulation', cutting down on amount of code needed
         */
        displayStatePopulation(state1);
        displayStatePopulation(state2);
        displayStatePopulation(state3);

        System.out.print("total population: " + Country.getTotalPopulation());
        System.out.println("\tTotal Cash: $"+Country.getTotalCash());

        System.out.println("\nWeapons: ");
        System.out.println(Country.getMissleType1()+ " ground missiles");
        System.out.println(Country.getMissleType2() + " nuclear warheads");
        System.out.println(Country.getMissleType3() + " hydrogen bombs");
    }

    //Method will check state population and adjust if it is == to 0.
    //If it is it reduces the number of states owned by 1
    public static void checkStatePopulation(country Country, state state) {
        if(state.getPopualtion() <= 0){
            state.setPopualtion(0);
            Country.setNumberOfStates(Country.getNumberOfStates() - 1);
        }
    }

    public static void displayStatePopulation(state StateBeingChecked){
        if(StateBeingChecked.getPopualtion() > 0) {
            System.out.println("City: " + StateBeingChecked.getStateName() + "\t\t\t\tpop: " + StateBeingChecked.getPopualtion()+ "\tMoney generated: $"+StateBeingChecked.getCashGenerated());
        }
    }



    /*
    next segment of code will cover the methods needs to purchase weapons
     */
    public static void purchaseWeapons(country Country){
        System.out.println("Your money $" + Country.getTotalCash());
        System.out.println("Which weapon(s) would you like to buy");
        System.out.println("[A] Ground missiles\tCost: $100");
        System.out.println("[B] Nuclear bombs\tCost: $400");
        System.out.println("[C] Hydrogen Bombs\tCost: $1000");
        System.out.println("[D] Exit the market place");
        Scanner input = new Scanner(System.in);
        while(true){
            String userChoice = input.next();

            /*this if statement allows the user to buy a ground missle.
            it will take user input to find out how many the user wants
            */
            if("a".equals(userChoice.toLowerCase())){
                System.out.println("How many ground missiles would you like to buy?");
                int userChoiceInt = input.nextInt();
                if(Country.getTotalCash() > (100 * userChoiceInt)){
                    Country.setTotalCash(Country.getTotalCash() - (100*userChoiceInt));
                    Country.setMissleType1(Country.getMissleType1()+userChoiceInt);
                    Country.setTotalCash(Country.getTotalCash() - (100 * userChoiceInt));
                    System.out.println("You purchased "+userChoiceInt+" ground missile(s)");
                    clearScreen();
                    return;
                }
                else{
                    System.out.println("You can not afford that");
                    return;
                }

            }
            else if("b".equals(userChoice.toLowerCase())){
                System.out.println("How many nuclear bombs would you like to buy?");
                int userChoiceInt = input.nextInt();
                if(Country.getTotalCash() > (400 * userChoiceInt)){
                    Country.setTotalCash(Country.getTotalCash() - (400 *userChoiceInt));
                    Country.setMissleType2(Country.getMissleType2()+userChoiceInt);
                    Country.setTotalCash(Country.getTotalCash() - (400 * userChoiceInt));
                    System.out.println("You purchased "+userChoiceInt+" nucelar bomb(s)");
                    clearScreen();
                    return;
                }
                else{
                    System.out.println("You can not afford that");
                    return;
                }

            }
            else if("c".equals(userChoice.toLowerCase())){
                System.out.println("How many hydrogen bombs would you like to buy?");
                int userChoiceInt = input.nextInt();
                if(Country.getTotalCash() > (1000 * userChoiceInt)){
                    Country.setTotalCash(Country.getTotalCash() - (1000*userChoiceInt));
                    Country.setMissleType3(Country.getMissleType3()+userChoiceInt);
                    Country.setTotalCash(Country.getTotalCash() - (1000 * userChoiceInt));
                    System.out.println("You purchased "+userChoiceInt+" hydrogen bomb(s)");
                    clearScreen();
                    return;
                }
                else{
                    System.out.println("You can not afford that");
                    return;
                }

            }
            else if("d".equals(userChoice.toLowerCase())){
                return;
            }
            else{
                System.out.println("That is not an option");
            }
        }

    }


    /*
    lines 237 - 240 is a method that will wipe the screen
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }



/*
************************
when you come back to code
all you need to do is create the method for attacking the other player
************************
 */














}
