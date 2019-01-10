/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameofcraps;

import java.util.Random;

/**
 *
 * @author dasare
 */
public class Dice {
    // Context class - current roll of the dice

    private int currentRoll;
    private State objState;
    Dice d;
    Win w;
    Loss l;
    

    public Dice() {
        objState = State.InitialState(this);
    }

    public void setState(State newState) {
        objState = newState;
    }

    public State getState() {
        return objState;
    }

    public int getCurrentRoll() {
        return currentRoll;
    }

    public void rollDice() {
//        currentRoll = generateRoll();
//        System.out.println("rolled a " + currentRoll);
//        objState.roll_dice();
//        do{
//            switch (currentRoll) {
//                case 4:
//            //objState.getContext();
//                case 5:
//                case 6:
//                case 8:
//                case 9:
//                case 10:
//                    System.out.println("roll of " + currentRoll + ("point"));
//                    objState.roll_dice();
//                    objState.transitionState();
//                    break;
//                case 2:
//                case 3:
//                case 12:
//                    System.out.println("roll of " + currentRoll + ("craps(lose)"));
//                    //objState.getContext();
//                    l.transitionState();
//                    break;
//                case 7:
//                case 11:
//                    System.out.println("roll of " + currentRoll + "natural(win)");
//                    w.transitionState();
//                    break;
//                default:
//                    break;
//            }
//        }while(currentRoll !=7);
        currentRoll = generateRoll();
        System.out.println("Rolled a " + currentRoll);
        objState.roll_dice();
        
    }

    private int generateRoll() {
        Random r = new Random();
        //int n = r.nextInt(12)+1;
        return r.nextInt((12 - 1) + 1) + 1;

    }
    

}
