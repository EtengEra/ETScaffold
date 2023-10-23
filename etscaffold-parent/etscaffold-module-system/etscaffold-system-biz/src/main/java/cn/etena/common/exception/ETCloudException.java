package cn.etena.common.exception;

/**
 * @Description: ETCloud自定义异常
 * @author: ETCloud
 */
public class ETCloudException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ETCloudException(String message){
		super(message);
	}

	public ETCloudException(Throwable cause)
	{
		super(cause);
	}

	public ETCloudException(String message, Throwable cause)
	{
		super(message,cause);
	}
}
