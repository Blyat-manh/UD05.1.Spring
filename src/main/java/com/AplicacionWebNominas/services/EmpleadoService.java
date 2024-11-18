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

    public List<Empleado> obtenerEmpleados() throws Exception {
        return empleadoDAO.obtenerEmpleado();
    }

    public Optional<Empleado> obtenerEmpleado(String dni) throws Exception {
        return empleadoDAO.obtenerEmpleado(dni);
    }

    public List<Empleado> buscarEmpleadosPorDNI(String dni) throws Exception {
        return empleadoDAO.buscarEmpleadosPorDNI(dni);
    }

    public boolean actualizarEmpleado(Empleado empleado) throws Exception {
        return empleadoDAO.actualizarEmpleado(empleado);
    }

    public int calcularSalario(Empleado empleado) {
        return NominaService.sueldo(empleado);
    }

	public int calcularSalario(Optional<Empleado> empleado) {
		return 0;
	}
}
