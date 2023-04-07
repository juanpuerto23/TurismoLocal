
import javax.swing.*;
import java.awt.*;

public class PanelLogin extends JPanel
{
    private JLabel lbTituloLogin;
    private JLabel lbUsuarioLogin;
    private JLabel lbContraseñaLogin;
    private static JTextField tfUsuarioLogin;
    private static JPasswordField pfContraseñaLogin;
    public final JButton btnAccionLogin;
    public JButton btnDialogo;

    public PanelLogin()
    {
        lbTituloLogin = new JLabel("INICIO DE SESIÓN", SwingConstants.CENTER);
        lbTituloLogin.setFont(new Font("Verdana", Font.BOLD, 20));
        lbTituloLogin.setForeground(Color.BLACK);
        lbTituloLogin.setBounds(0, 120, 720, 30);

        lbUsuarioLogin = new JLabel("Nombre de usuario: ", SwingConstants.CENTER);
        lbUsuarioLogin.setFont(new Font("Verdana", Font.PLAIN, 20));
        lbUsuarioLogin.setForeground(Color.BLACK);
        lbUsuarioLogin.setBounds(0, 190, 540, 30);

        lbContraseñaLogin = new JLabel("Contraseña: ", SwingConstants.CENTER);
        lbContraseñaLogin.setFont(new Font("Verdana", Font.PLAIN, 20));
        lbContraseñaLogin.setForeground(Color.BLACK);
        lbContraseñaLogin.setBounds(0, 230, 540, 30);

        tfUsuarioLogin = new JTextField();
        tfUsuarioLogin.setFont(new Font("Verdana", Font.PLAIN, 20));
        tfUsuarioLogin.setForeground(Color.BLACK);
        tfUsuarioLogin.setBounds(390, 190, 200, 30);

        pfContraseñaLogin = new JPasswordField();
        pfContraseñaLogin.setFont(new Font("Verdana", Font.PLAIN, 20));
        pfContraseñaLogin.setForeground(Color.BLACK);
        pfContraseñaLogin.setBounds(390, 230, 200, 30);

        btnAccionLogin = new JButton("Iniciar sesión");
        btnAccionLogin.setFont(new Font("Verdana", Font.PLAIN, 20));
        btnAccionLogin.setForeground(Color.BLACK);
        btnAccionLogin.setBounds(150, 300, 180, 40);
        btnAccionLogin.setActionCommand("accionLogin");

        btnDialogo = new JButton("Registro");
        btnDialogo.setFont(new Font("Verdana", Font.PLAIN, 20));
        btnDialogo.setForeground(Color.BLACK);
        btnDialogo.setBounds(400, 300, 180, 40);
        btnDialogo.setActionCommand("crearRegistro");

        this.setLayout(null);
        this.setBackground(Color.decode("#8CF739"));
        this.setVisible(true);
        this.add(lbTituloLogin);
        this.add(lbUsuarioLogin);
        this.add(lbContraseñaLogin);
        this.add(tfUsuarioLogin);
        this.add(pfContraseñaLogin);
        this.add(btnAccionLogin);
        this.add(btnDialogo);
    }

    public void agregarOyentesBotones(controlador controlador) 
    {
    }
}
