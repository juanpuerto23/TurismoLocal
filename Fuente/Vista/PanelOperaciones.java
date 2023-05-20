
import java.awt.*;
import java.awt.event.ActionListener;

import static java.awt.Font.BOLD;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class PanelOperaciones extends JPanel 
{
    public JButton bCrear;
    public JButton bBorrar;
    public JButton bCerrarSesion;
    public JButton bDialogoTabla;
    
    public PanelOperaciones()
    {
        setLayout(null);
        setBackground(Color.decode("#ebd234"));

        bCrear = new JButton("Crear");
        bCrear.setFont(new Font("Arial", BOLD, 12));
        bCrear.setBounds(80, 20, 90, 20);
        bCrear.setBackground(Color.decode("#21eb5d"));
        add(bCrear);
        bCrear.setActionCommand("crear");

        bBorrar = new JButton("Borrar");
        bBorrar.setFont(new Font("Arial", BOLD, 12));
        bBorrar.setBounds(80, 100, 90, 20);
        bBorrar.setBackground(Color.decode("#eb2e21"));
        add(bBorrar);
        bBorrar.setActionCommand("borrar");

        bCerrarSesion = new JButton("Cerrar Sesion");
        bCerrarSesion.setFont(new Font("Arial", BOLD, 12));
        bCerrarSesion.setBounds(210, 100, 140, 20);
        bCerrarSesion.setBackground(Color.decode("#eb2e21"));
        add(bCerrarSesion);
        bCerrarSesion.setActionCommand("cerrarSesion");

        bDialogoTabla = new JButton("Tabla Eventos");
        bDialogoTabla.setFont(new Font("Arial", BOLD, 12));
        bDialogoTabla.setBounds(210, 20, 140, 20);
        bDialogoTabla.setBackground(Color.decode("#21eb5d"));
        add(bDialogoTabla);
        bDialogoTabla.setActionCommand("dialogoTabla");


        TitledBorder borde = BorderFactory.createTitledBorder("Botones");
        borde.setTitleColor(Color.decode("#7542f5"));
        setBorder(borde);
    }

    public void agregarOyentesBotones(ActionListener pAL)
    {
        bCrear.addActionListener(pAL);
        bBorrar.addActionListener(pAL);
        bCerrarSesion.addActionListener(pAL);
        bDialogoTabla.addActionListener(pAL);
    }

    public void desactivarBotonCrear()
    {
        bCrear.setEnabled(false);
    }

    public void activarBotonCrear()
    {
        bCrear.setEnabled(true);
    }
}
