package chaiOfResponsibility.message;

public class AbstractResponse<T> 
extends AbstractMessage<T> implements Response<T>
{
	public AbstractResponse(T data)
	{
		super(data);
	}
}
