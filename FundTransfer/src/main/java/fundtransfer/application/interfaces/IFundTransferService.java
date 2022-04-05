package fundtransfer.application.interfaces;

import fundtransfer.contracts.input.FundTransferRequest;
import fundtransfer.contracts.output.FundTransferResponse;

public interface IFundTransferService {
    FundTransferResponse sendTransfer(FundTransferRequest request);

}
