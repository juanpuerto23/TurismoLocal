import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.util.Date;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogoTabla extends JDialog {
    private Object[] nombreColumnas = {"Sitio", "Cantidad gente", "Tipo evento", "Fecha", "Comando"};
    private DefaultTableModel modeloOriginalTabla = new DefaultTableModel(nombreColumnas, 0) {
        @Override
        public boolean isCellEditable(int row, int col) {
            return col == 4;
        }
    };

    public DialogoTabla() {
        setLayout(null);

        // Agregar 30 filas a la tabla
        for (int i = 0; i < 50; i++) {
            Object[] fila = {"Sitio " + i, i * 10, "Evento " + i, new Date(), "Se asistirá"};
            modeloOriginalTabla.addRow(fila);
        }

        JTable tTablaEstudiantes = new JTable(modeloOriginalTabla);
        tTablaEstudiantes.getTableHeader().setReorderingAllowed(false);
        tTablaEstudiantes.getTableHeader().setResizingAllowed(false);

        // Agregar un botón "Se asistirá" en la columna "Comando"
        tTablaEstudiantes.getColumn("Comando").setCellRenderer(new ButtonRenderer());
        tTablaEstudiantes.getColumn("Comando").setCellEditor(new ButtonEditor(new JCheckBox(), tTablaEstudiantes)); 
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

    public void cerrarDialogo() {
        this.dispose();
    }

    // Clase para renderizar un botón en la columna "Comando"
    class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    class ButtonEditor extends DefaultCellEditor 
    {
        protected JButton button;
        private String label;
        private boolean isPushed;
        private JTable table; // Variable de instancia para la tabla

        public ButtonEditor(JCheckBox checkBox, JTable table) // Pasar la tabla como parámetro al constructor
        {
            super(checkBox);
            this.table = table; // Inicializar la variable de instancia con la tabla recibida
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(e -> fireEditingStopped());
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) 
        {
            if (isSelected) 
            {
                button.setForeground(table.getSelectionForeground());
                button.setBackground(table.getSelectionBackground());
            } 
            else 
            {
                button.setForeground(table.getForeground());
                button.setBackground(table.getBackground());
            }
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        public Object getCellEditorValue() 
        {
            if (isPushed) 
            {
                int row = table.getCellEditor().getTableCellEditorComponent(table, null, true, 0, 0).getY();
                int cantidadGente = (int) modeloOriginalTabla.getValueAt(row, 1);
                modeloOriginalTabla.setValueAt(cantidadGente + 1, row, 1);
                button.setText("Se asistirá");
                isPushed = false;
            }
            return label;
        }
        

        public Object comandoAsistir() 
        {
            int cantidadTotalGente = 0;

            for (int i = 0; i < modeloOriginalTabla.getRowCount(); i++) 
            {
                // Obtener el valor de la columna "Cantidad gente" de la fila actual
                int cantidadGenteFila = (int) modeloOriginalTabla.getValueAt(i, 1);
                // Sumar el valor obtenido al total
                cantidadTotalGente += cantidadGenteFila;
            }
            if (isPushed) 
            {
                // Aquí puedes implementar la acción que desees cuando se presiona el botón
                JOptionPane.showMessageDialog(button, label + " en la fila " + (cantidadTotalGente) + " ha sido asistido.");
            }
            isPushed = false;
            return label;
        }
    }
}