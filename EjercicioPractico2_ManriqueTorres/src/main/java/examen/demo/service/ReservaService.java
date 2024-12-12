package examen.demo.service;

import examen.demo.domain.Reserva;
import examen.demo.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> getAllReservas() {
        return reservaRepository.findAll();
    }

    public Optional<Reserva> getReservaById(Long id) {
        return reservaRepository.findById(id);
    }

    public Reserva createReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public Optional<Reserva> updateReserva(Long id, Reserva reservaDetails) {
        return reservaRepository.findById(id).map(reserva -> {
            reserva.setUsuario(reservaDetails.getUsuario());
            reserva.setEvento(reservaDetails.getEvento());
            reserva.setFechaReserva(reservaDetails.getFechaReserva());
            return reservaRepository.save(reserva);
        });
    }

    public void deleteReserva(Long id) {
        reservaRepository.deleteById(id);
    }
}
