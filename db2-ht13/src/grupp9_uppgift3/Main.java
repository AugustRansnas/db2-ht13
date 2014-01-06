/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp9_uppgift3;

import java.io.File;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.icepdf.ri.common.ComponentKeyBinding;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

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
