
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class controlador implements ActionListener 
{
    private VentanaPrincipal venPrin;
    private Cliente model1;
    private Grupo model2;
    private Evento model3;
    private VentanaLogin miVentanaLogin;
    private Login miLogin;

    public controlador(VentanaLogin miVentanaLogin, Login miLogin, Cliente pModel1, Grupo pModel2, Evento pModel3)
    {
        this.miVentanaLogin = miVentanaLogin;
        this.miLogin = miLogin;
        this.model1 = pModel1;
        this.model2 = pModel2;
        this.model3 = pModel3;
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
                String usuario = miLogin.getUsuario();
                String Contraseña = miLogin.getContraseña();
                miLogin.verificarLogin(usuario, Contraseña);
                JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso!");
                VentanaPrincipal miVentanaPrincipal = new VentanaPrincipal();
                miVentanaPrincipal.setVisible(true);
            } 
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(null, "Inicio de sesión fallido!");
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
            try
            {
                String gusto = venPrin.miPanelEntradaDatos.getGusto();
                String fechaSalida = venPrin.miPanelEntradaDatos.getFechaSalida();
                String fechaEntrada = venPrin.miPanelEntradaDatos.getFechaEntrada();
                int Presupuesto = Integer.parseInt(venPrin.miPanelEntradaDatos.getPresupuesto());

                model1 = new Cliente(fechaSalida, fechaEntrada, Presupuesto, gusto);

                venPrin.miPanelResultado.mostrarResultado("Se ha creado un nuevo cliente");
                venPrin.miPanelResultado.mostrarResultado("La fecha en la que llego a Socorro fue " + model1.getFechaEntrada());
                venPrin.miPanelResultado.mostrarResultado("La fecha en la que se ira de Socorro es " + model1.getFechaSalida());
                venPrin.miPanelResultado.mostrarResultado("Su presupesto es de $" + model1.getPresupuesto());
                venPrin.miPanelResultado.mostrarResultado("Sus gustos se basan en " + model1.getGusto());

                venPrin.miPanelOperaciones.desactivarBotonCrear();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Error en datos de entrada", 
                "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
