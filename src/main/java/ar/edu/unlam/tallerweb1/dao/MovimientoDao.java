package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.EstadoMovimiento;
import ar.edu.unlam.tallerweb1.modelo.Movimiento;
import ar.edu.unlam.tallerweb1.modelo.TipoMovimiento;

public interface MovimientoDao {

	Movimiento guardarMovimiento(Movimiento movimiento);
	Movimiento actualizarMovimiento(Movimiento movimiento);
	Movimiento buscarIdMovimiento(Long idMovimiento);

	List<Movimiento> buscarMovimientosPorTipo(Long idTipoMovimiento);

	// Trae todos los movimientos del usuarioM
	List<Movimiento> buscarMovimientosPorUsuario(Long idUsuario);

	// Trae un movimiento especifico los movimientos del usuario M
	List<Movimiento> buscarMovimientosPorUsuario(Long idUsuario, int idTipoMovimiento);

	// Trae los remitos para los choferes
	List<Movimiento> buscarMovimientosParaChofer(Long idChofer);

	long getLastNumber();

	List<Movimiento> BuscarPresupuestosAceptados();

	Movimiento buscarMovimientosPorViaje(Long idViaje, int idTipoMovimiento);
	List<Movimiento> buscarMovimientosPorTipoyEstado(TipoMovimiento presupuesto,EstadoMovimiento estadoMovimiento );
}
