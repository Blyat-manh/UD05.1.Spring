package com.example.empresa2.model;

import jakarta.persistence.*;

@Entity
@Table(name="empleado")
public class Empleado {

    @Id
    private String dni;
    private String nombre;
    
    private String sexo;
    private String categoria;
    private int aniosTrabajados;
    private double salario;

   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    // Método para calcular salario basado en categoría y años trabajados
    public void calcularSalario() {
        // Por ejemplo: salario base + incremento por años trabajados
        double salarioBase = 2000;
        double incremento = this.aniosTrabajados * 100; // 100 por cada año trabajado
        this.salario = salarioBase + incremento;
    }
}
