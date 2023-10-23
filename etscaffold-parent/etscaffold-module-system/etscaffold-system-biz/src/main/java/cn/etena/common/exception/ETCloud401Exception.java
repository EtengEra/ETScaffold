package cn.etena.common.exception;

/**
 * @Description: ETCloud自定义401异常
 * @author: ETCloud
 */
public class ETCloud401Exception extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ETCloud401Exception(String message){
		super(message);
	}

	public ETCloud401Exception(Throwable cause)
	{
		super(cause);
	}

	public ETCloud401Exception(String message, Throwable cause)
	{
		super(message,cause);
	}
}
