
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
        setBackground(Color.decode("#42855B"));

        taResultado = new JTextArea();
        taResultado.setBackground(Color.decode("#90B77D"));
        spResultado = new JScrollPane(taResultado);
        spResultado.setBounds(10, 20, 360, 210);
        add(spResultado);

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
