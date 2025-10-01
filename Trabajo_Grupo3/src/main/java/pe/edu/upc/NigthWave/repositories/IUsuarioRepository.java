package pe.edu.upc.NigthWave.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.NigthWave.entities.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

    public Usuario findOneByUsername(String username);

    // BUSCAR POR USERNAME
    @Query("SELECT COUNT(u) FROM Usuario u WHERE u.username = :username")
    int buscarUsername(@Param("username") String username);

    // INSERTAR ROL PARA UN USUARIO
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO roles (nombre_rol, user_id) VALUES (:rol, :user_id)", nativeQuery = true)
    void insRol(@Param("rol") String rol, @Param("user_id") int userId);
}

