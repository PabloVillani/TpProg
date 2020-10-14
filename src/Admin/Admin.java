package Admin;

import Citizen.Citizen;
//Objeto de admin, con sus capacidades de trabajo.
public class Admin  {
    String user;
    String password;

    public Admin(String user, String password){
        this.password = password;
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public void unLock(Citizen c) { //Desbloquea el usuario.
        c.setBloqueado(false);
    }

}
