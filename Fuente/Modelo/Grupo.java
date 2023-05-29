
public class Grupo extends Evento
{
    private static int numPersonas;
    private String nomGrupo;
    private String[] gustos;
    private String horaReunion;    
    private String tipoActividad;

    public Grupo(String ptipoActividad, String[] pGustos, String pNomGrupo, String pHoraReunion)
    {
        super(numPersonas, pNomGrupo, pHoraReunion, ptipoActividad);
        this.gustos = pGustos;
        this.horaReunion = pHoraReunion;
        this.nomGrupo = pNomGrupo;
        this.tipoActividad = ptipoActividad;
    }

    public String getHoraReunion() 
    {
        return horaReunion;
    }
    public void setHoraReunion(String horaReunion) 
    {
        this.horaReunion = horaReunion;
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
    public String[] getGustos() 
    {
        return gustos;
    }
    public void setGustos(String[] gustos) 
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
        int posicionGrupo;
    }
}
