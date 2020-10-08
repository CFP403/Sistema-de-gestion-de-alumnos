
package validadoresjtfenfoco;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextField;

/**
 *
 * @author VarelaVargasLeandro
 */
public class SoloLetras extends FocusAdapter
{
    @Override
    public void focusLost ( FocusEvent e )
    {

        JTextField letrasTextField = ((JTextField) e.getSource());
        String letras = letrasTextField.getText();

        if ( letras.matches ( "[A-z\\ ]+" ) )
            letrasTextField.setForeground(Color.BLACK);
        else
            letrasTextField.setForeground(Color.RED);

    }
}
