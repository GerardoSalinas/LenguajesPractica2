Desarrolle una base de datos que permita manejar los pagos históricos que se hacen a los
empleados, para lo cual deberá diseñar las siguientes tablas:


Con base en lo anterior usted deberá crear: Modelos, Repositorios, servicios y
controladores que permitan realizar estas tareas:
- Método para crear empleados
    - Parámetros: Json con las propiedades del empleado
- b. Método para eliminar empleados
    - Parámetros: id de empleado a eliminar
- c. Método para buscar Empleado (deberá devolver el historial de pagos)
    - Parámetros: id de empleado a buscar
- d. Método para obtener todos los empleados (deberá incluir el historial de pagos de
todos los empleados)
    - Parámetros: Ninguno
- e. Método para obtener los pagos de un empleado en una fecha específica
    - Parámetros: Json Request
``` 
{
    “idEmpleado: “idEmpleado”,
    “fechaInicio”: “fechaInicio”,
    “fechaFin”: “fechaFin”
} 
```

- f. Método para crear pago de empleado:
Parámetros: Json request
```
{
    “idEmpleado” : “idEmpleado”,
    “horasTrabajadas” : “999”,
    “precioPorHora” : “999.99”
}
```

Usted deberá validar que el empleado exista, de igual forma que tanto horas
trabajadas como precio por hora sean mayor que 0.
El método deberá calcular el total (horasTrabajadas * precioPorHora) y la fecha
deberá tomarla del sistema.