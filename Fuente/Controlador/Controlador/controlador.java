package Fuente.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import Vista.VentanaPrincipal;

public class controlador implements ActionListener 
{
    private VentanaPrincipal venPrin;
    private Cliente model1;
    private Grupo model2;
    private Sitio model3;

    public Controlador(VentanaPrincipal pVenPrin, Cliente pModel1, Grupo pModel2, Sitio pModel3)
    {
        this.venPrin = pVenPrin;
        this.model1 = pModel1;
        this.model2 = pModel2;
        this.model3 = pModel3;
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        String comando = ae.getActionCommand();

        if(comando.equals("Crear Cliente"))
        {
            try 
            {
                String gusto = venPrin.miPanelEntradaDatos.getGusto();
                String fechaSalida = venPrin.miPanelEntradaDatos.getGusto();


            }
        }
    }

}