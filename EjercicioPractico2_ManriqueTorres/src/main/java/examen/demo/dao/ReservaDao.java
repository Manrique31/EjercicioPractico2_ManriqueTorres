package examen.demo.dao;

package examen.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import examen.demo.domain.Reserva;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
