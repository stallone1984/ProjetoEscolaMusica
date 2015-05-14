package projeto.escola.musica.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import projeto.escola.musica.modelo.Cidade;
import projeto.escola.musica.modelo.Curso;
import projeto.escola.musica.modelo.Estado;
import projeto.escola.musica.util.JpaUtil;

public class CursoDao {

	public static void salvar(Curso curso){
		EntityManager manager = JpaUtil.getEntityManager();
		
		manager.getTransaction().begin();
		
		manager.persist(curso);
		
		manager.getTransaction().commit();
		
		manager.close();
	}
	
	public static List<Curso> listarTodas(){
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		Query query = manager.createQuery("from Curso");
		
		List<Curso> cursos = query.getResultList();
		
		manager.close();
		
		return cursos;
	}
	
}
