
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class controlador implements ActionListener 
{
    private VentanaPrincipal miVentanaPrincipal;
    private Cliente model1;
    private VentanaLogin miVentanaLogin;
    private Login miLogin;

    public controlador(VentanaLogin miVentanaLogin, Login miLogin)
    {
        this.miVentanaLogin = miVentanaLogin;
        this.miLogin = miLogin;
        this.miVentanaLogin.miPanelLogin.btnAccionLogin.addActionListener(this);
        this.miVentanaLogin.miPanelLogin.btnDialogo.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        String comando = ae.getActionCommand();

        if(comando.equals("accionLogin"))
        {
            try 
            {
                String pUsuario = miVentanaLogin.miPanelLogin.getUsuarioLogin();
                String pContraseña = miVentanaLogin.miPanelLogin.getContraseñaLogin();
                if(miLogin.verificarLogin(pUsuario, pContraseña))
                {
                    JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso!");
                    this.miVentanaPrincipal = new VentanaPrincipal();
                    miVentanaPrincipal.setVisible(true);
                    miVentanaPrincipal.miPanelOperaciones.agregarOyentesBotones(this);
                    miVentanaLogin.cerrarLogin();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Inicio de sesión fallido", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } 
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(null, "ERROR");
            }
        }

        if(comando.equals("crearRegistro"))
        {
            
            miVentanaLogin.crearDialogoRegistro();
            this.miVentanaLogin.miDialogoRegistro.agregarOyentesBotones(this);
        }

        if(comando.equals("aceptar"))
        {
            String usuario = miVentanaLogin.miDialogoRegistro.getUsuario();
            String Contraseña = miVentanaLogin.miDialogoRegistro.getContraseña();
            miLogin.registrarLogin(usuario, Contraseña);
            JOptionPane.showMessageDialog(null, "Usuario creado exitosamente");
            miVentanaLogin.miDialogoRegistro.cerrarDialogo();
        }

        if(comando.equals("crear"))
        {
            VentanaPrincipal venPrin = miVentanaPrincipal;
            String gusto = venPrin.miPanelEntradaDatos.getGusto();
            String fechaSalida = venPrin.miPanelEntradaDatos.getFechaSalida();
            String fechaEntrada = venPrin.miPanelEntradaDatos.getFechaEntrada();
            int Presupuesto = Integer.parseInt(venPrin.miPanelEntradaDatos.getPresupuesto());

            model1 = new Cliente(fechaSalida, fechaEntrada, Presupuesto, gusto);

            venPrin.miPanelResultado.mostrarResultado("Se ha creado un nuevo cliente");
            venPrin.miPanelResultado.mostrarResultado("La fecha en la que llego a Socorro fue " + model1.getFechaEntrada());
            venPrin.miPanelResultado.mostrarResultado("La fecha en la que se ira de Socorro es " + model1.getFechaSalida());
            venPrin.miPanelResultado.mostrarResultado("Su presupesto es de $" + model1.getPresupuesto() + " pesos.");
            venPrin.miPanelResultado.mostrarResultado("Sus gustos se basan en " + model1.getGusto());

            venPrin.miPanelOperaciones.desactivarBotonCrear();
        }

        if(comando.equals("borrar"))
        {
            miVentanaPrincipal.miPanelEntradaDatos.borrar();
            miVentanaPrincipal.miPanelResultado.borrar();
        }

        if(comando.equals("cerrarSesion"))
        {
            miVentanaPrincipal.cerrarVenPrincipal();
            VentanaLogin miVentanaLogin = new VentanaLogin();
            Login miLogin = new Login(null, null);
            controlador miControlador = new controlador(miVentanaLogin, miLogin);
        }

    }
}
