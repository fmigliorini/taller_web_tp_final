package ar.edu.unlam.tallerweb1.servicios;


import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.EstadoMovimientoDao;
import ar.edu.unlam.tallerweb1.modelo.EstadoMovimiento;

@Service("EstadoTipoMovimiento")
@Transactional
public class ServicioEstadoMovimientoImpl implements ServicioEstadoMovimiento {

	@Inject
	private EstadoMovimientoDao estadoMovimientoDao;

	public List<EstadoMovimiento> listarEstadosMovimientos(){
		return estadoMovimientoDao.listarEstadosMovimientos();
	}
	
	public EstadoMovimiento buscarPorId(int id){
		return estadoMovimientoDao.buscarPorId(id);
	}
	
}