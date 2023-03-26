package Vista;

import java.awt.Color;
import javax.swing.*;


public class PanelEntradaDatos extends JPanel 
{
    private JLabel lbImagen;
    private ImageIcon iImagen;
    
    public PanelEntradaDatos() 
    {
        setLayout(null);
        setBackground(Color.decode("#11d445"));

        iImagen = new ImageIcon(getClass().getResource("/Imagenes/Logo.png"));
        lbImagen = new JLabel(iImagen);
        lbImagen.setBounds(10, 10, 200, 200);
        add(lbImagen);
    }
}
