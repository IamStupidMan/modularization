package http.exception;

/**
 * <pre>
 *     author: Summer
 *     time  : 2018/06/13
 *     desc  : api接口错误/异常统一处理类
 * </pre>
 */
public class ApiException extends RuntimeException {
    private int code;//错误码
    private String msg;//错误信息
    private String tipMsg;//提示用户的错误信息

    public ApiException(Throwable throwable, int code) {
        super(throwable);
        this.code = code;
    }

    public ApiException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ApiException(int code, String msg, String tipMsg) {
        this.code = code;
        this.msg = msg;
        this.tipMsg = tipMsg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTipMsg() {
        return tipMsg;
    }

    public void setTipMsg(String tipMsg) {
        this.tipMsg = tipMsg;
    }
}
