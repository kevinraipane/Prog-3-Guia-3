package model.repositories.impl;

import config.DBConnection;
import model.entities.CuentaEntity;
import model.entities.enums.TipoCuenta;
import model.repositories.interfaces.IRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CuentaRepository implements IRepository<CuentaEntity> {
    private final Connection connection;

    public CuentaRepository(){
        this.connection = DBConnection.getInstance().getConnection();
    }

    @Override
    public void save(CuentaEntity cuentaEntity)throws SQLException{
        String sql = "INSERT INTO cuentas (id_cuenta,id_usuario,tipo,saldo) VALUES (?,?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1,cuentaEntity.getId());
            stmt.setInt(2,cuentaEntity.getId_usuario());
            stmt.setString(3,cuentaEntity.getTipoCuenta().toString());
            stmt.setDouble(4,cuentaEntity.getSaldo());
            stmt.execute();
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<CuentaEntity> findAll() throws SQLException{
        List<CuentaEntity> cuentas = new ArrayList<>();
        String sql = "SELECT * FROM cuentas";
        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                cuentas.add(new CuentaEntity(
                        rs.getInt("id_cuenta"),
                        rs.getInt("id_usuario"),
                        TipoCuenta.valueOf(rs.getString("tipo")),
                        rs.getDouble("saldo"),
                        rs.getTimestamp("fecha_creacion").toLocalDateTime()));
            }
        }
        return cuentas;
    }

    @Override
    public Optional<CuentaEntity> findById(Integer id) throws SQLException{
        String sql = "SELECT * FROM cuentas WHERE id_cuenta = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1,id);
            try (ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    return Optional.of(new CuentaEntity(
                            rs.getInt("id_cuenta"),
                            rs.getInt("id_usuario"),
                            TipoCuenta.valueOf(rs.getString("tipo")),
                            rs.getDouble("saldo"),
                            rs.getTimestamp("fecha_creacion").toLocalDateTime()));
                }
            }
            return Optional.empty();
        }
    }

    @Override
    public void update(CuentaEntity cuentaEntity) throws SQLException{
        String sql = "UPDATE cuentas SET saldo = ? WHERE id_cuenta = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setDouble(1,cuentaEntity.getSaldo());
            stmt.setInt(2,cuentaEntity.getId());
            stmt.execute();
        }
    }

    @Override
    public void delete(CuentaEntity cuentaEntity)throws SQLException{
        String sql = "DELETE FROM cuentas WHERE id_cuenta = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,cuentaEntity.getId());
            statement.execute();
        }
    }

    public List<CuentaEntity> findAllByUserId(Integer id_usuario)throws SQLException{
        List<CuentaEntity> cuentas = new ArrayList<>();
        String sql = "SELECT * FROM cuentas WHERE id_usuario = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1,id_usuario);
            try (ResultSet rs = stmt.executeQuery()){
                while (rs.next()){
                    cuentas.add(new CuentaEntity(
                            rs.getInt("id_cuenta"),
                            rs.getInt("id_usuario"),
                            TipoCuenta.valueOf(rs.getString("tipo")),
                            rs.getDouble("saldo"),
                            rs.getTimestamp("fecha_creacion").toLocalDateTime()));
                }
            }
        }
        return cuentas;
    }
}
