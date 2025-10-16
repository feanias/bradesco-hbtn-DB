package models;

import com.gestao.cursos.entities.Aluno;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class AlunoModel {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("gestao-cursos-jpa");

    public void create(Aluno aluno) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(aluno);
            em.getTransaction().commit();
            System.out.println("✅ Aluno criado com sucesso!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("❌ Erro ao criar aluno: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public Aluno findById(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Aluno.class, id);
        } finally {
            em.close();
        }
    }

    public List<Aluno> findAll() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("FROM Aluno", Aluno.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void update(Aluno aluno) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(aluno);
            em.getTransaction().commit();
            System.out.println("✅ Aluno atualizado com sucesso!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("❌ Erro ao atualizar aluno: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void delete(Aluno aluno) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Aluno a = em.find(Aluno.class, aluno.getId());
            if (a != null) {
                em.remove(a);
                System.out.println("✅ Aluno removido com sucesso!");
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("❌ Erro ao deletar aluno: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}