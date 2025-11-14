<template>
    <div id="basicLayout">
        <a-layout style="min-height: 100vh">
            <!-- 导航栏组件 -->
            <a-layout-header class="header">
                <GlobalHeader />
            </a-layout-header>
            
            <!-- 内容显示区域 -->
            <a-layout-content class="content">
                <router-view />
            </a-layout-content>

            <!-- 页脚组件 -->
            <a-layout-footer class="footer">
                <GlobalFooter />
            </a-layout-footer>
            
        </a-layout>
    </div>
</template>

<script setup lang="ts">
import GlobalHeader from '@/components/GlobalHeader.vue'
import GlobalFooter from '@/components/GlobalFooter.vue'


</script>

<style scoped>
#basicLayout {
    min-height: 100vh;
}

#basicLayout .header {
  padding-inline: 20px;
  margin-bottom: 16px;
  color: unset;
  background: white;
}

#basicLayout .content {
  background: linear-gradient(to right, #fefefe, #fff);
  margin-bottom: 28px;
  padding: 20px;
}


#basicLayout .footer {
  background: #efefef;
  padding: 16px;
  position: fixed;
  bottom: 0;
  left: 0;
  right: 0;
  text-align: center;
}

</style>
