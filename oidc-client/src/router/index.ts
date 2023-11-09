import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  {
    path: '/',
    redirect: '/login'
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import('@/views/Login.vue'),
    meta: {
      requireAuth: false,
    },
  },
  {
    path: '/callback',
    name: 'Callback',
    component: () => import('@/views/Callback.vue'),
    meta: {
      requireAuth: false,
    },
  },
  {
    path: '/top',
    name: 'TOP',
    component: () => import('@/views/Top.vue'),
    meta: {
      requireAuth: true,
    },
  },
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

import { useAuthStore } from '@/stores/sample'
router.beforeEach((to, from, next) => {
  const requireAuth = to.meta.requireAuth;
  const isAuthenticated = useAuthStore().isAuthenticated;

  if (requireAuth && !isAuthenticated) {
    next('/');
  } else {
    next();
  }
})

export default router
