/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package examen.demo.service;

import examen.demo.domain.Evento;
import examen.demo.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public List<Evento> getAllEventos() {
        return eventoRepository.findAll();
    }

    public Optional<Evento> getEventoById(Long id) {
        return eventoRepository.findById(id);
    }

    public Evento createEvento(Evento evento) {
        return eventoRepository.save(evento);
    }

    public Optional<Evento> updateEvento(Long id, Evento eventoDetails) {
        return eventoRepository.findById(id).map(evento -> {
            evento.setNombre(eventoDetails.getNombre());
            evento.setDescripcion(eventoDetails.getDescripcion());
            evento.setTipo(eventoDetails.getTipo());
            evento.setFechaInicio(eventoDetails.getFechaInicio());
            evento.setFechaFin(eventoDetails.getFechaFin());
            evento.setCapacidad(eventoDetails.getCapacidad());
            return eventoRepository.save(evento);
        });
    }

    public void deleteEvento(Long id) {
        eventoRepository.deleteById(id);
    }
}
