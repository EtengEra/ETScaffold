package cn.etena.modules.etcloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: ETCloudClient
 * @Description: 管理中心API客户端封装
 * @author: huangjx
 *
 */
@Slf4j
@Component
public class ETCloudClient  {
	
	@Value("${etscaffold.etcloudServerUrl}")
	private String etcloudServerUrl;	

	/**
	 * 调用管理中心登录接口
	 * @return
	 */
	public String callEtCloudLogin() {
		String url = etcloudServerUrl + "/sys/login";		
		JSONObject json=new JSONObject();
		String respStr = HttpRequest.post(url)
			.header(Header.AUTHORIZATION, callEtCloudToken())//头信息，多个头信息多次调用此方法即可
			.body(json.toString())//Restful请求
			//.timeout(20000)//超时，毫秒
			.execute().body();

		log.info("*************管理中心登录接口查询结果：" + respStr);		
		return respStr;		
	}

	/**
	 * 调用管理中心用户信息接口
	 * @return
	 */
	public String callEtCloudUserInfo() {
		String url = etcloudServerUrl + "/sys/user/getUserInfo";
		String respStr = HttpRequest.get(url)
				.header(Header.AUTHORIZATION, callEtCloudToken())//头信息，多个头信息多次调用此方法即可
				//.timeout(20000)//超时，毫秒
				.execute().body();
		log.info("*************管理中心用户信息接口查询结果：" + respStr);
		return respStr;
	}

	/**
	 * 调用管理中心用户权限接口
	 * @return
	 */
	public String callEtCloudUserPermission() {
		String url = etcloudServerUrl + "/sys/permission/getUserPermissionByToken";
		String respStr = HttpRequest.get(url)
				.header(Header.AUTHORIZATION, callEtCloudToken())//头信息，多个头信息多次调用此方法即可
				//.timeout(20000)//超时，毫秒
				.execute().body();
		log.info("*************管理中心用户信息接口查询结果：" + respStr);
		return respStr;
	}

	/**
	 * 获取token
	 * @return
	 */
	public String callEtCloudToken() {
		//链式构建请求
		Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
		//获得token
		String token=((Jwt)authentication.getPrincipal()).getTokenValue();
		return "Bearer "+token;
	}
}