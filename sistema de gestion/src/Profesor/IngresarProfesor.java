/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Profesor;

import javax.swing.JInternalFrame;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
public class IngresarProfesor extends JInternalFrame
{
 
    public IngresarProfesor ()
    {
        
        super ( "Ingresar Docente" );
        
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

