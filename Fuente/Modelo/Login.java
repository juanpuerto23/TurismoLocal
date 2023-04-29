import java.io.*;

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

    public boolean verificarLogin(String usuario, String Contraseña)
    {
        boolean resultado = false;
        FileReader reader = null;
        BufferedReader bufferedReader = null;
        try 
        {
            File archivo = new File("C:\\Users\\monos\\OneDrive\\Escritorio\\TurismoLocal\\Documentos\\Login.txt");
            reader = new FileReader(archivo);
            bufferedReader = new BufferedReader(reader);
            String linea;
            while ((linea = bufferedReader.readLine()) != null) 
            {
                String[] credenciales = linea.split(":");
                if (credenciales[0].equals(usuario) && credenciales[1].equals(Contraseña)) 
                {
                    resultado = true;
                    break;
                }
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        } 
        finally 
        {
            try {
                if (bufferedReader != null) 
                {
                    bufferedReader.close();
                }
                if (reader != null) 
                {
                    reader.close();
                }
            } 
            catch (IOException ex) 
            {
                ex.printStackTrace();
            }
        }
        return resultado;
    }

    public boolean registrarLogin(String usuario, String Contraseña)
    {
        boolean resultado = false;
        FileWriter writer = null;
        try {
            File archivo = new File("C:\\Users\\monos\\OneDrive\\Escritorio\\TurismoLocal\\Documentos\\Login.txt");
            writer = new FileWriter(archivo, true);
            writer.write(usuario + ":" + Contraseña + "\n");
            resultado = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return resultado;
    }


}
