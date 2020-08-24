
package Curso;

import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 * @author Lucas
 */

public class IngresarCurso extends JInternalFrame implements ActionListener 
{
    
    private JButton btnAceptar;
    
    private JTextField tfNombre,
            tfDiaCreacion,
            tfMesCreacion,
            tfAnioCreacion,
            tfDiaInicio,
            tfMesInicio,
            tfAnioInicio,
            tfDiaFin, 
            tfMesFin,
            tfAnioFin,
            tfDuracion,
            tfCupoAlumnos,
            tfCupoDocentes;
    
    public IngresarCurso ()
    {        
        
        super ( "Ingresar Curso" );
        this.setLayout( new FlowLayout (FlowLayout.CENTER) );
        
        /* -- Nombre del curso --*/
        
        tfNombre = new JTextField(8);
        this.add(new JLabel("Nombre del curso"));
        this.add(tfNombre);
        
        /* ---- */
        
        /* -- Fecha de creacion --*/
        
        tfDiaCreacion = new JTextField(2);
        tfMesCreacion = new JTextField(2); 
        tfAnioCreacion = new JTextField(3);
        
        this.add(new JLabel("Fecha de creacion"));
        this.add(tfDiaCreacion);
        this.add(new JLabel("/"));
        this.add(tfMesCreacion);
        this.add(new JLabel("/"));
        this.add(tfAnioCreacion);
        
        /* ---- */
        
        /* -- Fecha de inicio -- */
        
        tfDiaInicio = new JTextField(2);
        tfMesInicio = new JTextField(2); 
        tfAnioInicio = new JTextField(3);
        
        tfDiaInicio.addActionListener(this);
        tfMesInicio.addActionListener(this);
        tfAnioInicio.addActionListener(this);
        
        this.add(new JLabel("Fecha de inicio"));
        this.add(tfDiaInicio);
        this.add(new JLabel("/"));
        this.add(tfMesInicio);
        this.add(new JLabel("/"));
        this.add(tfAnioInicio);
        /* ---- */
        
        /* -- Fecha de cierre -- */
        
        tfDiaFin = new JTextField(2);
        tfMesFin = new JTextField(2); 
        tfAnioFin = new JTextField(3);
        
        this.add(new JLabel("Fecha de cierre"));
        this.add(tfDiaFin);
        this.add(new JLabel("/"));
        this.add(tfMesFin);
        this.add(new JLabel("/"));
        this.add(tfAnioFin);
        /* ---- */
        
        /* -- Duracion (meses) -- */
        
        tfDuracion = new JTextField(3);
        this.add(new JLabel("Duracion del curso (meses)"));
        this.add(tfDuracion);
        
        /* ---- */
        
        /* -- Cupo de alumnos -- */
        
        tfCupoAlumnos = new JTextField(3);
        this.add(new JLabel("Cupo de alumnos   "));
        this.add(tfCupoAlumnos);
        
        /* ---- */
        
        /* -- Cupo de docentes -- */
        
        tfCupoDocentes = new JTextField(3);
        this.add(new JLabel("Cupo de docentes   "));
        this.add(tfCupoDocentes);
        
        /* ---- */        
                
        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(this);
        this.add(btnAceptar);
        
        this.Configurar();
        
    }
    
    private void Configurar ()
    {
        
        this.setResizable ( false );
        this.setClosable ( true );
        this.setMaximizable ( false );
        this.setIconifiable ( true );
        this.setSize ( 250 , 242 );
        this.setVisible ( true );
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        try{
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        
        String cNombre = tfNombre.getText();
        
        String cFechaCreacion = tfDiaCreacion.getText()+"/"+
                tfMesCreacion.getText()+"/"+tfAnioCreacion.getText();
        Date fechaCreacion = simpleDateFormat.parse(cFechaCreacion);
        String cFechaInicio = tfDiaInicio.getText()+"/"+
                tfMesInicio.getText()+"/"+tfAnioInicio.getText();
        Date fechaInicio = simpleDateFormat.parse(cFechaInicio);
        String cFechaCierre = tfDiaFin.getText()+"/"+
                tfMesFin.getText()+"/"+tfAnioFin.getText();
        Date fechaCierre = simpleDateFormat.parse(cFechaCierre);
        int cDuracion = Integer.parseInt(tfDuracion.getText());
        int cCupoAlumnos = Integer.parseInt(tfCupoAlumnos.getText());
        int cCupoDocentes = Integer.parseInt(tfCupoDocentes.getText());
                
        System.out.println("Curso: "+cNombre);
        System.out.println("Creacion: "+fechaCreacion);
        System.out.println("Inicio: "+fechaInicio);
        System.out.println("Cierre: "+fechaCierre);
        System.out.println("Duracion: "+cDuracion+" meses");
        System.out.println("Cupo Alumnos: "+cCupoAlumnos);
        System.out.println("Cupo Docentes: "+cCupoDocentes);
        } catch (ParseException ex) {
            Logger.getLogger(IngresarCurso.class.getName()).log(Level.SEVERE, null, ex);
        }           
    }
    
}
