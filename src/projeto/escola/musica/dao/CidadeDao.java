package projeto.escola.musica.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import projeto.escola.musica.modelo.Cidade;
import projeto.escola.musica.modelo.Estado;
import projeto.escola.musica.util.JpaUtil;

public class CidadeDao {

	public static void salvar(Cidade cidade){
		EntityManager manager = JpaUtil.getEntityManager();
		
		manager.getTransaction().begin();
		
		manager.persist(cidade);
		
		manager.getTransaction().commit();
		
		manager.close();
	}
	
	public static List<Cidade> listarTodas(){
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		Query query = manager.createQuery("from Cidade");
		
		List<Cidade> cidades = query.getResultList();
		
		manager.close();
		
		return cidades;
	}
	
	public static List<Cidade> listarPorEstado(Estado estado){
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		List<Cidade> cidades = manager
				.createQuery("from Cidade where uf = :uf", Cidade.class)
				.setParameter("uf", estado)
				.getResultList();
		
		manager.close();
		
		return cidades;
	}
	
	public static void main(String[] args) {
		Cidade cidade = new Cidade();
		
		cidade.setNome("S�o Jos� dos Campos");
		cidade.setUf(Estado.SAO_PAULO);
		salvar(cidade);
		
		/*for(Cidade cidade : listarPorEstado(Estado.SAO_PAULO)){
			System.out.println(cidade.getNome());
		}*/
	}
}
