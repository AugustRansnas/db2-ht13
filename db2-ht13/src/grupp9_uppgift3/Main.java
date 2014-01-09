/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp9_uppgift3;

/**
 *
 * @author svalan
 */
public class Main {

    public static void main(String[] args) {
        
        ICEHandler ice1 = new ICEHandler();
        
        ICEHandler ice2 = new ICEHandler();

        MainView mainView = new MainView(ice1, ice2);
        
        mainView.setVisible(true);

    }
}
