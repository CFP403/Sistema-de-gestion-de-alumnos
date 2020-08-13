
package Alumno;

import javax.swing.JInternalFrame;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
public class ModificarAlumno extends JInternalFrame
{
 
    public ModificarAlumno ()
    {
        
        super ( "Modificar Alumno" );
        
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
