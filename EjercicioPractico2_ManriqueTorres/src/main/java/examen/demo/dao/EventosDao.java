package examen.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import examen.demo.domain.Evento;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
    
}
