package com.study.utils.httpUtil;


import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 2018-10-02 18:26
 * 创建人 HAOLI
 */
public class HttpUtil {

	private final static Logger logger = LoggerFactory.getLogger(HttpUtil.class);

	private static CloseableHttpClient httpClient;

	static {
		PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
		cm.setMaxTotal(100);
		cm.setDefaultMaxPerRoute(20);
		cm.setDefaultMaxPerRoute(50);
		httpClient = HttpClients.custom().setConnectionManager(cm).build();
	}

	//创建访问https的httpClient
	public static CloseableHttpClient createSSLClientDefault() {
		try {
			//使用 loadTrustMaterial() 方法实现一个信任策略，信任所有证书
			SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
				// 信任所有
				public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
					return true;
				}
			}).build();
			//NoopHostnameVerifier类作为主机名验证工具，实质上关闭了主机名验证，它接受任何有效的SSL会话并匹配到目标主机。
			HostnameVerifier hostnameVerifier = NoopHostnameVerifier.INSTANCE;
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, hostnameVerifier);
			return HttpClients.custom().setSSLSocketFactory(sslsf).build();
		} catch (KeyManagementException | NoSuchAlgorithmException | KeyStoreException e) {
			e.printStackTrace();
		}
		return HttpClients.createDefault();
	}

	public static String get(String url) {
		CloseableHttpResponse response = null;
		BufferedReader in = null;
		String result = "";
		try {
			HttpGet httpGet = new HttpGet(url);
			RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(210000).setConnectionRequestTimeout(210000).setSocketTimeout(210000).build();
			httpGet.setConfig(requestConfig);
			httpGet.setConfig(requestConfig);
			httpGet.addHeader("Content-type", "application/json; charset=utf-8");
			httpGet.setHeader("Accept", "application/json");
			response = httpClient.execute(httpGet);
			in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer sb = new StringBuffer("");
			String line = "";
			String NL = System.getProperty("line.separator");
			while ((line = in.readLine()) != null) {
				sb.append(line + NL);
			}
			in.close();
			result = sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != response) {
					response.close();
				}
			} catch (IOException e) {
				logger.error(e.getMessage());
				e.printStackTrace();
			}
		}
		return result;
	}

	public static String post(String url, String jsonString) {
		if (StringUtils.isEmpty(jsonString)) {
			return "";
		}
		CloseableHttpResponse response = null;
		BufferedReader in = null;
		String result = "";
		try {
			HttpPost httpPost = new HttpPost(url);
			RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(210000).setConnectionRequestTimeout(210000).setSocketTimeout(210000).build();
			httpPost.setConfig(requestConfig);
			httpPost.addHeader("Content-type", "application/json; charset=utf-8");
			httpPost.setHeader("Accept", "application/json");
//			httpPost.setHeader("con","");
			httpPost.setEntity(new StringEntity(jsonString, StandardCharsets.UTF_8));
			response = httpClient.execute(httpPost);
			in = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
			StringBuffer sb = new StringBuffer("");
			String line = "";
			String NL = System.getProperty("line.separator");
			while ((line = in.readLine()) != null) {
				sb.append(line + NL);
			}
			in.close();
			result = sb.toString();
		} catch (IOException e) {
			logger.error(e.getMessage());
		} finally {
			try {
				if (null != response) {
					response.close();
				}
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		}
		return result;
	}

	public static byte[] postStr(String url, String jsonString) {
		byte[] result =null;
		if (StringUtils.isEmpty(jsonString)) {
			return result;
		}
		CloseableHttpResponse response = null;
//		BufferedReader in = null;

		try {
			HttpPost httpPost = new HttpPost(url);
			RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(210000).setConnectionRequestTimeout(210000).setSocketTimeout(210000).build();
			httpPost.setConfig(requestConfig);
			httpPost.addHeader("Content-type", "application/json; charset=utf-8");
			httpPost.setHeader("Accept", "application/json");
//			httpPost.setHeader("con","");
			httpPost.setEntity(new StringEntity(jsonString, Charset.forName("UTF-8")));
			response = httpClient.execute(httpPost);
			/*in = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
			StringBuffer sb = new StringBuffer("");
			String line = "";
			String NL = System.getProperty("line.separator");
			while ((line = in.readLine()) != null) {
				sb.append(line + NL);
			}
			in.close();
			result = sb.toString();*/
			InputStream in = response.getEntity().getContent();

			ByteArrayOutputStream out =  new ByteArrayOutputStream();
			byte[] recv = new byte[1024];
			int ilen = 0;
			while( (ilen = in.read(recv,0,1024)) != -1)
			{
				out.write(recv,0,ilen);
			}
			in.close();
			result = out.toByteArray();
		} catch (IOException e) {
			logger.error(e.getMessage());
		} finally {
			try {
				if (null != response) {
					response.close();
				}
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		}
		return result;
	}




	public static String get_xform_https(String url) {
		CloseableHttpResponse response = null;
		BufferedReader in = null;
		String result = "";
		try {
			httpClient = createSSLClientDefault();

			HttpGet httpGet = new HttpGet(url);
			RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(210000).setConnectionRequestTimeout(210000).setSocketTimeout(210000).build();
			httpGet.setConfig(requestConfig);
			httpGet.addHeader("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

			response = httpClient.execute(httpGet);
			in = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), StandardCharsets.UTF_8));
			StringBuilder sb = new StringBuilder("");
			String line = "";
			String NL = System.getProperty("line.separator");
			while ((line = in.readLine()) != null) {
				sb.append(line).append(NL);
			}
			in.close();
			result = sb.toString();
		} catch (IOException e) {
			logger.error(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != response) {
					response.close();
				}
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		}
		return result;
	}

	public static String post_xform_https(String url, String param) {
		CloseableHttpResponse response = null;
		BufferedReader in = null;
		String result = "";
		try {
			httpClient = createSSLClientDefault();

			HttpPost httpPost = new HttpPost(url);
			RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(210000).setConnectionRequestTimeout(210000).setSocketTimeout(210000).build();
			httpPost.setConfig(requestConfig);
			httpPost.addHeader("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			//========================================
			if (param != null && param.length() > 0) {
				//对【key1=value1&key2=value2&key3=value3】的入参进行拆分
				String[] params = param.split("&");
				List<NameValuePair> formparams = new ArrayList<NameValuePair>();
				for (int i = 0; i < params.length; i++) {
					formparams.add(new BasicNameValuePair(params[i].split("=")[0], params[i].split("=").length > 1 ? params[i].substring(params[i].indexOf("=") + 1) : ""));
				}
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, "UTF-8");
				httpPost.setEntity(entity);
			}
			//========================================

			response = httpClient.execute(httpPost);
			in = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
			StringBuffer sb = new StringBuffer("");
			String line = "";
			String NL = System.getProperty("line.separator");
			while ((line = in.readLine()) != null) {
				sb.append(line + NL);
			}
			in.close();
			result = sb.toString();
		} catch (IOException e) {
			logger.error(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != response) {
					response.close();
				}
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		}
		return result;
	}

	//================================================================================================================

	/**
	 * http GET请求
	 *
	 * @param url   http请求地址ַ
	 * @param param 请求参数
	 * @return
	 * @throws IOException
	 */
	public static String send_get(String url, String param) {
		return send_get(url, param, null);
	}

	/**
	 * http GET
	 *
	 * @param url   http请求地址
	 * @param param 请求参数
	 * @param prop  请求头map
	 * @return
	 * @throws IOException
	 */
	public static String send_get(String url, String param, Map<String, String> prop) {
		return send(url, "GET", param, prop);
	}

	/**
	 * http POST请求
	 *
	 * @param url   http请求地址
	 * @param param 请求参数
	 * @return
	 * @throws IOException
	 */
	public static String send_post(String url, String param) {
		return send_post(url, param, null);
	}

	/**
	 * http POST请求
	 *
	 * @param url   http请求地址
	 * @param param 请求体
	 * @param prop  请求头map
	 * @return
	 * @throws IOException
	 */
	public static String send_post(String url, String param, Map<String, String> prop) {
		return send(url, "POST", param, prop);
	}

	/**
	 * HTTP请求
	 *
	 * @param urlString http请求地址
	 * @param method    请求方式： GET或POST
	 * @param param     请求体
	 * @param prop      请求头map
	 * @return
	 * @throws IOException
	 */
	public static String send(String urlString, String method, String param, Map<String, String> prop) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		try {
			//自定义请求配置信息
			RequestConfig requestConfig = RequestConfig.custom()
					.setSocketTimeout(70000)
					.setConnectTimeout(70000)
					.setConnectionRequestTimeout(70000).build();
			if (method.equalsIgnoreCase("GET")) {
				//get请求
				if (param != null && param.length() > 0) {
					if (urlString.indexOf("?") > -1) {
						urlString += "&" + param;
					} else {
						urlString += "?" + param;
					}
				}
				HttpGet httpget = new HttpGet(urlString);
				httpget.setConfig(requestConfig);
				if (prop != null) {
					for (String key : prop.keySet()) {
						httpget.setHeader(key, prop.get(key));
					}
				}
				response = httpclient.execute(httpget);
			} else {
				//post请求
				HttpPost httppost = new HttpPost(urlString);
				httppost.setConfig(requestConfig);
				if (prop != null) {
					for (String key : prop.keySet()) {
						httppost.setHeader(key, prop.get(key));
					}
				}
				if (param != null && param.length() > 0) {
					//==HttpEntity entity = new StringEntity(param,"utf-8");

					//对【key1=value1&key2=value2&key3=value3】的入参进行拆分
					String[] params = param.split("&");
					List<NameValuePair> formparams = new ArrayList<NameValuePair>();
					for (int i = 0; i < params.length; i++) {
						formparams.add(new BasicNameValuePair(params[i].split("=")[0], params[i].split("=").length > 1 ? params[i].substring(params[i].indexOf("=") + 1) : ""));
					}
					UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, "UTF-8");
					httppost.setEntity(entity);
				}
				response = httpclient.execute(httppost);
			}

			if (response != null && response.getEntity() != null) {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "utf-8"));
				StringBuffer temp = new StringBuffer();
				String sep = System.getProperty("line.separator");
				String line = bufferedReader.readLine();
				while (line != null) {
					temp.append(line).append(sep);
					line = bufferedReader.readLine();
				}
				bufferedReader.close();
				return temp.toString();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (response != null) {
					response.close();
				}
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * http get请求
	 *
	 * @param url   请求地址
	 * @param param 请求参数
	 * @return 返回结果
	 */
	public static String sendGet(String url, String param) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString = url + "?" + param;
			//System.out.println("sendGet,urlNameString:" + urlNameString);
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 建立实际的连接
			connection.connect();
			// 获取所有响应头字段
			Map<String, List<String>> map = connection.getHeaderFields();
			// 遍历所有的响应头字段
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(
					connection.getInputStream(), "utf-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			//System.out.println(e.getMessage());
			//e.printStackTrace();
			logger.info(e.getMessage());
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				//System.out.println(e2.getMessage());
				logger.info(e2.getMessage());
				//e2.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 读取请求体中的流
	 *
	 * @param request
	 * @return
	 * @throws IOException
	 */
	public static String getBodyString(HttpServletRequest request) throws IOException {
		StringBuilder sb = new StringBuilder();
		InputStream inputStream = null;
		BufferedReader reader = null;
		try {
			inputStream = request.getInputStream();
			reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
			String line = "";
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		//,queryString:
		// String url = "https://puser.qingdao.gov.cn:9001/oauth2/token";
		// String parm = "client_id=bigapp&client_secret=123456&code=jhJ5oShtR-sFioF2o9QD6Id6j41dUtJW&redirect_uri=https://qdzwconsole02.qingdao.gov.cn:9005/loginauth.html&grant_type=authorization_code";
		// String result = post_xform_https(url, parm);
		// System.out.println(result);

		//String url = "http://zwfw.sd.gov.cn/sdsfjis/gateway/interface.do?appmark=sdzwfortest&time=20180620135338&sign=257768185c405ecadbde7611673b99ec&servicename=ticketValidate&params={\"ticket\":\"70cde8b9e5437cf27aa9193b8a1adcd5\"}";
		String url = "http://zwfw.sd.gov.cn/sdsfjis/gateway/interface.do";
		String parms = "appmark=sdzwfortest&time=20180620135338&sign=257768185c405ecadbde7611673b99ec&servicename=ticketValidate&params={\"ticket\":\"70cde8b9e5437cf27aa9193b8a1adcd5\"}";
		sendGet(url, parms);
	}
}
