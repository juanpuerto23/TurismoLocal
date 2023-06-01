
import java.awt.Color;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;

public class PanelEntradaDatos extends JPanel 
{
    private JLabel lbImagen;
    private ImageIcon iImagen;
    private JLabel lbPresupuesto;
    private JTextField tfPresupuesto;
    private JLabel lbGusto;
    private JComboBox<String> cbGusto;
    private JLabel lbnombreCliente;
    private JTextField tfnombreCliente;
    private JLabel lbFechaSalida;
    private JTextField tfFechaSalida;
    
    public PanelEntradaDatos() 
    {
        setLayout(null);
        setBackground(Color.decode("#42855B"));

        iImagen = new ImageIcon("C:/Users/57316/Desktop/Programación/Proyecto_POO/TurismoLocal/Turismo.png");
        lbImagen = new JLabel(iImagen);
        lbImagen.setBounds(10,10,200,200);
        add(lbImagen);
        
        lbPresupuesto = new JLabel("Cual es tu presupuesto?");
        lbPresupuesto.setBounds(210, 60, 220, 150);
        add(lbPresupuesto);
        tfPresupuesto = new JTextField("0");
        tfPresupuesto.setBounds(355, 115, 100, 40);
        tfPresupuesto.setBackground(Color.decode("#90B77D"));
        add(tfPresupuesto);

        String[] gustosPredeterminados = {"Farrear", "Turistear", "Comer", "Explorar"};
        lbGusto = new JLabel("Selecciona una accion");
        lbGusto.setBounds(490, -40, 220, 150);
        add(lbGusto);
        cbGusto = new JComboBox<>(gustosPredeterminados);
        cbGusto.setSelectedIndex(0);
        cbGusto.setBounds(630, 15, 100, 40);
        cbGusto.setBackground(Color.decode("#90B77D"));
        add(cbGusto);

        lbnombreCliente = new JLabel("Dime tu nombre");
        lbnombreCliente.setBounds(210, -40, 220, 150); 
        add(lbnombreCliente);
        tfnombreCliente = new JTextField("Juanito");
        tfnombreCliente.setBounds(355, 15, 100, 40); 
        tfnombreCliente.setBackground(Color.decode("#90B77D")); 
        add(tfnombreCliente);

        lbFechaSalida = new JLabel("Cuando te vas? ");
        lbFechaSalida.setBounds(490, 60, 220, 150);
        add(lbFechaSalida);
        tfFechaSalida = new JTextField("01/11/2023");
        tfFechaSalida.setBounds(630, 115, 100, 40);
        tfFechaSalida.setBackground(Color.decode("#90B77D"));
        add(tfFechaSalida);

    }

    public String getGusto() 
    {
        return cbGusto.getSelectedItem().toString();
    }

    public String getFechaSalida()
    {
        return tfFechaSalida.getText();
    }

    public String getnombreCliente()
    {
        return tfnombreCliente.getText();
    }

    public String getPresupuesto()
    {
        return tfPresupuesto.getText();
    }

    public void borrar()
    {
        tfnombreCliente.setText("");
        tfFechaSalida.setText("");
        tfPresupuesto.setText("");
    }
}
