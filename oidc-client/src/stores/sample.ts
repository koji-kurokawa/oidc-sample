import { defineStore } from 'pinia'
import { computed, ref } from 'vue'

export const useCounterStore = defineStore('counter', () => {
  const count = ref(0)
  const doubleCount = computed(() => count.value * 2)
  function increment() {
    count.value++
  }

  return { count, doubleCount, increment }
})

export const useAuthStore = defineStore("auth", () => {
  const isAuthenticated = ref(false);
  const updateAuthStatus = (value: boolean) => {
    isAuthenticated.value = value;
  }
  return { isAuthenticated, updateAuthStatus };
});

// Pinia は Vuex の後継です
/*
Webページをリロードするとstore内のデータが消えるので、
storeの状態管理を永続化したい場合はライブラリを利用して実現します。

vue2 + vuex なら vuex-persistedstate を使います。
vue3 + pinia なら pinia-plugin-persistedstate が一番人気みたいです。
https://github.com/prazdevs/pinia-plugin-persistedstate
*/
