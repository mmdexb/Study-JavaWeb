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
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse response = httpClient.execute(httpGet);

            HttpEntity entity = response.getEntity();
            String html = EntityUtils.toString(entity);
            
            Document document = Jsoup.parse(html);
            
            // 获取第二个div元素的文字内容
            Element secondDiv = document.select("div").get(1);
            String metar = secondDiv.select("font").text();
            response.close();
            httpClient.close();
            
            return metar;
        } catch (Exception e) {
            e.printStackTrace();
            return "没有查询到此机场的Metar";
        }
    }
}
