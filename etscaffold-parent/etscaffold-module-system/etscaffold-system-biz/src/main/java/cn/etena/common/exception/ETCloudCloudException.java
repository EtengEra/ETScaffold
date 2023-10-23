package cn.etena.common.exception;

/**
 * @Description: ETCloud-cloud自定义异常
 * @Author: zyf
 * @Date: 2022-05-30
 */
public class ETCloudCloudException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ETCloudCloudException(String message) {
        super(message);
    }

}
