package examen.demo.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import examen.demo.domain.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
   
}

