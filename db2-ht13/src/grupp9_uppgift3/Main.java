
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

        
        
        ICEHandler[] ice = {new ICEHandler(new FileHandler()), new ICEHandler(new FileHandler())};     

        MainView mainView = new MainView(ice, new FileHandler());

        mainView.setVisible(true);

    }
}
