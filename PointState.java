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
public class PointState extends State {
 

    private int pointsToMatch;

    public PointState(State source) {
        super(source);
        pointsToMatch = source.getContext().getCurrentRoll();
    }

    public PointState(Dice dice) {
        super(dice);
        System.out.println("** Invalid State Transition Exception **");
        System.exit(0);
    }

    @Override
    public void transitionState() {
        if (pointsToMatch == getContext().getCurrentRoll()) {
            //transition to win
            getContext().setState(new Win(this));
        } else if (getContext().getCurrentRoll() == 7) {
            //transition to win
            getContext().setState(new Loss(this));
        } else {
            //roll again
            getContext().rollDice();
        }
    }
}
