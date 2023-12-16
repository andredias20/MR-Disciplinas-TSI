package moneyDispenser;

import java.util.ArrayList;
import java.util.List;

import chaiOfResponsibility.processor.AbstractProcessor;

class DispenserProcessor 
extends AbstractProcessor<DispenserRequest, DispenserResponse>
{
	private int numberOfNotes =0;
	private int noteValue     =0;
		
	//--------------------------------------------------------
	public 
	int getNoteValue()
	{
		return noteValue;
	}
	
	//--------------------------------------------------------
	public 
	int getNumberOfNotes()
	{
		return numberOfNotes;
	}
	
	//--------------------------------------------------------
	protected 
	DispenserProcessor()
	{
		//nothing for while
	}
	
	//--------------------------------------------------------
	public 
	DispenserProcessor(int noteValue, int numberOfNotes)
	{
		this.noteValue = noteValue;
		this.load(noteValue, numberOfNotes);
	}
	
	//--------------------------------------------------------
	public 
	void load(int noteValue, int numberOfNotes)
	{
		if(this.noteValue == noteValue)
		{
			this.numberOfNotes += numberOfNotes;
			return;
		}
		
		DispenserProcessor next = (DispenserProcessor)this.getNext();
		next.load(noteValue, numberOfNotes);
	}

	//--------------------------------------------------------
	@Override
	public 
	DispenserResponse process(final DispenserRequest req, 
			                  final DispenserResponse resp ) 
	{
		int requestValue =  req.getData();
		
		int requiredNotes = requestValue / this.noteValue;
		
		if(requiredNotes == 0)
			return next(req, resp);
		
		if(requiredNotes > this.numberOfNotes)
			requiredNotes = this.numberOfNotes;
		
		this.numberOfNotes -= requiredNotes;
		DispenserRequest newReq = new DispenserRequest( req.getData() - (requiredNotes * noteValue) );
		
		List<Pair> list = new ArrayList<>();
		list.addAll(resp.getData());
		list.add(new Pair(requiredNotes, noteValue));
		DispenserResponse newResp = new DispenserResponse(list);
		
		return next(newReq, newResp);
	}	
}
