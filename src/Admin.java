import Ciudadano.Ciudadano;

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

    public void desbloquear(Ciudadano c) {

    }

}
