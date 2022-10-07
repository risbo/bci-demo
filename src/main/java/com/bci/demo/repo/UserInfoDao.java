package com.bci.demo.repo;

import com.bci.demo.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
public class UserInfoDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private UserInfoRepository userInfoRepository;


    public void existEmail(final String email) {
        final Query query = entityManager.createQuery("SELECT usi FROM UserInfo usi WHERE usi.email =:email AND usi.isActive = true");
        query.setParameter("email", email);
        final List result = query.getResultList();
        if (result != null && !result.isEmpty()) {
            throw new RuntimeException("El correo ya registrado");
        }
    }

    public void saveUserInformation(final UserInfo userInfo){
        userInfoRepository.save(userInfo);
    }
}
