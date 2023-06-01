import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.event.ActionListener;
import static java.awt.Font.BOLD;

public class DialogoTablaExploracion extends JDialog
{
    private String[] nombreColumnas = {"Sitio", "Direccion", "Tipo sitio", "Distancia en carro (minutos)"};
    private String[] nombreSitio = {"Centro Recreativo Olimpico's", "Balneario La Honda", "Playa Azul", "La Fortuna", "Billar El Rodeo"};
    private String[] cantidadGente = {"Km2 via Socorro-Oiba", "Villa Gomez, Palmas del Socorro", "Berlin, Socorro", "Calle 15 Manzana 62", "Km0 via San Gil-Socorro"};
    private String[] tipoEvento = {"Piscina", "Piscina", "Piscina", "Lugar exotico", "Billar"};
    private String[] fechaEvento = {"9", "19", "15", "3", "29"};
    private JTable tTablaEstudiantes;
    private JComboBox<String> cbSitioEvento;
    private JButton bRegistrarEvento;
    private DefaultTableModel modeloOriginalTabla = new DefaultTableModel(nombreColumnas, 0) 
    {
        @Override
        public boolean isCellEditable(int row, int col) 
        {
            return col == 4;
        }
    };

    public DialogoTablaExploracion() 
    {

        cbSitioEvento = new JComboBox<>(nombreSitio);
        cbSitioEvento.setSelectedIndex(0);
        cbSitioEvento.setFont(new Font("Arial", Font.PLAIN, 18));
        cbSitioEvento.setForeground(Color.BLACK);
        cbSitioEvento.setBounds(300, 520, 190, 30);
        add(cbSitioEvento);

        // Agregar 5 filas a la tabla
        for (int i = 0; i < 5; i++) 
        {
            String[] fila = {nombreSitio[i], cantidadGente[i], tipoEvento[i], fechaEvento[i]};
            modeloOriginalTabla.addRow(fila);
        }

        tTablaEstudiantes = new JTable(modeloOriginalTabla);
        tTablaEstudiantes.getTableHeader().setReorderingAllowed(false);
        tTablaEstudiantes.getTableHeader().setResizingAllowed(false);

        bRegistrarEvento = new JButton("Registrarse");
        bRegistrarEvento.setActionCommand("registrarEvento");
        bRegistrarEvento.setBackground(Color.decode("#21eb5d"));
        bRegistrarEvento.setFont(new Font("Arial", BOLD, 12));
        bRegistrarEvento.setBounds(670, 520, 140, 20);
        this.add(bRegistrarEvento);


        // Pasar la tabla como parámetro
        JScrollPane spTablaEstudiantes = new JScrollPane();
        spTablaEstudiantes.setViewportView(tTablaEstudiantes);
        spTablaEstudiantes.setBounds(10, 15, 820, 480);

        this.add(spTablaEstudiantes);

        setTitle("Registro Eventos");
        setSize(860,600);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setVisible(true);
    }

    public String[] getNombreSitio() 
    {
        return nombreSitio;
    }
    public void setNombreSitio(String[] nombreSitio) 
    {
        this.nombreSitio = nombreSitio;
    }
    public String[] getCantidadGente() 
    {
        return cantidadGente;
    }
    public void setCantidadGente(String[] cantidadGente) 
    {
        this.cantidadGente = cantidadGente;
    }
    public String[] getTipoEvento() 
    {
        return tipoEvento;
    }
    public void setTipoEvento(String[] tipoEvento) 
    {
        this.tipoEvento = tipoEvento;
    }
    public String[] getFechaEvento() 
    {
        return fechaEvento;
    }
    public void setFechaEvento(String[] fechaEvento) 
    {
        this.fechaEvento = fechaEvento;
    }

    public void cerrarDialogo() 
    {
        this.dispose();
    }

    public String getTfnombreSitio()
    {
        return cbSitioEvento.getSelectedItem().toString();
    }
    
    public void agregarOyentesBotones(ActionListener pAL)
    {
        bRegistrarEvento.addActionListener(pAL);
    }

    public void desactivarBotonCrear()
    {
        bRegistrarEvento.setEnabled(false);
    }

    public void obtenerDatos()
    {
        String sitioBuscado = getTfnombreSitio();
        int filaEncontrada = -1;

        for(int i = 0; i < modeloOriginalTabla.getRowCount(); i++)
        {
            String sitio = modeloOriginalTabla.getValueAt(i, 0).toString();
            if (sitio.equals(sitioBuscado)) 
            {
                filaEncontrada = i;
                break; // Terminar el bucle si se encuentra la fila
            }
        }

        if (filaEncontrada != -1) 
        {
            // Se encontró la fila
            String[] fila = new String[4];
            for (int j = 0; j < 4; j++) 
            {
                fila[j] = modeloOriginalTabla.getValueAt(filaEncontrada, j).toString();
            }

            JOptionPane.showMessageDialog(null,"Nombre sitio: " + fila[0] + "\nDireccion: " + fila[1] + "\nTipo sitio: " + fila[2] + "\n" + fila[3] + " minutos se demora desde Socorro", "Datos Exploracion", JOptionPane.INFORMATION_MESSAGE);
        } 
        else 
        {
            // No se encontró la fila
            System.out.println("No se encontró ninguna fila con el sitio buscado.");
        }
    }
}
