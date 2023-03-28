
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;



public class controlador implements ActionListener 
{
    private VentanaPrincipal venPrin;
    private Cliente model1;
    private Grupo model2;
    private Evento model3;

    public controlador(VentanaPrincipal pVenPrin, Cliente pModel1, Grupo pModel2, Evento pModel3)
    {
        this.venPrin = pVenPrin;
        this.model1 = pModel1;
        this.model2 = pModel2;
        this.model3 = pModel3;
        this.venPrin.miPanelOperaciones.agregarOyentesBotones(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        String comando = ae.getActionCommand();

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
