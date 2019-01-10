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
public class Loss extends State {

    public Loss(Dice pts) {
        super(pts);
    }

    public Loss(State source) {
        super(source);
    }

    @Override
    public void transitionState() {
        System.out.println("** Invalid State Transition Exception **");
        System.exit(0);
    }
}
