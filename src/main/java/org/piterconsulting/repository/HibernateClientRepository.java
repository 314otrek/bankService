package org.piterconsulting.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.piterconsulting.repository.annotation.HibernateRepository;
import org.piterconsulting.repository.entity.Account;
import org.piterconsulting.repository.entity.Client;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@HibernateRepository
public class HibernateClientRepository implements ClientRipository {
    @Override
    public void save(Client client) {
        final Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        client.getAccounts()
                .forEach(session::save);
        session.save(client);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Client findByMail(String mail) {
        final Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        final Query<Client> query = session.createQuery("from Client where mail=:mail", Client.class);
        query.setParameter("mail",mail);

        final Client uniqueResult = query.uniqueResult();
        session.close();
        return uniqueResult;
    }

//    @Override
//    public boolean isExistMail(String mail) {
//        final Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        final Query<Boolean> query = session.createQuery("select count(c)>0 from Client c where mail=:mail",Boolean.class);
//        query.setParameter("mail",mail);
//        final Boolean integer = query.uniqueResult();
//        session.close();
//        return integer;
//    }

    @Override
    public void delete(Client client) {

    }
}
