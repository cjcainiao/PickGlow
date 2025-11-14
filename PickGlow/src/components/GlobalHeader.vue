<template>
    <div id="globalHeader">
        <a-menu mode="horizontal" :selected-keys="current">
            <!-- logo -->
            <a-menu-item key="/" disabled>
                <router-link to="/" class="logo" aria-label="首页">
                    <img src="../assets/images/logo.png" alt="Logo">
                    <p>PickGlow</p>
                </router-link>
            </a-menu-item>

            <!-- 动态渲染菜单组件 -->
            <a-menu-item v-for="item in routerList" :key="item.path" @click="doMenuClick({ key: item.path })">
                {{ item.name }}
            </a-menu-item>

            <!-- 个人中心，固定在右侧 -->
            <a-menu-item key="userCenter" class="user-center">
                <router-link to="/user">个人中心</router-link>
            </a-menu-item>

        </a-menu>
    </div>
</template>

<script setup lang="ts">
import routes from '../router/routes';
import { ref } from 'vue';
import { useRouter } from 'vue-router';

// 当前页面路由对象
const router = useRouter();

//拿到当前路由列表信息
const routerList = routes[0].children || [];

//实现高亮显示功能
const current = ref<string[]>([]);
router.afterEach((to, from, next) => {
    current.value = [to.path];
});

//实现页面跳转功能
const doMenuClick = ({ key }: { key: string }) => {
    router.push({
        path: key,
    });
};

</script>

<style scoped>
.logo {
    display: flex;
    align-items: center;
    cursor: pointer;

}

.logo img {
    height: 48px;
    margin-right: 8px;
}

.logo p {
    margin: 0;
    font-weight: 700;
    color: black
}


/* 让菜单变为 flex 布局并把个人中心推到最右侧 (使用 ::v-deep 覆盖子组件生成的 DOM) */
::v-deep .ant-menu-horizontal {
    display: flex;
    align-items: center;
}

::v-deep .ant-menu-item.user-center {
    margin-left: auto;
}
</style>
