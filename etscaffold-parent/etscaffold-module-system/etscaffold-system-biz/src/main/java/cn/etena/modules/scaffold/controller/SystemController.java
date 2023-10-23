package cn.etena.modules.scaffold.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.etena.modules.etcloud.ETCloudClient;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Slf4j
@RestController
@RequestMapping("/scaffold")
public class SystemController {
    @Resource
    private ETCloudClient eTCloudClient;

    /**
     * 调用管理中心登录接口
     *
     * @return
     */
    @PostMapping("/callEtCloudLogin")
    public String callEtCloudLogin() {
    	log.info("---------/scaffold/callEtCloudLogin接口-----------------");
    	String respStr=eTCloudClient.callEtCloudLogin();
    	return respStr;
    }
    /**
     * 调用管理中心用户信息接口
     *
     * @return
     */
    @GetMapping("/callEtCloudUserInfo")
    public String callEtCloudUserInfo() {
        log.info("---------/scaffold/callEtCloudUserInfo接口-----------------");
        String respStr=eTCloudClient.callEtCloudUserInfo();
        return respStr;
    }
    /**
     *  调用管理中心用户权限接口
     *
     * @return
     */
    @GetMapping("/callEtCloudUserPermission")
    public String callEtCloudUserPermission() {
        log.info("---------/scaffold/callEtCloudUserPermission接口-----------------");
        String respStr=eTCloudClient.callEtCloudUserPermission();
        return respStr;
    }

    
}
