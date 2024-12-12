package examen.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository; 
import examen.demo.domain.Rol;
import org.springframework.stereotype.Repository; 

@Repository 
public interface RolRepository extends JpaRepository<Rol, Long> {
    
}
