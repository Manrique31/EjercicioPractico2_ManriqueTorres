package examen.demo.controller;

import examen.demo.domain.Evento;
import examen.demo.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {
    @Autowired
    private EventoRepository eventoRepository;

    @GetMapping
    public List<Evento> getAllEventos() {
        return eventoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> getEventoById(@PathVariable Long id) {
        Optional<Evento> evento = eventoRepository.findById(id);
        return evento.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Evento createEvento(@RequestBody Evento evento) {
        return eventoRepository.save(evento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evento> updateEvento(@PathVariable Long id, @RequestBody Evento eventoDetails) {
        Optional<Evento> evento = eventoRepository.findById(id);
        if (evento.isPresent()) {
            Evento eventoToUpdate = evento.get();
            eventoToUpdate.setNombre(eventoDetails.getNombre());
            eventoToUpdate.setDescripcion(eventoDetails.getDescripcion());
            eventoToUpdate.setTipo(eventoDetails.getTipo());
            eventoToUpdate.setFechaInicio(eventoDetails.getFechaInicio());
            eventoToUpdate.setFechaFin(eventoDetails.getFechaFin());
            eventoToUpdate.setCapacidad(eventoDetails.getCapacidad());
            return ResponseEntity.ok(eventoRepository.save(eventoToUpdate));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvento(@PathVariable Long id) {
        eventoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
