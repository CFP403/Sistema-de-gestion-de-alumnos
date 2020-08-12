
package Curso;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * @author Lucas
 */

public class ModificarCurso extends JDialog implements ActionListener{
 
    private JButton btnAceptar, btnCancelar;
    
    public ModificarCurso()
    {
        this.setTitle("Modificar Curso");
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        this.add(new JLabel("Nombre del curso"));
        this.add(new JTextField(20));
        
        this.add(new JLabel("Cantidad de Alumnos"));
        this.add(new JTextField(20));

        
        btnAceptar = new JButton("Aceptar");
        //btnAceptar.addActionListener();
        btnCancelar = new JButton("Cancelar");
        /*btnCancelar.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ModificarCurso.this.dispose();
            }
        });*/
        
        btnCancelar.addActionListener(this);
        this.add(btnAceptar);
        this.add(btnCancelar);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
                ModificarCurso.this.dispose();
    }
    
    public void Mostrar()
    {
        ImageIcon img = new ImageIcon("src/Imagenes/icon32.png");
        this.setIconImage(img.getImage());
        this.setSize (300, 300);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setModal(true);
    }
}