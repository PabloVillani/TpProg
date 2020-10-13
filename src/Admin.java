import Ciudadano.Ciudadano;
//Objeto de admin, con sus capacidades de trabajo.
public class Admin  {
    String usuario;
    String contra;

    public Admin(String usuario, String contra){
        this.contra = contra;
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContra() {
        return contra;
    }

    public void desbloquear(Ciudadano c) { //Desbloquea el usuario.
        c.setBloqueado(false);
    }

}
