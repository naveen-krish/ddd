package fundtransfer.domain.interfaces;

public interface IFeasibilityCheckService
{
    boolean isEligible();
    boolean hasBalance(long account);
}

