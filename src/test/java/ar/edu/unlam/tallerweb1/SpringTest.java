package ar.edu.unlam.tallerweb1;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ar.edu.unlam.tallerweb1.modelo.Barrio;
import ar.edu.unlam.tallerweb1.modelo.Comuna;
import ar.edu.unlam.tallerweb1.modelo.Direccion;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;
import ar.edu.unlam.tallerweb1.modelo.Punto;

// Se indica que los test que hereden de esta clase corran con el runner de junit para spring.
@RunWith(SpringJUnit4ClassRunner.class)
// Se indica
@ContextConfiguration(locations = {"/test-applicationContext.xml"})
// Clase base para los test que se pretende que se corran dentro del contexto de spring
public abstract class SpringTest {

    // Tiene inyectado el session factory para que los test que hereden de éste tengan acceso al mismo
    @Inject
    private SessionFactory sessionFactory;

    // Metodo para obtener una sesion de base de datos
    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    protected void saveDataForTest(){
    	Comuna comuna1= new Comuna();
		comuna1.setNombre("Comuna 1");
		
		Comuna comuna2= new Comuna();
		comuna2.setNombre("Comuna 2");
		
		Barrio barrio1 = new Barrio();
	    barrio1.setNombre("San Justo");
	    barrio1.setComuna(comuna1);
	    
		Barrio barrio2 = new Barrio();
	    barrio2.setNombre("Ramos Mejia");
	    barrio2.setComuna(comuna1);
	    
	    Barrio barrio3 = new Barrio();
	    barrio3.setNombre("Moron");
	    barrio3.setComuna(comuna2);
	    
	    Direccion direccion1 = new Direccion();
	    direccion1.setBarrio(barrio1);
	    direccion1.setCalle("Calle1");
	    direccion1.setNumero("numero1");
	    
	    Direccion direccion2 = new Direccion();
	    direccion2.setBarrio(barrio2);
	    direccion2.setCalle("Calle2");
	    direccion2.setNumero("numero2");
	    
	    Direccion direccion3 = new Direccion();
	    direccion3.setBarrio(barrio3);
	    direccion3.setCalle("Calle3");
	    direccion3.setNumero("numero3");
	    
	    Direccion direccion4 = new Direccion();
	    direccion4.setBarrio(barrio2);
	    direccion4.setCalle("Calle4");
	    direccion4.setNumero("numero4");
	    
	    
	    Punto punto1 = new Punto();
	    punto1.setLatitud("latitud1");
	    punto1.setLongitud("longitud1");
	    
	    Punto punto2 = new Punto();
	    punto2.setLatitud("latitud2");
	    punto2.setLongitud("longitud2");
	    
	    Punto punto3 = new Punto();
	    punto3.setLatitud("latitud3");
	    punto3.setLongitud("longitud3");
	   
	    Punto punto4 = new Punto();
	    punto4.setLatitud("latitud4");
	    punto4.setLongitud("longitud4");
	    
	    Farmacia farmacia1 = new Farmacia();
	    farmacia1.setDiaDeTurno("Martes");
	    farmacia1.setNombre("Farmacia 1");
	    farmacia1.setTelefono("telefono1");
	    farmacia1.setPunto(punto1);
	    farmacia1.setDireccion(direccion1);
	    
	    Farmacia farmacia2 = new Farmacia();
	    farmacia2.setDiaDeTurno("Martes");
	    farmacia2.setNombre("Farmacia 2");
	    farmacia2.setTelefono("telefono2");
	    farmacia2.setPunto(punto2);
	    farmacia2.setDireccion(direccion2);
	    
	    Farmacia farmacia3 = new Farmacia();
	    farmacia3.setDiaDeTurno("Martes");
	    farmacia3.setNombre("Farmacia 3");
	    farmacia3.setTelefono("telefono3");
	    farmacia3.setPunto(punto3);
	    farmacia3.setDireccion(direccion3);
	    
	    Farmacia farmacia4 = new Farmacia();
	    farmacia4.setDiaDeTurno("Lunes");
	    farmacia4.setNombre("Farmacia 2");
	    farmacia4.setTelefono("telefono2");
	    farmacia4.setPunto(punto2);
	    farmacia4.setDireccion(direccion2);
	    
	    getSession().save(comuna1);
	    getSession().save(comuna2);
	    getSession().save(barrio1);
	    getSession().save(barrio2);
	    getSession().save(barrio3);
	    getSession().save(direccion1);
	    getSession().save(direccion2);
	    getSession().save(direccion3);
	    getSession().save(direccion4);
	    
	    getSession().save(punto1);
	    getSession().save(punto2);
	    getSession().save(punto3);
	    getSession().save(punto4);
	    
	    getSession().save(farmacia1);
	    getSession().save(farmacia2);
	    getSession().save(farmacia3);
	    getSession().save(farmacia4);
    }
}
