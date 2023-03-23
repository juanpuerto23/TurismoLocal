public class Cliente 
{
    public int presupuesto;
    public String fechaIngreso;
    public String fechaSalida;

    public Cliente(String pFechaSalida, String pFechaIngreso, int pPresupuesto)
    {
        this.fechaIngreso = pFechaIngreso;
        this.presupuesto = pPresupuesto;
        this.fechaSalida = pFechaSalida;
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



}