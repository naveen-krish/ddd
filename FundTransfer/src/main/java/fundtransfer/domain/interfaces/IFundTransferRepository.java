package fundtransfer.domain.interfaces;

import fundtransfer.domain.FundTransfer;

import java.util.List;

public interface IFundTransferRepository {
    int save(FundTransfer fundTransfer);
    List<FundTransfer> search(int transferId);
}
