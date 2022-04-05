package fundtransfer.infrastructure.repository;

import fundtransfer.domain.FundTransfer;
import fundtransfer.domain.interfaces.IFundTransferRepository;

import java.util.List;

public class FundTransferRepository implements IFundTransferRepository {


    @Override
    public int save(FundTransfer fundTransfer) {
        return 200;
    }

    @Override
    public List<FundTransfer> search(int transferId) {
        return null;
    }
}
