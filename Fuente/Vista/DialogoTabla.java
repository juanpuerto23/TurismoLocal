import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.util.Date;
import java.awt.Color;
import java.awt.Component;

public class DialogoTabla extends JDialog
{
    private Object[] nombreColumnas = {"Sitio", "Cantidad gente", "Tipo evento", "Fecha", "Comando"};
    private DefaultTableModel modeloOriginalTabla = new DefaultTableModel(nombreColumnas, 0) {
        @Override
        public boolean isCellEditable(int row, int col) {
            return col == 4; // solo la columna "Comando" es editable
        }
    };

    public DialogoTabla() {
        setLayout(null);

        // Agregar 30 filas a la tabla
        for (int i = 0; i < 30; i++) {
            Object[] fila = {"Sitio " + i, i * 10, "Evento " + i, new Date(), "Asistir"};
            modeloOriginalTabla.addRow(fila);
        }

        JTable tTablaEstudiantes = new JTable(modeloOriginalTabla);
        tTablaEstudiantes.getTableHeader().setReorderingAllowed(false);
        tTablaEstudiantes.getTableHeader().setResizingAllowed(false);

        // Agregar un botón "Asistir" en la columna "Comando"
        tTablaEstudiantes.getColumn("Comando").setCellRenderer(new ButtonRenderer());
        tTablaEstudiantes.getColumn("Comando").setCellEditor(new ButtonEditor(new JCheckBox()));

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
    class ButtonRenderer extends JButton implements TableCellRenderer 
    {
        public ButtonRenderer() 
        {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,int row, int column) 
        {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    // Clase para editar un botón en la columna "Comando"
    class ButtonEditor extends DefaultCellEditor {
        protected JButton button;

        private String label;

        private boolean isPushed;

        public ButtonEditor(JCheckBox checkBox) 
        {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(e -> fireEditingStopped());
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) 
        {
            if (isSelected) {
                button.setForeground(table.getSelectionForeground());
                button.setBackground(table.getSelectionBackground());
            } else {
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
            if (isPushed) {
                // Aquí puedes implementar la acción que desees cuando se presiona el botón
                JOptionPane.showMessageDialog(button, label + " en la fila " + modeloOriginalTabla.getRowCount() + " ha sido asistido.");
            }
            isPushed = false;
            return label;
        }
    }
}


