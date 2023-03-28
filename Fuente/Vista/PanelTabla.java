import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;

public class PanelTabla extends JPanel
{
    private Object[] nombreColumnas = {"Sitio", "Cantidad gente", "Tipo evento", "Fecha", "Comando"};
    public PanelTabla()
    {
        setLayout(null);
        setBackground(Color.decode("#92e310"));

        TitledBorder borde = BorderFactory.createTitledBorder("Tabla de eventos");
        borde.setTitleColor(Color.BLUE);
        setBorder(borde);

        DefaultTableModel modeloOriginalTabla = new DefaultTableModel(nombreColumnas, 0) 
        
        {
            @Override
            public boolean isCellEditable(int row, int col) {
                    return true;
            }    
                    
        };

        JTable tTablaEstudiantes = new JTable(modeloOriginalTabla);
        tTablaEstudiantes.getTableHeader().setReorderingAllowed(false);
        tTablaEstudiantes.getTableHeader().setResizingAllowed(false);

        JScrollPane spTablaEstudiantes = new JScrollPane();
        spTablaEstudiantes.setViewportView(tTablaEstudiantes);
        spTablaEstudiantes.setBounds(10, 15, 820, 480);

        this.add(spTablaEstudiantes);
    }
}
