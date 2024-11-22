package com.example.empresa2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.empresa2.model.Empleado;
import com.example.empresa2.service.EmpleadoService;

import java.util.List;

@Controller
@RequestMapping("/empresa")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    // Página principal
    @GetMapping("/")
    public String mostrarIndex() {
        return "index";
    }

    // Listar empleados
    @GetMapping("/empleados")
    public String listarEmpleados(Model model) {
        List<Empleado> empleados = empleadoService.obtenerTodosLosEmpleados();
        model.addAttribute("empleados", empleados);
        return "listar";
    }

    // Mostrar salario de un empleado
    @GetMapping("/empleados/salario")
    public String mostrarFormularioSalario() {
        return "salario";
    }

    @PostMapping("/empleados/salario")
    public String mostrarSalario(@RequestParam String dni, Model model) {
        Empleado empleado = empleadoService.obtenerEmpleadoPorDni(dni);
        if (empleado != null) {
            model.addAttribute("empleado", empleado);
        } else {
            model.addAttribute("error", "Empleado no encontrado");
        }
        return "salario";
    }

    // Modificar datos de un empleado
    @GetMapping("/empleados/modificar")
    public String mostrarFormularioModificar() {
        return "formulario";
    }

    @PostMapping("/empleados/modificar")
    public String modificarEmpleado(@ModelAttribute Empleado empleado) {
        empleadoService.guardarEmpleado(empleado);
        return "redirect:/empresa/empleados";
    }

    // Eliminar un empleado
    @GetMapping("/empleados/eliminar/{id}")
    public String eliminarEmpleado(@PathVariable String dni) {
        empleadoService.eliminarEmpleado(dni);
        return "redirect:/empresa/empleados";
    }
}
