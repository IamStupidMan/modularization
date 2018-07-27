package http;

import com.google.gson.JsonParseException;
import com.google.gson.stream.MalformedJsonException;

import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.ParseException;

import retrofit2.HttpException;
import utils.LogUtils;


/**
 * 错误/异常处理工具
 *
 * @author ZhongDaFeng
 */
public class ExceptionEngine {

    public static final int HTTP_EXCEPTION = -1000;//HTTP错误
    public static final int SOCKET_TIME_OUT_EXCEPTION = -1001;//SocketTimeout超时错误
    public static final int CONNECT_EXCEPTION = -1002;//网络连接错误
    public static final int UN_KNOWN_HOST_EXCEPTION = -1003;//未知主机错误
    public static final int ANALYTIC_SERVER_DATA_ERROR = -1004;//解析数据错误
    public static final int UN_KNOWN_ERROR = -1005;//其他未处理错误

    //APP需要处理的一些异常
    public static final int TOKEN_ERROR = -1006;//Token错误
    public static final int AUTH_ERROR = -1007;//实名认证错误

    public static ApiException handleException(Throwable e) {
        ApiException ex;
        if (e instanceof HttpException) {
            //HTTP错误
            ex = new ApiException(e, HTTP_EXCEPTION);
            ex.setMsg("HTTP错误:::" + e.getMessage());
            LogUtils.e("code :" + ex.getCode() + "  msg:" + ex.getMsg());
            return ex;
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException || e instanceof MalformedJsonException) {
            //解析数据错误
            ex = new ApiException(e, ANALYTIC_SERVER_DATA_ERROR);
            ex.setMsg("解析错误:::" + e.getMessage());
            LogUtils.e("code :" + ex.getCode() + "  msg:" + ex.getMsg());
            return ex;
        } else if (e instanceof SocketTimeoutException) {
            //Socket连接超时
            ex = new ApiException(e, SOCKET_TIME_OUT_EXCEPTION);
            ex.setMsg("Socket连接超时:::" + e.getMessage());
            LogUtils.e("code :" + ex.getCode() + "  msg:" + ex.getMsg());
            return ex;
        } else if (e instanceof ConnectException) {
            //连接网络错误
            ex = new ApiException(e, CONNECT_EXCEPTION);
            ex.setMsg("ConnectException:::" + e.getMessage());
            LogUtils.e("code :" + ex.getCode() + "  msg:" + ex.getMsg());
            return ex;
        } else if (e instanceof UnknownHostException) {
            //未知主机错误
            ex = new ApiException(e, UN_KNOWN_HOST_EXCEPTION);
            ex.setMsg("UnknownHostException:::" + e.getMessage());
            LogUtils.e("code :" + ex.getCode() + "  msg:" + ex.getMsg());
            return ex;
        } else if (e instanceof ApiException) {
            //APP自定义的一些错误
            ex = (ApiException) e;
            if (ex.getCode() == TOKEN_ERROR) {
                //Token错误，自己处理
            } else if (ex.getCode() == AUTH_ERROR) {
                //实名认证错误
            }
            return ex;
        } else {
            //其他未处理的错误
            ex = new ApiException(e, UN_KNOWN_ERROR);
            ex.setMsg("其他未处理的错误:::" + e.getMessage());
            LogUtils.e("code :" + ex.getCode() + "  msg:" + ex.getMsg());
            return ex;
        }
    }

}
