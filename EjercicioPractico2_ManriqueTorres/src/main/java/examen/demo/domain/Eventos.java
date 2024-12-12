package examen.demo.domain;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "eventos")
public class Eventos {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "tipo", nullable = false, length = 50)
    private String tipo;

    @Column(name = "fecha_inicio", nullable = false)
    private java.util.Date fechaInicio;

    @Column(name = "fecha_fin", nullable = false)
    private java.util.Date fechaFin;

    @Column(name = "capacidad", nullable = false)
    private Integer capacidad;
}
