package pl.umcs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.umcs.types.BankAccount;

import java.util.List;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/bank")
public class BankAccountController {

    BankAccountService bankAccountService;

    @Autowired
    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }
    @GetMapping("/hello")
    public String hello() {
        return "Hello. This is bank.";
    }


    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<BankAccount> getAllAccounts() {
        return bankAccountService.findAll();
    }

    @GetMapping("/{id}")
    public BankAccount find(@PathVariable String number) {
        return bankAccountService.find(number);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public String save(@RequestBody BankAccount newAccount) {
        return bankAccountService.save(newAccount);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEmployee(@PathVariable String number) {
        bankAccountService.delete(number);

        return new ResponseEntity(NO_CONTENT);
    }
}
