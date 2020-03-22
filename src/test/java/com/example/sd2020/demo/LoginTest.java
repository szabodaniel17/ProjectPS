package com.example.sd2020.demo;

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

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

public class LoginTest {
    @Mock
    LoginInterface loginInterface;
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    private LoginService loginService;

    @Before
    public void init(){
        loginService = new LoginService(loginInterface);
    };

    @Test
    public void testLoginSucces(){
        Account account = new Account("admin","admin");
        User expected = new Admin("Admin",new Date(),"021 361 622",account);

        User result = loginService.checkLogin("admin","admin");
        assertEquals(expected,result);
    }

    @Test
    public void testLoginFail(){
        Account account = new Account("admin","admin");

        User result = loginService.checkLogin("admin","admin");
        assertEquals(null,result);
    }

}
