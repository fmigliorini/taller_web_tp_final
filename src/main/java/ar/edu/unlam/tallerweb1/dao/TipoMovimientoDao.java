package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.TipoMovimiento;

public interface TipoMovimientoDao {
	List<TipoMovimiento> listarTiposMovimientos();

	TipoMovimiento buscarPorId(int id);
	
	TipoMovimiento buscarPorDescripcion(String descripcion);
}