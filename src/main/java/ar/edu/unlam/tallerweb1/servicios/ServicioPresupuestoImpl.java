package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.PresupuestoDao;
import ar.edu.unlam.tallerweb1.modelo.Presupuesto;

@Service("servicioPresupusto")
@Transactional
public class ServicioPresupuestoImpl implements ServicioPresupuesto {
	
	@Inject
	private PresupuestoDao presupuestoDao;
	
	public Presupuesto guardarPresupusto(Presupuesto presupuesto)
	{
		return presupuestoDao.guardarPresupusto(presupuesto);
	}
}
