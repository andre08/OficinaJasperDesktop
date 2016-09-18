package com.oficinajasperdesktop.dao;

import com.oficinajasperdesktop.model.Cliente;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author andre ulisses
 */
public class ClienteDao {

    public boolean save(Cliente pessoa) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.getTransaction().begin();
        s.saveOrUpdate(pessoa);
        s.getTransaction().commit();
        s.close();
        return true;
    }

    public List<Cliente> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();

        Query query = session.createQuery("FROM Cliente");
        List<Cliente> lista = query.list();
        session.getTransaction().commit();
        session.close();
        return lista;
    }

    public Cliente getById(Integer id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.getTransaction().begin();
        Cliente cliente = (Cliente) s.get(Cliente.class, id);
        s.getTransaction().commit();
        s.close();
        return cliente;
    }

    public boolean delete(Cliente cliente) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(cliente);
        session.getTransaction().commit();
        session.close();
        return true;
    }
}
