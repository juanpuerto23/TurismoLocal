public class Evento
{
    private int numGrupo;
    private String nombreSitio;
    private String fechaApertura;
    private String tipoEvento;

    public Evento(int numGrupo, String nombreSitio, String fechaApertura, String tipoEvento) 
    {
        this.numGrupo = numGrupo;
        this.nombreSitio = nombreSitio;
        this.fechaApertura = fechaApertura;
        this.tipoEvento = tipoEvento;
    }

    public int getNumGrupo() 
    {
        return numGrupo;
    }
    public String getNombreSitio() 
    {
        return nombreSitio;
    }
    public String getFechaApertura() 
    {
        return fechaApertura;
    }
    public void setNumGrupo(int numGrupo) 
    {
        this.numGrupo = numGrupo;
    }
    public void setNombreSitio(String nombreSitio) 
    {
        this.nombreSitio = nombreSitio;
    }
    public void setFechaApertura(String fechaApertura) 
    {
        this.fechaApertura = fechaApertura;
    }
    public String getTipoEvento() 
    {
        return tipoEvento;
    }
    public void setTipoEvento(String tipoEvento) 
    {
        this.tipoEvento = tipoEvento;
    }
    public String toString()
    {
        return "Se asistira a: " + getNombreSitio() + "\nTipo evento: " + getTipoEvento() + "\nNumero de personas que asistiran: " + getNumGrupo() + "\nFecha en la que se llevara a cabo el evento: " + getFechaApertura();
    }
}
