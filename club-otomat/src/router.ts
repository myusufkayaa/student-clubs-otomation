import Vue from 'vue'
import Router from 'vue-router'
import Home from './pages/home.page.vue'
import About from './pages/about.page.vue'

Vue.use(Router)

const routes = [
  {
    path: '/',
    name: 'home',
    compomemt: Home,
    meta: { title: 'Anasayfa!!!' }
  },
  {
    path: '/about/',
    name: 'about',
    compomemt: About,
    meta: { title: 'Hakkımızda!!!' }
  }
]

const router = new Router({
  mode: 'history',
  routes: routes
})

router.beforeEach((to, from, next) => {
  document.title = to.meta.title
  next()
})

export default router
