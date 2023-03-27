package Vista;

import java.awt.Color;
import javax.swing.*;
import javax.swing.border.TitledBorder;


public class PanelEntradaDatos extends JPanel 
{
    private JLabel lbImagen;
    private ImageIcon iImagen;
    private JLabel lbPresupuesto;
    private JTextField tfPresupuesto;
    private JLabel lbGusto;
    private JTextField tfGusto;
    private JLabel lbFechaEntrada;
    private JTextField tfFechaEntrada;
    private JLabel lbFechaSalida;
    private JTextField tfFechaSalida;
    
    public PanelEntradaDatos() 
    {
        setLayout(null);
        setBackground(Color.decode("#11d445"));

        iImagen = new ImageIcon(getClass().getResource("/Imagenes/Logo.png"));
        lbImagen = new JLabel(iImagen);
        lbImagen.setBounds(5, 20, 200, 200);
        add(lbImagen);

        lbPresupuesto = new JLabel("Cual es tu presupuesto?");
        lbPresupuesto.setBounds(210, -40, 220, 150);
        add(lbPresupuesto);
        tfPresupuesto = new JTextField("0");
        tfPresupuesto.setBounds(355, 15, 100, 40);
        add(tfPresupuesto);

        lbGusto = new JLabel("Dime un gusto tuyo");
        lbGusto.setBounds(210, 10, 220, 150);
        add(lbGusto);
        tfGusto = new JTextField("Farrear");
        tfGusto.setBounds(355, 65, 100, 40);
        add(tfGusto);

        lbFechaEntrada = new JLabel("Cuando llegaste? ");
        lbFechaEntrada.setBounds(210, 60, 220, 150);
        add(lbFechaEntrada);
        tfFechaEntrada = new JTextField("01/01/2023");
        tfFechaEntrada.setBounds(355, 115, 100, 40);
        add(tfFechaEntrada);

        lbFechaSalida = new JLabel("Cuando te vas? ");
        lbFechaSalida.setBounds(210, 110, 220, 150);
        add(lbFechaSalida);
        tfFechaSalida = new JTextField("01/11/2023");
        tfFechaSalida.setBounds(355, 165, 100, 40);
        add(tfFechaSalida);

        TitledBorder borde = BorderFactory.createTitledBorder("Datos cliente");
        borde.setTitleColor(Color.WHITE);
        setBorder(borde);
    }

    public String getGusto() 
    {
        return tfGusto.getText();
    }

    public String getFechaSalida()
    {
        return tfFechaSalida.getText();
    }

    public String getFechaEntrada()
    {
        return tfFechaEntrada.getText();
    }

    public String getPresupuesto()
    {
        return tfPresupuesto.getText();
    }

    public void borrar()
    {
        tfFechaEntrada.setText("");
        tfFechaSalida.setText("");
        tfPresupuesto.setText("");
        tfGusto.setText("");
    }
}
