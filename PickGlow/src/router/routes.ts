import type { RouteRecordRaw } from 'vue-router'
import IndexView from '@/views/IndexView.vue'
import HomeView from '@/views/HomeView.vue'
import TestView from '@/views/TestView.vue'

// 全局路由配置：把根路径重定向到 /index
const routes: Array<RouteRecordRaw> = [
    {
        path: '',
        redirect: '/index',
        children:[
            {
                path: '/index',
                name: '首页',
                component: IndexView,
            },
            {
                path: '/test',
                name: '测试',
                component: TestView
            }
        ]
    },
    {
        path: '/home',
        name: 'Home',
        component: HomeView,
    },
]

export default routes