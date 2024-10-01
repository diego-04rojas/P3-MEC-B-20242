import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.Timer;

public class SistemaDeRegistro extends JFrame {
    private JTextField txtIdentificacion;
    private JComboBox<String> cmbGrupoEtario;
    private JComboBox<String> cmbTipoServicio;
    private JLabel lblTotalPacientes;
    private JSlider sliderDuracionTurno;
    private JLabel lblDuracionSlider;
    private ArrayList<Paciente> listaPacientes;
    private int totalPacientes = 0;
    private JTable tablaPacientes;
    private DefaultTableModel modeloTabla;
    private JLabel lblPacienteActual;
    private JLabel lblSiguientePaciente;
    private Timer timer;
    private boolean modoAutomatico = false;

    public SistemaDeRegistro() {
        listaPacientes = new ArrayList<>();

        setTitle("Sistema de Registro de Pacientes");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelPrincipal = new JPanel(new GridLayout(1, 2)); 
        add(panelPrincipal, BorderLayout.CENTER);

        JPanel panelEntrada = new JPanel(new GridLayout(8, 2));
        txtIdentificacion = new JTextField();
        cmbGrupoEtario = new JComboBox<>(new String[] {"Menor de 60", "Mayor de 60", "Con Discapacidad"});
        cmbTipoServicio = new JComboBox<>(new String[] {"Consulta General", "Consulta Especializada", "Pruebas de Laboratorio", "Imágenes Diagnósticas"});
        lblTotalPacientes = new JLabel("Pacientes registrados: 0");
        lblDuracionSlider = new JLabel("Duración por turno: 10 segundos"); 
        sliderDuracionTurno = new JSlider(5, 60, 10);
        sliderDuracionTurno.setPaintTicks(true);
        sliderDuracionTurno.setPaintLabels(true);
        sliderDuracionTurno.setMajorTickSpacing(5); 

        JButton btnAgregarPaciente = new JButton("Agregar Paciente");

        txtIdentificacion.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validarIdentificacion();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validarIdentificacion();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validarIdentificacion();
            }
