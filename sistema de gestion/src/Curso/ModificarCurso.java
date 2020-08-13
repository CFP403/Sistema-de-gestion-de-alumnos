
package Curso;

import javax.swing.*;

/**
 * @author Lucas
 */

public class ModificarCurso extends JInternalFrame
{
 
    public ModificarCurso()
    {
        
        super ( "Modificar Curso" );
        
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