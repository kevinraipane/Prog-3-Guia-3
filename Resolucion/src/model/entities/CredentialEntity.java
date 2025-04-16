package model.entities;

import model.entities.enums.Permiso;

public class CredentialEntity {
    //ATRIBUTOS
    private Integer id;
    private Integer id_usuario;
    private String username;
    private String password;
    private Permiso permiso;

    //CONSTRUCTOR
    public CredentialEntity(){

    }

    public CredentialEntity(Integer id,Integer id_usuario,String username,String password,Permiso permiso){
        this.id = id;
        this.id_usuario = id_usuario;
        this.username = username;
        this.password = password;
        this.permiso = permiso;
    }

    //GETTERS
    public Integer getId(){
        return id;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Permiso getPermiso() {
        return permiso;
    }

    //SETTERS
    public void setId(Integer id) {
        this.id = id;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }

    //TO STRING
    @Override
    public String toString(){
        return "Credenciales[" + "id=" + id + "id usuario=" + id_usuario + ", username='" + username +
                ", password=" + password + ", permiso=" + permiso + "]";
    }
}
