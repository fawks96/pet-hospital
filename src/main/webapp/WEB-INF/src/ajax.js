import axios from 'axios'

export default {
    install(Vue, option = {}) {
        const http = axios.create(option)
        // 1.通过 Vue.http 调用
        Vue.http = http
        // 2.通过 this.$http 调用
        Vue.prototype.$http = http
    }
}