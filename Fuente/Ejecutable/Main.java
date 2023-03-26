package Ejecutable;

import Controlador.controlador;
import Modelo.Cliente;
import Vista.VentanaPrincipal;

public class Main 
{
    public static void main(String[] args) 
    {
        VentanaPrincipal miVentana = new VentanaPrincipal();
        Cliente miCliente = null;
        controlador miControlador = new controlador(miVentana, miCliente, null, null);
        
    }
}
