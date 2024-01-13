package com.excel.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.excel.demo.entity.Paper;
import com.excel.demo.mapper.PaperMapper;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("/thesis")
public class ThesisController {

    public final static String API_URL_TOKEN = "http://api.kefuju.cn/claimToken?name=kxjswxcbs&password=kxjswxcbs2020&api_id=99001";
    public final static String API_URL_SEARCH = "http://api.kefuju.cn/open/api/PreciseSearch";

    @Autowired
    private PaperMapper paperMapper;

    /**
     * post 登录请求,获取token
     * @return token
     */
    public static String getToken() throws IOException {
        HttpClient httpClient = new HttpClient();
        PostMethod postMethod = new PostMethod(API_URL_TOKEN);

        postMethod.addRequestHeader("accept", "*/*");
        postMethod.addRequestHeader("connection", "Keep-Alive");
        //设置json格式传送
        //postMethod.addRequestHeader("Content-Type", "application/json;charset=GBK");
        //必须设置下面这个Header
        postMethod.addRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.81 Safari/537.36");
        //添加请求参数
        //postMethod.addParameter("commentId", json.getString("commentId"));

        httpClient.executeMethod(postMethod);
        String res = postMethod.getResponseBodyAsString();
        return JSONObject.parseObject(res).get("token").toString();
    }

    /**
     * 匹配检索接口
     * @param token
     * @param title 标题
     * @return 单位
     * @throws IOException
     */
    public static String getSearch(String token, String title) throws IOException {

        String str = "";

        //1.生成HttpClient对象并设置参数
        HttpClient httpClient = new HttpClient();
        //设置Http连接超时为5秒
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
        //2.生成GetMethod对象并设置参数
        GetMethod getMethod = new GetMethod(API_URL_SEARCH);
        //设置get请求超时为5秒
        getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 5000);

        //设置请求头，token
        getMethod.setRequestHeader("Authorization", token);

        //设置接口参数
        getMethod.setQueryString(new NameValuePair[] {
                new NameValuePair("indexName", "10001"),
                new NameValuePair("filter", "TI:" + title)
        });

        httpClient.executeMethod(getMethod);

        //接口返回结果
        String result = getMethod.getResponseBodyAsString();

        //返回数据条数
        Long total = JSONObject.parseObject(JSONObject.parseObject(result)
                        .get("data").toString())
                .getLong("total");

        if (total < 1){
            return str;
        }

        //获取到集合
        JSONArray jsonArray = JSONArray.parseArray(JSONObject.parseObject(JSONObject.parseObject(result)
                        .get("data").toString())
                .get("sources").toString());

        JSONArray list = jsonArray.stream().filter(l -> JSONObject.parseObject(JSONObject.parseObject(l.toString())
                .get("source").toString()).get("TI").toString().equals(title)).collect(Collectors.toCollection(JSONArray::new));

        if (CollectionUtils.isNotEmpty(list)){
            JSONArray array = JSONArray.parseArray(JSONObject.parseObject(JSONObject.parseObject(list.get(0).toString())
                    .get("source").toString()).get("ORG").toString());
            str = org.apache.commons.lang3.StringUtils.join(array, ',');
        }
        return str;
    }

    @PostMapping("/test")
    public String updateData(Integer pageNo, Integer pageSize){
        LambdaQueryWrapper<Paper> lambdaQueryWrapper = Wrappers.lambdaQuery();
        lambdaQueryWrapper.eq(Paper::getPaperLibrary, 1);
        Page<Paper> page = new Page(pageNo, pageSize);
        IPage<Paper> iPage = this.paperMapper.selectPage(page, lambdaQueryWrapper);
        List<Paper> list = iPage.getRecords();

        list.forEach(l ->{
            try {
                String insrirution = getSearch(getToken(), l.getTitle());

                if (StringUtils.isEmpty(insrirution)){
                    return;
                }

                LambdaUpdateWrapper<Paper> updateWrapper = Wrappers.lambdaUpdate();
                updateWrapper.set(Paper::getInsrirution, insrirution);
                updateWrapper.eq(Paper::getId, l.getId());
                this.paperMapper.update(null, updateWrapper);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });
        return null;
    }
}
