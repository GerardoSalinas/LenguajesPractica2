package unah.lenguajes.hn.pagosempleados.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import unah.lenguajes.hn.pagosempleados.models.Empleado;

public interface EmpleadoRepositorio extends JpaRepository<Empleado, String> {
    
}
