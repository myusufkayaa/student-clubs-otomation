import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import './registerServiceWorker'
import './assets/styles/styles.scss'

Vue.config.productionTip = false

new Vue({
  router: router,
  store: store,
  render: h => h(App)
}).$mount('#app')
