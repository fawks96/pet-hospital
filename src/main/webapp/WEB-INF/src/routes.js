/**
 * Created by Administrator on 2017/3/7.
 */

// 引用模板
import Vue from 'vue';
import Router from 'vue-router';
import indexPage from './components/public/header.vue'
import Home from './views/home.vue'
import Show from './views/show.vue'
import Login from './views/login.vue'
import Test from './views/test.vue'
import Learn from './views/learn.vue'
import Play from './views/play.vue'
import Roles from './views/roles.vue'
import Case from './views/case.vue'
import My from './views/my.vue'
Vue.use(Router)

export default new Router({
    routes:[
        {
            path:'/',
            component:Home
        },
        {
            path:'/show',
            component:Show
        },
        {
            path:'/learn',
            component:Learn
        },
        {
            path:'/play',
            component:Play
        },
        {
            path:'/login',
            component:Login
        },
        {
            path:'/test',
            component:Test
        },
        {
            name: 'roles',
            path: '/role/:role',
            component: Roles
        },
        {
            name: 'case',
            path: '/case/:case',
            component: Case
        },
        {
            name: 'my',
            path: '/my',
            component: My
        }
    ]
})