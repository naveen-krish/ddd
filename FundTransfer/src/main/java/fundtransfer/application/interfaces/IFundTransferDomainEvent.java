package fundtransfer.application.interfaces;

public interface IFundTransferDomainEvent {
    void publishFundTransferEvent(Object o);
}
