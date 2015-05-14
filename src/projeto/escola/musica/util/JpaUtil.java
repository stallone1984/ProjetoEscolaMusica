package projeto.escola.musica.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	public static EntityManager getEntityManager(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("projeto_escola_musica");
		
		return factory.createEntityManager();
	}
}
