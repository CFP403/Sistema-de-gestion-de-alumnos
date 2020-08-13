
package Ventanas;

import javax.swing.*;

/**
 * @author Lucas
 */

public class InternalFrame 
{ 
        
    public InternalFrame(JFrame f) 
    {
        JFrame fs = new JFrame();
        
        JDesktopPane theDesktop = new JDesktopPane();
        fs.add(theDesktop); // add desktop pane to frame
        
        
        fs.setVisible(true);
        fs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fs.setSize(800, 800);
        fs.setLocationRelativeTo(null);
        

        JInternalFrame frame = new JInternalFrame("Internal Frame", true, true, true, true);
        
        theDesktop.add(frame);
        
        frame.setVisible(true);
        frame.setSize(300, 300);
        
    }
}