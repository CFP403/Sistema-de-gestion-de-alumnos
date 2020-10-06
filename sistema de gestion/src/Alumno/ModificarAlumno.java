
package Alumno;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
public final class ModificarAlumno extends JInternalFrame
{

    private final GridBagLayout layout = new GridBagLayout ();

    private JPanel jpDatosAlumno;
        //Documento:
            private JComboBox jcbTipoDoc;
            private JComboBox jcbNroDoc;
            private ButtonGroup bgEstadoDoc;
                private JRadioButton jrbBueno;
                private JRadioButton jrbMalo;
                private JRadioButton jrbEnTramite;
                private JRadioButton jrbNoPosee;
        //Nombre y Sexo:
            private JTextField jtfApellido;
            private JTextField jtfNombre;
            private JComboBox jcbSexo;
        //Nacimiento:
            private SpinnerModel smModeloFecha;
            private JSpinner jsFecha;
            private JTextField jtfLugarNacimiento;
            private JTextField jtfNacionalidad;
        //Domicilio:
            private JTextField jtfDomicilioCalle;
            private JTextField jtfNro;
            private JTextField jtfPiso;
            private JTextField jtfTorre;
            private JTextField jtfDpto;
            private JTextField jtfLocalidad;
            private JTextField jtfCodPostal;
            private JTextField jtfTelefono;
            private JTextField jtfEmail;
        //Nivel Instrucción:
            private ButtonGroup bgNivelInstruccion;
                private JRadioButton jrbNinguno;
                private JRadioButton jrbPrimario;
                private JRadioButton jrbSecundario;
                private JRadioButton jrbTerciario;
                private JRadioButton jrbUniversitario;
                private JRadioButton jrbPosgrado;
                    private ButtonGroup bgHasta;
                        private JRadioButton jrbCompleto;
                        private JRadioButton jrbIncompleto;
                        private JRadioButton jrbHastaAnio;
                            private JTextField jtfAnioCompleto;
        //Boton Aceptar
        private JButton jbAceptar;

    public ModificarAlumno ()
    {

        super ( "Modificar Alumno" );

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

    private void agregarComponentes (  )
    {

        this.jpDatosAlumno = new JPanel ();
            this.jpDatosAlumno.setBorder ( BorderFactory.createTitledBorder ( "Ingreso Alumnos" ) );
            this.agregarDocumento ( this.jpDatosAlumno );
            this.add ( this.jpDatosAlumno, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST, GridBagConstraints.BOTH, 0, 0, 1, 1, 1, 1, null ) );

            
    }
    
    private boolean ingresosCorrectos ()
    {
        
        try
        {
            
            String TipoDocumento = (String)this.jcbTipoDoc.getSelectedItem();
            String EstadoDocumento = this.bgEstadoDoc.getSelection().getActionCommand();
            String Sexo = (String)this.jcbSexo.getSelectedItem();
            String NivelInstruccion = this.bgNivelInstruccion.getSelection().getActionCommand();
            String Completo = this.bgHasta.getSelection().getActionCommand();
            String HastaAnio = this.jtfAnioCompleto.getText();

            List<JTextField> listaTextFields = new ArrayList();
                //listaTextFields.add (this.jtfNroDoc);
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
                
                return true;
                
            }
            
            return false;
                
        }
        catch ( NullPointerException ex )
        {

            JOptionPane.showMessageDialog(this, "No ha seleccionado una opción de cada uno de los botones de opciones.", "ERROR", JOptionPane.ERROR_MESSAGE);
            //System.out.println ( ex.getCause().getClass().componentType() );
            return false;
            
        }
        
    }
    
    private void agregarDocumento ( JPanel contenedorDocumento )
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

            /*----------  Panel NroDoc  ----------*/
            JPanel panelnroDoc = new JPanel ();
                JLabel labelNroDoc = new JLabel ( "Nro Doc: " );
                this.jcbNroDoc = new JComboBox ();
                
                //this.jtfNroDoc.addFocusListener( this.Solonumeros );
                
                panelnroDoc.add ( labelNroDoc );
                panelnroDoc.add ( this.jcbNroDoc );

                    panelTipoDocumentos.add ( panelnroDoc );
            /*----------  Fin Panel NroDoc  ----------*/
        /*=====  End of Panel TipoDocumentos  ======*/
        
        contenedorDocumento.add ( panelTipoDocumentos, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST, GridBagConstraints.BOTH, 0, 0, 1, 1, 0.5, PesoFilasPaneles, null ) );
    }
    
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
                
                this.jtfApellido.addFocusListener ( this.SoloLetras );
                
                panelInfoPers.add ( labelApellidos, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.HORIZONTAL, 0, 0, 1, 1, 0.1, ( 1.0 / panelInfoFilas ), null ) );
                panelInfoPers.add ( this.jtfApellido, this.ConstraintsGridBag ( GridBagConstraints.NORTHWEST , GridBagConstraints.HORIZONTAL, 1, 0, 1, 1, 0.9, ( 1.0 / panelInfoFilas ), null ) );
                /*----------  End of Apellido/s  ----------*/

                /*----------  Nombre/s  ----------*/
                JLabel labelNombres = new JLabel ( "Nombre/s:" );
                this.jtfNombre = new JTextField ( 15 );
                
                this.jtfNombre.addFocusListener ( this.SoloLetras );
                
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
                
                this.jtfLugarNacimiento.addFocusListener ( this.SoloLetras );
                
                panelNac.add ( labelLugarNacimiento, this.ConstraintsGridBag ( GridBagConstraints.NORTHWEST , GridBagConstraints.HORIZONTAL, 0, 1, 1, 1, 0.1, ( 1.0 / panelNacFilas ), margenlabelsNacimiento ) );
                panelNac.add ( this.jtfLugarNacimiento, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.HORIZONTAL, 1, 1, 1, 1, 0.9, ( 1.0 / panelNacFilas ), null )  );
                /*----------  End of LugarNacimiento  ----------*/

                /*----------  Nacionalidad  ----------*/
                JLabel labelNacionalidad = new JLabel ( "Nacionalidad: " );
                this.jtfNacionalidad = new JTextField ( 20 );
                
                this.jtfNacionalidad.addFocusListener ( this.SoloLetras );
                
                panelNac.add ( labelNacionalidad, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.NONE, 0, 2, 1, 1, 0.1, ( 1.0 / panelNacFilas ), margenlabelsNacimiento )  );
                panelNac.add ( this.jtfNacionalidad, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.HORIZONTAL, 1, 2, 1, 1, 0.9, ( 1.0 / panelNacFilas ), null )  );
                /*----------  End of Nacionalidad  ----------*/
        /*=====  End of Panel Nacimiento  ======*/

        contenedorDocumento.add ( panelNac, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.HORIZONTAL, 1, 1, 1, 1, 0.5, PesoFilasPaneles, null ) );

    }
    
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
                
                this.jtfDomicilioCalle.addFocusListener(this.SoloLetras);
                
                panelDomic.add ( labelCalleDomicilio, this.ConstraintsGridBag ( GridBagConstraints.NORTHWEST , GridBagConstraints.NONE, 0, 0, 1, 1, 0.05, ( 1.0 / panelDomicFilas ), null ) );
                panelDomic.add ( this.jtfDomicilioCalle, this.ConstraintsGridBag ( GridBagConstraints.NORTHWEST , GridBagConstraints.HORIZONTAL, 1, 0, 3, 1, 0.95, ( 1.0 / panelDomicFilas ), null ) );
                /*----------  End of Domicilio  ----------*/

                /*----------  Número  ----------*/
                JLabel labelNro = new JLabel ( "N°: " );
                this.jtfNro = new JTextField ( 4 );
                
                this.jtfNro.addFocusListener ( this.Solonumeros );
                
                panelDomic.add ( labelNro, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.NONE, 0, 1, 1, 1, 0.25, ( 1.0 / panelDomicFilas ), null ) );
                panelDomic.add ( this.jtfNro, this.ConstraintsGridBag ( GridBagConstraints.NORTHWEST , GridBagConstraints.HORIZONTAL, 1, 1, 1, 1, 0.25, ( 1.0 / panelDomicFilas ), null ) );
                /*----------  End of Número  ----------*/

                /*----------  Piso  ----------*/
                JLabel labelPiso = new JLabel ( " Piso: " );
                this.jtfPiso = new JTextField ( 10 );
                
                this.jtfPiso.addFocusListener ( this.Solonumeros );
                
                panelDomic.add ( labelPiso, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.NONE, 2, 1, 1, 1, 0.25, ( 1.0 / panelDomicFilas ), null ) );
                panelDomic.add ( this.jtfPiso, this.ConstraintsGridBag ( GridBagConstraints.NORTHWEST , GridBagConstraints.HORIZONTAL, 3, 1, 1, 1, 0.25, ( 1.0 / panelDomicFilas ), null ) );
                /*----------  End of Piso  ----------*/

                /*----------  Torre  ----------*/
                JLabel labelTorre = new JLabel ( "Torre: " );
                this.jtfTorre = new JTextField ( 10 );
                
                this.jtfTorre.addFocusListener ( this.Solonumeros );
                
                panelDomic.add ( labelTorre, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.NONE, 0, 2, 1, 1, 0.25, ( 1.0 / panelDomicFilas ), null ) );
                panelDomic.add ( this.jtfTorre, this.ConstraintsGridBag ( GridBagConstraints.NORTHWEST , GridBagConstraints.HORIZONTAL, 1, 2, 1, 1, 0.25, ( 1.0 / panelDomicFilas ), null ) );
                /*----------  End of Torre  ----------*/

                /*----------  Dpto  ----------*/
                JLabel labelDpto = new JLabel ( " Dpto: " );
                this.jtfDpto = new JTextField ( 10 );
                
                this.jtfDpto.addFocusListener ( this.Solonumeros );
                
                panelDomic.add ( labelDpto, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.NONE, 2, 2, 1, 1, 0.25, ( 1.0 / panelDomicFilas ), null ) );
                panelDomic.add ( this.jtfDpto, this.ConstraintsGridBag ( GridBagConstraints.NORTHWEST , GridBagConstraints.HORIZONTAL, 3, 2, 1, 1, 0.25, ( 1.0 / panelDomicFilas ), null ) );
                /*----------  End of Dpto  ----------*/
        /*=====  End of Panel Domicilio  ======*/
        contenedorDocumento.add ( panelDomic, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.HORIZONTAL, 0, 2, 1, 1, 0.5, PesoFilasPaneles, null ) );
    }
    
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
                
                this.jtfLocalidad.addFocusListener ( this.SoloLetras );
                
                panelLocalidadContacto.add ( labelLocalidad, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.HORIZONTAL, 0, 0, 1, 1, 0.1, ( 1.0 / panelLocalidadContactoFilas ), null ) );
                panelLocalidadContacto.add ( this.jtfLocalidad, this.ConstraintsGridBag ( GridBagConstraints.NORTHWEST , GridBagConstraints.HORIZONTAL, 1, 0, 3, 1, 0.9, ( 1.0 / panelLocalidadContactoFilas ), null ) );
                /*----------  End of Localidad  ----------*/

                /*----------  Teléfono  ----------*/
                JLabel labelTelefono = new JLabel ( "Teléfono: " );
                this.jtfTelefono = new JTextField ( 12 );
                
                this.jtfTelefono.addFocusListener ( this.telefono );
                
                panelLocalidadContacto.add ( labelTelefono, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.HORIZONTAL, 0, 1, 1, 1, 0.07, ( 1.0 / panelLocalidadContactoFilas ), null ) );
                panelLocalidadContacto.add ( this.jtfTelefono, this.ConstraintsGridBag ( GridBagConstraints.NORTHWEST , GridBagConstraints.HORIZONTAL, 1, 1, 1, 1, 0.63, ( 1.0 / panelLocalidadContactoFilas ), null ) );
                /*----------  End of Código Teléfono  ----------*/
                /*----------  Código Postal  ----------*/
                JLabel labelCodPostal = new JLabel ( "Código Postal: " );
                Insets margenlabelCodPostal = new Insets ( 0, 10, 0, 0 );
                this.jtfCodPostal = new JTextField ( 4 );
                
                this.jtfCodPostal.addFocusListener (this.Solonumeros);
                
                panelLocalidadContacto.add ( labelCodPostal, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.HORIZONTAL, 2, 1, 1, 1, 0.03, ( 1.0 / panelLocalidadContactoFilas ), margenlabelCodPostal ) );
                panelLocalidadContacto.add ( this.jtfCodPostal, this.ConstraintsGridBag ( GridBagConstraints.NORTHWEST , GridBagConstraints.HORIZONTAL, 3, 1, 1, 1, 0.27, ( 1.0 / panelLocalidadContactoFilas ), null ) );
                /*----------  End of Código Postal  ----------*/

                /*----------  Email  ----------*/
                JLabel labelEmail = new JLabel ( "E-mail: " );
                this.jtfEmail = new JTextField ( 20 );
                
                this.jtfEmail.addFocusListener( this.SoloEmail );
                
                panelLocalidadContacto.add ( labelEmail, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.HORIZONTAL, 0, 2, 1, 1, 0.1, ( 1.0 / panelLocalidadContactoFilas ), null ) );
                panelLocalidadContacto.add ( this.jtfEmail, this.ConstraintsGridBag ( GridBagConstraints.NORTHWEST , GridBagConstraints.HORIZONTAL, 1, 2, 3, 1, 0.9, ( 1.0 / panelLocalidadContactoFilas ), null ) );
                /*----------  End of Email  ----------*/
        /*=====  End of Panel Localidad/Contacto  ======*/

        contenedorDocumento.add ( panelLocalidadContacto, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.HORIZONTAL, 1, 2, 1, 1, 0.5, PesoFilasPaneles, null ) );

    }
    
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
                    
                    this.jtfAnioCompleto.addFocusListener ( this.Solonumeros );
                    
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
    
    private void botonAceptar (JPanel contenedorDocumento )
    {
         /*=====================================
        =            Boton Aceptar            =
        =====================================*/
        this.jbAceptar = new JButton ( "Modificar en la Base de Datos" );
        
        this.jbAceptar.addActionListener ( (ActionEvent l) -> {
            
            if ( ModificarAlumno.this.ingresosCorrectos() )
            {
            
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(((Date)this.smModeloFecha.getValue()));

                String TipoDocumento = (String)this.jcbTipoDoc.getSelectedItem();
                String NroDocumento = "AAA";
                String EstadoDocumento = this.bgEstadoDoc.getSelection().getActionCommand();
                String Apellido = this.jtfApellido.getText();
                String Nombre = this.jtfNombre.getText();
                String Sexo = (String)this.jcbSexo.getSelectedItem();
                String FechaNacimiento = calendar.get(Calendar.DATE) + "/" + calendar.get(Calendar.MONTH) + "/" + calendar.get(Calendar.YEAR);
                String LugarNacimiento = this.jtfLugarNacimiento.getText();
                String Nacionalidad = this.jtfNacionalidad.getText();
                String CalleDomicilio = this.jtfDomicilioCalle.getText();
                String Nro = this.jtfNro.getText();
                String Piso = this.jtfPiso.getText();
                String Dpto = this.jtfDpto.getText();
                String Localidad = this.jtfLocalidad.getText();
                String NroTelefono = this.jtfTelefono.getText();
                String CodPostal = this.jtfCodPostal.getText();
                String Email = this.jtfEmail.getText();
                String NivelInstruccion = this.bgNivelInstruccion.getSelection().getActionCommand();
                String Completo = this.bgHasta.getSelection().getActionCommand();
                String HastaAnio = this.jtfAnioCompleto.getText();


                System.out.println ( "\tTipo Documento: " + TipoDocumento + "\tDocumento: " + NroDocumento + 
                        "\tEstado del documento: " + EstadoDocumento );
                System.out.println ( "\tApellido/s: " + Apellido + "\tNombre: " + Nombre + "\tSexo: " + Sexo + 
                        "\tFecha de Nacimiento: " + FechaNacimiento + "\tLugar de Nacimiento: " + LugarNacimiento + "\tNacionalidad: " + Nacionalidad );
                System.out.println ( "\tCalle-Domicilio: " + CalleDomicilio + "\tN°: " + Nro + "\tDpto: " + Dpto + "\tPiso: " + Piso + "\tLocalidad: " +
                        Localidad + "\tNro de Teléfono: " + NroTelefono + "\tCódigo Postal: " + CodPostal + "\tE-mail: " + Email );
                System.out.print ( "\tNivel de Instrucción: " + NivelInstruccion + "\t");

                if ( Completo.equals("Hasta Año") )
                    System.out.println ( "Hasta Año: " + HastaAnio );
                else
                    System.out.println ( Completo );

            }
            
        });
        
        /*=====  End of Boton Aceptar  ======*/

        contenedorDocumento.add ( this.jbAceptar, this.ConstraintsGridBag ( GridBagConstraints.CENTER, GridBagConstraints.NONE, 0, 4, 2, 1, 1.0, 0.1, null ) );
        contenedorDocumento.add ( new JPanel (), this.ConstraintsGridBag ( GridBagConstraints.CENTER, GridBagConstraints.NONE, 0, 5, 2, 1, 1.0, 0.5, null ) );
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
    
    public ModificarAlumno Mostrar ()
    {
        
        this.setVisible ( true );
        
        return this;
        
    }

    private final FocusAdapter Solonumeros = new FocusAdapter () {
      
        @Override
        public void focusLost ( FocusEvent e ) {
            
            JTextField numeros = ((JTextField) e.getSource());
            String textoNumeros = numeros.getText();
            
            if ( textoNumeros.matches ( "[0-9]+[ ]*" ) )
                numeros.setForeground(Color.BLACK);
            else
                numeros.setForeground(Color.RED);
            
            
        }
        
    };
    
    private final FocusAdapter SoloLetras = new FocusAdapter () {
        
        @Override
        public void focusLost ( FocusEvent e )
        {

            JTextField letrasTextField = ((JTextField) e.getSource());
            String letras = letrasTextField.getText();
            
            if ( letras.matches ( "[A-z\\ ]+" ) )
                letrasTextField.setForeground(Color.BLACK);
            else
                letrasTextField.setForeground(Color.RED);

        }
        
    };
    
    private final FocusAdapter SoloEmail = new FocusAdapter () {
        
        @Override
        public void focusLost ( FocusEvent e )
        {

            JTextField emailTextField = ((JTextField) e.getSource());
            String email = emailTextField.getText();
            String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w ]+";

            if ( email.matches(regex) )
                emailTextField.setForeground ( Color.BLACK );
            else
                emailTextField.setForeground ( Color.RED );

        }
        
    };
    
    private final FocusAdapter telefono = new FocusAdapter() {
                    
        @Override
        public void focusLost ( FocusEvent e ) 
        {

            JTextField telefonoTextField = ((JTextField) e.getSource());
            String telefono = telefonoTextField.getText();

            if ( telefono.matches ( "[+]?\\d*[ ]*[\\d]+[ ]*" ) )
                telefonoTextField.setForeground(Color.BLACK);
            else
                telefonoTextField.setForeground(Color.RED);

        }

    };
    
}
