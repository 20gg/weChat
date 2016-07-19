package com.team.weChat.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpUtil {


    public static String entityToString(HttpResponse resonse) throws Exception{
        HttpEntity entity = resonse.getEntity();
        if (entity != null) {
            String msg = null;
            try {
                msg = EntityUtils.toString(entity, "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
            int code = resonse.getStatusLine().getStatusCode();
            if (code == 200) {
                return msg;
            } else {
                String errerMsg = (msg == null ? null : msg);
                throw new Exception("http code:" + code +",error:"+ errerMsg);
            }
        }
        throw new Exception("http entity is null");
    }
    
    
    public static void main1(String[] args) throws Exception {
    	CloseableHttpClient httpclient = HttpClients.createDefault();
    	HttpGet httpget = new HttpGet("http://blog.csdn.net/xinshou_jiaoming/article/details/8600230");
    	CloseableHttpResponse response = httpclient.execute(httpget);
    	try {
    		System.out.println(entityToString(response));
    	} finally {
    	    response.close();
    	}
	}
    
    
    
    
    
    
    public HttpUtil() {
		super();
	}


	public static void main(String[] args) {
		List<HttpUtil> list = new ArrayList<HttpUtil>();
		while(true){
			list.add(new HttpUtil());
		}
	}
    
    
    
    
    
    
    
    
    
    
}