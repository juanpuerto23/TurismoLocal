public class Main 
{
    public static void main(String[] args) 
    {
        Login miLogin = new Login(null, null);
        VentanaLogin miVentanaLogin = new VentanaLogin();
        controlador miControlador = new controlador(miVentanaLogin, miLogin);
    }
}
