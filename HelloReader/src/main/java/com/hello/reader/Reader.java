package com.hello.reader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.entity.ContentType;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;

@Service
public class Reader {
    private static final String CSDN_FLAG = "https://blog.csdn.net/";

    @Autowired
    HttpClient httpClient;

    public String read(String url) {
        HttpGet httpGet = new HttpGet(url);
        if (url.startsWith(CSDN_FLAG)) {
            //csdn
            httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.99 Safari/537.36 LBBROWSER");
        } else {
            //51cto
            httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.115 Safari/537.36 LBBROWSER");
        }

        // 判断cookie, BROWSER_COMPATIBILITY
        httpGet.getParams().setParameter(ClientPNames.COOKIE_POLICY, CookiePolicy.BROWSER_COMPATIBILITY);

        String ret = null;
        try {
            // 发起请求.
            HttpResponse resp = httpClient.execute(httpGet);
            int code = resp.getStatusLine().getStatusCode();
            System.out.printf("%s, %d, %s\n", code == HttpStatus.SC_OK ? "Success" : "Fail", code, url);

            // 读取返回内容
            HttpEntity entity = resp.getEntity();
            if (entity != null) {
                ContentType contentType = ContentType.getOrDefault(entity);
                Charset charset = contentType.getCharset();
                ret = EntityUtils.toString(entity, charset);
            }

            // 暂停3秒
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.printf("Error: %s, %s\n", e.getMessage(), url);
        } finally {
            httpGet.releaseConnection();
        }
        return ret;
    }
}
