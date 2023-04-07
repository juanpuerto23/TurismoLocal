
import javax.swing.JFrame;
import java.awt.*;

public class VentanaPrincipal extends JFrame
{
    //----------------------
    //Atributos
    //----------------------
    public PanelEntradaDatos miPanelEntradaDatos;
    public PanelOperaciones miPanelOperaciones;
    public PanelResultados miPanelResultado;
    public PanelTabla miPanelTabla;
    //-------------------------
    //Métodos
    //-------------------------
    
    //Metodo constructor
    public VentanaPrincipal()
    {
        //Definición del contenedor de la ventana
        setLayout(null);
        
        
        //Creación y adición del PanelEntradaDatos

        miPanelTabla = new PanelTabla();
        miPanelTabla.setBounds(500, 0, 840, 505);
        add(miPanelTabla);
        
        miPanelEntradaDatos = new PanelEntradaDatos();
        miPanelEntradaDatos.setBounds(0, 0, 480, 290);
        add(miPanelEntradaDatos);
       

        //Creación y adición del PanelOperaciones
        miPanelOperaciones = new PanelOperaciones();
        miPanelOperaciones.setBounds(0,300,480,90);
        add(miPanelOperaciones);
        
        //Creación y adición del PanelOperaciones
        miPanelResultado = new PanelResultados();
        miPanelResultado.setBounds(0,390,480,250);
        add(miPanelResultado);
        
        
        //Caracteristicas de la ventana
        setTitle("Turismo Local");
        setSize(1360,700);
        // setBackground(Color.decode("#11d445")); Esto se pone en el panel alskdo
        // setLocation(50,50);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
    
}