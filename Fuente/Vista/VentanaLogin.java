import javax.swing.*;

public class VentanaLogin extends JFrame
{
    public PanelLogin miPanelLogin;

    public VentanaLogin()
    {
        miPanelLogin = new PanelLogin();
        miPanelLogin.setBounds(0, 0, 720, 480);

        this.setTitle("Inicio de sesion");
        this.setSize(720, 480);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(null);
        this.add(miPanelLogin);
    }
}
