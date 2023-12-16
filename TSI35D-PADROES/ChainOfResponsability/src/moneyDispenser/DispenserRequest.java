package moneyDispenser;

import chaiOfResponsibility.message.AbstractRequest;

public class DispenserRequest extends AbstractRequest<Integer> {
    public DispenserRequest(Integer data) {
        super(data);
    }
}
