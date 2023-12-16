package moneyDispenser;

public class DispenserProcessorError extends DispenserProcessor {
    @Override
    public void load(int noteValue, int numberOfNotes) {
        throw new RuntimeException("Note value not supported ($"+noteValue + ")");
    }

    @Override
    public DispenserResponse process(DispenserRequest req, DispenserResponse resp) {
        if(req.getData() > 0)
            throw new RuntimeException("Insufient balance");
        return resp;
    }

    @Override
    public int getNoteValue() {
        return super.getNoteValue();
    }

    @Override
    public int getNumberOfNotes() {
        return super.getNumberOfNotes();
    }

    protected DispenserProcessorError() {
        super();
    }

    public DispenserProcessorError(int noteValue, int numberOfNotes) {
        super(noteValue, numberOfNotes);
    }
}
