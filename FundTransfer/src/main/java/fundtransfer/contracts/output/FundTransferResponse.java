package fundtransfer.contracts.output;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FundTransferResponse {

    boolean IsSuccess;
    String ErrorReason;
    long txID;

    public boolean isIsSuccess() {
        return IsSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        IsSuccess = isSuccess;
    }

    public String getErrorReason() {
        return ErrorReason;
    }

    public void setErrorReason(String errorReason) {
        ErrorReason = errorReason;
    }

    public long getTxID() {
        return txID;
    }

    public void setTxID(long txID) {
        txID = txID;
    }

    @JsonCreator
    private FundTransferResponse(@JsonProperty("isSuccess") boolean isSuccess,
                               @JsonProperty("errorReason") String errorReason,
                               @JsonProperty("tx-id") long txID)
    {
        IsSuccess = isSuccess;
        ErrorReason = errorReason;
        txID = txID;
    }
    public static FundTransferResponse create(boolean isSuccess,
                                              String reason,
                                              long txID)
    {
        return new FundTransferResponse(isSuccess, reason, txID);
    }
}
