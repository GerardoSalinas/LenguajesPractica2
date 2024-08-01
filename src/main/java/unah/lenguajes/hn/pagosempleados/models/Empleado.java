package unah.lenguajes.hn.pagosempleados.models;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="empleado")
@Data
public class Empleado {
    
    @Id
    @Column(name="dni")
    private String dni;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="apellido")
    private String apellido;
    
    @Column(name="fechaingreso")
    private LocalDate fechaIngreso;

    //@JsonIgnore
    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL)
    private List<HistoricoPago> historicoPago;

    
}
