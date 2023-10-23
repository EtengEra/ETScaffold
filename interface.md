# 开发接口

## 登录

### 获取登录信息接口

#### 请求

##### 请求方式

| HTTP URL    | scaffold/callEtCloudLogin |
| ----------- | ------------------------- |
| HTTP Method | GET                       |

##### 请求头

| 名称          | 类型   | 必填 | 描述                                          |
| ------------- | ------ | ---- | --------------------------------------------- |
| Content-Type  | string | 是   | **固定值**："application/json; charset=utf-8" |
| Authorization | String | 是   | Bearer Token                                  |

##### 请求体

| 名称     | 类型   | 必填 | 描述   |
| -------- | ------ | ---- | ------ |
| password | String | 是   | 密码   |
| username | String | 是   | 账号   |
| captcha  | String | 是   | 验证码 |
| checkKey | String | 否   |        |

##### 请求体示例

```JSON
{
    "password":"data.password",
    "username":"data.account",
    "captcha":"data.inputCode",
    "checkKey":"randCodeData.checkKey"
}

```

##### 响应

| 名称            | 类型    | 描述     |
| --------------- | ------- | -------- |
| success         | boolean | 成功标识 |
| message         | string  | 提示信息 |
| code            | int     | 状态码   |
| result          | object  | 响应示例 |
| multi_depart    | int     | 多种部门 |
| sysAllDictItems | Object  | 数据字典 |

租户信息（result.tenantList响应体)

| 名称       | 类型    | 描述             |
| ---------- | ------- | ---------------- |
| id         | Integer | 编码             |
| name       | string  | 名称             |
| createBy   | String  | 创建人           |
| createTime | Date    | 创建时间         |
| beginDate  | Date    | 开始时间         |
| endDate    | Date    | 结束时间         |
| status     | int     | 状态 1正常 0冻结 |
| preCode    | String  | 角色编码前缀     |

用户信息（result.userInfo响应体）

| 名称         | 类型   | 描述                                               |
| ------------ | ------ | -------------------------------------------------- |
| id           | String | 用户ID                                             |
| username     | string | 登录账号                                           |
| realname     | String | 真实姓名                                           |
| birthday     | Date   | 生日                                               |
| sex          | int    | 性别（1：男 2：女）                                |
| email        | String | 电子邮件                                           |
| phone        | String | 电话                                               |
| orgCode      | String | 部门code(当前选择登录部门)                         |
| orgCodeTxt   | String | 部门名称                                           |
| status       | int    | 状态(1：正常  2：冻结 ）                           |
| delFlag      | int    | 删除状态（0，正常，1已删除）                       |
| workNo       | String | 工号，唯一键                                       |
| post         | String | 职务，关联职务表                                   |
| telephone    | String | 座机号                                             |
| activitiSync | String | 同步工作流引擎1同步0不同步                         |
| userIdentity | String | 身份（0 普通成员 1 上级）                          |
| departIds    | String | 负责部门                                           |
| relTenantIds | String | 多租户id配置，编辑用户的时候设置                   |
| clientId     | String | 设备id uniapp推送用                                |
| homePath     | String | 登录首页地址                                       |
| tenantId     | String | 租户id                                             |
| devFlag      | int    | 是否是开发者 0 非开发者1 开发者默认情况是 非开发者 |



##### 响应示例

```JSON
{
    "success":true,
    "message":"登录成功",
    "code":200,
    "result":{
        "tenantList":[
            {
                "id":99999,
                "name":"ETCloud平台租户",
                "createBy":"admin",
                "createTime":"2023-07-27 15:11:41",
                "beginDate":null,
                "endDate":null,
                "status":1,
                "preCode":null
            }
        ],
        "userInfo":{
            "id":"e9ca23d68d884d4ebb19d07889727dae",
            "username":"admin",
            "realname":"管理员",
            "avatar":"http://www.etena.cn/templets/1/eteng/etena.ico",
            "birthday":"2018-12-06",
            "sex":1,
            "email":"hr2@etena.cn",
            "phone":"18611111199",
            "orgCode":"A01",
            "orgCodeTxt":null,
            "status":1,
            "delFlag":0,
            "workNo":"00001",
            "post":"chuzhang,fuchuzhang",
            "telephone":null,
            "createBy":null,
            "createTime":"2019-06-21 17:54:10",
            "updateBy":"admin",
            "updateTime":"2023-08-11 16:47:14",
            "activitiSync":1,
            "userIdentity":2,
            "departIds":"1684503169479081985",
            "relTenantIds":"1001,1002,99999",
            "clientId":null,
            "homePath":null,
            "tenantId":"99999",
            "devFlag":0
        }
    },
    "timestamp":1697535161557
}
```



### 获取用户信息接口

#### 请求

##### 请求方式

| HTTP URL    | /scaffold/callEtCloudUserInfo |
| ----------- | ----------------------------- |
| HTTP Method | GET                           |

##### 请求头

| 名称          | 类型   | 必填 | 描述                                          |
| ------------- | ------ | ---- | --------------------------------------------- |
| Content-Type  | string | 是   | **固定值**："application/json; charset=utf-8" |
| Authorization | String | 是   | Bearer Token                                  |

##### 请求体

```http
/scaffold/callEtCloudUserInfo?_t=1697705279882
```



##### 请求体示例

```JSON
/scaffold/callEtCloudUserInfo?_t=1697705279882

```

##### 响应

| 名称            | 类型    | 描述     |
| --------------- | ------- | -------- |
| success         | boolean | 成功标识 |
| message         | string  | 提示信息 |
| code            | int     | 状态码   |
| result          | object  | 响应示例 |
| sysAllDictItems | Object  | 数据字典 |

用户信息（result.userInfo响应体）

| 名称         | 类型   | 描述                                               |
| ------------ | ------ | -------------------------------------------------- |
| id           | String | 用户ID                                             |
| username     | string | 登录账号                                           |
| realname     | String | 真实姓名                                           |
| birthday     | Date   | 生日                                               |
| sex          | int    | 性别（1：男 2：女）                                |
| email        | String | 电子邮件                                           |
| phone        | String | 电话                                               |
| orgCode      | String | 部门code(当前选择登录部门)                         |
| orgCodeTxt   | String | 部门名称                                           |
| status       | int    | 状态(1：正常  2：冻结 ）                           |
| delFlag      | int    | 删除状态（0，正常，1已删除）                       |
| workNo       | String | 工号，唯一键                                       |
| post         | String | 职务，关联职务表                                   |
| telephone    | String | 座机号                                             |
| activitiSync | String | 同步工作流引擎1同步0不同步                         |
| userIdentity | String | 身份（0 普通成员 1 上级）                          |
| departIds    | String | 负责部门                                           |
| relTenantIds | String | 多租户id配置，编辑用户的时候设置                   |
| clientId     | String | 设备id uniapp推送用                                |
| homePath     | String | 登录首页地址                                       |
| tenantId     | String | 租户id                                             |
| devFlag      | int    | 是否是开发者 0 非开发者1 开发者默认情况是 非开发者 |



##### 响应示例

```JSON
{
    "success":true,
    "message":"登录成功",
    "code":200,
    "result":{
        "userInfo":{
            "id":"e9ca23d68d884d4ebb19d07889727dae",
            "username":"admin",
            "realname":"管理员",
            "avatar":"http://www.etena.cn/templets/1/eteng/etena.ico",
            "birthday":"2018-12-06",
            "sex":1,
            "email":"hr2@etena.cn",
            "phone":"18611111199",
            "orgCode":"A01",
            "orgCodeTxt":null,
            "status":1,
            "delFlag":0,
            "workNo":"00001",
            "post":"chuzhang,fuchuzhang",
            "telephone":null,
            "createBy":null,
            "createTime":"2019-06-21 17:54:10",
            "updateBy":"admin",
            "updateTime":"2023-08-11 16:47:14",
            "activitiSync":1,
            "userIdentity":2,
            "departIds":"1684503169479081985",
            "relTenantIds":"1001,1002,99999",
            "clientId":null,
            "homePath":null,
            "tenantId":"99999",
            "devFlag":0
        },
        "sysAllDictItems":{}
    },
    "timestamp":1697535161557
}
```





### 获取菜单权限接口

#### 请求

##### 请求方式

| HTTP URL    | scaffold/callEtCloudUserPermission |
| ----------- | ---------------------------------- |
| HTTP Method | GET                                |

##### 请求头

| 名称          | 类型   | 必填 | 描述                                          |
| ------------- | ------ | ---- | --------------------------------------------- |
| Content-Type  | string | 是   | **固定值**："application/json; charset=utf-8" |
| Authorization | String | 是   | Bearer Token                                  |

##### 请求体

| 名称 | 类型 | 必填 | 描述 |
| ---- | ---- | ---- | ---- |

##### 请求体示例

```JSON
{
}

```

##### 响应

| 名称    | 类型    | 描述     |
| ------- | ------- | -------- |
| success | boolean | 成功标识 |
| message | string  | 提示信息 |
| code    | int     | 状态码   |
| result  | object  | 响应示例 |

全部权限配置集合按钮权限，访问权限（result.allAuth响应体) 

| 名称     | 类型   | 描述                                                         |
| -------- | ------ | ------------------------------------------------------------ |
| action   | String | 菜单权限编码，例如：“sys:schedule:list,sys:schedule:info”,多个逗号隔开 |
| describe | string | 组件名字                                                     |
| type     | String | 权限策略1显示2禁用                                           |
| status   | String | 按钮权限状态(0无效1有效)                                     |

 按钮权限（用户拥有的权限集合）（result.Auth响应体) 

| 名称     | 类型   | 描述                                                         |
| -------- | ------ | ------------------------------------------------------------ |
| action   | String | 菜单权限编码，例如：“sys:schedule:list,sys:schedule:info”,多个逗号隔开 |
| describe | string | 组件名字                                                     |
| type     | String | 权限策略1显示2禁用                                           |

 路由菜单（result.menu响应体）

| 名称      | 类型   | 描述             |
| --------- | ------ | ---------------- |
| redirect  | String | 一级菜单跳转地址 |
| path      | string | url              |
| component | String | 前端组件         |
| route     | String | 路由             |
| meta      | int    | 隐藏tab功能      |
| name      | String | 名称             |
| children  | Obj    | 菜单             |

 路由菜单（result.menu.**children**响应体）

| 名称      | 类型   | 描述        |
| --------- | ------ | ----------- |
| path      | string | url         |
| component | String | 前端组件    |
| route     | String | 路由        |
| meta      | int    | 隐藏tab功能 |
| name      | String | 名称        |





##### 响应示例

```JSON
{
    "success":true,
    "message":"",
    "code":0,
    "result":{
        "allAuth":[
            {
                "action":"btn:add",
                "describe":"btn:add",
                "type":"1",
                "status":"1"
            },
            {
                "action":"user:edit",
                "describe":"用户编辑",
                "type":"1",
                "status":"1"
            },
            {
                "action":"user:add",
                "describe":"新增用户",
                "type":"1",
                "status":"1"
            },
            {
                "action":"user:form:phone",
                "describe":"手机号禁用",
                "type":"2",
                "status":"1"
            }
        ],
        "auth":[
            {
                "action":"user:add",
                "describe":"新增用户",
                "type":"1"
            },
            {
                "action":"user:edit",
                "describe":"用户编辑",
                "type":"1"
            },
            {
                "action":"user:form:phone",
                "describe":"手机号禁用",
                "type":"2"
            }
        ],
        "menu":[
            {
                "redirect":"/dashboard/analysis",
                "path":"/dashboard",
                "component":"layouts/default/index",
                "route":"1",
                "children":[
                    {
                        "path":"/dashboard/analysis",
                        "component":"dashboard/Analysis",
                        "route":"1",
                        "meta":{
                            "keepAlive":true,
                            "internalOrExternal":false,
                            "icon":"ant-design:bank-filled",
                            "componentName":"Analysis",
                            "title":"首页"
                        },
                        "name":"dashboard-analysis",
                        "id":"9502685863ab87f0ad1134142788a385"
                    },
                    {
                        "path":"/dashboard/workbench",
                        "component":"dashboard/workbench/index",
                        "route":"1",
                        "meta":{
                            "keepAlive":false,
                            "internalOrExternal":false,
                            "icon":"ant-design:appstore-twotone",
                            "componentName":"index",
                            "title":"工作台"
                        },
                        "name":"dashboard-workbench",
                        "id":"1438108176814825473"
                    }
                ],
                "meta":{
                    "keepAlive":false,
                    "internalOrExternal":false,
                    "icon":"ion:grid-outline",
                    "componentName":"index",
                    "title":"Dashboard"
                },
                "name":"dashboard",
                "id":"1438108176273760258"
            },
            {
                "redirect":null,
                "path":"/about/index",
                "component":"sys/about/index",
                "route":"1",
                "meta":{
                    "keepAlive":false,
                    "internalOrExternal":false,
                    "icon":"simple-icons:about-dot-me",
                    "componentName":"index",
                    "title":"关于"
                },
                "name":"about-index",
                "id":"1438108225451974658"
            }
        ],
        "sysSafeMode":false
    },
    "timestamp":1697620446895
}
```



### 获取code接口

#### 请求

#### 请求方式

| HTTP URL    | oauth2/authorize |
| ----------- | ---------------- |
| HTTP Method | GET              |

#### 请求头

| 名称         | 类型   | 必填 | 描述                                          |
| ------------ | ------ | ---- | --------------------------------------------- |
| Content-Type | string | 是   | **固定值**："application/json; charset=utf-8" |

#### 查询参数

| 名称          | 类型   | 必填 | 描述                       |
| ------------- | ------ | ---- | -------------------------- |
| response_type | String | 是   | 表示要求返回授权码code     |
| client_id     | String | 是   | 让oauth知道是谁在请求      |
| redirect_uri  | String | 是   | 接受或拒绝请求后的跳转网址 |
| scope         | String | 是   | 表示要求的授权范围         |

#### 请求示例

```HTTP
oauth2/authorize?response_type=code&client_id=${VITE_OAUTH2_CLIENTID}&scope=${VITE_OAUTH2_SCOPE}&redirect_uri=${VITE_OAUTH2_REDIRECTURI}
```

#### 响应

#### 响应示例

```http
${VITE_OAUTH2_REDIRECTURI}?code=CODE
```

### 获取access_token接口

#### 请求

#### 请求方式

| HTTP URL    | /auth/token |
| ----------- | ----------- |
| HTTP Method | POST        |

#### 请求头

| 名称         | 类型   | 必填 | 描述                                          |
| ------------ | ------ | ---- | --------------------------------------------- |
| Content-Type | string | 是   | **固定值**："application/json; charset=utf-8" |

#### 请求体

| 名称         | 类型   | 必填 | 描述                                                    |
| ------------ | ------ | ---- | ------------------------------------------------------- |
| client_id    | string | 是   | 应用唯一标识                                            |
| code         | string | 是   | 授权码                                                  |
| redirect_uri | string | 是   | 单点登录跳转链接                                        |
| scope        | string | 是   | 授权范围，openid和profile为必须，多个字段中间用空格间隔 |

#### 请求体示例

```JSON
{
    "client_id": "messaging"
    "code": "N6Th6yqJQoAgzJOk67reOe1U2qsdI0JHVqCnKmuMOW246LdSTgseokqJuz88DzEa1yY2DyxB6pmNHwle3uXUEn_qFx3lD7sodTK4cJzef2SrGB8BQMu1hlp4HsNWLXOB"
    "redirect_uri": "http://127.0.0.1:8080/authorized"
    "scope": "all openid profile"
}
```

#### 响应

| 名称    | 类型    | 描述     |
| ------- | ------- | -------- |
| code    | int     | 状态码   |
| msg     | String  | 提示信息 |
| success | boolean | 成功标识 |
| data    | int     | 响应数据 |

data相应数据

| 名称          | 类型   | 描述                   |
| ------------- | ------ | ---------------------- |
| scope         | string | 授权范围               |
| access_token  | string | 接口访问token          |
| refresh_token | string | 刷新token              |
| expires_in    | int    | token有效时长，单位 秒 |
| token_type    | string | token类型              |
| id_token      | string |                        |

#### 响应示例

```JSON
{
    "code": 1,
    "msg": "成功",
    "success": true,
    "data": {
        "scope": "all openid profile",
        "access_token": "eyJraWQiOiI3ODRjYWYyNS05NDdiLTRiOTUtOTZjYi0wYTk5OThmNjk0YTAiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJvYXV0aCIsImF1ZCI6Im1lc3NhZ2luZyIsIm5iZiI6MTY4NzkzOTEzOSwic2NvcGUiOlsiYWxsIiwib3BlbmlkIiwicHJvZmlsZSJdLCJpc3MiOiJodHRwOi8vMTkyLjE2OC4wLjI0MToxOTAwMSIsImV4cCI6MTY4NzkzOTQzOSwiaWF0IjoxNjg3OTM5MTM5fQ.HBpp0YfPlube5KCWVIzUYrSYVk0kAmomK16tDjABy83p3HMi38xV4aHG7YhXDxNpF5tNQFT2fqdB6-myABWiW0j4FjvcVdnTYy4Ubm8tL9QJfZfUluE7ucZQdFMEgwtCzH7xFzulKSrv_RdO4HQe3DBuHBCN1tcio_cMAYTKd8FIdBSRzweGgHe1BxLxLMl5-GvbqdRRrmPrWZuCRBtWdiPm5kiGNMbpeddjfRgYXtb4cFi_rYy4Xl5-2xlQEy-4F-lH0X9mhPSuP7bEthEPbBpHKtMgVn5I5KB6-GCWFldqjPu3XcEEgZT11sSRtg1raTyBIOFGrroH-15BtdEl3w",
        "refresh_token": "xUd05w4ga0jRskbgAsQqbHPC6gjVjZi0NAiMaY3bznEQdZ1rKuzY1NXllWkFQt6lW7CVw53kJjz1DmTr2cLHU7x44oBfvxxPUni1NtDPU7ZeeNU7Ty0pV5vvtija9Upz",
        "expires_in": 299,
        "token_type": "Bearer",
        "id_token": "eyJraWQiOiI3ODRjYWYyNS05NDdiLTRiOTUtOTZjYi0wYTk5OThmNjk0YTAiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJvYXV0aCIsImF1ZCI6Im1lc3NhZ2luZyIsImF6cCI6Im1lc3NhZ2luZyIsImlzcyI6Imh0dHA6Ly8xOTIuMTY4LjAuMjQxOjE5MDAxIiwiZXhwIjoxNjg3OTQwOTM5LCJpYXQiOjE2ODc5MzkxMzl9.N5lyZd5TS8PXPCt_fEoIiIgP6cAj2hXJj8pmzwFbA7PDF_Giq-T9lbEIey52_1F32jA3WnbypWDNg3PdXZnhXCVyf8vtqSfl1SxT7u4RP-K2BTWsxn4LyZEY-BMgns6Mint4yoVyaj_xPyMlFuluk95-XfAsE-BNQ1b-aVhS_zcS3at9tgboKWFLYBLSBLV-eblNnQmfdde3mvMTVab0akA3COoWxlR716DJnrx-H1T1zza74LcUpz-nqffOhf1UYZApqMb0JYGL0p-nXdkhzvgXUgLXTsEwe9TZUn-E0KUyevnFHBbiFEm-jPfvQ6_1gS96_Rm8yUWajzxYA-ClYw"
    }
}
```



获取用户信息

### 获取用户信息

#### 请求

#### 请求方式

| HTTP URL    | /auth/userInfo |
| ----------- | -------------- |
| HTTP Method | GET            |

#### 请求头

| 名称         | 类型   | 必填 | 描述                                          |
| ------------ | ------ | ---- | --------------------------------------------- |
| Content-Type | string | 是   | **固定值**："application/json; charset=utf-8" |

#### 查询参数

| 名称  | 类型   | 必填 | 描述                           |
| ----- | ------ | ---- | ------------------------------ |
| token | string | 是   | 根据授权码获取到的access_token |

#### 请求示例

```HTTP
/oauth/userInfo?token=eyJraWQiOiI3ODRjYWYyNS05NDdiLTRiOTUtOTZjYi0wYTk5OThmNjk0YTAiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJvYXV0aCIsImF1ZCI6Im1lc3NhZ2luZyIsIm5iZiI6MTY4NzkzOTEzOSwic2NvcGUiOlsiYWxsIiwib3BlbmlkIiwicHJvZmlsZSJdLCJpc3MiOiJodHRwOi8vMTkyLjE2OC4wLjI0MToxOTAwMSIsImV4cCI6MTY4NzkzOTQzOSwiaWF0IjoxNjg3OTM5MTM5fQ.HBpp0YfPlube5KCWVIzUYrSYVk0kAmomK16tDjABy83p3HMi38xV4aHG7YhXDxNpF5tNQFT2fqdB6-myABWiW0j4FjvcVdnTYy4Ubm8tL9QJfZfUluE7ucZQdFMEgwtCzH7xFzulKSrv_RdO4HQe3DBuHBCN1tcio_cMAYTKd8FIdBSRzweGgHe1BxLxLMl5-GvbqdRRrmPrWZuCRBtWdiPm5kiGNMbpeddjfRgYXtb4cFi_rYy4Xl5-2xlQEy-4F-lH0X9mhPSuP7bEthEPbBpHKtMgVn5I5KB6-GCWFldqjPu3XcEEgZT11sSRtg1raTyBIOFGrroH-15BtdEl3w
```

#### 响应

| 名称     | 类型    | 描述     |
| -------- | ------- | -------- |
| code     | int     | 状态码   |
| msg      | String  | 提示信息 |
| success  | boolean | 成功标识 |
| data     | int     | 响应数据 |
| data.sub | string  | 用户名   |



#### 响应示例

```JSON
{
    "code": 1,
    "msg": "成功",
    "success": true,
    "data": {
        "sub": "oauth"
    }
}
```

### 验证token

#### 请求

#### 请求方式

| HTTP URL    | /auth/introspect |
| ----------- | ---------------- |
| HTTP Method | POST             |

#### 请求头

| 名称         | 类型   | 必填 | 描述                                          |
| ------------ | ------ | ---- | --------------------------------------------- |
| Content-Type | string | 是   | **固定值**："application/json; charset=utf-8" |

#### 请求体

| 名称      | 类型   | 必填 | 描述         |
| --------- | ------ | ---- | ------------ |
| client_id | string | 是   | 应用唯一标识 |
| token     | string | 是   | access_token |

#### 请求体示例

```JSON
{
  "client_id": "messaging"
  "token": "eyJraWQiOiI3ODRjYWYyNS05NDdiLTRiOTUtOTZjYi0wYTk5OThmNjk0YTAiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJvYXV0aCIsImF1ZCI6Im1lc3NhZ2luZyIsIm5iZiI6MTY4Nzk0MjcyMCwic2NvcGUiOlsiYWxsIiwib3BlbmlkIiwicHJvZmlsZSJdLCJpc3MiOiJodHRwOi8vMTkyLjE2OC4wLjI0MToxOTAwMSIsImV4cCI6MTY4Nzk0MzAyMCwiaWF0IjoxNjg3OTQyNzIwfQ.XwmzVRhXWLOirfxbedUwWtJ4TRKjowBRRRX6lZ-WoAEPkzQMR3SExoUyVEurb6DoMtMSPIbpxURXLDa_LyxsZ84o1dJciwf8JtrPcRFAzCfLqg-1YjRYDs_1-AHF2IBMYuxwwsGnWKhtCpJxE8Myy0DcEfExQWeao_0y0GPtXCdz34_6QJippvb-OD5WiSDwatHqhSWedCCVv99uTnKfVmFmLb0hS6sNqfK7UwO-I3cv1ouL4sTMwkHFghw2AKco1lfsnxpWaY7Nr_h5b5ngIKVN-AWl42r5RiE5ttSDm5JAG2aAshncL3BdlqRAFh4LchXV61qkBkF1LmTsk72OOA"
}
```

#### 响应

| 名称    | 类型    | 描述     |
| ------- | ------- | -------- |
| code    | int     | 状态码   |
| msg     | String  | 提示信息 |
| success | boolean | 成功标识 |
| data    | int     | 响应数据 |

data相应数据

| 名称       | 类型    | 描述                            |
| ---------- | ------- | ------------------------------- |
| active     | boolean | token是否有效                   |
| sub        | String  | token所属资源拥有者的唯一标识   |
| aud        | array   | token颁发给谁                   |
| nbf        | long    | token不可以在这个时间之前被使用 |
| scope      | string  | 授权范围                        |
| iss        | string  | token颁发者                     |
| exp        | long    | token的过期时间                 |
| iat        | long    | token的颁发时间                 |
| client_id  | string  | 客户端ID                        |
| token_type | string  | token类型                       |





#### 响应示例

```JSON
{
    "code": 1,
    "msg": "成功",
    "success": true,
    "data": {
        "active": true,
        "sub": "oauth",
        "aud": [
            "messaging"
        ],
        "nbf": 1687942720,
        "scope": "all openid profile",
        "iss": "http://192.168.0.241:19001",
        "exp": 1687943020,
        "iat": 1687942720,
        "client_id": "messaging",
        "token_type": "Bearer"
    }
}
```



### 注销token

#### 请求

#### 请求方式

| HTTP URL    | /auth/revoke |
| ----------- | ------------ |
| HTTP Method | POST         |

#### 请求头

| 名称         | 类型   | 必填 | 描述                                          |
| ------------ | ------ | ---- | --------------------------------------------- |
| Content-Type | string | 是   | **固定值**："application/json; charset=utf-8" |

#### 请求体

| 名称      | 类型   | 必填 | 描述         |
| --------- | ------ | ---- | ------------ |
| client_id | string | 是   | 应用唯一标识 |
| token     | string | 是   | access_token |

#### 请求体示例

```JSON
{
  "client_id": "messaging"
  "token": "eyJraWQiOiI3ODRjYWYyNS05NDdiLTRiOTUtOTZjYi0wYTk5OThmNjk0YTAiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJvYXV0aCIsImF1ZCI6Im1lc3NhZ2luZyIsIm5iZiI6MTY4Nzk0MjcyMCwic2NvcGUiOlsiYWxsIiwib3BlbmlkIiwicHJvZmlsZSJdLCJpc3MiOiJodHRwOi8vMTkyLjE2OC4wLjI0MToxOTAwMSIsImV4cCI6MTY4Nzk0MzAyMCwiaWF0IjoxNjg3OTQyNzIwfQ.XwmzVRhXWLOirfxbedUwWtJ4TRKjowBRRRX6lZ-WoAEPkzQMR3SExoUyVEurb6DoMtMSPIbpxURXLDa_LyxsZ84o1dJciwf8JtrPcRFAzCfLqg-1YjRYDs_1-AHF2IBMYuxwwsGnWKhtCpJxE8Myy0DcEfExQWeao_0y0GPtXCdz34_6QJippvb-OD5WiSDwatHqhSWedCCVv99uTnKfVmFmLb0hS6sNqfK7UwO-I3cv1ouL4sTMwkHFghw2AKco1lfsnxpWaY7Nr_h5b5ngIKVN-AWl42r5RiE5ttSDm5JAG2aAshncL3BdlqRAFh4LchXV61qkBkF1LmTsk72OOA"
}
```

#### 响应

| 名称    | 类型    | 描述     |
| ------- | ------- | -------- |
| code    | int     | 状态码   |
| msg     | String  | 提示信息 |
| success | boolean | 成功标识 |
| data    | int     | 响应数据 |



#### 响应示例

```JSON
{
    "code": 1,
    "msg": "成功",
    "success": true,
    "data": null
}
```

#### 退出跳转

在 `Spring Authorization Server`新版本中增加了退出登录的链接跳转

1. 在 oauth2_registered_client 表中增加了post_logout_redirect_uris 字段，这个字段用来设置退出登录后需要跳转的页面地址
2. 在调用完token的注销接口之后，我们需要进行跳转

```Bash
http://127.0.0.1:19001/oauth2/logout?id_token_hint=${id_token}&post_logout_redirect_uri=${post_logout_redirect_uri}
```



### 刷新token

#### 请求

#### 请求方式

| HTTP URL    | /auth/refreshToken |
| ----------- | ------------------ |
| HTTP Method | POST               |

#### 请求头

| 名称         | 类型   | 必填 | 描述                                          |
| ------------ | ------ | ---- | --------------------------------------------- |
| Content-Type | string | 是   | **固定值**："application/json; charset=utf-8" |

#### 请求体

| 名称          | 类型   | 必填 | 描述         |
| ------------- | ------ | ---- | ------------ |
| client_id     | string | 是   | 应用唯一标识 |
| refresh_token | string | 是   | 刷新token    |

#### 请求体示例

```JSON
{
    "client_id": "messaging"
    "refresh_token": "ckq_C0dKDzjTmb9Lc49oWsHeeFkPF41oTR6NiQ4o90ZVuSjvJRcpYghGkXGTdnusI5HlcofQsSfb6VUGumXPVXMa-QfQF4r2EK7_N_tKR0EkicWVwlcOjAgm-AM6uEa-"
    }
```

#### 响应

| 名称    | 类型    | 描述     |
| ------- | ------- | -------- |
| code    | int     | 状态码   |
| msg     | String  | 提示信息 |
| success | boolean | 成功标识 |
| data    | int     | 响应数据 |

data：

| 名称          | 类型   | 描述                   |
| ------------- | ------ | ---------------------- |
| scope         | string | 授权范围               |
| access_token  | string | 接口访问token          |
| refresh_token | string | 刷新token              |
| expires_in    | int    | token有效时长，单位 秒 |
| token_type    | string | token类型              |
| id_token      | string |                        |

#### 响应示例

#### 响应示例

```JSON
{
    "code": 1,
    "msg": "成功",
    "success": true,
    "data": {
        "scope": "all openid profile",
        "access_token": "eyJraWQiOiI3ODRjYWYyNS05NDdiLTRiOTUtOTZjYi0wYTk5OThmNjk0YTAiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJvYXV0aCIsImF1ZCI6Im1lc3NhZ2luZyIsIm5iZiI6MTY4ODAyNTEzNCwic2NvcGUiOlsiYWxsIiwib3BlbmlkIiwicHJvZmlsZSJdLCJpc3MiOiJodHRwOi8vMTkyLjE2OC4wLjI0MToxOTAwMSIsImV4cCI6MTY4ODAyNTQzNCwiaWF0IjoxNjg4MDI1MTM0fQ.KDjnK9b49QxzNualviq5W7nh0eWJFFHjXO_oqy8lqVYww3OsNnOS8GJ_G0gnS4bXD9dilV8GCS-ItXWeJjElvDEfL1hwenu-7lRTfhNB7zh0M74VthnwGwNZob1LEdlD376XtujNLNRFmxPevSnOl2XMjfZY6CRindS65mbNiW_dc445F3BlgCnjL-2L7eCDWvWSJ1Nws6xCmhqoftBd30SgT59Sqr4ZSyBJcOehfUYnPyvoX7kT9yntduMgjeR6trZb7xVPTQL1I2oziPrkUYlHO4v6fo2Nc1e1JIguQSKKL9y2CJBCNZjP9xSA_2vJhcBuygCl4pU579N5YjCtCw",
        "refresh_token": "ckq_C0dKDzjTmb9Lc49oWsHeeFkPF41oTR6NiQ4o90ZVuSjvJRcpYghGkXGTdnusI5HlcofQsSfb6VUGumXPVXMa-QfQF4r2EK7_N_tKR0EkicWVwlcOjAgm-AM6uEa-",
        "expires_in": 299,
        "token_type": "Bearer",
        "id_token": "eyJraWQiOiI3ODRjYWYyNS05NDdiLTRiOTUtOTZjYi0wYTk5OThmNjk0YTAiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJvYXV0aCIsImF1ZCI6Im1lc3NhZ2luZyIsImF6cCI6Im1lc3NhZ2luZyIsImlzcyI6Imh0dHA6Ly8xOTIuMTY4LjAuMjQxOjE5MDAxIiwiZXhwIjoxNjg4MDI2OTM0LCJpYXQiOjE2ODgwMjUxMzR9.ReWl3kyZ94Gvxl1cOMih1M-UeecvDkeupYbRYz-u618zW8uolUyneTDairxctv2F8dzsu06tHV4Sbv_4hg1YGhbwIvavNLhq5bxbu-mD-HZy4PTIhY92x8EZtwyvp-NYQJ53KClzCTkLauIix6R84HCIXbti3v5kj4QIm_x4GM4bgoB4X1behChgfH0BPuzmgCW6JnXh_Rv5h9BWSs1DTaZKNB7XBNFKKS9qnVg_FV3yvIUE8CDgSYinZAanPwWakwXm3BcGSg_NjF731In-RpSr-U_LhiVq8NXvGWraMjAzLCLpn-0JICSxz8nbFdMfUSbqof9kRA_difAs-8CbSw"
    }
}
```
