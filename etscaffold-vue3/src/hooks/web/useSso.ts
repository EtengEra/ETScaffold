// 单点登录核心类
import { getToken } from '/@/utils/auth';
import { getUrlParam } from '/@/utils';
import { useGlobSetting } from '/@/hooks/setting';
import { validateCasLogin, oauth2SSOLoginOut } from '/@/api/sys/user';
import { useUserStore } from '/@/store/modules/user';
import { RevokeIntrospectTokenParams } from '/@/api/sys/model/userModel';
const globSetting = useGlobSetting();
const openSso = globSetting.openSso;
export function useSso() {
  let locationUrl = 'http://' + window.location.host + '/';
  /**
   * 单点登录
   */
  async function ssoLogin() {
    if (openSso == 'true') {
      let token = getToken();
      let ticket = getUrlParam('ticket');
      if (!token) {
        if (ticket) {
          await validateCasLogin({
            ticket: ticket,
            service: locationUrl,
          }).then((res) => {
            const userStore = useUserStore();
            userStore.setToken(res.token);
            return userStore.afterLoginAction(true, {});
          });
        } else {
          window.location.href = globSetting.casBaseUrl + '/login?service=' + encodeURIComponent(locationUrl);
        }
      }
    }
  }

  /**
   * 退出登录
   */
  async function ssoLoginOut() {
    window.location.href = globSetting.casBaseUrl + '/logout?service=' + encodeURIComponent(locationUrl);
  }

  /**
   * oauth2 退出登录
   */
  async function doOauth2SSOLogOut(params : RevokeIntrospectTokenParams, id_token: string) {
    const { VITE_OAUTH2_LOGOUT_URI,VITE_OAUTH2_REDIRECTURI} = import.meta.env;
    const url = `${VITE_OAUTH2_LOGOUT_URI}?id_token_hint=${id_token}&post_logout_redirect_uri=${VITE_OAUTH2_REDIRECTURI}`;
    oauth2SSOLoginOut(params);
    window.location.href = url;
  }

  return { ssoLogin, ssoLoginOut, doOauth2SSOLogOut };
}
