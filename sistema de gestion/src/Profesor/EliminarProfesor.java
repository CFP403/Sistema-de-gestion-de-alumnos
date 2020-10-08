
package Profesor;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
public class EliminarProfesor extends JInternalFrame
{
 
    public JTextField jtfNombre;
    public JComboBox jcbDNI;
    public JTextField jtfTelefono;
    
    public EliminarProfesor ()
    {
        
        super ( "Eliminar Docente" );
        
        this.Configurar();
        
    }
    
    private void Configurar ()
    {
        
        this.setResizable ( true );
        this.setClosable ( true );
        this.setMaximizable ( true );
        this.setIconifiable ( true );
        this.setSize ( 250 , 200 );
        this.setVisible ( true );
        
    }
    
}
