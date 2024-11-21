package com.aplicacionnominas.empresa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.aplicacionnominas.empresa.model.Empleado;
import com.aplicacionnominas.empresa.repository.EmpleadoService;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping
    public String listarEmpleados(Model model) {
        model.addAttribute("empleados", empleadoService.obtenerTodos());
        return "empleados/lista";
    }

    @GetMapping("/{dni}")
    public String verEmpleado(@PathVariable String dni, Model model) {
        Empleado empleado = empleadoService.obtenerPorDni(dni);
        if (empleado != null) {
            model.addAttribute("empleado", empleado);
            model.addAttribute("salario", empleadoService.calcularSalario(empleado));
        }
        return "empleados/detalle";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("empleado", new Empleado());
        return "empleados/formulario";
    }

    @PostMapping
    public String guardarEmpleado(Empleado empleado) {
        empleadoService.guardarEmpleado(empleado);
        return "redirect:/empleados";
    }

    @GetMapping("/eliminar/{dni}")
    public String eliminarEmpleado(@PathVariable String dni) {
        empleadoService.eliminarEmpleado(dni);
        return "redirect:/empleados";
    }
}