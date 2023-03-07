package ru.geekbrains.spring1.lesson5;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();
        ProductDao productDao = new ProductDaoImpl(sessionFactoryUtils);

        Product p = productDao.findById(1l);
        System.out.println(p);

        List<Product> productList = productDao.findAll();
        System.out.println(productList);
        productDao.deleteById(1l);
        List<Product> products = productDao.findAll();
        System.out.println(products);
        productDao.saveOrUpdate(new Product(2l, "asdf", 656));
        List<Product> products123 = productDao.findAll();
        System.out.println(products123);

        sessionFactoryUtils.shutdown();
    }
}
