import javax.swing.JOptionPane;

public class Grupo extends Evento
{
    private static int numPersonas;
    private String nomGrupo;
    private String gustos;
    private static String horaReunion;    
    private String tipoActividad;

    public Grupo(String ptipoActividad, String pGustos, String pNomGrupo, String pHoraReunion)
    {
        super(numPersonas, pNomGrupo, pHoraReunion, ptipoActividad);
        this.gustos = pGustos;
        Grupo.horaReunion = pHoraReunion;
        this.nomGrupo = pNomGrupo;
        this.tipoActividad = ptipoActividad;
    }

    public Grupo(String ptipoActividad, String pGustos, String pNomGrupo)
    {
        super(numPersonas, pNomGrupo, horaReunion, pGustos);
        this.gustos = pGustos;
        this.nomGrupo = pNomGrupo;
        this.tipoActividad = ptipoActividad;
        
    }

    public String getHoraReunion() 
    {
        return horaReunion;
    }
    public void setHoraReunion(String horaReunion) 
    {
        Grupo.horaReunion = horaReunion;
    }
    public String getNomGrupo() 
    {
        return nomGrupo;
    }
    public void setNomGrupo(String nomGrupo) 
    {
        this.nomGrupo = nomGrupo;
    }
    public static int getNumPersonas() 
    {
        return numPersonas;
    }
    public static void setNumPersonas(int numPersonas) 
    {
        Grupo.numPersonas = numPersonas;
    }
    public String getGustos() 
    {
        return gustos;
    }
    public void setGustos(String gustos) 
    {
        this.gustos = gustos;
    }
    public String gettipoActividad()
    {
        return this.tipoActividad;
    }
    public void settipoActividad(String ptipoActividad)
    {
        this.tipoActividad = ptipoActividad;
    }

    public void calcularGrupos(int numPersonas)
    {
        int numGrupos = (numPersonas/5);
        int sobrantes = numPersonas % 5;
        if (sobrantes == 0) 
        {
            int grupoSobrante = numGrupos + 1;
            JOptionPane.showMessageDialog(null, "Numero grupo incompleto: " + grupoSobrante, "Grupo faltante", JOptionPane.OK_CANCEL_OPTION);
        }
        int posicionGrupo = (int)(Math.random() * numGrupos) + 1;
        JOptionPane.showMessageDialog(null, "Numero de grupos totales con 5 personas: " + numGrupos + "\nA usted se le asigno el grupo: " + posicionGrupo, "Evento registrado", JOptionPane.OK_CANCEL_OPTION);
    }
}
