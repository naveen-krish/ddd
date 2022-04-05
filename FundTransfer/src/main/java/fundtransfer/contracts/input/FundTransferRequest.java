package fundtransfer.contracts.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import fundtransfer.domain.Bonifico;

public class FundTransferRequest
{
    public Bonifico bonifico;


    @JsonCreator
    private FundTransferRequest(@JsonProperty("bonifico") Bonifico bonifico)
    {
        this.bonifico = bonifico;

    }

    public static FundTransferRequest create(Bonifico bonifico)
    {

        return new FundTransferRequest(bonifico);
    }
}

