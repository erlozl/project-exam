package shop.mtcoding.blogex.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProductRepository {

    @Autowired
    private EntityManager em;

    @Transactional
    public void save(String name, Integer price, Integer qty) {
        Query query = em.createNativeQuery("insert into product_tb (name,price,qty) values (:name,:price,:qty)");
        query.setParameter("name", name);
        query.setParameter("price", price);
        query.setParameter("qty", qty);
        query.executeUpdate();
    }

    @Transactional
    public Product update(Product product) {
        Query query = em
                .createNativeQuery("update product_tb set name = :name, price = :price, qty = :qty where id= :id");
        query.setParameter("name", product.getName());
        query.setParameter("price", product.getPrice());
        query.setParameter("qty", product.getQty());
        query.setParameter("id", product.getId());
        query.executeUpdate();
        return product;
    }

    @Transactional
    public void delete(Integer id) {
        Query query = em.createNativeQuery("delete from product_tb where id= :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public List<Product> findAll() {
        Query query = em.createNativeQuery("select * from product_tb", Product.class);
        List<Product> products = query.getResultList();
        return products;
    }

    public Product findById(Integer id) {
        Query query = em.createNativeQuery("select * from product_tb where id = :id", Product.class);
        query.setParameter("id", id);
        Product product = (Product) query.getSingleResult();
        return product;
    }

    // --------------

    // public List<Product> findJoinAll() {
    // Query query = em.createNativeQuery();
    // List<Product> joinList = query.getResultList();
    // return joinList;
    // }

}
