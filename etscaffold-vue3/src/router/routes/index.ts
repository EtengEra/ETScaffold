import type { AppRouteRecordRaw, AppRouteModule } from '/@/router/types';

import { PAGE_NOT_FOUND_ROUTE, REDIRECT_ROUTE } from '/@/router/routes/basic';

import { mainOutRoutes } from './mainOut';
import { PageEnum } from '/@/enums/pageEnum';
import { t } from '/@/hooks/web/useI18n';

const modules = import.meta.glob('./modules/**/*.ts', { eager: true });

const routeModuleList: AppRouteModule[] = [];

// 加入到路由集合中
Object.keys(modules).forEach((key) => {
  const mod = (modules as Recordable)[key].default || {};
  const modList = Array.isArray(mod) ? [...mod] : [mod];
  routeModuleList.push(...modList);
});

export const asyncRoutes = [PAGE_NOT_FOUND_ROUTE, ...routeModuleList];

export const RootRoute: AppRouteRecordRaw = {
  path: '/',
  name: 'Root',
  redirect: PageEnum.BASE_HOME,
  meta: {
    title: 'Root',
  },
};

// export const LoginRoute: AppRouteRecordRaw = {
//   path: '/login',
//   name: 'Login',
//   component: () => import('/@/views/sys/login/Login.vue'),
//   meta: {
//     title: t('routes.basic.login'),
//   },
// };

//update-begin---author:wangshuai ---date:20220629  for：auth2登录页面路由------------
export const Oauth2LoginRoute: AppRouteRecordRaw = {
  path: '/oauth2-app/login',
  name: 'oauth2-app-login',
  component: () => import('/@/views/sys/login/OAuth2Login.vue'),
  meta: {
    title: t('routes.oauth2.login'),
  },
};
//update-end---author:wangshuai ---date:20220629  for：auth2登录页面路由------------

export const Oauth2SSORoute: AppRouteRecordRaw = {
  path: '/oauth2/authorized',
  name: 'oauth2-authorized',
  component: () => import('/@/views/sys/login/OAuthSSO.vue'),
  meta: {
    title: t('routes.basic.oauth2'),
  },
};

/**
 * 【通过token直接静默登录】流程办理登录页面 中转跳转
 */
export const TokenLoginRoute: AppRouteRecordRaw = {
  path: '/tokenLogin',
  name: 'TokenLoginRoute',
  component: () => import('/@/views/sys/login/TokenLoginPage.vue'),
  meta: {
    title: '带token登录页面',
    ignoreAuth: true,
  },
};

// export const AccountSettingRoute: AppRouteRecordRaw = {
//   path: '',
//   name:'account-setting-page',
//   component: () => import('/@/layouts/default/index.vue'),
//   meta:{
//     title:'虚拟account父节点settings'
//   },
//   children:[
//     {
//       path: '/page-demo/account/setting',
//       name: 'AccountSettingPage',
//       component: () => import('/@/views/demo/page/account/setting/index.vue'),
//       meta: {
//         title: t('routes.demo.page.accountSetting'),
//       },
//     }
//   ]

// };

// Basic routing without permission AccountSettingRoute,  LoginRoute,
export const basicRoutes = [Oauth2SSORoute,  RootRoute, ...mainOutRoutes, REDIRECT_ROUTE, PAGE_NOT_FOUND_ROUTE, TokenLoginRoute, Oauth2LoginRoute];
