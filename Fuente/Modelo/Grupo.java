
public class Grupo 
{
    public int numPersonas;
    // public String gustos[];
    public String tipoActividad;

    public Grupo(int pnumPersonas, String ptipoActividad)
    {
        this.numPersonas = pnumPersonas;
        this.tipoActividad = ptipoActividad;
    }
    
    public int getnumPersonas()
    {
        return this.numPersonas;
    }

    public void setnumPersonas(int pnumPersonas)
    {
        this.numPersonas = pnumPersonas;
    }

    public String gettipoActividad()
    {
        return this.tipoActividad;
    }

    public void settipoActividad(String ptipoActividad)
    {
        this.tipoActividad = ptipoActividad;
    }

}
