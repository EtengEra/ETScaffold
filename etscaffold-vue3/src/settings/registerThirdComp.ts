import type { App } from 'vue';

// 注册全局聊天表情包
import { Picker } from 'emoji-mart-vue-fast/src';
import { EmojiIndex } from "emoji-mart-vue-fast/src";
import data from "emoji-mart-vue-fast/data/apple.json";

// 注册全局dayjs
import dayjs from 'dayjs';
import relativeTime from 'dayjs/plugin/relativeTime';
import customParseFormat from 'dayjs/plugin/customParseFormat';

export async function registerThirdComp(app: App) {
  //---------------------------------------------------------------------
  // 注册全局聊天表情包
  app.component('Picker', Picker);
  let myEmojiIndex = new EmojiIndex(data, {
    function() {
      return true;
    },
    exclude:['recent','people','nature','foods','activity','places','objects','symbols','flags']
  });
  app.config.globalProperties.$globalEmojiIndex = myEmojiIndex
  app.provide('$globalEmojiIndex', myEmojiIndex)
  //---------------------------------------------------------------------
  // 注册全局dayjs
  dayjs.locale('zh-cn');
  dayjs.extend(relativeTime);
  dayjs.extend(customParseFormat);
  app.config.globalProperties.$dayjs = dayjs
  app.provide('$dayjs', dayjs)
  //---------------------------------------------------------------------
}
