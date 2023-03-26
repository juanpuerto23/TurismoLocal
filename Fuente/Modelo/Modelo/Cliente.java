package Modelo;
public class Cliente 
{
    public int presupuesto;
    public String gusto;
    public String fechaIngreso;
    public String fechaSalida;
    // public String gustos[]; Esta verga toca pillarla bien

    public Cliente(String pFechaSalida, String pFechaIngreso, int pPresupuesto, String pGusto)
    {
        this.fechaIngreso = pFechaIngreso;
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

    public String getFechaIngreso()
    {
        return this.fechaIngreso;
    }

    public void setFechaIngreso(String pFechaIngreso)
    {
        this.fechaIngreso = pFechaIngreso;
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