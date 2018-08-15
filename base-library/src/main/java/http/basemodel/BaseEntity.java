package http.basemodel;


/**
 * <pre>
 *     author: Summer
 *     time  : 2018/06/13
 *     desc  : RESTFUL返回数据的基础类
 * </pre>
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

    /**
     * 规定接口返回code == 0表示接口请求成功
     *
     * @return
     */
    public boolean isApiSuccess() {
        return code == 0;
    }
}
