/**
 * Created by Administrator on 2017/3/7.
 */
//main.js这是项目的核心文件。全局的配置都在这个文件里面配置
import Vue from 'vue'
import App from './App.vue'
import Vuex from 'vuex';
import router from './routes.js'
import ElementUI from 'element-ui';
import './assets/styles/base.css'
import store from './store.js'
import echarts from 'echarts'
import axios from 'axios'
import Ajax from './ajax.js'
//import './assets/sass/reset.scss'//报错暂时不用sass

Vue.config.debug = true;//开启错误提示
Vue.use(ElementUI);
Vue.use(echarts)
Vue.use(Ajax, {
    baseURL: 'http://111.231.62.36:8080'
})
new Vue({
    router,
    store,
    el: '#appIndex',
    render: h => h(App)
})











