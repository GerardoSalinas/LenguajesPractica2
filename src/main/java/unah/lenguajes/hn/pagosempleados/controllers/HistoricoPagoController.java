package unah.lenguajes.hn.pagosempleados.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.lenguajes.hn.pagosempleados.models.HistoricoPago;
import unah.lenguajes.hn.pagosempleados.services.HistoricoPagoServicio;

@RestController
@RequestMapping("/api/pagos")
public class HistoricoPagoController {
    
    @Autowired
    private HistoricoPagoServicio pagoServicio;

    @PostMapping("/crear")
    public HistoricoPago crearPago(@RequestBody HistoricoPago nvoPago){
        return this.pagoServicio.crearPago(nvoPago);
    }

    @GetMapping("/obtener")
    public List<HistoricoPago> obtenerPagosEmpleado(@RequestBody HistoricoPago pago){
        return this.pagoServicio.obtenerPagosEmpleado(pago);
    }
}
