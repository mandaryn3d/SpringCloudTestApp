package pl.umcs;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import pl.umcs.types.BankAccount;
import wiremock.com.google.common.collect.ImmutableList;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@DirtiesContext
@AutoConfigureMessageVerifier
public abstract class BaseTestClass {



    @Mock
    BankAccountService bankAccountService;
    @InjectMocks
    BankAccountController bankAccountController;

    @Before
    public void setUp() {
        BankAccount accountMock = new BankAccount("1111 2223", mockBalance());
        BDDMockito.given(bankAccountService.findAll()).willReturn(ImmutableList.of(mockAccount()));
        BDDMockito.given(bankAccountService.find(mockNumber())).willReturn(mockAccount());
        BDDMockito.given(bankAccountService.save(accountMock)).willReturn()
    }

    private String mockNumber() {
        return "1234 5678";
    }
    private Integer mockBalance() {
        return 912;
    }
    private BankAccount mockAccount() {
        return new BankAccount(mockNumber(), mockBalance());
    }
}
