
package Alumno;

import java.awt.GridBagLayout;
import javax.swing.JInternalFrame;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
public class InscribirAlumno extends JInternalFrame
{

    private final GridBagLayout layout = new GridBagLayout ();

    
    public InscribirAlumno ()
    {

        super ( "Inscribir Alumno" );

        this.Configurar();
        //this.agregarComponentes();

    }

    private void Configurar ()
    {

        this.setResizable ( true );
        this.setClosable ( true );
        this.setMaximizable ( true );
        this.setIconifiable ( true );
        this.setSize ( 500, 500 );
        //this.setMinimumSize ( new Dimension ( 800, 540 ) );
        this.setLayout ( this.layout );

    }
    
    public InscribirAlumno Mostrar ()
    {
        
        this.setVisible ( true );
        
        return this;
        
    }
    
}
