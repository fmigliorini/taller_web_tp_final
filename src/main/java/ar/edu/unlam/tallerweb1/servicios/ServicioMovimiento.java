package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Movimiento;

public interface ServicioMovimiento {
	Movimiento guardarMovimiento(Movimiento mov);

	Movimiento actualizarMovimiento(Movimiento movimiento);
	Movimiento buscarIdMovimiento(Long idMovimiento);
	
	List<Movimiento> buscarMovimientosPorTipo(Long idTipoMovimiento);
	
	//Trae todos los movimientos del usuarioM
	List<Movimiento> buscarMovimientosPorUsuario(Long idUsuario);
	
	List<Movimiento>BuscarPresupuestosAceptados();
	//Trae un movimiento especifico los movimientos del usuario M
	List<Movimiento> buscarMovimientosPorUsuario(Long idUsuario,int idTipoMovimiento);
	
	//Trae los remitos para los choferes
	List<Movimiento> buscarMovimientosParaChofer(Long idChofer);
	
	long getLastNumber();
}
