package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.inject.Inject;

// implelemtacion del DAO de usuarios, la anotacion @Repository indica a Spring que esta clase es un componente que debe
// ser manejado por el framework, debe indicarse en applicationContext que busque en el paquete ar.edu.unlam.tallerweb1.dao
// para encontrar esta clase.
//implelemtacion del DAO de usuarios, la anotacion @Repository indica a Spring que esta clase es un componente que debe
//ser manejado por el framework, debe indicarse en applicationContext que busque en el paquete ar.edu.unlam.tallerweb1.dao
//para encontrar esta clase.
@Repository("usuarioDao")
public class UsuarioDaoImpl implements UsuarioDao {

	// Como todo dao maneja acciones de persistencia, normalmente estar�
	// inyectado el session factory de hibernate
	// el mismo est� difinido en el archivo hibernateContext.xml
	@Inject
	private SessionFactory sessionFactory;

	@Override
	public Usuario consultarUsuario(Usuario usuario) {

		// Se obtiene la sesion asociada a la transaccion iniciada en el
		// servicio que invoca a este metodo y se crea un criterio
		// de busqueda de Usuario donde el email y password sean iguales a los
		// del objeto recibido como parametro
		// uniqueResult da error si se encuentran m�s de un resultado en la
		// busqueda.
		final Session session = sessionFactory.getCurrentSession();
		return (Usuario) session.createCriteria(Usuario.class).add(Restrictions.eq("email", usuario.getEmail()))
				.add(Restrictions.eq("password", usuario.getPassword())).uniqueResult();
	}

	@Override
	public Usuario generarUsuario(Usuario usuario) {
		final Session session = sessionFactory.getCurrentSession();
		session.save(usuario);
		return usuario;
	}

	@Override
	public void actualizarUsuario(Usuario usuario) {
		final Session session = sessionFactory.getCurrentSession();
		session.update(usuario);

	}

	@Override
	public void eliminarUsuario(Usuario usuario) {
		final Session session = sessionFactory.getCurrentSession();
		session.delete(usuario);

	}

	@Override
	public Usuario buscarPorId(Long id) {
		final Session session = sessionFactory.getCurrentSession();
		return (Usuario) session.createCriteria(Usuario.class).add(Restrictions.eq("id", id)).uniqueResult();
	}

	@Override
	public List<Usuario> usuariosRol(String rol) {
		final Session session = sessionFactory.getCurrentSession();
		List<Usuario> usuarios = session.createCriteria(Usuario.class).add(Restrictions.eq("rol", rol)).list();
		return usuarios;
	}

	@Override
	public List<Usuario> listarChoferes() {
		final Session session = sessionFactory.getCurrentSession();
		List<Usuario> Usuarios = session.createCriteria(Usuario.class).add(Restrictions.eq("rol", "chofer")).list();
		return Usuarios;
	}

	@Override
	public List<Usuario> listarChoferesSinVehiculo() {
		final Session session = sessionFactory.getCurrentSession();
		List<Usuario> Usuarios = session.createCriteria(Usuario.class).createAlias("Vehiculo", "vehiculo")
				.add(Restrictions.eq("rol", "chofer")).add(Restrictions.eq("vehiculo", null)).list();
		return Usuarios;
	}

}