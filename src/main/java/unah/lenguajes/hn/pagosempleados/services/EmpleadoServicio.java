package unah.lenguajes.hn.pagosempleados.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes.hn.pagosempleados.models.Empleado;
import unah.lenguajes.hn.pagosempleados.models.HistoricoPago;
import unah.lenguajes.hn.pagosempleados.repositories.EmpleadoRepositorio;
import unah.lenguajes.hn.pagosempleados.repositories.HistoricoPagoRepositorio;

@Service
public class EmpleadoServicio {
    @Autowired
    private EmpleadoRepositorio empleadoRepositorio;

    @Autowired
    private HistoricoPagoRepositorio pagoRepositorio;

    public Empleado crearEmpleado(Empleado nvoEmpleado){
        List<HistoricoPago> nvoPago = nvoEmpleado.getHistoricoPago();
        if (nvoPago != null){
            for (HistoricoPago pago: nvoPago){
                pago.setEmpleado(nvoEmpleado);
                this.pagoRepositorio.save(pago);
            }
        }
        return this.empleadoRepositorio.save(nvoEmpleado);
    }

    public String eliminarEmpleado(String dni){
        if (this.empleadoRepositorio.existsById(dni)){
            Empleado empleadoEliminar = this.empleadoRepositorio.findById(dni).get() ;
            this.empleadoRepositorio.delete(empleadoEliminar);
            return "Se ha eliminado el empleado";
        }
        return "No se pudo eliminar el empleado";
    }

    public Empleado buscarEmpleado(String dni){
        if (this.empleadoRepositorio.existsById(dni)){
            return this.empleadoRepositorio.findById(dni).get();
        }
        return null;
    }

    public List<Empleado> obtenerTodos(){
        return this.empleadoRepositorio.findAll();
    }
}
