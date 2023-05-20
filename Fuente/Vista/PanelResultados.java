
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class PanelResultados extends JPanel 
{
    private JTextArea taResultado;
    private JScrollPane spResultado;

    public PanelResultados()
    {
        setLayout(null);
        setBackground(Color.decode("#11d445"));

        taResultado = new JTextArea();
        spResultado = new JScrollPane(taResultado);
        spResultado.setBounds(10, 20, 360, 210);
        add(spResultado);

        TitledBorder borde = BorderFactory.createTitledBorder("Datos creados");
        borde.setTitleColor(Color.decode("#7542f5"));
        setBorder(borde);
    }

    public void borrar()
    {
        taResultado.setText("");
    }

    public void mostrarResultado(String msj)
    {
        taResultado.append(msj + "\n");
    }
}
