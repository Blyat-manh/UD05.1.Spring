package com.AplicacionWebNominas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.AplicacionWebNominas.model.Empleado;
import com.AplicacionWebNominas.services.EmpleadoService;

@Controller
@RequestMapping("/Empresa")
public class EmpleadoController {

	@Autowired
	private EmpleadoService empleadoService;

	@GetMapping("/listar")
	public String listarEmpleados(Model model) throws Exception {
		model.addAttribute("empleados", empleadoService.obtenerEmpleados());
		return "listar";
	}

	@GetMapping("/empleado/salario")
	public String mostrarSalario(@RequestParam("dni") String dni, Model model) throws Exception {
		Optional<Empleado> empleado = empleadoService.obtenerEmpleado(dni);
		int salario = (empleado != null) ? empleadoService.calcularSalario(empleado) : 0;
		model.addAttribute("empleado", empleado);
		model.addAttribute("salario", salario);
		return "salario"; 
	}

	@GetMapping("/empleado/editar")
	public String editarEmpleado(@RequestParam("dni") String dni, Model model) throws Exception {
		Optional<Empleado> empleado = empleadoService.obtenerEmpleado(dni);
		if (empleado == null) {
			model.addAttribute("errorMessage", "Empleado no encontrado.");
			return "error";
		}
		model.addAttribute("empleado", empleado);
		return "editar";
	}

	@PostMapping("/empleado/buscar")
	public String buscarEmpleados(@RequestParam("dni") String dni, Model model) throws Exception {
		List<Empleado> empleados = empleadoService.buscarEmpleadosPorDNI(dni);
		if (empleados.isEmpty()) {
			model.addAttribute("errorMessage", "No se encontraron empleados con ese DNI.");
			return "buscarResultados";
		}
		model.addAttribute("empleados", empleados);
		return "buscarResultados";
	}

	@PostMapping("/empleado/actualizar")
	public String actualizarEmpleado(@ModelAttribute Empleado empleado, Model model) throws Exception {
		boolean actualizado = empleadoService.actualizarEmpleado(empleado);
		if (actualizado) {
			return "redirect:/empleados";
		} else {
			model.addAttribute("errorMessage", "No se pudo actualizar el empleado.");
			return "errorActualizar";
		}
	}
}
