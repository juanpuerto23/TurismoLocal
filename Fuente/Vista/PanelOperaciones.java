
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
    public JButton bMostrarDatos;
    
    public PanelOperaciones()
    {
        setLayout(null);
        setBackground(Color.decode("#42855B"));

        bCrear = new JButton("Crear");
        bCrear.setFont(new Font("Arial", BOLD, 12));
        bCrear.setBounds(80, 20, 90, 20);
        bCrear.setBackground(Color.decode("#D2D79F"));
        add(bCrear);
        bCrear.setActionCommand("crear");

        bBorrar = new JButton("Borrar");
        bBorrar.setFont(new Font("Arial", BOLD, 12));
        bBorrar.setBounds(80, 180, 90, 20);
        bBorrar.setBackground(Color.decode("#D2D79F"));
        add(bBorrar);
        bBorrar.setActionCommand("borrar");

        bCerrarSesion = new JButton("Cerrar Sesion");
        bCerrarSesion.setFont(new Font("Arial", BOLD, 12));
        bCerrarSesion.setBounds(210, 180, 140, 20);
        bCerrarSesion.setBackground(Color.decode("#D2D79F"));
        add(bCerrarSesion);
        bCerrarSesion.setActionCommand("cerrarSesion");

        bDialogoTabla = new JButton("Tabla Eventos");
        bDialogoTabla.setFont(new Font("Arial", BOLD, 12));
        bDialogoTabla.setBounds(210, 20, 140, 20);
        bDialogoTabla.setBackground(Color.decode("#D2D79F"));
        add(bDialogoTabla);
        bDialogoTabla.setActionCommand("dialogoTabla");
        
        bMostrarDatos = new JButton("Mostrar Datos");
        bMostrarDatos.setFont(new Font("Arial" , BOLD, 12));
        bMostrarDatos.setBounds(210, 100, 140, 20);
        bMostrarDatos.setBackground(Color.decode("#D2D79F"));
        bMostrarDatos.setActionCommand("mostrarDatos");
        add(bMostrarDatos);

    }

    public void agregarOyentesBotones(ActionListener pAL)
    {
        bCrear.addActionListener(pAL);
        bBorrar.addActionListener(pAL);
        bCerrarSesion.addActionListener(pAL);
        bDialogoTabla.addActionListener(pAL);
        bMostrarDatos.addActionListener(pAL);
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
