package com.example.sd2020.demo;

import business.LoginService;
import org.junit.Before;
import org.junit.Rule;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import repository.LoginRepo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

public class LoginServiceTest {
    @Mock
    LoginRepo loginRepo;
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    private LoginService loginService;

    @Before
    public void init(){
        loginService = new LoginService(loginRepo);
    };

/*    @Test
    public void testAttemptLoginSuccessful(){
        Account account = new Account("abc","1234");
        User expected = new Teacher("Ion",new Date(),account);

        when(loginRepo.attemptLogin(account)).thenReturn(expected);
        User result = loginService.attemptLogin("abc","1234");
        assertEquals(expected,result);
        verify(loginRepo).attemptLogin(account);
    }

    @Test
    public void testAttemptLoginError(){
        Account account = new Account("abc","1234");

        when(loginRepo.attemptLogin(account)).thenReturn(null);
        User result = loginService.attemptLogin("abc","1234");
        assertEquals(null,result);
        verify(loginRepo).attemptLogin(account);
    }*/

}
