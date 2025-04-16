package model.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UsuarioEntity {
    private Integer id;
    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private LocalDateTime fechaCreacion;
    private CredentialEntity credentialEntity;
    private List<CuentaEntity> cuentas;

    public UsuarioEntity(){

    }

    public UsuarioEntity(Integer id,String nombre,String apellido,String dni,String email,LocalDateTime fechaCreacion,
                         CredentialEntity credentialEntity){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.fechaCreacion = fechaCreacion;
        this.credentialEntity = credentialEntity;
        this.cuentas =  new ArrayList<>();
    }

    //GETTERS
    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public CredentialEntity getCredentialEntity() {
        return credentialEntity;
    }

    public List<CuentaEntity> getCuentas() {
        return cuentas;
    }

    //SETTERS
    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setCredentialEntity(CredentialEntity credentialEntity) {
        this.credentialEntity = credentialEntity;
    }

    public void setCuentas(List<CuentaEntity> cuentas) {
        this.cuentas = cuentas;
    }

    //TOSTRING
    @Override
    public String toString() {
        return "UsuarioEntity[" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", email='" + email + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", credencial=" + credentialEntity +
                ", cuentas=" + cuentas +
                "]";
    }
}
