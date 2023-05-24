import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DialogoRegistroTabla extends JDialog
{
    private JLabel lbTitulo;
    private static JComboBox<String> cbSitioEvento;
    private ImageIcon iLogo;
    private JLabel lbLogo;

    public DialogoRegistroTabla()
    {
        lbTitulo = new JLabel("Registro Evento", SwingConstants.CENTER);
        lbTitulo.setFont(new Font("Verdana", Font.BOLD, 20));
        lbTitulo.setForeground(Color.BLACK);
        lbTitulo.setBounds(0, 10, 558, 30);
        add(lbTitulo);

        String[] sitioEventos = {"Bohemia Club House", "Kalema Bar", "Tercer Tiempo", "La Arenosa Disco Bar"};
        cbSitioEvento = new JComboBox<>(sitioEventos);
        cbSitioEvento.setSelectedIndex(0);
        cbSitioEvento.setFont(new Font("Arial", Font.PLAIN, 18));
        cbSitioEvento.setForeground(Color.BLACK);
        cbSitioEvento.setBounds(300, 300, 190, 30);
        add(cbSitioEvento);

        iLogo = new ImageIcon("/Turismo.png");

        lbLogo = new JLabel(iLogo);
        lbLogo.setOpaque(true);
        lbLogo.setBorder(BorderFactory.createRaisedBevelBorder());
        lbLogo.setBounds(55, 42, 126, 172);
        add(lbLogo);

        setTitle("Registro Evento");
        setSize(600,600);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        
    }

    public static String getTfSitioEvento()
    {
        return cbSitioEvento.getSelectedItem().toString();
    }
}
