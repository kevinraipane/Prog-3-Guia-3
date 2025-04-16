package model.entities;

import model.entities.enums.TipoCuenta;

import java.time.LocalDateTime;

public class CuentaEntity {
    private Integer id;
    private Integer id_usuario;
    private TipoCuenta tipoCuenta;
    private Double saldo;
    private LocalDateTime fechaCreacion;

    public CuentaEntity(){

    }

    public CuentaEntity(Integer id,Integer id_usuario,TipoCuenta tipoCuenta,Double saldo,LocalDateTime fechaCreacion){
        this.id = id;
        this.id_usuario = id_usuario;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
        this.fechaCreacion = fechaCreacion;
    }

    //GETTERS
    public Integer getId() {
        return id;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    //SETTERS
    public void setId(Integer id) {
        this.id = id;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return "CuentaEntity[" + "id=" + id + ", tipo=" + tipoCuenta + ", saldo=" + saldo +
                ", fechaCreacion=" + fechaCreacion + "]";
    }
}
