
package validadoresjtfenfoco;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextField;

/**
 *
 * @author bapo
 */
public class SoloTelefono extends FocusAdapter
{
    
    @Override
    public void focusLost ( FocusEvent e ) 
    {

        JTextField telefonoTextField = ((JTextField) e.getSource());
        String telefono = telefonoTextField.getText();

        if ( telefono.matches ( "[+]?\\d*[ ]*[\\d]+[ ]*" ) )
            telefonoTextField.setForeground(Color.BLACK);
        else
            telefonoTextField.setForeground(Color.RED);

    }
    
}
