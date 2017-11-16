
package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.EstadoMovimiento;

public interface EstadoMovimientoDao {
	List<EstadoMovimiento> listarEstadosMovimientos();
	EstadoMovimiento buscarPorId(Long id);
}