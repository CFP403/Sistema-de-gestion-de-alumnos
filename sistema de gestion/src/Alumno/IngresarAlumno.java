
package Alumno;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
        this.setSize ( 550, 200 );
        this.setMinimumSize ( new Dimension ( 550, 100 ) );
        this.setLayout ( this.layout );
        
    }
    
    private void agregarComponentes ()
    {
        
        this.jpDatosAlumno = new JPanel ();
            this.jpDatosAlumno.setBorder ( BorderFactory.createTitledBorder ( "Ingreso Alumnos" ) );
            this.agregarDocumento ( this.jpDatosAlumno );
            this.add ( this.jpDatosAlumno, this.ConstraintsGridBag ( GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH, 0, 0, 1, 1, 1, 1, null ) );
            
            
    }
    
    private void agregarDocumento ( JPanel contenedorDocumento )
    {
        
        double Filas = 2.0;
        
        contenedorDocumento.setLayout ( this.layout );
            
        /*============================================
        =            Panel TipoDocumentos            =
        ============================================*/
        JPanel panelTipoDocumentos = new JPanel ();
        
            /*----------  JComboBox TipoDoc  ----------*/
                String [] tiposDocumentos = { "DNI", "Cédula Identidad", "Pasaporte", "Libreta de Enrolamiento" };
                this.jcbTipoDoc = new JComboBox ( tiposDocumentos );
                    panelTipoDocumentos.add ( this.jcbTipoDoc );
            /*----------  Fin JComboBox TipoDoc  ----------*/
            
            /*----------  Panel NroDoc  ----------*/
                JPanel panelnroDoc = new JPanel ();
                    JLabel labelNroDoc = new JLabel ( "Nro Doc: " );
                    this.jtfNroDoc = new JTextField ( 8 );
                    panelnroDoc.add ( labelNroDoc );
                    panelnroDoc.add ( this.jtfNroDoc );
                    panelTipoDocumentos.add ( panelnroDoc );
            /*----------  Fin Panel NroDoc  ----------*/
        
        contenedorDocumento.add ( panelTipoDocumentos, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST, GridBagConstraints.BOTH, 0, 0, 1, 1, 0.5, ( 1.0 / Filas ), null ) );
        /*=====  End of Panel TipoDocumentos  ======*/
        
        /*=======================================
        =            Panel EstadoDoc            =
        =======================================*/
        JPanel panelEstado = new JPanel ();
            panelEstado.setSize ( 50, 50 );
            panelEstado.setBorder ( BorderFactory.createTitledBorder ( "Estado del documento: " ) );
            panelEstado.setLayout ( new FlowLayout ( FlowLayout.LEFT ) );
            
            /*----------  Botones EstadoDoc  ----------*/
                this.bgEstadoDoc = new ButtonGroup ();
                    this.jrbBueno = new JRadioButton ( "Bueno " );
                    this.bgEstadoDoc.add ( this.jrbBueno );
                    panelEstado.add ( this.jrbBueno );
                    this.jrbMalo = new JRadioButton ( "Malo " );
                    this.bgEstadoDoc.add ( this.jrbMalo );
                    panelEstado.add ( this.jrbMalo );
                    this.jrbEnTramite = new JRadioButton ( "En Trámite " );
                    this.bgEstadoDoc.add ( this.jrbEnTramite );
                    panelEstado.add ( this.jrbEnTramite );
                    this.jrbNoPosee = new JRadioButton ( "No Posee " );
                    this.bgEstadoDoc.add ( this.jrbNoPosee );
                    panelEstado.add ( this.jrbNoPosee );
            /*----------  Fin EstadoDoc  ----------*/
        
        contenedorDocumento.add ( panelEstado, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST, GridBagConstraints.BOTH, 1, 0, 1, 1, 0.5, ( 1.0 / Filas ), null ) );
        /*=====  End of Panel EstadoDoc  ======*/
        
        
        
    }
    
    private GridBagConstraints ConstraintsGridBag ( int Posicionrelativa, int Rellenar, int X, int Y, int Ancho, int Alto, double WeightX, double WeightY, Insets margen )
    {
        
        
        GridBagConstraints gbc = new GridBagConstraints ();
        
        gbc.gridx = X;
        gbc.gridy = Y;
        gbc.gridwidth = Ancho;
        gbc.gridheight = Alto;
        gbc.anchor = Posicionrelativa;
        gbc.fill = Rellenar;
        gbc.weightx = WeightX;
        gbc.weighty = WeightY;
        
        if ( margen != null )
            gbc.insets = margen;
        
        return gbc;
        
    }
    
    public void Mostrar ()
    {
        
        this.setVisible ( true );
        
    }
    
}
