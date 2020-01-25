package com.team3d.instagram.Persistent.Repositories;

import com.team3d.instagram.Persistent.DbContext.HibernateUtil;
import com.team3d.instagram.Persistent.Models.User;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CrudRepositoryTest {


    @BeforeAll
    @DisplayName("connection test")
    static void setUp() {
        boolean hibernateUtil = HibernateUtil.getSession().isConnected();
        try {
            assertEquals(true,hibernateUtil,"Not Connected!");

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    @Test
    @DisplayName("save user")
    void save() {
        User user = new User("userTest","passTest","emailTest","firstTest","lastTest");
        UserRepository mokito = mock(UserRepository.class);
        when(mokito.save(user)).thenReturn(user);
        User u = mokito.save(user);
        Assert.assertEquals(u.getUsername(),user.getUsername());
    }

    @Test
    @DisplayName("update user")
    void update() {
        User user = new User("userTest","passTest","emailTest","firstTest","lastTest");
        User updated = new User("updatedUser","updatedpass","updatedEmail","updatedUserName","updatedPass");
        UserRepository mokito = mock(UserRepository.class);
        when(mokito.update(user)).thenReturn(updated);
        User u = mokito.update(user);
        Assertions.assertNotSame(user,u);
    }

    @Test
    @DisplayName("remove user")
    void remove() {

        User subject =new User("user1","pass1","email1","firstName1","last1");
        UserRepository mokito = mock(UserRepository.class);
        mokito.remove(subject);
        Assertions.assertNotEquals(subject,null);

    }

    @Test
    @DisplayName("remove user by id")
    void removeById() {
        User subject =new User("user1","pass1","email1","firstName1","last1");
        subject.setId(1L);
        UserRepository mokito = mock(UserRepository.class);
        mokito.remove(subject);
        Assertions.assertNotEquals(subject,null);
    }

    @Test
    @DisplayName("find user by id")
    void findById() {
        User user = new User("userTest","passTest","emailTest","firstTest","lastTest");
        UserRepository mokito = mock(UserRepository.class);
        when(mokito.findById(user.getId())).thenReturn(user);
        User u = mokito.findById(user.getId());
        Assertions.assertEquals(user.getId(),u.getId());

    }


    @AfterAll
    static void tearDown(){
        HibernateUtil.getSession().close();
    }
}