// 全局请求工具类
import axios from 'axios';

// 创建axios实例

const request = axios.create({
    baseURL: '/api', // 全局请求地址前缀 
    timeout: 5000, // 请求超时时间
});

// 请求拦截器
request.interceptors.request.use(config => {
    //携带token
    const token = localStorage.getItem('token');
    if (token) {
        config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
}, error => {
    return Promise.reject(error);
});

// 响应拦截器
request.interceptors.response.use(response => {
    //存储token
    const token = response.headers['authorization'];
    if (token) {
        localStorage.setItem('token', token);
    }
    return response.data;
}, error => {
    return Promise.reject(error);
});

export default request;