package fundtransfer.contracts.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class Bonifico {
    public long accountNumber;
    public BigDecimal balance;

    @JsonCreator
    private Bonifico(@JsonProperty("conto") long accountNumber,
                    @JsonProperty("saldo") BigDecimal balance)
    {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public static Bonifico create(long accountNumber, BigDecimal balance)
    {
        return new Bonifico(accountNumber, balance);
    }
}
