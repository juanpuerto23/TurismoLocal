package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import Vista.VentanaPrincipal;
import Modelo.Cliente;
import Modelo.Grupo;
import Modelo.Sitio;

public class controlador implements ActionListener 
{
    private VentanaPrincipal venPrin;
    private Cliente model1;
    private Grupo model2;
    private Sitio model3;

    public controlador(VentanaPrincipal pVenPrin, Cliente pModel1, Grupo pModel2, Sitio pModel3)
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
            /* 
            String gusto = venPrin.miPanelEntradaDatos.getGusto();
            String fechaSalida = venPrin.miPanelEntradaDatos.getFechaSalida();
            */
        }
    }

}