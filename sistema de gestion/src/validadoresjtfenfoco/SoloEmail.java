
package validadoresjtfenfoco;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextField;

/**
 *
 * @author VarelaVargasLeandro
 */
public class SoloEmail extends FocusAdapter
{
    
    @Override
    public void focusLost ( FocusEvent e )
    {

        JTextField emailTextField = ((JTextField) e.getSource());
        String email = emailTextField.getText();
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w ]+";

        if ( email.matches(regex) )
            emailTextField.setForeground ( Color.BLACK );
        else
            emailTextField.setForeground ( Color.RED );

    }
    
}
