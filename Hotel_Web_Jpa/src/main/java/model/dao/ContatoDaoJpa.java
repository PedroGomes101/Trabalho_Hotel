    package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Hospede;

public class ContatoDaoJpa implements InterfaceDao<Hospede> {

    @Override
    public void incluir(Hospede entidade) throws Exception {
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entidade);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void editar(Hospede entidade) throws Exception {
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(entidade);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void excluir(Hospede entidade) throws Exception {
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();

            Hospede c1 = em.find(Hospede.class, entidade.getId());
            em.remove(c1);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public Hospede pesquisarPorId(int id) throws Exception {
        Hospede c = null;
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();

            c = em.find(Hospede.class, id);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return c;
    }

    @Override
    public List<Hospede> listar() throws Exception {
        List<Hospede> lista = null;
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            lista = em.createQuery("FROM Hospede c").getResultList();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return lista;
    }

    @Override
    public List<Hospede> filtrarPorNome(String nome) throws Exception {
        EntityManager em = ConnFactory.getEntityManager();

        Query query = em.createNamedQuery("Hospede.filtrarPorNome");
        query.setParameter("nome", nome);
        List<Hospede> resultado = query.getResultList();
        return resultado;
    }

}
