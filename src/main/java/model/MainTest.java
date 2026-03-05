package model;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainTest {



        public static void main(String[] args) {
            // Cette ligne force Hibernate à lire persistence.xml et à se connecter à MySQL
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
            EntityManager em = emf.createEntityManager();

            System.out.println(">>> Connexion réussie et tables créées !");

            em.close();
            emf.close();
        }
    }

