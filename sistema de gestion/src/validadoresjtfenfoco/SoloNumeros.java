
package validadoresjtfenfoco;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextField;

/**
 *
 * @author VarelaVargasLeandro
 */
public class SoloNumeros extends FocusAdapter
{
    
    @Override
    public void focusLost ( FocusEvent e ) {

        JTextField numeros = ((JTextField) e.getSource());
        String textoNumeros = numeros.getText();

        if ( textoNumeros.matches ( "[0-9]+[ ]*" ) )
            numeros.setForeground(Color.BLACK);
        else
            numeros.setForeground(Color.RED);


    }
    
}
