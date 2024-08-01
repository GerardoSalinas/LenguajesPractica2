package unah.lenguajes.hn.pagosempleados.repositories;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import unah.lenguajes.hn.pagosempleados.models.HistoricoPago;

public interface HistoricoPagoRepositorio extends JpaRepository<HistoricoPago, LocalDate> {
    
}
