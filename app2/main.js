import App from './App'
import axios from './utils/request/request.js'

// #ifndef VUE3
import Vue from 'vue'
import './uni.promisify.adaptor'
import * as echarts from 'echarts'
import 'echarts-liquidfill'
import './permission'
Vue.config.productionTip = false
App.mpType = 'app'
Vue.prototype.$axios = axios
Vue.prototype.$echarts = echarts


const app = new Vue({
  ...App
})
app.$mount()
// #endif

// #ifdef VUE3
import { createSSRApp } from 'vue'
export function createApp() {
  const app = createSSRApp(App)
  return {
    app
  }
}
// #endif