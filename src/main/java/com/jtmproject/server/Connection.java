package com.jtmproject.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreProtocolPNames;

import com.jtmproject.actions.Checks;


/**
 * this class retrieves data through the server.
 * @author Javier Tejedor
 * **/
public class Connection {
	
	private InputStream is = null;
	private String result = "";
	private HttpPost httpPost;

	/**
	 * gets the data through the server
	 * @param postParams
	 * @param url
	 * @return
	 */
	public String getServerData(ArrayList<NameValuePair> postParams, String url){
		if(Checks.isInternetReachable()){
			
			httpPostConnect(postParams,url);
			
			if (is != null){
				return getPostResponse();
			}else{
				return null;
			}
		}else{
			
			return null;
		}
	}

	/**
	 * Connects with the server
	 * @param parametrosPostWeb
	 * @param url
	 */
	private void httpPostConnect(ArrayList<NameValuePair> parametrosPostWeb, String url){
		try {
			CookieStore cookieStore = new BasicCookieStore();
			DefaultHttpClient httpClient = new DefaultHttpClient();    
			
			httpClient.getParams().setParameter(CoreProtocolPNames.USER_AGENT, "");
			httpClient.getParams().setParameter(ClientPNames.COOKIE_POLICY, CookiePolicy.RFC_2109);
			httpClient.setCookieStore(cookieStore);
			httpPost = new HttpPost(url);
			httpPost.setEntity(new UrlEncodedFormEntity(parametrosPostWeb));
			httpPost.setHeader("User-Agent","");
			httpPost.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
			
			HttpResponse httpResponse = httpClient.execute(httpPost);

			HttpEntity httpEntity = httpResponse.getEntity();
			is = httpEntity.getContent();

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}  catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * gets the response of the server
	 * @return
	 */
	private String getPostResponse(){
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(is,"UTF-8"),8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			is.close();

			result = sb.toString();
		}catch(Exception e){
			
		}
		return result;
	}
	
	/**
	 * this method stops closes the connection
	 */
	public void closeConnection(){
		if(httpPost != null){
			httpPost.abort();
		}
	}
}
