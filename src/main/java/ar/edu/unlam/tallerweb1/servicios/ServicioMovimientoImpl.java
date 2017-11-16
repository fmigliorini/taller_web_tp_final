package ar.edu.unlam.tallerweb1.servicios;


import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.MovimientoDao;
import ar.edu.unlam.tallerweb1.modelo.Movimiento;

@Service("servicioMovimiento")
@Transactional
public class ServicioMovimientoImpl implements ServicioMovimiento {
	
	@Inject
	private MovimientoDao movimientoDao;
	
	public Movimiento guardarMovimiento(Movimiento mov)
	{
		return movimientoDao.guardarMovimiento(mov);
	}

	
	public Movimiento buscarIdMovimiento(Long idMovimiento){
		return movimientoDao.buscarIdMovimiento(idMovimiento);
	}
	
	public List<Movimiento> buscarMovimientosPorTipo(Long idTipoMovimiento)	{
		return movimientoDao.buscarMovimientosPorTipo(idTipoMovimiento);
	}
	
	//Trae todos los movimientos del usuarioM
	public List<Movimiento> buscarMovimientosPorUsuario(Long idUsuario)	{
		return movimientoDao.buscarMovimientosPorUsuario(idUsuario);
	}
	
	//Trae un movimiento especifico los movimientos del usuario M
	public List<Movimiento> buscarMovimientosPorUsuario(Long idUsuario,Long idTipoMovimiento)	{
		return movimientoDao.buscarMovimientosPorUsuario(idUsuario,idTipoMovimiento);
	}
	
	//Trae los remitos para los choferes
	public List<Movimiento> buscarMovimientosParaChofer(Long idChofer)	{
		return movimientoDao.buscarMovimientosParaChofer(idChofer);
	}
}
