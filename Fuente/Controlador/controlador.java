
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
            boolean usuarioExistente = miLogin.verificarExistenciaUsuario(usuario);
            if(usuarioExistente == true)
            {
                JOptionPane.showMessageDialog(null, "Ya existe un usuario con ese nombre!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            if(usuarioExistente == false)
            {
                miLogin.registrarLogin(usuario, Contraseña);
                JOptionPane.showMessageDialog(null, "Usuario creado exitosamente", "Usuario creado", JOptionPane.INFORMATION_MESSAGE);
                miVentanaLogin.miDialogoRegistro.cerrarDialogo();
            }
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
            venPrin.miPanelOperaciones.activarBotonMostrarConsejo();
        }

        if(comando.equals("registrarEvento"))
        {
            if(model1.getGusto() == "Farrear")
            {
                miVentanaPrincipal.miPanelResultado.mostrarResultado("\n-----------------------------------");
                miVentanaPrincipal.miPanelResultado.mostrarResultado("----- NUEVO EVENTO -----");
                miVentanaPrincipal.miPanelResultado.mostrarResultado("-----------------------------------\n");
                String nombreSitio = miVentanaPrincipal.miDialogoTabla.getTfnombreSitio();
                miVentanaPrincipal.miDialogoTabla.obtenerDatos();
                miVentanaPrincipal.miDialogoTabla.cerrarDialogo();
                evento1 = new Evento(40, nombreSitio, "10/06/2023", "Farra");
                String mensaje = evento1.toString();
                miVentanaPrincipal.miPanelResultado.mostrarResultado(mensaje);
                Grupo grupo1 = new Grupo("Farra", "Farra", nombreSitio, "12:00 pm");
                miVentanaPrincipal.miPanelResultado.mostrarResultado("No se recomienda conducir en estado de ebriedad, tenlo en cuenta!");
                miVentanaPrincipal.miPanelResultado.mostrarResultado("Ten cuidado sobre lo que te ofrecen en la farra");
                grupo1.calcularGrupos(evento1.getNumGrupo());
            }
            if(model1.getGusto() == "Comer")
            {
                
                String nombreSitio = miVentanaPrincipal.miDialogoTablaRestaurante.getTfnombreSitio();
                miVentanaPrincipal.miDialogoTablaRestaurante.cerrarDialogo();
                miVentanaPrincipal.miPanelResultado.mostrarResultado("\nPiensas ir a " + nombreSitio + "? Genial!");
                miVentanaPrincipal.miDialogoTablaRestaurante.obtenerDatos();
                Grupo grupo1 = new Grupo("Comida/Restaurantes", "Comer", nombreSitio + "1");
                if(model1.getPresupuesto() < 50000)
                {
                    miVentanaPrincipal.miPanelResultado.mostrarResultado("El presupuesto es menor a $50000.\nSi vas acompañado te sugerimos llevar mas dinero");
                }
            }
            if(model1.getGusto() == "Explorar")
            {
                String nombreSitio = miVentanaPrincipal.miDialogoTablaExploracion.getTfnombreSitio();
                miVentanaPrincipal.miDialogoTablaExploracion.cerrarDialogo();
                Grupo grupo1 = new Grupo("Actividades y Aventuras", "Explorar", nombreSitio + " 1");
                miVentanaPrincipal.miPanelResultado.mostrarResultado("Quieres ir a " + nombreSitio + "? Genial!");
                miVentanaPrincipal.miPanelResultado.mostrarResultado("Si vas a una piscina, no olvides aplicarte bloqueador!");
                miVentanaPrincipal.miDialogoTablaExploracion.obtenerDatos();
            }
            if(model1.getGusto() == "Turistear")
            {
                String nombreSitio = miVentanaPrincipal.miDialogoTablaTurismo.getTfnombreSitio();
                Grupo grupo1 = new Grupo("Sitios turisticos", "Turistear", nombreSitio + " 1");
                miVentanaPrincipal.miPanelResultado.mostrarResultado("Quieres ir a " + nombreSitio + "? Excelente!");
                miVentanaPrincipal.miDialogoTablaTurismo.cerrarDialogo();
                miVentanaPrincipal.miDialogoTablaTurismo.obtenerDatos();
            }
        }

        if(comando.equals("mostrarConsejo"))
        {
            miVentanaPrincipal.miPanelResultado.mostrarResultado("\nHola, " + model1.getnombreCliente() +"!.\nAqui algunos consejos: ");
            int diasRestantes = model1.calcularDiasRestantes();
            if(diasRestantes <= 2)
            {
                miVentanaPrincipal.miPanelResultado.mostrarResultado("Te vas en " + diasRestantes + " dias. Alista tu maleta!.");
            }
            else
            {
                miVentanaPrincipal.miPanelResultado.mostrarResultado("Te vas en " + diasRestantes + " dias.");
            }
            if(model1.getPresupuesto() >= 1000000)
            {
                miVentanaPrincipal.miPanelResultado.mostrarResultado("Tienes $" + model1.getPresupuesto() + " pesos.");
                miVentanaPrincipal.miPanelResultado.mostrarResultado("En cualquier caso, existe una estacion de policia en el Parque de la Independencia.");
            }
            if(model1.getPresupuesto() <= 50000)
            {
                miVentanaPrincipal.miPanelResultado.mostrarResultado("Tienes $" + model1.getPresupuesto() + " pesos.");
                miVentanaPrincipal.miPanelResultado.mostrarResultado("Si piensas hacer un retiro grande recuerda hacerlo en un corresponsal autorizado.\nEstos corresponsales quedan en el Parque de la Independencia.");
            }
            if(model1.getGusto() == "Turistear")
            {
                miVentanaPrincipal.miPanelResultado.mostrarResultado("Te gusta " + model1.getGusto());
                miVentanaPrincipal.miPanelResultado.mostrarResultado("Recuerda que si quieres turistear en El Socorro existe un punto de informacion en frente de la Iglesia ubicada en el Parque de la Independencia.");
            }
            if(model1.getGusto() == "Comer" && model1.getPresupuesto() <= 50000)
            {
                miVentanaPrincipal.miPanelResultado.mostrarResultado("Te gusta " + model1.getGusto());
                miVentanaPrincipal.miPanelResultado.mostrarResultado("Tienes $" + model1.getPresupuesto() + " pesos.");
                miVentanaPrincipal.miPanelResultado.mostrarResultado("Si vas a comer acompañado se te sugiere llevar mas dinero.");
            }
            if(model1.getGusto() == "Farrear")
            {
                miVentanaPrincipal.miPanelResultado.mostrarResultado("Te gusta " + model1.getGusto());
                miVentanaPrincipal.miPanelResultado.mostrarResultado("Recuerda no conducir en estado de ebriedad!.");
                miVentanaPrincipal.miPanelResultado.mostrarResultado("Se te sugiere ir acompañado de tus amigos o del grupo seleccionado para ti.");
            }
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
            else if(evento1 != null)
            {
                String mensaje1 = model1.toString();
                miVentanaPrincipal.miPanelResultado.mostrarResultado(mensaje1);
                String mensaje = evento1.toString();
                miVentanaPrincipal.miPanelResultado.mostrarResultado(mensaje);
            }
            else if(evento1 == null)
            {
                miVentanaPrincipal.miPanelResultado.mostrarResultado("No se ha inscrito a ningun evento");
                if(model1 != null)
                {
                    String mensaje1 = model1.toString();
                    miVentanaPrincipal.miPanelResultado.mostrarResultado(mensaje1);
                }
            }
        }

        if(comando.equals("borrar"))
        {
            JOptionPane.showMessageDialog(null, "Se borrarán los datos.", "Borrar datos", JOptionPane.CANCEL_OPTION);
            miVentanaPrincipal.miPanelEntradaDatos.borrar();
            miVentanaPrincipal.miPanelResultado.borrar();
            miVentanaPrincipal.miPanelOperaciones.desactivarBotonMostrarConsejo();
            miVentanaPrincipal.miPanelOperaciones.activarBotonCrear();
        }

        if(comando.equals("cerrarSesion"))
        {
            JOptionPane.showMessageDialog(null, "Se cerrará la sesión.", "Cerrar Sesion", JOptionPane.CANCEL_OPTION);
            miVentanaPrincipal.cerrarVenPrincipal();
            VentanaLogin miVentanaLogin = new VentanaLogin();
            Login miLogin = new Login(null, null);
            controlador miControlador = new controlador(miVentanaLogin, miLogin);
        }

        if(comando.equals("dialogoTabla"))
        {
            if(model1.getGusto() == "Farrear")
            {
                miVentanaPrincipal.crearDialogoTabla();
                this.miVentanaPrincipal.miDialogoTabla.agregarOyentesBotones(this);
            }
            if(model1.getGusto() == "Comer")
            {
                miVentanaPrincipal.crearDialogoTablaRestaurante();
                this.miVentanaPrincipal.miDialogoTablaRestaurante.agregarOyentesBotones(this);
            }
            if(model1.getGusto() == "Explorar")
            {
                miVentanaPrincipal.crearDialogoTablaExploracion();
                this.miVentanaPrincipal.miDialogoTablaExploracion.agregarOyentesBotones(this);
            }
            if(model1.getGusto() == "Turistear")
            {
                miVentanaPrincipal.crearDialogoTablaTurismo();
                this.miVentanaPrincipal.miDialogoTablaTurismo.agregarOyentesBotones(this);
            }

        }

    }
}
