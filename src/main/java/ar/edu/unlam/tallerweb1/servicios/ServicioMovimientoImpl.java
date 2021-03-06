package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.MovimientoDao;
import ar.edu.unlam.tallerweb1.modelo.EstadoMovimiento;
import ar.edu.unlam.tallerweb1.modelo.Movimiento;
import ar.edu.unlam.tallerweb1.modelo.TipoMovimiento;

@Service("servicioMovimiento")
@Transactional
public class ServicioMovimientoImpl implements ServicioMovimiento {

	@Inject
	private MovimientoDao movimientoDao;

	public Movimiento guardarMovimiento(Movimiento mov) {
		return movimientoDao.guardarMovimiento(mov);
	}
	public Movimiento actualizarMovimiento(Movimiento mov)
	{
		return movimientoDao.actualizarMovimiento(mov);
	}

	public Movimiento buscarIdMovimiento(Long idMovimiento) {
		return movimientoDao.buscarIdMovimiento(idMovimiento);
	}

	public List<Movimiento> buscarMovimientosPorTipo(Long idTipoMovimiento) {
		return movimientoDao.buscarMovimientosPorTipo(idTipoMovimiento);
	}

	// Trae todos los movimientos del usuarioM
	public List<Movimiento> buscarMovimientosPorUsuario(Long idUsuario) {
		return movimientoDao.buscarMovimientosPorUsuario(idUsuario);
	}

	// Trae un movimiento especifico los movimientos del usuario M
	public List<Movimiento> buscarMovimientosPorUsuario(Long idUsuario, int idTipoMovimiento) {
		return movimientoDao.buscarMovimientosPorUsuario(idUsuario, idTipoMovimiento);
	}

	// Trae los remitos para los choferes
	public List<Movimiento> buscarMovimientosParaChofer(Long idChofer) {
		return movimientoDao.buscarMovimientosParaChofer(idChofer);
	}

	public List<Movimiento> BuscarPresupuestosAceptados() {
		return movimientoDao.BuscarPresupuestosAceptados();
	}

	public Movimiento buscarMovimientosPorViaje(Long idViaje, int idTipoMovimiento) {
		return movimientoDao.buscarMovimientosPorViaje(idViaje, idTipoMovimiento);
	}

	public long getLastNumber() {

		return movimientoDao.getLastNumber();
	}
	
	public List<Movimiento> buscarMovimientosPorTipoyEstado(TipoMovimiento presupuesto,EstadoMovimiento estadoMovimiento ){
		return movimientoDao.buscarMovimientosPorTipoyEstado(presupuesto, estadoMovimiento);
	}
}
