package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidades.Universo;
import util.JPAUtil;

public class UniversoDao {

	public static void salvar(Universo u) {
		EntityManager em = JPAUtil.criarEM();
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void editar(Universo u) {
		EntityManager em = JPAUtil.criarEM();
		em.getTransaction().begin();
		em.merge(u);//
		em.getTransaction().commit();
		em.close();
	}
	
	public static void excluir(Universo u, int id) {
		EntityManager em = JPAUtil.criarEM();
		em.getTransaction().begin();
		u = em.find(Universo.class, id);
		em.remove(u);//
		em.getTransaction().commit();
		em.close();
	}
	
	
	public static List<Universo> listar(){
		EntityManager em = JPAUtil.criarEM();
		Query q = em.createQuery("select u from Universo u ");
		List<Universo> listar = q.getResultList();
		em.close();
		return listar;
	}
	
	public static Integer contar() {
		EntityManager em = JPAUtil.criarEM();
		Integer count = (Integer) em.createQuery("select u from Universo u").getResultList().size();
		em.close();
		return count;
	}
}
