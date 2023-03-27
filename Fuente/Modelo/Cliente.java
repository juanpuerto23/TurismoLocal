package Modelo;
public class Cliente 
{
    public int presupuesto;
    public String gusto;
    public String fechaEntrada;
    public String fechaSalida;

    public Cliente(String pFechaSalida, String pFechaEntrada, int pPresupuesto, String pGusto)
    {
        this.fechaEntrada = pFechaEntrada;
        this.presupuesto = pPresupuesto;
        this.fechaSalida = pFechaSalida;
        this.gusto = pGusto;
    }

    public int getPresupuesto()
    {
        return this.presupuesto;
    }

    public void setPresupuesto(int pPresupuesto)
    {
        this.presupuesto = pPresupuesto;
    }

    public String getFechaEntrada()
    {
        return this.fechaEntrada;
    }

    public void setFechaIngreso(String pFechaEntrada)
    {
        this.fechaEntrada = pFechaEntrada;
    }

    public String getFechaSalida()
    {
        return this.fechaSalida;
    }

    public void setFechaSalida(String pFechaSalida)
    {
        this.fechaSalida = pFechaSalida;
    }

    public String toString()
    {
        return "";
    }

    public String getGusto() 
    {
        return gusto;
    }

    public void setGusto(String gusto) 
    {
        this.gusto = gusto;
    }



}