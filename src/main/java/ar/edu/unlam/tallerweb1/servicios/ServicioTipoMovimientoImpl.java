package ar.edu.unlam.tallerweb1.servicios;


import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.TipoMovimientoDao;
import ar.edu.unlam.tallerweb1.modelo.TipoMovimiento;

@Service("servicioTipoMovimiento")
@Transactional
public class ServicioTipoMovimientoImpl implements ServicioTipoMovimiento {

	@Inject
	private TipoMovimientoDao tipoMovimientoDao;

	public List<TipoMovimiento> listarTiposMovimientos(){
		return tipoMovimientoDao.listarTiposMovimientos();
	}
	
	public TipoMovimiento buscarPorId(Long id){
		return tipoMovimientoDao. buscarPorId(id);
	}
	
}
