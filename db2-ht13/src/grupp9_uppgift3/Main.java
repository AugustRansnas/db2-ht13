/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp9_uppgift3;

/**
 * This class starts ICEHandlers and viewer.
 *
 * @author Jonas Ahrne
 * @author August Ransnäs
 * @author Viktor Voigt
 * @author Joel Pennegård
 */
public class Main {

    /**
     * This method starts ICEHandlers and viewer.
     *
     * @param args from system to program
     */
    public static void main(String[] args) {

        ICEHandler ice1 = new ICEHandler();

        ICEHandler ice2 = new ICEHandler();

        MainView mainView = new MainView(ice1, ice2);

        mainView.setVisible(true);

    }
}
