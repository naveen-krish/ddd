package fundtransfer.infrastructure.domainEvent;

import fundtransfer.application.interfaces.IFundTransferDomainEvent;

public class FundTransferDomainEvent implements IFundTransferDomainEvent {
    @Override
    public void publishFundTransferEvent(Object o) {

        /*
             publish fundtransfer domain event via message bus
         */
    }
}
