package com.AplicacionWebNominas.services;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AplicacionWebNominas.dao.EmpleadoDAO;
import com.AplicacionWebNominas.model.Empleado;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoDAO empleadoDAO;

    // Obtener todos los empleados
    public List<Empleado> obtenerEmpleados() throws Exception {
        return empleadoDAO.obtenerEmpleado();
    }

    // Obtener un empleado por su DNI
    public Optional<Empleado> obtenerEmpleado(String dni) throws Exception {
        return empleadoDAO.obtenerEmpleado(dni);
    }

    // Buscar empleados por DNI
    public List<Empleado> buscarEmpleadosPorDNI(String dni) throws Exception {
        return empleadoDAO.buscarEmpleadosPorDNI(dni);
    }

    // Actualizar un empleado
    public boolean actualizarEmpleado(Empleado empleado) throws Exception {
        return empleadoDAO.actualizarEmpleado(empleado);
    }

    // Calcular salario de un empleado
    public int calcularSalario(Empleado empleado) {
        return NominaService.sueldo(empleado); // Aquí puedes agregar más lógica si lo necesitas
    }

	public int calcularSalario(Optional<Empleado> empleado) {
		// TODO Auto-generated method stub
		return 0;
	}
}
