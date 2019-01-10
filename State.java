/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameofcraps;

/**
 *
 * @author dasare
 */
public abstract class State {

    private Dice context;

    public State(Dice dice) {
        context = dice;
    }

    public State(State source) {
        setContext(source.getContext());
    }

    public static State InitialState(Dice pts) {
        return new ComingOutState(pts);
    }

    public Dice getContext() {
        return context;
    }

    public void setContext(Dice dice) {
        context = dice;
    }

    public void roll_dice() {
        transitionState();
    }

    public abstract void transitionState();

}
