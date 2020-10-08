
package Alumno;

import Ventanas.TipoVentana.ETipoVentana;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;

import validadoresjtfenfoco.*;

/**
 *
 * @author VarelaVargasLeandro
 */
public class ModeloVentanaAlumno extends JInternalFrame
{
    
    private ETipoVentana tipo;
    
    protected final LayoutManager layout = new GridBagLayout ();

    protected JPanel jpDatosAlumno;
        //Documento:
            protected JComboBox jcbTipoDoc;
            protected JTextField jtfNroDoc;
            private JComboBox jcbNroDoc;
            protected ButtonGroup bgEstadoDoc;
                protected JRadioButton jrbBueno;
                protected JRadioButton jrbMalo;
                protected JRadioButton jrbEnTramite;
                protected JRadioButton jrbNoPosee;
        //Nombre y Sexo:
            protected JTextField jtfApellido;
            protected JTextField jtfNombre;
            protected JComboBox jcbSexo;
        //Nacimiento:
            protected SpinnerModel smModeloFecha;
            protected JSpinner jsFecha;
            protected JTextField jtfLugarNacimiento;
            protected JTextField jtfNacionalidad;
        //Domicilio:
            protected JTextField jtfDomicilioCalle;
            protected JTextField jtfNro;
            protected JTextField jtfPiso;
            protected JTextField jtfTorre;
            protected JTextField jtfDpto;
            protected JTextField jtfLocalidad;
            protected JTextField jtfCodPostal;
            protected JTextField jtfTelefono;
            protected JTextField jtfEmail;
        //Nivel Instrucción:
            protected ButtonGroup bgNivelInstruccion;
                protected JRadioButton jrbNinguno;
                protected JRadioButton jrbPrimario;
                protected JRadioButton jrbSecundario;
                protected JRadioButton jrbTerciario;
                protected JRadioButton jrbUniversitario;
                protected JRadioButton jrbPosgrado;
                    protected ButtonGroup bgHasta;
                        protected JRadioButton jrbCompleto;
                        protected JRadioButton jrbIncompleto;
                        protected JRadioButton jrbHastaAnio;
                            protected JTextField jtfAnioCompleto;
        //Boton Aceptar
        protected JButton jbAceptar;
        
        public ModeloVentanaAlumno ( String titulo, ETipoVentana tipo )
        {
            super ( titulo );
            this.tipo = tipo;
            this.Configurar();
            this.agregarComponentes( );
        }
    
        private void Configurar ()
        {

            this.setResizable ( true );
            this.setClosable ( true );
            this.setMaximizable ( true );
            this.setIconifiable ( true );
            this.setSize ( 870, 550 );
            this.setMinimumSize ( new Dimension ( 800, 540 ) );
            this.setLayout ( this.layout );

        }
        
        private void agregarComponentes ( )
        {

            this.jpDatosAlumno = new JPanel ();
            this.jpDatosAlumno.setBorder ( BorderFactory.createTitledBorder ( "Ingreso Alumnos" ) );
            this.agregarPaneles ( this.jpDatosAlumno );
            this.add ( this.jpDatosAlumno, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST, GridBagConstraints.BOTH, 0, 0, 1, 1, 1, 1, null ) );

        }

        /**
         * Invoca a TODAS las funciones para la creación de paneles y los
         * agrega a la ventana.
         * @param contenedorDocumento panel principal de la ventana
         */
        private void agregarPaneles ( JPanel contenedorDocumento )
        {
            double PesoFilasPaneles = 0.1;

            contenedorDocumento.setLayout ( this.layout );

            // FILA UNO:
                // Panel DOCUMENTO.
                this.ColumnaDocumento(contenedorDocumento, PesoFilasPaneles);
                // Panel ESTADODOCUMENTO.
                this.ColumnaEstadoDocumento(contenedorDocumento, PesoFilasPaneles);

            // FILA DOS:
                // Panel INFORMACIÓN PERSONAL.
                this.ColumnaInfoPers(contenedorDocumento, PesoFilasPaneles);
                // Panel NACIMIENTO.
                this.ColumnaNac(contenedorDocumento, PesoFilasPaneles);

            // FILA TRES:
                // Panel DOMICILIO.
                this.ColumnaDomic(contenedorDocumento, PesoFilasPaneles);
                // Panel LOCALIDAD/CONTACTO.
                this.ColumnaLocalidadContacto(contenedorDocumento, PesoFilasPaneles);
            // Panel NIVEL INSTRUCCION

            // FILA CUATRO:
                this.filaNivelInstruccion(contenedorDocumento, PesoFilasPaneles);

            // Boton ACEPTAR
            this.botonAceptar( contenedorDocumento );
        }
        
        /**
         * Crea el panel correspondiente a los datos de DNI
         * @param contenedorDocumento panel principal de la ventana
         * @param PesoFilasPaneles Weight GridBagConstraints
         */
        private void ColumnaDocumento ( JPanel contenedorDocumento, double PesoFilasPaneles )
        {
            /*============================================
            =            Panel TipoDocumentos            =
            ============================================*/
            JPanel panelTipoDocumentos = new JPanel ();
            panelTipoDocumentos.setLayout ( new FlowLayout ( FlowLayout.CENTER ) );

            /*----------  JComboBox TipoDoc  ----------*/
            JPanel paneltiposDocumentosComboBox = new JPanel ();
                String [] tiposDocumentos = { "DNI", "Cédula Identidad", "Pasaporte", "Libreta de Enrolamiento" };
                this.jcbTipoDoc = new JComboBox ( tiposDocumentos );

                paneltiposDocumentosComboBox.add ( this.jcbTipoDoc );    

                    panelTipoDocumentos.add ( paneltiposDocumentosComboBox );
            /*----------  Fin JComboBox TipoDoc  ----------*/

            switch ( this.tipo )
            {
                
                case Crear:
                {
                    /*----------  Panel NroDoc  ----------*/
                    JPanel panelnroDoc = new JPanel ();
                        JLabel labelNroDoc = new JLabel ( "Nro Doc: " );
                        this.jtfNroDoc = new JTextField ( 8 );

                        this.jtfNroDoc.addFocusListener(  new SoloNumeros()  );

                        panelnroDoc.add ( labelNroDoc );
                        panelnroDoc.add ( this.jtfNroDoc );

                            panelTipoDocumentos.add ( panelnroDoc );
                    /*----------  Fin Panel NroDoc  ----------*/
                    break;
                }
                
                default:
                {
                    /*----------  Panel NroDoc  ----------*/
                    JPanel panelnroDoc = new JPanel ();
                        JLabel labelNroDoc = new JLabel ( "Nro Doc: " );
                        this.jcbNroDoc = new JComboBox ();

                        //this.jtfNroDoc.addFocusListener( new SoloNumeros() );

                        panelnroDoc.add ( labelNroDoc );
                        panelnroDoc.add ( this.jcbNroDoc );

                            panelTipoDocumentos.add ( panelnroDoc );
                    /*----------  Fin Panel NroDoc  ----------*/
                }
                
            }
            
                
            /*=====  End of Panel TipoDocumentos  ======*/

            contenedorDocumento.add ( panelTipoDocumentos, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST, GridBagConstraints.BOTH, 0, 0, 1, 1, 0.5, PesoFilasPaneles, null ) );
        }

        /**
         * Crea el panel correspondiente a los datos de estado de DNI
         * @param contenedorDocumento panel principal de la ventana
         * @param PesoFilasPaneles Weight GridBagConstraints
         */
        private void ColumnaEstadoDocumento ( JPanel contenedorDocumento, double PesoFilasPaneles )
        {
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
                            this.jrbBueno.setActionCommand ( "Bueno" );
                        this.jrbMalo = new JRadioButton ( "Malo " );
                            this.jrbMalo.setActionCommand ( "Malo" );
                        this.jrbEnTramite = new JRadioButton ( "En Trámite " );
                            this.jrbEnTramite.setActionCommand( "En Trámite" );
                        this.jrbNoPosee = new JRadioButton ( "No Posee " );
                            this.jrbNoPosee.setActionCommand("No posee");

                        this.bgEstadoDoc.add ( this.jrbBueno );
                        this.bgEstadoDoc.add ( this.jrbMalo );
                        this.bgEstadoDoc.add ( this.jrbEnTramite );
                        this.bgEstadoDoc.add ( this.jrbNoPosee );

                        panelEstado.add ( this.jrbBueno );
                        panelEstado.add ( this.jrbMalo );
                        panelEstado.add ( this.jrbEnTramite );
                        panelEstado.add ( this.jrbNoPosee );
                /*----------  Fin EstadoDoc  ----------*/
            /*=====  End of Panel EstadoDoc  ======*/

            contenedorDocumento.add ( panelEstado, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST, GridBagConstraints.HORIZONTAL, 1, 0, 1, 1, 0.5, PesoFilasPaneles, null ) );
        }
        
        /**
         * Crea el panel correspondiente a la Información Personal del Alumno
         * @param contenedorDocumento panel principal de la ventana
         * @param PesoFilasPaneles Weight GridBagConstraints
         */
        private void ColumnaInfoPers (JPanel contenedorDocumento, double PesoFilasPaneles)
        {
            /*==================================================
            =            Panel Información Personal            =
            ==================================================*/
            JPanel panelInfoPers = new JPanel();
            double panelInfoFilas = 3.0;
                panelInfoPers.setLayout ( this.layout );

                    /*----------  Apellido/s  ----------*/
                    JLabel labelApellidos = new JLabel ( "Apellido/s: " );
                    this.jtfApellido = new JTextField ( 15 );

                    this.jtfApellido.addFocusListener ( new SoloLetras() );

                    panelInfoPers.add ( labelApellidos, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.HORIZONTAL, 0, 0, 1, 1, 0.1, ( 1.0 / panelInfoFilas ), null ) );
                    panelInfoPers.add ( this.jtfApellido, this.ConstraintsGridBag ( GridBagConstraints.NORTHWEST , GridBagConstraints.HORIZONTAL, 1, 0, 1, 1, 0.9, ( 1.0 / panelInfoFilas ), null ) );
                    /*----------  End of Apellido/s  ----------*/

                    /*----------  Nombre/s  ----------*/
                    JLabel labelNombres = new JLabel ( "Nombre/s:" );
                    this.jtfNombre = new JTextField ( 15 );

                    this.jtfNombre.addFocusListener ( new SoloLetras() );

                    panelInfoPers.add ( labelNombres, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.HORIZONTAL, 0, 1, 1, 1, 0.1, ( 1.0 / panelInfoFilas ), null ) );
                    panelInfoPers.add ( this.jtfNombre, this.ConstraintsGridBag ( GridBagConstraints.NORTHWEST , GridBagConstraints.HORIZONTAL, 1, 1, 1, 1, 0.9, ( 1.0 / panelInfoFilas ), null ) );
                    /*----------  End of Nombre/s  ----------*/

                    /*----------  Sexo  ----------*/
                    JLabel labelSexo = new JLabel ( "Sexo: " );
                    String [] Sexos = { "Masculino", "Femenino" };
                    this.jcbSexo = new JComboBox ( Sexos );
                    panelInfoPers.add ( labelSexo, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.HORIZONTAL, 0, 2, 1, 1, 0.1, ( 1.0 / panelInfoFilas ), null ) );
                    panelInfoPers.add ( this.jcbSexo, this.ConstraintsGridBag ( GridBagConstraints.NORTHWEST , GridBagConstraints.HORIZONTAL, 1, 2, 1, 1, 0.9, ( 1.0 / panelInfoFilas ), null ) );
                    /*----------  End of Sexo  ----------*/
            /*=====  End of Panel Información Personal  ======*/

            contenedorDocumento.add ( panelInfoPers, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.HORIZONTAL, 0, 1, 1, 1, 0.5, PesoFilasPaneles, null ) );

        }
        
        /**
         * Crea el panel correspondiente a los datos de Nacimiento del Alumno.
         * @param contenedorDocumento panel principal de la ventana
         * @param PesoFilasPaneles Weight GridBagConstraints 
         */
        private void ColumnaNac ( JPanel contenedorDocumento, double PesoFilasPaneles )
        {
            /*========================================
            =            Panel Nacimiento            =
            ========================================*/
            JPanel panelNac = new JPanel ();
            double panelNacFilas = 3.0;
                panelNac.setLayout ( this.layout );
                Insets margenlabelsNacimiento = new Insets ( 0, 10, 0, 0 );

                    /*----------  FechaNac  ----------*/
                    JPanel panelFechaNac = new JPanel ();
                        JLabel labelFechaNac = new JLabel ( "Fecha de Nacimiento: " );
                        panelFechaNac.setLayout ( new FlowLayout ( FlowLayout.LEFT ) );

                        Calendar calendar = Calendar.getInstance();
                        Date fechaInicial = calendar.getTime();
                        calendar.add(Calendar.YEAR, -100);
                        Date fechaMin = calendar.getTime();
                        calendar.add(Calendar.YEAR, 200);
                        Date fechaMax = calendar.getTime();
                        calendar.add(Calendar.YEAR, -100);

                        this.smModeloFecha = new SpinnerDateModel ( fechaInicial, fechaMin, fechaMax, 1 );
                        this.jsFecha = new JSpinner ( this.smModeloFecha );

                        JSpinner.DateEditor editor = new JSpinner.DateEditor(this.jsFecha, "yyyy/MM/dd");
                        this.jsFecha.setEditor(editor);

                            panelFechaNac.add ( labelFechaNac );
                            panelFechaNac.add ( this.jsFecha );
                    panelNac.add ( panelFechaNac, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.HORIZONTAL, 0, 0, 2, 1, 1.0, ( 1.0 / panelNacFilas ), margenlabelsNacimiento ) );
                    /*----------  End of FechaNac  ----------*/

                    /*----------  LugarNacimiento  ----------*/
                    JLabel labelLugarNacimiento = new JLabel ( "Lugar de Nac: " );
                    this.jtfLugarNacimiento = new JTextField ( 20 );

                    this.jtfLugarNacimiento.addFocusListener ( new SoloLetras() );

                    panelNac.add ( labelLugarNacimiento, this.ConstraintsGridBag ( GridBagConstraints.NORTHWEST , GridBagConstraints.HORIZONTAL, 0, 1, 1, 1, 0.1, ( 1.0 / panelNacFilas ), margenlabelsNacimiento ) );
                    panelNac.add ( this.jtfLugarNacimiento, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.HORIZONTAL, 1, 1, 1, 1, 0.9, ( 1.0 / panelNacFilas ), null )  );
                    /*----------  End of LugarNacimiento  ----------*/

                    /*----------  Nacionalidad  ----------*/
                    JLabel labelNacionalidad = new JLabel ( "Nacionalidad: " );
                    this.jtfNacionalidad = new JTextField ( 20 );

                    this.jtfNacionalidad.addFocusListener ( new SoloLetras() );

                    panelNac.add ( labelNacionalidad, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.NONE, 0, 2, 1, 1, 0.1, ( 1.0 / panelNacFilas ), margenlabelsNacimiento )  );
                    panelNac.add ( this.jtfNacionalidad, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.HORIZONTAL, 1, 2, 1, 1, 0.9, ( 1.0 / panelNacFilas ), null )  );
                    /*----------  End of Nacionalidad  ----------*/
            /*=====  End of Panel Nacimiento  ======*/

            contenedorDocumento.add ( panelNac, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.HORIZONTAL, 1, 1, 1, 1, 0.5, PesoFilasPaneles, null ) );
        }
        
        /**
         * Crea el panel correspondiente a los datos de Domicilio del Alumno.
         * @param contenedorDocumento panel principal de la ventana
         * @param PesoFilasPaneles Weight GridBagConstraints
         */
        private void ColumnaDomic ( JPanel contenedorDocumento, double PesoFilasPaneles )
        {
            /*=======================================
            =            Panel Domicilio            =
            =======================================*/
            JPanel panelDomic = new JPanel ();
            double panelDomicFilas = 3.0;
                panelDomic.setLayout ( new GridBagLayout () );

                    /*----------  Domicilio  ----------*/
                    JLabel labelCalleDomicilio = new JLabel ( "Calle - Domicilio:" );
                    this.jtfDomicilioCalle = new JTextField ( 20 );

                    this.jtfDomicilioCalle.addFocusListener(new SoloLetras());

                    panelDomic.add ( labelCalleDomicilio, this.ConstraintsGridBag ( GridBagConstraints.NORTHWEST , GridBagConstraints.NONE, 0, 0, 1, 1, 0.05, ( 1.0 / panelDomicFilas ), null ) );
                    panelDomic.add ( this.jtfDomicilioCalle, this.ConstraintsGridBag ( GridBagConstraints.NORTHWEST , GridBagConstraints.HORIZONTAL, 1, 0, 3, 1, 0.95, ( 1.0 / panelDomicFilas ), null ) );
                    /*----------  End of Domicilio  ----------*/

                    /*----------  Número  ----------*/
                    JLabel labelNro = new JLabel ( "N°: " );
                    this.jtfNro = new JTextField ( 4 );

                    this.jtfNro.addFocusListener (  new SoloNumeros()  );

                    panelDomic.add ( labelNro, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.NONE, 0, 1, 1, 1, 0.25, ( 1.0 / panelDomicFilas ), null ) );
                    panelDomic.add ( this.jtfNro, this.ConstraintsGridBag ( GridBagConstraints.NORTHWEST , GridBagConstraints.HORIZONTAL, 1, 1, 1, 1, 0.25, ( 1.0 / panelDomicFilas ), null ) );
                    /*----------  End of Número  ----------*/

                    /*----------  Piso  ----------*/
                    JLabel labelPiso = new JLabel ( " Piso: " );
                    this.jtfPiso = new JTextField ( 10 );

                    this.jtfPiso.addFocusListener (  new SoloNumeros()  );

                    panelDomic.add ( labelPiso, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.NONE, 2, 1, 1, 1, 0.25, ( 1.0 / panelDomicFilas ), null ) );
                    panelDomic.add ( this.jtfPiso, this.ConstraintsGridBag ( GridBagConstraints.NORTHWEST , GridBagConstraints.HORIZONTAL, 3, 1, 1, 1, 0.25, ( 1.0 / panelDomicFilas ), null ) );
                    /*----------  End of Piso  ----------*/

                    /*----------  Torre  ----------*/
                    JLabel labelTorre = new JLabel ( "Torre: " );
                    this.jtfTorre = new JTextField ( 10 );

                    this.jtfTorre.addFocusListener (  new SoloNumeros()  );

                    panelDomic.add ( labelTorre, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.NONE, 0, 2, 1, 1, 0.25, ( 1.0 / panelDomicFilas ), null ) );
                    panelDomic.add ( this.jtfTorre, this.ConstraintsGridBag ( GridBagConstraints.NORTHWEST , GridBagConstraints.HORIZONTAL, 1, 2, 1, 1, 0.25, ( 1.0 / panelDomicFilas ), null ) );
                    /*----------  End of Torre  ----------*/

                    /*----------  Dpto  ----------*/
                    JLabel labelDpto = new JLabel ( " Dpto: " );
                    this.jtfDpto = new JTextField ( 10 );

                    this.jtfDpto.addFocusListener (  new SoloNumeros()  );

                    panelDomic.add ( labelDpto, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.NONE, 2, 2, 1, 1, 0.25, ( 1.0 / panelDomicFilas ), null ) );
                    panelDomic.add ( this.jtfDpto, this.ConstraintsGridBag ( GridBagConstraints.NORTHWEST , GridBagConstraints.HORIZONTAL, 3, 2, 1, 1, 0.25, ( 1.0 / panelDomicFilas ), null ) );
                    /*----------  End of Dpto  ----------*/
            /*=====  End of Panel Domicilio  ======*/
            contenedorDocumento.add ( panelDomic, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.HORIZONTAL, 0, 2, 1, 1, 0.5, PesoFilasPaneles, null ) );
        }
        
        /**
         * Crea el panel correspondiente a los datos de Localidad y Contacto del Alumno
         * @param contenedorDocumento panel principal de la ventana
         * @param PesoFilasPaneles Weight GridBagConstraints
         */
        private void ColumnaLocalidadContacto ( JPanel contenedorDocumento, double PesoFilasPaneles )
        {
            /*================================================
            =            Panel Localidad/Contacto            =
            ================================================*/
            JPanel panelLocalidadContacto = new JPanel ();
            double panelLocalidadContactoFilas = 4.0;
                panelLocalidadContacto.setLayout( new GridBagLayout () );

                    /*----------  Localidad  ----------*/
                    JLabel labelLocalidad = new JLabel ( "Localidad: " );
                    this.jtfLocalidad = new JTextField ( 20 );

                    this.jtfLocalidad.addFocusListener ( new SoloLetras() );

                    panelLocalidadContacto.add ( labelLocalidad, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.HORIZONTAL, 0, 0, 1, 1, 0.1, ( 1.0 / panelLocalidadContactoFilas ), null ) );
                    panelLocalidadContacto.add ( this.jtfLocalidad, this.ConstraintsGridBag ( GridBagConstraints.NORTHWEST , GridBagConstraints.HORIZONTAL, 1, 0, 3, 1, 0.9, ( 1.0 / panelLocalidadContactoFilas ), null ) );
                    /*----------  End of Localidad  ----------*/

                    /*----------  Teléfono  ----------*/
                    JLabel labelTelefono = new JLabel ( "Teléfono: " );
                    this.jtfTelefono = new JTextField ( 12 );

                    this.jtfTelefono.addFocusListener ( new SoloTelefono() );

                    panelLocalidadContacto.add ( labelTelefono, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.HORIZONTAL, 0, 1, 1, 1, 0.07, ( 1.0 / panelLocalidadContactoFilas ), null ) );
                    panelLocalidadContacto.add ( this.jtfTelefono, this.ConstraintsGridBag ( GridBagConstraints.NORTHWEST , GridBagConstraints.HORIZONTAL, 1, 1, 1, 1, 0.63, ( 1.0 / panelLocalidadContactoFilas ), null ) );
                    /*----------  End of Código Teléfono  ----------*/
                    /*----------  Código Postal  ----------*/
                    JLabel labelCodPostal = new JLabel ( "Código Postal: " );
                    Insets margenlabelCodPostal = new Insets ( 0, 10, 0, 0 );
                    this.jtfCodPostal = new JTextField ( 4 );

                    this.jtfCodPostal.addFocusListener ( new SoloNumeros() );

                    panelLocalidadContacto.add ( labelCodPostal, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.HORIZONTAL, 2, 1, 1, 1, 0.03, ( 1.0 / panelLocalidadContactoFilas ), margenlabelCodPostal ) );
                    panelLocalidadContacto.add ( this.jtfCodPostal, this.ConstraintsGridBag ( GridBagConstraints.NORTHWEST , GridBagConstraints.HORIZONTAL, 3, 1, 1, 1, 0.27, ( 1.0 / panelLocalidadContactoFilas ), null ) );
                    /*----------  End of Código Postal  ----------*/

                    /*----------  Email  ----------*/
                    JLabel labelEmail = new JLabel ( "E-mail: " );
                    this.jtfEmail = new JTextField ( 20 );

                    this.jtfEmail.addFocusListener( new SoloEmail() );

                    panelLocalidadContacto.add ( labelEmail, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.HORIZONTAL, 0, 2, 1, 1, 0.1, ( 1.0 / panelLocalidadContactoFilas ), null ) );
                    panelLocalidadContacto.add ( this.jtfEmail, this.ConstraintsGridBag ( GridBagConstraints.NORTHWEST , GridBagConstraints.HORIZONTAL, 1, 2, 3, 1, 0.9, ( 1.0 / panelLocalidadContactoFilas ), null ) );
                    /*----------  End of Email  ----------*/
            /*=====  End of Panel Localidad/Contacto  ======*/

            contenedorDocumento.add ( panelLocalidadContacto, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.HORIZONTAL, 1, 2, 1, 1, 0.5, PesoFilasPaneles, null ) );
        }
        
        /**
         * Crea el panel correspondiente a los datos de Nivel de Instrucción del Alumno
         * @param contenedorDocumento panel principal de la ventana
         * @param PesoFilasPaneles Weight GridBagConstraints
         */
        private void filaNivelInstruccion ( JPanel contenedorDocumento, double PesoFilasPaneles )
        {
            /*=========================================
            =            Nivel Instruccion            =
            =========================================*/
            JPanel panelNivelInstruccion = new JPanel ();
                panelNivelInstruccion.setLayout ( new GridBagLayout () );

                /*----------  Grupo Botones Niveles  ----------*/
                this.bgNivelInstruccion = new ButtonGroup ();
                        this.jrbNinguno = new JRadioButton ( "Ninguno" );
                            this.jrbNinguno.setActionCommand ( "Ninguno" );
                        this.bgNivelInstruccion.add ( this.jrbNinguno ); 
                        this.jrbPrimario = new JRadioButton ( "Primario" );
                            this.jrbPrimario.setActionCommand ( "Primario" );
                        this.bgNivelInstruccion.add ( this.jrbPrimario );
                        this.jrbSecundario = new JRadioButton ( "Secundario" );
                            this.jrbSecundario.setActionCommand( "Secundario" );
                        this.bgNivelInstruccion.add ( this.jrbSecundario );
                        this.jrbTerciario = new JRadioButton ( "Terciario" );
                            this.jrbTerciario.setActionCommand( "Terciario" );
                        this.bgNivelInstruccion.add ( this.jrbTerciario );
                        this.jrbUniversitario = new JRadioButton ( "Universitario" );
                            this.jrbUniversitario.setActionCommand ( "Universitario" );
                        this.bgNivelInstruccion.add ( this.jrbUniversitario );
                        this.jrbPosgrado = new JRadioButton ( "Posgrado" );
                            this.jrbPosgrado.setActionCommand("Posgrado");
                        this.bgNivelInstruccion.add ( this.jrbPosgrado );
                /*----------  End of Grupo Botones Niveles  ----------*/   
                /*----------  Panel NivelInstruccionBotones  ----------*/
                JPanel panelNivelInstruccionBotones = new JPanel ();
                    panelNivelInstruccionBotones.setBorder ( BorderFactory.createTitledBorder ( "Nivel Instrucción" ) );
                    panelNivelInstruccionBotones.setLayout ( new FlowLayout ( FlowLayout.LEFT ) );
                        panelNivelInstruccionBotones.add ( this.jrbNinguno );
                        panelNivelInstruccionBotones.add ( this.jrbPrimario );
                        panelNivelInstruccionBotones.add ( this.jrbSecundario );
                        panelNivelInstruccionBotones.add ( this.jrbTerciario );
                        panelNivelInstruccionBotones.add ( this.jrbUniversitario );
                        panelNivelInstruccionBotones.add ( this.jrbPosgrado );
                /*----------  End of Panel NivelInstruccionBotones  ----------*/

                panelNivelInstruccion.add ( panelNivelInstruccionBotones, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.BOTH, 0, 0, 1, 1, 0.5, 1.0, null ) );

                /*----------  Panel NivelCompleto  ----------*/
                this.bgHasta = new ButtonGroup ();
                    this.jrbCompleto = new JRadioButton ( "Completo" );
                        this.jrbCompleto.setActionCommand( "Completo" );
                    this.bgHasta.add ( this.jrbCompleto );
                    this.jrbIncompleto = new JRadioButton ( "Incompleto" );
                        this.jrbIncompleto.setActionCommand ( "Incompleto" );
                    this.bgHasta.add ( this.jrbIncompleto );
                    this.jrbHastaAnio = new JRadioButton ( "Hasta Año" );
                        this.jrbHastaAnio.setActionCommand("Hasta Año");
                    this.bgHasta.add ( this.jrbHastaAnio );
                /*----------  End of Panel NivelCompleto  ----------*/
                /*----------  Panel HastaAnio  ----------*/
                JPanel panelHastaAnio = new JPanel ();
                    panelHastaAnio.setLayout ( new FlowLayout ( FlowLayout.LEFT ) );
                        JLabel labelAnioCompleto = new JLabel ( "Hasta Año/Grado: " );    
                        panelHastaAnio.add ( labelAnioCompleto );
                        this.jtfAnioCompleto = new JTextField ( 5 );

                        this.jtfAnioCompleto.addFocusListener ( new SoloNumeros () );

                        panelHastaAnio.add ( this.jtfAnioCompleto );
                /*----------  End of Panel HastaAnio  ----------*/
                /*----------  Panel NivelCompleto  ----------*/
                JPanel panelNivelCompleto = new JPanel ();
                    panelNivelCompleto.setBorder ( BorderFactory.createTitledBorder ( "Completos" ) );
                    panelNivelCompleto.setLayout ( new FlowLayout ( FlowLayout.LEFT ) );
                        panelNivelCompleto.add ( this.jrbCompleto );
                        panelNivelCompleto.add ( this.jrbIncompleto );
                        panelNivelCompleto.add ( this.jrbHastaAnio );
                        panelNivelCompleto.add ( panelHastaAnio );
                /*----------  End of Panel NivelCompleto  ----------*/

                panelNivelInstruccion.add ( panelNivelCompleto, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.BOTH, 1, 0, 1, 1, 0.5, 1.0, null ) );
            /*=====  End of Nivel Instruccion  ======*/

            contenedorDocumento.add ( panelNivelInstruccion, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.BOTH, 0, 3, 2, 1, 1.0, PesoFilasPaneles, null ) );

        }
        
        /**
         * Crea el panel correspondiente al boton de Confirmación de los datos
         * @param contenedorDocumento panel principal de la ventana
         */
        private void botonAceptar (JPanel contenedorDocumento)
        {
             /*=====================================
            =            Boton Aceptar            =
            =====================================*/
            this.jbAceptar = new JButton ();
            
            switch ( this.tipo )
            {
                
                case Crear:
                {
                    this.jbAceptar.setText("Ingresar a Base De Datos");
                    break;
                }
                
                default:
                {
                    this.jbAceptar.setText("Modificar en Base de Datos");
                }
                
            }
            /*=====  End of Boton Aceptar  ======*/

            contenedorDocumento.add ( this.jbAceptar, this.ConstraintsGridBag ( GridBagConstraints.CENTER, GridBagConstraints.NONE, 0, 4, 2, 1, 1.0, 0.1, null ) );
            contenedorDocumento.add ( new JPanel (), this.ConstraintsGridBag ( GridBagConstraints.CENTER, GridBagConstraints.NONE, 0, 5, 2, 1, 1.0, 0.5, null ) );
        }
        
        /**
         * Función para establecer ctes de un componente con GridBagLayout
         * @param Posicionrelativa
         * @param Rellenar
         * @param X
         * @param Y
         * @param Ancho
         * @param Alto
         * @param WeightX
         * @param WeightY
         * @param margen
         * @return 
         */
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
        
        public ModeloVentanaAlumno Mostrar ()
        {
            this.setVisible ( true );

            return this;
        }
        
        protected boolean chequeoInformacion ()
        {
            
            boolean ret = false;
            
            try
            {

                String TipoDocumento = (String)this.jcbTipoDoc.getSelectedItem();
                String EstadoDocumento = this.bgEstadoDoc.getSelection().getActionCommand();
                String Sexo = (String)this.jcbSexo.getSelectedItem();
                String NivelInstruccion = this.bgNivelInstruccion.getSelection().getActionCommand();
                String Completo = this.bgHasta.getSelection().getActionCommand();
                String HastaAnio = this.jtfAnioCompleto.getText();

                List<JTextField> listaTextFields = new ArrayList();
                    listaTextFields.add (this.jtfNroDoc);
                    listaTextFields.add (this.jtfApellido);
                    listaTextFields.add (this.jtfNombre);
                    listaTextFields.add (this.jtfLugarNacimiento);
                    listaTextFields.add (this.jtfNacionalidad);
                    listaTextFields.add (this.jtfDomicilioCalle);
                    listaTextFields.add (this.jtfNro);
                    listaTextFields.add (this.jtfPiso);
                    listaTextFields.add (this.jtfDpto);
                    listaTextFields.add (this.jtfLocalidad);
                    listaTextFields.add (this.jtfTelefono);
                    listaTextFields.add (this.jtfCodPostal);
                    listaTextFields.add (this.jtfEmail);

                if ( !Completo.equals("Hasta Año") || Completo.equals("Hasta Año") && (!HastaAnio.isBlank() || !HastaAnio.isEmpty()) )
                {

                    for ( JTextField jtf : listaTextFields )
                    {

                        if ( jtf.getText().isBlank() || jtf.getText().isEmpty() )
                        {
                            JOptionPane.showMessageDialog(this, "Error, falta información.", "ERROR", JOptionPane.ERROR_MESSAGE);
                            return false;
                        }
                        else if (jtf.getForeground() == Color.RED)
                        {
                            JOptionPane.showMessageDialog(this, "Error, hay información incorrecta.", "ERROR", JOptionPane.ERROR_MESSAGE);
                            return false;
                        }

                    }

                    ret = true;

                }

                return ret;

            }
            catch ( NullPointerException ex )
            {

                JOptionPane.showMessageDialog(this, "No ha seleccionado una opción de cada uno de los botones de opciones.", "ERROR", JOptionPane.ERROR_MESSAGE);
                //System.out.println ( ex.getCause().toString() );
                return false;

            }
        }
        
}
