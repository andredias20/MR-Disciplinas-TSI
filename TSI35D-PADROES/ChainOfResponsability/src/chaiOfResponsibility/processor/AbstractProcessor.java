package chaiOfResponsibility.processor;

import chaiOfResponsibility.message.Request;
import chaiOfResponsibility.message.Response;

public abstract 
class AbstractProcessor< TReq extends Request<?>, TResp extends Response<?> > 
{
	private AbstractProcessor <TReq, TResp> next = null;
	
	//-----------------------------------------------------------------------
	public
	void SetNext(AbstractProcessor<TReq, TResp> processor) 
	{
		this.next = processor;
	}
	
	//-----------------------------------------------------------------------
	public
	AbstractProcessor <TReq, TResp> getNext()
	{
		return this.next;
	}
	

	//-----------------------------------------------------------------------
	public 
	boolean hasNext()
	{
		return (next != null);
	}
	
	//-----------------------------------------------------------------------
	protected
	TResp next(TReq req, TResp resp)
	{
		if ( ! hasNext() )
			return resp;
		
		return next.process(req, resp);		
	}
	
	//-----------------------------------------------------------------------
	protected abstract
	TResp process(TReq req, TResp resp);
}
