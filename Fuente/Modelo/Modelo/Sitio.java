package Modelo;
public class Sitio 
{
    public int numGrupo;
    public String nombreSitio;
    public String fechaApertura;
    public int numPersonasMax;
    public int precioComida;
    public String tipoComida;

    public Sitio(int numGrupo, String nombreSitio, String fechaApertura, int numPersonasMax, int precioComida,
            String tipoComida) 
    {
        this.numGrupo = numGrupo;
        this.nombreSitio = nombreSitio;
        this.fechaApertura = fechaApertura;
        this.numPersonasMax = numPersonasMax;
        this.precioComida = precioComida;
        this.tipoComida = tipoComida;
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
    public int getNumPersonasMax() 
    {
        return numPersonasMax;
    }
    public int getPrecioComida() 
    {
        return precioComida;
    }
    public String getTipoComida() 
    {
        return tipoComida;
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
    public void setNumPersonasMax(int numPersonasMax) 
    {
        this.numPersonasMax = numPersonasMax;
    }
    public void setPrecioComida(int precioComida) 
    {
        this.precioComida = precioComida;
    }
    public void setTipoComida(String tipoComida) 
    {
        this.tipoComida = tipoComida;
    }

    
}
