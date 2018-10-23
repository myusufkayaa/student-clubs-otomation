import Vue from 'vue'
import Router from 'vue-router'
import Home from './pages/home.page.vue'
import About from './pages/about.page.vue'

Vue.use(Router)

const routes = [
  {
    path: '/',
    name: 'home',
    component: Home,
    meta: { title: 'Anasayfa!!!' }
  },
  {
    path: '/about/',
    name: 'about',
    component: About,
    meta: { title: 'Hakkımızda!!!' }
  }
]

const router: Router = new Router({
  mode: 'history',
  routes: routes
})

router.beforeResolve((to:any, from: any, next: any) => {
  next()
})

router.beforeEach((to: any, from: any, next: any) => {
  document.title = to.meta.title
  next()
})

export default router
