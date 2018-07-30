package http;


import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import model.FundDetailModel;
import model.FundInfoModel;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * <pre>
 *     author: Summer
 *     time  : 2018/06/13
 *     desc  : api接口
 * </pre>
 */
public interface ApiService {

    /**
     * 批量获取基金信息
     * http://192.168.1.70:8081/fundController/batchGetFundInfo?sort=ASC&pageSize=10&pageIndex=1
     *
     * @return
     */
    @GET("fundController/batchGetFundInfo")
    Observable<BaseEntity<List<FundInfoModel>>> queryFundInfo(@QueryMap Map<String, String> params);


    /**
     * 获取单只基金的基本信息
     * http://192.168.1.70:8081/fundController/getSingleFundBasic?fundCode=040035
     *
     * @return
     */
    @GET("/fundController/getSingleFundBasic")
    Observable<BaseEntity<FundDetailModel>> fetchSingleFundBasic(@QueryMap Map<String, String> map);

}
