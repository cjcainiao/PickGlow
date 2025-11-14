import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router'

//字节前端开源组件
import Antd from "ant-design-vue";
import "ant-design-vue/dist/reset.css";

const app = createApp(App)

app.use(createPinia())
app.use(router)
app.use(Antd)

app.mount('#app')
