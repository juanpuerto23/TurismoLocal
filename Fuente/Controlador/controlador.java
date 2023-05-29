
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class controlador implements ActionListener 
{
    private VentanaPrincipal miVentanaPrincipal;
    private Cliente model1;
    private Evento evento1;
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
                    JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso!", "Inicio de sesion", JOptionPane.INFORMATION_MESSAGE);
                    this.miVentanaPrincipal = new VentanaPrincipal();
                    miVentanaPrincipal.setVisible(true);
                    miVentanaPrincipal.miPanelOperaciones.agregarOyentesBotones(this);
                    miVentanaLogin.cerrarLogin();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Inicio de sesión fallido", "Inicio de sesion", JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "Usuario creado exitosamente", "Usuario creado", JOptionPane.INFORMATION_MESSAGE);
            miVentanaLogin.miDialogoRegistro.cerrarDialogo();
        }

        if(comando.equals("registrarEvento"))
        {
            miVentanaPrincipal.miPanelResultado.mostrarResultado("\n-----------------------------------");
            miVentanaPrincipal.miPanelResultado.mostrarResultado("----- NUEVO EVENTO -----");
            miVentanaPrincipal.miPanelResultado.mostrarResultado("-----------------------------------\n");
            String nombreSitio = miVentanaPrincipal.miDialogoTabla.getTfnombreSitio();
            miVentanaPrincipal.miDialogoTabla.obtenerDatos();
            miVentanaPrincipal.miDialogoTabla.cerrarDialogo();
            evento1 = new Evento(10 + 1, nombreSitio, "23/07/2023", "Farra");
            String mensaje = evento1.toString();
            miVentanaPrincipal.miPanelResultado.mostrarResultado(mensaje);
            Grupo grupo1 = new Grupo("Farra", "Farra", nombreSitio, "12:00 pm");
            grupo1.calcularGrupos(evento1.getNumGrupo());

        }

        if(comando.equals("crear"))
        {
            miVentanaPrincipal.miPanelResultado.mostrarResultado("\n-------------------------------------");
            miVentanaPrincipal.miPanelResultado.mostrarResultado("----- NUEVO CLIENTE -----");
            miVentanaPrincipal.miPanelResultado.mostrarResultado("-------------------------------------\n");
            VentanaPrincipal venPrin = miVentanaPrincipal;
            String gusto = venPrin.miPanelEntradaDatos.getGusto();
            String fechaSalida = venPrin.miPanelEntradaDatos.getFechaSalida();
            String nombreCliente = venPrin.miPanelEntradaDatos.getnombreCliente();
            int Presupuesto = Integer.parseInt(venPrin.miPanelEntradaDatos.getPresupuesto());

            model1 = new Cliente(fechaSalida, nombreCliente, Presupuesto, gusto);

            venPrin.miPanelResultado.mostrarResultado("Se ha creado un nuevo cliente");
            venPrin.miPanelResultado.mostrarResultado("Nombre del cliente: " + model1.getnombreCliente());
            venPrin.miPanelResultado.mostrarResultado("La fecha en la que se ira de Socorro es " + model1.getFechaSalida());
            venPrin.miPanelResultado.mostrarResultado("Su presupesto es de $" + model1.getPresupuesto() + " pesos.");
            venPrin.miPanelResultado.mostrarResultado("Sus gustos se basan en " + model1.getGusto());

            venPrin.miPanelOperaciones.desactivarBotonCrear();
        }

        if(comando.equals("mostrarDatos"))
        {
            miVentanaPrincipal.miPanelResultado.mostrarResultado("\n-------------------------------------");
            miVentanaPrincipal.miPanelResultado.mostrarResultado("----- MOSTRAR DATOS -----");
            miVentanaPrincipal.miPanelResultado.mostrarResultado("-------------------------------------\n");
            if(model1 == null)
            {
                miVentanaPrincipal.miPanelResultado.mostrarResultado("No se ha creado ningun cliente");
            }
            if(evento1 == null)
            {
                if(model1 != null)
                {
                    String mensaje1 = model1.toString();
                    miVentanaPrincipal.miPanelResultado.mostrarResultado(mensaje1);
                }
                miVentanaPrincipal.miPanelResultado.mostrarResultado("No se ha inscrito a ningun evento");
            }
            else
            {
                String mensaje1 = model1.toString();
                miVentanaPrincipal.miPanelResultado.mostrarResultado(mensaje1);
                String mensaje = evento1.toString();
                miVentanaPrincipal.miPanelResultado.mostrarResultado(mensaje);
            }
        }

        if(comando.equals("borrar"))
        {
            miVentanaPrincipal.miPanelEntradaDatos.borrar();
            miVentanaPrincipal.miPanelResultado.borrar();
            miVentanaPrincipal.miPanelOperaciones.activarBotonCrear();
        }

        if(comando.equals("cerrarSesion"))
        {
            miVentanaPrincipal.cerrarVenPrincipal();
            VentanaLogin miVentanaLogin = new VentanaLogin();
            Login miLogin = new Login(null, null);
            controlador miControlador = new controlador(miVentanaLogin, miLogin);
        }

        if(comando.equals("dialogoTabla"))
        {
            miVentanaPrincipal.crearDialogoTabla();
            this.miVentanaPrincipal.miDialogoTabla.agregarOyentesBotones(this);
        }

    }
}
