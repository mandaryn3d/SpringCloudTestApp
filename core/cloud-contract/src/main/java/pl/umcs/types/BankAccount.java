package pl.umcs.types;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class BankAccount {
    private String number;
    private Integer balance;
    public BankAccount clone() {
        BankAccount cloned = new BankAccount();
        cloned.setNumber(this.number);
        cloned.setBalance(this.balance);
        return cloned;
    }

}
