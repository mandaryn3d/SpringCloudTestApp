package pl.umcs;


import com.netflix.discovery.EurekaClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import pl.umcs.datatypes.Employee;
import pl.umcs.repositories.EmployeeRepository;
import pl.umcs.services.EmployeeService;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ClientBasicControllerTest {

    /*
    @MockBean
    EurekaClient eurekaClientMock;
    @Autowired
    ClientBasicController testObj;

    @Value("${spring.application.name}")
    private String appName;
    */


//    @Test
//    public void getHello() {
//        EmployeeRepository employeeRepository = new EmployeeRepository() {
//            @Override
//            public <S extends Employee> S save(S s) {
//                return null;
//            }
//
//            @Override
//            public <S extends Employee> Iterable<S> saveAll(Iterable<S> iterable) {
//                return null;
//            }
//
//            @Override
//            public Optional<Employee> findById(Long aLong) {
//                return Optional.empty();
//            }
//
//            @Override
//            public boolean existsById(Long aLong) {
//                return false;
//            }
//
//            @Override
//            public Iterable<Employee> findAll() {
//                return null;
//            }
//
//            @Override
//            public Iterable<Employee> findAllById(Iterable<Long> iterable) {
//                return null;
//            }
//
//            @Override
//            public long count() {
//                return 0;
//            }
//
//            @Override
//            public void deleteById(Long aLong) {
//
//            }
//
//            @Override
//            public void delete(Employee employee) {
//
//            }
//
//            @Override
//            public void deleteAll(Iterable<? extends Employee> iterable) {
//
//            }
//
//            @Override
//            public void deleteAll() {
//
//            }
//        };
//        EmployeeService employeeService = new EmployeeService(employeeRepository);
//        String testResult = new ClientBasicController(employeeService).getHello();
//        assertEquals(testResult, "Hello. This is the Client speaking.");
//    }


    /*
    @Test
    public void greeting() {
      //  eurekaClientMock = mock(EurekaClient.class);
        String returnedString = "Mocked eureka client";
        Mockito.when(eurekaClientMock.getApplication(appName).getName()).thenReturn(returnedString) ;
        String testResult = testObj.greeting();
        String expectedResult = "Hello from '" + returnedString + "'!";
        assertEquals(testResult, expectedResult);
    }
    */
}