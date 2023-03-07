package ru.geekbrains.spring1.lesson5;

import org.hibernate.Session;

import java.util.List;

public class ProductDaoImpl implements ProductDao{

    protected SessionFactoryUtils sessionFactoryUtils;

    public ProductDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public Product findById(Long id) {
        Session session = sessionFactoryUtils.getSession();
        session.beginTransaction();
        Product p = session.get(Product.class, id);
        session.getTransaction().commit();
        return p;
    }

    @Override
    public List<Product> findAll() {
        Session session = sessionFactoryUtils.getSession();
        session.beginTransaction();
        List<Product> products = session.createQuery("SELECT p FROM Product p").getResultList();
        session.getTransaction().commit();
        return products;
    }

    @Override
    public void deleteById(Long id) {
        Session session = sessionFactoryUtils.getSession();
        session.beginTransaction();
        Product p = session.get(Product.class, id);
        session.delete(p);
        session.getTransaction().commit();
    }

    @Override
    public Product saveOrUpdate(Product p) {
        Session session = sessionFactoryUtils.getSession();
        session.beginTransaction();
        session.saveOrUpdate(p);
        session.getTransaction().commit();
        return p;
    }
}
