package model.repositories.impl;

import config.DBConnection;
import model.entities.CredentialEntity;
import model.entities.enums.Permiso;
import model.repositories.interfaces.IRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CredentialRepository implements IRepository<CredentialEntity> {

    private final Connection connection;

    public CredentialRepository(){
        this.connection = DBConnection.getInstance().getConnection();
    }

    @Override
    public void save(CredentialEntity credentialEntity) throws SQLException{
        String sql = "INSERT INTO credenciales (id_usuario,username,password,permiso) VALUES (?,?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1,credentialEntity.getId_usuario());
            stmt.setString(2,credentialEntity.getUsername());
            stmt.setString(3,credentialEntity.getPassword());
            stmt.setString(4,credentialEntity.getPermiso().toString());
            stmt.execute();
        }
    }

    @Override
    public List<CredentialEntity> findAll()throws SQLException{
        List<CredentialEntity> credenciales = new ArrayList<>();
        String sql = "SELECT * FROM credenciales";
        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                credenciales.add(new CredentialEntity(
                        rs.getInt("id_credencial"),
                        rs.getInt("id_usuario"),
                        rs.getString("username"),
                        rs.getString("password"),
                        Permiso.valueOf(rs.getString("permiso"))));
            }
        }
        return credenciales;
    }

    @Override
    public Optional<CredentialEntity> findById(Integer id)throws SQLException{
        String sql = "SELECT * FROM credenciales WHERE id_credencial = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1,id);
            try (ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    return Optional.of(new CredentialEntity(
                            rs.getInt("id_credencial"),
                            rs.getInt("id_usuario"),
                            rs.getString("username"),
                            rs.getString("password"),
                            Permiso.valueOf(rs.getString("permiso"))));
                }
            }
        }
        return Optional.empty();
    }

    public Optional<CredentialEntity> findByUserId(Integer id_usuario)throws SQLException{
        String sql = "SELECT * FROM credenciales WHERE id_usuario = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1,id_usuario);
            try (ResultSet rs = stmt.executeQuery()){
                if (rs.next()){
                    return Optional.of(new CredentialEntity(
                            rs.getInt("id_credencial"),
                            rs.getInt("id_usuario"),
                            rs.getString("username"),
                            rs.getString("password"),
                            Permiso.valueOf(rs.getString("permiso"))));
                }
            }
        }
        return Optional.empty();
    }

    public Optional<CredentialEntity> findByUsername(String username)throws SQLException{
        String sql = "SELECT * FROM credenciales WHERE username = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1,username);
            try (ResultSet rs = stmt.executeQuery()){
                if (rs.next()){
                    return Optional.of(new CredentialEntity(
                            rs.getInt("id_credencial"),
                            rs.getInt("id_usuario"),
                            rs.getString("username"),
                            rs.getString("password"),
                            Permiso.valueOf(rs.getString("permiso"))));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public void update(CredentialEntity credentialEntity) throws SQLException{
        String sql = "UPDATE credenciales SET username = ?,password = ?,permiso = ?, WHERE id_credencial = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, credentialEntity.getUsername());
            stmt.setString(2, credentialEntity.getPassword());
            stmt.setString(3,credentialEntity.getPermiso().toString());
            stmt.setLong(4,credentialEntity.getId());
            stmt.execute();
        }
    }

    @Override
    public void delete(CredentialEntity credentialEntity) throws SQLException{
        String sql = "DELETE FROM credenciales WHERE id_credencial = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1,credentialEntity.getId());
            stmt.execute();
        }
    }
}
