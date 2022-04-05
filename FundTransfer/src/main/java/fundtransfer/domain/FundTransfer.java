package fundtransfer.domain;

import fundtransfer.domain.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;


public class FundTransfer
{
   @Autowired
    private IFeasibilityCheckService iFeasibilityCheckService;
   
    public int transferId;

    private FundTransfer(int transferId,Bonifico bonifico,IFeasibilityCheckService iFeasibilityCheckService){

    }

    public static FundTransfer create(Bonifico bonifico, IFeasibilityCheckService iFeasibilityCheckService)
    {
        return new FundTransfer(-1,bonifico,iFeasibilityCheckService);
    }
    public boolean canWireTransfer(long debitAccount,long creditAccount){
        return hasEligibility() && hasBalance(debitAccount);
    }
    private boolean hasEligibility(){
          return iFeasibilityCheckService.isEligible();
    }
    private boolean hasBalance(long account){
        return iFeasibilityCheckService.hasBalance(account);
    }
}

