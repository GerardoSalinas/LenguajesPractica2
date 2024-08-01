package unah.lenguajes.hn.pagosempleados.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes.hn.pagosempleados.models.Empleado;
import unah.lenguajes.hn.pagosempleados.models.HistoricoPago;
import unah.lenguajes.hn.pagosempleados.repositories.EmpleadoRepositorio;
import unah.lenguajes.hn.pagosempleados.repositories.HistoricoPagoRepositorio;

@Service
public class HistoricoPagoServicio {
    
    @Autowired
    private HistoricoPagoRepositorio pagoRepositorio;

    @Autowired
    private EmpleadoRepositorio empleadoRepositorio;

    public HistoricoPago crearPago(HistoricoPago nvoPago){
        Empleado empleadoActual = nvoPago.getEmpleado();
        if (this.empleadoRepositorio.existsById(empleadoActual.getDni())){
            if (nvoPago.getHorasTrabajadas() != 0 && nvoPago.getPrecioPorHora() != 0){
                empleadoActual = this.empleadoRepositorio.findById(empleadoActual.getDni()).get();
                nvoPago.setEmpleado(empleadoActual);
                nvoPago.setTotalSueldo(nvoPago.getHorasTrabajadas()*nvoPago.getPrecioPorHora());
                LocalDate fecha = LocalDate.now();
                nvoPago.setFechaPago(fecha);
                empleadoActual.getHistoricoPago().add(nvoPago);
                return this.pagoRepositorio.save(nvoPago);
            }
        }
        return null;
    }

    public List<HistoricoPago> obtenerPagosEmpleado(HistoricoPago pago){
        Empleado empleadoActual = pago.getEmpleado();
        if (this.empleadoRepositorio.existsById(empleadoActual.getDni())){
            return empleadoActual.getHistoricoPago();
        }
        return null;
    }

}
