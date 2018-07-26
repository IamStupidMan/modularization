package http;


/**
 * 返回数据的基础类
 * @param <T>
 */
public class BaseEntity<T> {

    /**
     * 返回的状态码
     */
    private int code;
    /**
     * 访问接口是否成功
     */
    private boolean success;
    /**
     * 接口返回的信息
     */
    private String message;
    /**
     * 接口返回的data数据
     */
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
