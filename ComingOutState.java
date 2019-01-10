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
public class ComingOutState extends State {

    private int roll;
    Win w;
    Loss l;
    Dice d;
    State objState;

    public ComingOutState(Dice dice) {
        super(dice);
        //roll = objState.getContext().getCurrentRoll();
    }

    public ComingOutState(State source) {
        super(source);
        System.out.println("** Invalid State Transition Exception **");
        System.exit(0);
    }

    @Override
    public void transitionState() {

//        switch (roll) {
//            case 2:
//            case 3:
//            case 12:
//                System.out.println("Craps(You lose)");
//                l.transitionState();
//                break;
//            case 7:
//            case 11:
//                System.out.println("natural(Win)");
//                w.transitionState();
//                break;
//            default:
//                System.out.println("Point");
//                roll_dice();
//                break;
//        }
//    }
        //  transitions to either a Win, Loss or Points state 
        if (roll == getContext().getCurrentRoll()) {
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
