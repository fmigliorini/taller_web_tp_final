package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.TipoMovimiento;

public interface ServicioTipoMovimiento  {
	

	
	List<TipoMovimiento> listarTiposMovimientos();
	
	TipoMovimiento buscarPorId(Long id);

}
