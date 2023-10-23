<template>

</template>

<script setup lang="ts">

import { onMounted, ref, toRaw } from 'vue';
import { useRouter } from 'vue-router';
import { getOauth2Token } from '/@/api/sys/user';
import { useUserStore } from '/@/store/modules/user';
import { useMessage } from '/@/hooks/web/useMessage';
import { useI18n } from '/@/hooks/web/useI18n';

const { currentRoute } = useRouter();
const route = currentRoute.value;
let code = ref<any>('');
//token 结果
let result = ref({});
const userStore = useUserStore();
const loading = ref(false);
const { notification } = useMessage();
const { t } = useI18n();

onMounted( () => {
  //从浏览器中获取key为 code的值
  code = route.query.code;
  if(!code){
    // 跳转到登录页
    const {VITE_OAUTH2_URI,VITE_OAUTH2_CLIENTID,VITE_OAUTH2_REDIRECTURI,VITE_OAUTH2_SCOPE} = import.meta.env;
      const url = `${VITE_OAUTH2_URI}?response_type=code&client_id=${VITE_OAUTH2_CLIENTID}&scope=${VITE_OAUTH2_SCOPE}&redirect_uri=${VITE_OAUTH2_REDIRECTURI}`;
      window.location.href = url;
  }

  const {VITE_OAUTH2_CLIENTID,VITE_OAUTH2_REDIRECTURI,VITE_OAUTH2_SCOPE} = import.meta.env;
  
  const params = {
    'client_id': VITE_OAUTH2_CLIENTID,
    'code': code,
    'redirect_uri': VITE_OAUTH2_REDIRECTURI,
    'scope': VITE_OAUTH2_SCOPE
  }
  
  getOauth2Token(params).then( res => {
    result.value = res;
    userStore.setId_token(res.id_token);
    userStore.setToken(res.access_token);
    handleLogin();
  });

  async function handleLogin() {
    try {
      loading.value = true;
      const { userInfo } = await userStore.login(
        toRaw({
          password: 'data.password',
          username: 'data.account',
          captcha: 'data.inputCode',
          checkKey: 'randCodeData.checkKey',
          mode: 'none', //不要默认的错误提示
        })
      );
      if (userInfo) {
        notification.success({
          message: t('sys.login.loginSuccessTitle'),
          description: `${t('sys.login.loginSuccessDesc')}: ${userInfo.realname}`,
          duration: 3,
        });
      }
    } catch (error) {
      notification.error({
        message: t('sys.api.errorTip'),
        description: error.message || t('sys.api.networkExceptionMsg'),
        duration: 3,
      });
      loading.value = false;

    }
  }
  
});


</script>

<style>

</style>
