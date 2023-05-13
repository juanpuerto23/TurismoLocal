import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DialogoRegistro extends JDialog
{
    private JLabel lbTitulo;
    private JLabel lbUsuario;
    private JLabel lbContraseña;
    private JTextField txUsuario;
    private JTextField txContraseña;
    private JButton btAceptar;

    public DialogoRegistro()
    {
        setLayout(null);

        lbTitulo = new JLabel("Registro Usuario", JLabel.CENTER);
        lbTitulo.setFont(new Font("Arial", Font.BOLD, 25));
        lbTitulo.setBounds(75,10,280,20);
        add(lbTitulo);

        lbUsuario = new JLabel("Usuario = ", JLabel.RIGHT);
        lbUsuario.setFont(new Font("Arial", Font.BOLD, 25));
        lbUsuario.setBounds(10,50,200,20);
        add(lbUsuario);

        lbContraseña = new JLabel("Contraseña = ", JLabel.RIGHT);
        lbContraseña.setFont(new Font("Arial", Font.BOLD, 25));
        lbContraseña.setBounds(10,150,200,20);
        add(lbContraseña);

        txUsuario= new JTextField();
        txUsuario.setFont(new Font("Arial", Font.BOLD, 25));
        txUsuario.setBounds(250,50,100,25);
        add(txUsuario);
        
        txContraseña= new JTextField();
        txContraseña.setFont(new Font("Arial", Font.BOLD, 25));
        txContraseña.setBounds(250,150,100,25);
        add(txContraseña);

        btAceptar = new JButton("Aceptar");
        btAceptar.setFont(new Font("Arial", Font.BOLD, 25));
        btAceptar.setBounds(75,300,260,25);
        btAceptar.setActionCommand("aceptar");
        add(btAceptar);

        setTitle("Registro");
        setSize(400,400);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public String getUsuario() 
    {
        return txUsuario.getText();
    }

    public String getContraseña() 
    {
        return txContraseña.getText();
    }

    public void agregarOyentesBotones(ActionListener pAL)
    {
        btAceptar.addActionListener(pAL);
    }

    public void cerrarDialogo()
    {
        this.dispose();
    }  
}
