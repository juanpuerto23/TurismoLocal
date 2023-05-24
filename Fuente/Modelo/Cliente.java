public class Cliente
{
    public int presupuesto;
    public String gusto;
    public String nombreCliente;
    public String fechaSalida;

    public Cliente(String pFechaSalida, String pnombreCliente, int pPresupuesto, String pGusto)
    {
        this.nombreCliente = pnombreCliente;
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

    public String getnombreCliente()
    {
        return this.nombreCliente;
    }

    public void setNombreCliente(String pnombreCliente)
    {
        this.nombreCliente = pnombreCliente;
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
        return "Nombre del cliente: " + getnombreCliente() + "\nPresupuesto del cliente: " + getPresupuesto() + "\nGustos del cliente: " + getGusto() + "\nFecha a la que se ira el cliente: " + getFechaSalida();
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