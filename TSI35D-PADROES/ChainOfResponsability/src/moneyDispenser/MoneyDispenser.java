package moneyDispenser;

import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class MoneyDispenser
{
	DispenserProcessor root = new DispenserProcessorError();
	
	//-------------------------------------------------------------------------------
	public MoneyDispenser(Set<Integer> notesValuesSet)
	{
		SortedSet<Integer> sortedSet = new TreeSet<>(notesValuesSet);
		sortedSet.forEach(noteValue ->
		{
			DispenserProcessor newlyProcessor = new DispenserProcessor(noteValue, 0);
					
			newlyProcessor.SetNext(root);
			root = newlyProcessor;
		});		
	}
	
	//-------------------------------------------------------------------------------
	public 
	List<Pair> dispenseNotes(int value)
	{
		if(root == null)
			throw new RuntimeException("Dispenser is empty");
			
		DispenserResponse response = root.process(new DispenserRequest(value), 
				            					  new DispenserResponse());
		return response.getData();
	}
	
	//-------------------------------------------------------------------------------
	public 
	void loadNotes(int noteValue, int numberOfNotes)
	{ 
		root.load(noteValue, numberOfNotes);
	}
}
