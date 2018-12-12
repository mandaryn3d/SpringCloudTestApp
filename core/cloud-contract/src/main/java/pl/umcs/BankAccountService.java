package pl.umcs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.umcs.types.BankAccount;

import java.util.ArrayList;
import java.util.List;


@Service
public class BankAccountService {
    List<BankAccount> bankAccountList = new ArrayList<>();
    private static final Logger log = LoggerFactory.getLogger(BankAccountService.class);

    BankAccountService() {
        bankAccountList.add(new BankAccount("1111 2034", 44));
        bankAccountList.add(new BankAccount("2048 4096", 1058));
    }
    public List<BankAccount>findAll() {
        log.info("findAll called");
        List<BankAccount> newAccountList = bankAccountList;
        return newAccountList;
    }
    public BankAccount find(String accountNumber) {
        log.info("find called; param: " + accountNumber);
        BankAccount foundObj = null;
        for (BankAccount elem: bankAccountList) {
            if (accountNumber == elem.getNumber()) {
                foundObj = elem.clone();
                log.info("account number: " + foundObj.getNumber() + " found");
            }
        }

        return foundObj;
    }

    public String save( BankAccount newAccount) {
        log.info("save called");
        if (null != newAccount) {
            if (null != find(newAccount.getNumber())) {
                log.info("passed account is new; saving");
                bankAccountList.add(newAccount.clone());
                return "201";
            }
            return "200";
        }
        return "200";
    }

    public void delete(String toDel) {
        log.info("delete called");
        if (null != toDel) {
            for (BankAccount elem: bankAccountList) {
                if (toDel == elem.getNumber()) {
                    log.info("accaunt to be removed found");
                    bankAccountList.remove(elem);
                    break;
                }
            }
        }
    }
}
