package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.Statement;

import java.sql.Date;
import java.util.ArrayList;
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
		String query = "SELECT u.id , u.apellido, u.nombre , u.direccion , u.dni , u.email , u.password, u.rol , u.telefono FROM usuario u LEFT JOIN  vehiculo v ON v.chofer_id=u.id WHERE u.rol='chofer'";
		List<Object[]> rows = session.createSQLQuery(query).list();
		List<Usuario> usuarios = new ArrayList<Usuario>();

		for(Object[] row : rows){
			Usuario u = new Usuario();
			u.setId(Long.parseLong(row[0].toString()));
			u.setApellido(row[1].toString());
			u.setNombre(row[2].toString());
			u.setDireccion(row[3].toString());
			u.setDni(row[4].toString());
			u.setEmail(row[5].toString());
			u.setPassword(row[6].toString());
			u.setRol(row[7].toString());
			u.setTelefono(row[8].toString());
			usuarios.add(u);
		}
		return usuarios;
	}

	@Override
	public Usuario consultarUsuarioPorEmail(Usuario usuario) {
		final Session session=sessionFactory.getCurrentSession();
		return (Usuario) sessionFactory.getCurrentSession().createCriteria(Usuario.class)
				.add(Restrictions.eq("email", usuario.getEmail()))
				.uniqueResult();
	}

}