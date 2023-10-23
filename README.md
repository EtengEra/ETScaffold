

![北京易腾时代科技有限公司](https://eteng.oss-cn-qingdao.aliyuncs.com/git/images/etena.jpg "易腾时代")



ETScaffold 统一认证平台脚手架
===============

当前最新版本： 1.0.0（发布日期：2023-10-23） 


[![](https://eteng.oss-cn-qingdao.aliyuncs.com/git/images/Author-北京易腾时代科技-orange.svg)](http://www.etena.cn)
[![](https://eteng.oss-cn-qingdao.aliyuncs.com/git/images/version-1.0.0-brightgreen.svg)](https://gitee.com/eteng/etscaffold)


项目介绍
-----------------------------------

ETScaffold脚手架，提供统一认证服务（ OAuth 2.1 和 OpenID Connect 1.0 规范）、多租户管理、全面的权限系统支持。


源码下载
-----------------------------------

| 源码                | 源码地址                     | 
|--------------------|------------------------|
| gitee    | https://gitee.com/eteng/etscaffold.git        |
| github  | https://github.com/EtengEra/ETScaffold.git |

#### 项目说明

| 项目名                | 说明                     | 
|--------------------|------------------------|
| `etscaffold-parent`    | SpringBoot后台源码（支持微服务）        |
| `etscaffold-vue3` | Vue3+TS 前端源码 |


使用说明
-----------------------------------

#### 后端环境

##### 1.application-dev.yml配置

* 配置oauth-server地址：http://zj.etena.cn:19001  
&emsp;![](https://eteng.oss-cn-qingdao.aliyuncs.com/git/images/oauth-server.png "oauth-server")  

* 配置管理中心后端地址：http://zj.etena.cn/etcloud  
&emsp;![](https://eteng.oss-cn-qingdao.aliyuncs.com/git/images/etcloudserver.png "etcloud-server")

##### 2.启动后端应用
* 启动SpringBoot应用，运行ETScaffoldSystemApplication

#### 前端环境

##### 1.配置文件
.env.development（仅开发环境适用）

```
#后台接口全路径地址(必填)
VITE_GLOB_DOMAIN_URL=http://localhost:8080/etscaffold-system

# OAuth2 单点登录信息
## 单点登录基础地址
VITE_OAUTH2_URI=http://zj.etena.cn:19001/oauth2/authorize
## 单点退出基础地址
VITE_OAUTH2_LOGOUT_URI=http://zj.etena.cn:19001/oauth2/logout

## 客户端ID
VITE_OAUTH2_CLIENTID=1Xl53T3UEdDwxd3_TcyUF
## 授权范围
VITE_OAUTH2_SCOPE=all openid profile
## 跳转路径
VITE_OAUTH2_REDIRECTURI=http://localhost:4100/oauth2/authorized
```

vite.config.ts（仅开发环境适用）

```
    #代理配置
    server: {
      // Listening on all local IPs
      host: true,
      https: false,
      port: VITE_PORT,
      // Load proxy configuration from .env
      proxy:{
        '/auth':{
          target:'http://zj.etena.cn',          
          changeOrigin: true,
        },
        '/scaffold':{          
          target:'http://localhost:8080/etscaffold-system',
          changeOrigin: true,
          ws: true,
        },        
      },
    },
```

##### 2.基础环境安装
安装 Node.js

```
# 出现相应node版本即可
node -v
v18.14.2
# 出现相应npm版本即可
npm -v
9.5.0
```
安装 pnpm

```
# 全局安装pnpm
npm install pnpm -g

# 验证（出现对应版本号即代表安装成功）
pnpm -v
7.27.1
```

##### 3.启动项目
```
# 进入前端项目目录
cd etscaffold-vue3

# 安装依赖
pnpm install

# 运行项目
pnpm dev
```

##### 4.访问系统
```
# 访问地址
http://localhost:4100/


```
