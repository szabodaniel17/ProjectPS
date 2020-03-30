package com.example.sd2020.demo;

import repository.LoginRepository;
import service.LoginService;
import entity.Account;
import entity.Admin;
import entity.User;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import repository.LoginInterface;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LoginTest {
    @Mock
    LoginInterface loginRepo;
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    private LoginService loginService;

    @Before
    public void init(){
        loginService = new LoginService(loginRepo);
    };

    @Test
    public void testLoginSucces(){
        Account account = new Account("admin","admin");
        User expected = new Admin("Admin",new Date(),"021 361 622",account);

        when(loginRepo.checkLogin(account)).thenReturn(expected);
        User result = loginService.checkLogin("admin","admin");
        assertEquals(expected,result);
    }

    @Test
    public void testLoginFail(){
        Account account = new Account("admin","admin");
        User result = loginService.checkLogin("admin","admin");

        when(loginRepo.checkLogin(account)).thenReturn(null);
        assertEquals(null,result);
    }

}
