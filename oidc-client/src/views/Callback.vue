<script lang="ts" setup>
import router from '@/router';
import { useAuthStore } from '@/stores/sample';
import { ref } from 'vue';

const countdown = ref(5)
const startCountdown = () => {
  const timer = setInterval(() => {
    countdown.value--
    if (countdown.value <= 0) {
      clearInterval(timer)
      router.push('/top')
    }
  }, 1000)
}

const isLoggedIn = ref(false)
const loginError = ref('')
const getLoginStatus = async () => {
  try {
    const response = await fetch("http://localhost:8080/login-status", {
      credentials: "include",
    })
    isLoggedIn.value = await response.text() === "true"

    // const { updateAuthStatus } = useAuthStore() <--この書き方でも良い
    useAuthStore().updateAuthStatus(isLoggedIn.value)

    if (isLoggedIn.value) startCountdown()
  } catch (e) {
    loginError.value = `ログインが失敗しました: ${e}`
  }
}
getLoginStatus()
</script>

<template>
  <h1>Callback</h1><hr />
  <div>
    ログイン状態は「{{ isLoggedIn ? "ログイン済み" : "未ログイン" }}」です
    <br />
    <span v-if="loginError">
      {{ loginError }}
    </span>
  </div>
  <div v-if="isLoggedIn">
    {{ countdown }} 秒後にトップページに遷移します
  </div>
</template>

<style scoped>
</style>
