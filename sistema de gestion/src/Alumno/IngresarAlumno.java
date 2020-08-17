
package Alumno;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
public class IngresarAlumno extends JInternalFrame
{

    private final GridBagLayout layout = new GridBagLayout ();
    
    private JPanel jpDatosAlumno;
        //Documento:
            private JComboBox jcbTipoDoc;
            private JTextField jtfNroDoc;
            private ButtonGroup bgEstadoDoc;
                private JRadioButton jrbBueno;
                private JRadioButton jrbMalo;
                private JRadioButton jrbEnTramite;
                private JRadioButton jrbNoPosee;
        //Nombre y Sexo:
            private JTextField jtfApellido;
            private JTextField jtfNombre;
            private JTextField jtfSexo;
        //Nacimiento:
            private JTextField jtfDiaNacimiento;
            private JTextField jtfMesNacimiento;
            private JTextField jtfAnioNacimiento;
            private JTextField jtfLugarNaciomiento;
            private JTextField jtfNacionalidad;
        //Domicilio:
            private JTextField jtfCalleDomicilio;
            private JTextField jtfNroDomicilio;
            private JTextField jtfPisoDomicilio;
            private JTextField jtfTorreDomicilio;
            private JTextField jtfDptoDomicilio;
            private JTextField jtfLocalidadDomicilio;
            private JTextField jtfCodPostalDomicilio;
        //Nivel Instrucción:
            private ButtonGroup jbgNivelInstruccion;
                private JRadioButton jrbNinguno;
                private JRadioButton jrbPrimario;
                private JRadioButton jrbSecundario;
                private JRadioButton jrbTerciario;
                private JRadioButton jrbUniversitario;
                private JRadioButton jrbPosgrado;
                    private ButtonGroup jbgHasta;
                        private JRadioButton jrbCompleto;
                        private JRadioButton jrbIncompleto;
                        private JRadioButton jrbHastaAnio;
                            private JTextField jtfAnioCompleto;
    
    public IngresarAlumno ()
    {
        
        super ( "Ingresar Alumno" );
        
        this.Configurar();
        this.agregarComponentes();
        this.Mostrar();
        
    }
    
    private void Configurar ()
    {
        
        this.setResizable ( true );
        this.setClosable ( true );
        this.setMaximizable ( true );
        this.setIconifiable ( true );
        this.setSize ( 250 , 200 );
        this.setLayout ( this.layout );
        
    }
    
    private void agregarComponentes ()
    {
        
        this.jpDatosAlumno = new JPanel ();
            this.jpDatosAlumno.setBorder ( BorderFactory.createTitledBorder ( "Ingreso Alumnos" ) );
            this.agregarDocumento ( this.jpDatosAlumno );
            this.add ( this.jpDatosAlumno, this.ConstraintsGridBag ( GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH, 0, 0, 1, 1, 1, 1 ) );
            
            
    }
    
    private void agregarDocumento ( JPanel contenedor )
    {
        
        contenedor.setLayout ( this.layout );
        
            // TiposDocumentos:
            String [] tiposDocumentos = { "DNI", "Cédula Identidad", "Pasaporte", "Libreta de Enrolamiento" };
            this.jcbTipoDoc = new JComboBox ( tiposDocumentos );
            contenedor.add ( this.jcbTipoDoc, this.ConstraintsGridBag ( GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, 0, 0, 1, 1, 1, 1 ) );
            contenedor.add ( new JLabel ( "Nro Doc: " ), this.ConstraintsGridBag ( GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, 1, 0, 1, 1, 1, 1 ) );
            this.jtfNroDoc = new JTextField ( 20 );
            contenedor.add ( this.jtfNroDoc, this.ConstraintsGridBag ( GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, 2, 0, 1, 1, 1, 1 ) );
            
        
    }
    
    private GridBagConstraints ConstraintsGridBag ( int Posicionrelativa, int Rellenar, int Fila, int Columna, int Ancho, int Alto, double ExpansionFila, double ExpansionColumna )
    {
        
        GridBagConstraints gbc = new GridBagConstraints ();
        
        gbc.gridx = Fila;
        gbc.gridy = Columna;
        gbc.gridwidth = Ancho;
        gbc.gridheight = Alto;
        gbc.anchor = Posicionrelativa;
        gbc.fill = Rellenar;
        gbc.weightx = ExpansionFila;
        gbc.weighty = ExpansionColumna;
        
        return gbc;
        
    }
    
    public void Mostrar ()
    {
        
        this.setVisible ( true );
        
    }
    
}
