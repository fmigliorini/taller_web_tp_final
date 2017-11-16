package ar.edu.unlam.tallerweb1.servicios;

import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Presupuesto;
@Service
public interface ServicioPresupuesto {
	Presupuesto guardarPresupusto(Presupuesto presupuesto);
}
