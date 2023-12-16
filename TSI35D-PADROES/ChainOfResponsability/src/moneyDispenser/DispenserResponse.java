package moneyDispenser;

import chaiOfResponsibility.message.AbstractResponse;

import java.util.ArrayList;
import java.util.List;

public class DispenserResponse extends AbstractResponse<List<Pair>> {

    public DispenserResponse() {
        super(new ArrayList<Pair>());
    }

    public DispenserResponse(List<Pair> data) {
        super(data);
    }
}