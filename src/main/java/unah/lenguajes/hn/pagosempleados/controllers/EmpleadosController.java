package unah.lenguajes.hn.pagosempleados.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.lenguajes.hn.pagosempleados.models.Empleado;
import unah.lenguajes.hn.pagosempleados.services.EmpleadoServicio;

@RestController
@RequestMapping("api/empleados")
public class EmpleadosController {
    @Autowired
    private EmpleadoServicio empleadoServicio;

    @PostMapping("/crear")
    public Empleado crearEmpleado(@RequestBody Empleado nvoEmpleado){
        return this.empleadoServicio.crearEmpleado(nvoEmpleado);
    }

    @DeleteMapping("/eliminar/{dni}")
    public String eliminarEmpleado(@PathVariable(name="dni") String dni){
        return this.empleadoServicio.eliminarEmpleado(dni);
    }

    @GetMapping("/buscar/{dni}")
    public Empleado buscarEmpleado(@PathVariable(name="dni") String dni){
        return this.empleadoServicio.buscarEmpleado(dni);
    }

    @GetMapping("/todos")
    public List<Empleado> obtenerTodos(){
        return this.empleadoServicio.obtenerTodos();
    }
}
