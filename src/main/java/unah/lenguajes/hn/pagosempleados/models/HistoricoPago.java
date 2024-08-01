package unah.lenguajes.hn.pagosempleados.models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="historicopago")
@Data
public class HistoricoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="fechapago")
    private LocalDate fechaPago;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="dni", referencedColumnName = "dni")
    private Empleado empleado;

    @Column(name="horastrabajadas")
    private long horasTrabajadas;

    @Column(name="precioporhora")
    private double precioPorHora;

    @Column(name="totalsueldo")
    private double totalSueldo;

}
