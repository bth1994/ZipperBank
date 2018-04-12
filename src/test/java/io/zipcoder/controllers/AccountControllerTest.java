package io.zipcoder.controllers;

import io.zipcoder.repositories.AccountRepo;
import io.zipcoder.services.AccountService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountControllerTest {

    @MockBean
    private AccountService accountService;

    @InjectMocks
    private AccountController accountController;

    @Before
    public void setup() {
//        given(this.accountService.getAllAccounts())

    }



}
