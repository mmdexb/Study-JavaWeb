package com.hyper.demo.app;

import java.net.http.HttpRequest;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class weather {
    @GetMapping("/api/metar")
    public String getMetar(HttpServletRequest request) {
        String icao=request.getParameter("icao");
        String url = "https://xmairavt7.xiamenair.com/WarningPage?WarningAirports="+icao;
        
        try {
            // 创建HttpClient实例
            CloseableHttpClient httpClient = HttpClients.createDefault();
            
            // 创建HttpGet请求
            HttpGet httpGet = new HttpGet(url);
            
            // 发送请求并获取响应
            CloseableHttpResponse response = httpClient.execute(httpGet);
            
            // 获取响应内容
            HttpEntity entity = response.getEntity();
            String html = EntityUtils.toString(entity);
            
            // 使用Jsoup解析HTML
            Document document = Jsoup.parse(html);
            
            // 获取第二个div元素的文字内容
            Element secondDiv = document.select("div").get(1);
            String metar = secondDiv.select("font").text();
            
            // 关闭连接
            response.close();
            httpClient.close();
            
            return metar;
        } catch (Exception e) {
            e.printStackTrace();
            return "没有查询到此机场的Metar";
        }
    }
}
