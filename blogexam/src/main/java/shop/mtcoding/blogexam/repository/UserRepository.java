package shop.mtcoding.blogexam.repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.blogexam.dto.JoinDTO;

@Repository
public class UserRepository {

    @Autowired
    private EntityManager em;

    @Transactional
    public void save(JoinDTO joinDto) {
        Query query = em.createNativeQuery(
                "insert into user_tb (username, password, email) values (:username, :password, :email)");
        query.setParameter("username", joinDto.getUsername());
        query.setParameter("password", joinDto.getPassword());
        query.setParameter("email", joinDto.getEmail());
        query.executeUpdate();
    }

}
