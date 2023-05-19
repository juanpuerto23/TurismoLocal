import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.event.ActionListener;
import static java.awt.Font.BOLD;

public class DialogoTabla extends JDialog 
{
    private Object[] nombreColumnas = {"Sitio", "Cantidad gente", "Tipo evento", "Fecha", "Comando"};
    private Object[] nombreSitio = {"Bohemia Club House", "Kalema Bar", "Tercer Tiempo", "La Arenosa Disco Bar"};
    private Object[] cantidadGente = {"10", "20", "30", "40"};
    private Object[] tipoEvento = {"Restaurante Medieval", "Bar", "Bar", "Discoteca"};
    private Object[] fechaEvento = {"22/02/2024", "22/02/2024", "22/02/2024", "22/02/2024"};
    public JButton bRegistrarEvento;
    private DefaultTableModel modeloOriginalTabla = new DefaultTableModel(nombreColumnas, 0) 
    {
        @Override
        public boolean isCellEditable(int row, int col) 
        {
            return col == 4;
        }
    };

    public DialogoTabla() 
    {
        setLayout(null);

        // Agregar 5 filas a la tabla
        for (int i = 0; i < 4; i++) 
        {
            JButton bRegistrarEvento = new JButton("Registrarse");
            bRegistrarEvento.setActionCommand("registrarEvento");
            Object[] fila = {nombreSitio[i], cantidadGente[i], tipoEvento[i], fechaEvento[i], bRegistrarEvento};
            modeloOriginalTabla.addRow(fila);
        }

        JTable tTablaEstudiantes = new JTable(modeloOriginalTabla);
        tTablaEstudiantes.getTableHeader().setReorderingAllowed(false);
        tTablaEstudiantes.getTableHeader().setResizingAllowed(false);



        // Pasar la tabla como parámetro
        JScrollPane spTablaEstudiantes = new JScrollPane();
        spTablaEstudiantes.setViewportView(tTablaEstudiantes);
        spTablaEstudiantes.setBounds(10, 15, 820, 480);

        this.add(spTablaEstudiantes);

        setTitle("Registro Eventos");
        setSize(860,600);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public void cerrarDialogo() 
    {
        this.dispose();
    }

    public void agregarOyentesBotones(ActionListener pAL)
    {
        bRegistrarEvento.addActionListener(pAL);
    }

    public void desactivarBotonCrear()
    {
        bRegistrarEvento.setEnabled(false);
    }
}