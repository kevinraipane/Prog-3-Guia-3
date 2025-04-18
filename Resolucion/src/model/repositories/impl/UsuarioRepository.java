package model.repositories.impl;

import config.DBConnection;
import model.entities.UsuarioEntity;
import model.repositories.interfaces.IRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioRepository implements IRepository<UsuarioEntity> {
    private final Connection connection;

    public UsuarioRepository(){
        this.connection = DBConnection.getInstance().getConnection();
    }

    @Override
    public void save(UsuarioEntity usuarioEntity)throws SQLException{
        String sql = "INSERT INTO usuarios (id_usuario,nombre,apellido,dni,email) VALUES (?,?,?,?,?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setLong(1,usuarioEntity.getId());
            stmt.setString(2, usuarioEntity.getNombre());
            stmt.setString(3,usuarioEntity.getApellido());
            stmt.setString(4, usuarioEntity.getDni());
            stmt.setString(5, usuarioEntity.getEmail());
            stmt.execute();
        }
    }

    @Override
    public List<UsuarioEntity> findAll()throws SQLException{
        List<UsuarioEntity> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                usuarios.add(new UsuarioEntity(
                        rs.getInt("id_usuario"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("dni"),
                        rs.getString("email"),
                        rs.getTimestamp("fecha_creacion").toLocalDateTime()));
            }
        }
        return usuarios;
    }

    @Override
    public Optional<UsuarioEntity> findById(Integer id) throws SQLException{
        String sql = "SELECT * FROM usuarios WHERE id_usuario = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1,id);
            try (ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    return Optional.of(new UsuarioEntity(
                            rs.getInt("id_usuario"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getString("dni"),
                            rs.getString("email"),
                            rs.getTimestamp("fecha_creacion").toLocalDateTime()));
                }
            }
        }
        return Optional.empty();
    }

    //lanzo la excepcion en la funcion, no la manejo mas arriba
    public Integer findLastId(){
        String sql = "SELECT max(id_usuario) as id FROM usuarios";
        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            try (ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    return rs.getInt("id");
                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null; //Si no tengo registros
    }

    @Override
    public void update(UsuarioEntity usuarioEntity) throws SQLException{
        String sql = "UPDATE usuarios SET nombre = ?, apellido = ?, dni = ?, email = ?, WHERE id_usuario = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, usuarioEntity.getNombre());
            stmt.setString(2, usuarioEntity.getApellido());
            stmt.setString(3, usuarioEntity.getDni());
            stmt.setString(4, usuarioEntity.getEmail());
            stmt.setLong(5, usuarioEntity.getId());
            stmt.execute();
        }
    }

    @Override
    public void delete(UsuarioEntity usuarioEntity) throws SQLException{
        String sql = "DELETE FROM usuarios WHERE id_usuarios = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1,usuarioEntity.getId());
            stmt.execute();
        }
    }
}
