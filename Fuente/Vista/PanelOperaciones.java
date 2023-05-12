
import java.awt.*;
import java.awt.event.ActionListener;

import static java.awt.Font.BOLD;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class PanelOperaciones extends JPanel 
{
    public JButton bCrear;
    public JButton bBorrar;
    
    public PanelOperaciones()
    {
        setLayout(null);
        setBackground(Color.WHITE);

        bCrear = new JButton("Crear");
        bCrear.setFont(new Font("Arial", BOLD, 12));
        bCrear.setBounds(10, 20, 90, 20);
        add(bCrear);
        bCrear.setActionCommand("crear");

        bBorrar = new JButton("Borrar");
        bBorrar.setFont(new Font("Arial", BOLD, 12));
        bBorrar.setBounds(110, 20, 90, 20);
        add(bBorrar);
        bBorrar.setActionCommand("borrar");

        TitledBorder borde = BorderFactory.createTitledBorder("Botones");
        borde.setTitleColor(Color.BLUE);
        setBorder(borde);
    }

    public void agregarOyentesBotones(ActionListener pAL)
    {
        bCrear.addActionListener(pAL);
        bBorrar.addActionListener(pAL);
    }

    public void desactivarBotonCrear()
    {
        bCrear.setEnabled(false);
    }
}
