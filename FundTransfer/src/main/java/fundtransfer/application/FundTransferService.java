package fundtransfer.application;

import fundtransfer.application.interfaces.IFundTransferDomainEvent;
import fundtransfer.application.interfaces.IFundTransferService;
import fundtransfer.contracts.common.Bonifico;
import fundtransfer.contracts.input.FundTransferRequest;
import fundtransfer.contracts.output.FundTransferResponse;
import fundtransfer.domain.FundTransfer;
import fundtransfer.domain.interfaces.IFeasibilityCheckService;
import fundtransfer.domain.interfaces.IFundTransferRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class FundTransferService implements IFundTransferService {

    @Autowired
    private IFeasibilityCheckService iFeasibilityCheckService;
    @Autowired
    private IFundTransferRepository iFundTransferRepository;
    @Autowired
    private IFundTransferDomainEvent iFundTransferDomainEvent;

    @Override
    public FundTransferResponse sendTransfer(FundTransferRequest request) {
        FundTransfer fundTransfer = FundTransfer.create(request.bonifico, iFeasibilityCheckService);

        if (fundTransfer.canWireTransfer(request.bonifico.debitAccount.accountNumber, request.bonifico.creditAccount.accountNumber)) {
            int transferId = iFundTransferRepository.save(fundTransfer);
            iFundTransferDomainEvent.publishFundTransferEvent(mapToContract(request.bonifico));
            FundTransferResponse response = FundTransferResponse.create(true,"Success",transferId);
            return response;
        }else{
            FundTransferResponse response = FundTransferResponse.create(true,"FundTransfer Failed",-1);
            return response;
        }
    }
            private Bonifico mapToContract(fundtransfer.domain.Bonifico bonifico){
                return Bonifico.create(bonifico.debitAccount.accountNumber,bonifico.debitAccount.amount);
    }
}
