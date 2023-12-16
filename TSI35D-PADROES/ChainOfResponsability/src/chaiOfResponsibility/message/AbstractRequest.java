package chaiOfResponsibility.message;

public class AbstractRequest<T> 
extends AbstractMessage<T> implements Request<T>
{	
	//----------------------------------
	public AbstractRequest(T data)
	{
		super(data);
	}
}
