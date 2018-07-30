package http;

import com.google.gson.annotations.SerializedName;

/**
 * <pre>
 *     author: Summer
 *     time  : 2018/06/13
 *     desc  : HttpStatus响应状态
 * </pre>
 */

public class HttpStatus {
    @SerializedName("code")
    private int mCode;
    @SerializedName("message")
    private String mMessage;

    public int getCode() {
        return mCode;
    }

    public String getMessage() {
        return mMessage;
    }


    @Override
    public String toString() {
        return "HttpStatus{" +
                "mCode=" + mCode +
                ", mMessage='" + mMessage + '\'' +
                '}';
    }

    /**
     * 规定接口返回code == 0表示接口请求成功
     *
     * @return
     */
    public boolean isApiSuccess() {
        return mCode == 0;
    }
}

