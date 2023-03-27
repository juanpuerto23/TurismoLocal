
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
        setBackground(Color.decode("#d6b522"));

        taResultado = new JTextArea();
        spResultado = new JScrollPane(taResultado);
        spResultado.setBounds(10, 20, 460, 210);
        add(spResultado);

        TitledBorder borde = BorderFactory.createTitledBorder("Datos creados");
        borde.setTitleColor(Color.BLUE);
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
