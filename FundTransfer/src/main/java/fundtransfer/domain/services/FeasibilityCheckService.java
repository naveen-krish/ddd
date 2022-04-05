package fundtransfer.domain.services;

import fundtransfer.domain.interfaces.IFeasibilityCheckService;

public class FeasibilityCheckService implements IFeasibilityCheckService {
    @Override
    public boolean isEligible() {
        return true;
    }

    @Override
    public boolean hasBalance(long account) {
        return true;
    }
}
