public class Login 
{
    public String Usuario;
    public String Contraseña;

    public Login(String pUsuario, String pConstraseña)
    {
        this.Usuario = pUsuario;
        this.Contraseña = pConstraseña;
    }

    public String getUsuario() 
    {
        return Usuario;
    }

    public void setUsuario(String usuario) 
    {
        Usuario = usuario;
    }

    public String getContraseña() 
    {
        return Contraseña;
    }

    public void setContraseña(String contraseña)
    {
        Contraseña = contraseña;
    }



}
