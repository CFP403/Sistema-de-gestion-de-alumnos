
package Curso;

import javax.swing.*;

/**
 * @author Lucas
 */

public class EliminarCurso extends JInternalFrame
{
 
    public EliminarCurso()
    {
        
        super ( "Eliminar Curso" );
        
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