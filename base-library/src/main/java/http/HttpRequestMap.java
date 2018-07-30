package http;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *     author: Summer
 *     time  : 2018/06/13
 *     desc  : 获取基础的请求map
 * </pre>
 */

public class HttpRequestMap {

    /**
     * 获取参数map
     *
     * @return
     */
    public static Map<String, String> getRequest() {
        return new HashMap<>();
    }

    /**
     * 获取基本参数的map，如果APP的每一个请求，都希望在请求体中加一些基本参数，可以在这里添加
     *
     * @return
     */
    public static final Map<String, String> getRequestWithParams() {
        Map<String, String> params = getRequest();
        //put一些基础的参数
//        params.put(KeyConstant.SORT, KeyConstant.SORT_ASC);
        return params;
    }

}
