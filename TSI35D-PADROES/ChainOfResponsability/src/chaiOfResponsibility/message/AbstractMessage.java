package chaiOfResponsibility.message;

class AbstractMessage<T> implements Message<T>
{
	protected T data;
	
	//----------------------------------
	public AbstractMessage(T data)
	{
		this.data = data;
	}
	
	//----------------------------------
	public T getData()
	{
		return data;
	}
}
