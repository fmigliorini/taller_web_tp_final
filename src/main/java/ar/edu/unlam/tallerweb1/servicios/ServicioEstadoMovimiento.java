package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.EstadoMovimiento;

public interface ServicioEstadoMovimiento {

	List<EstadoMovimiento> listarEstadosMovimientos();

	EstadoMovimiento buscarPorId(int id);

	EstadoMovimiento buscarPorDescripcion(String descripcion);
}
