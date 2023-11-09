<script lang="ts" setup>
const loginWithCloudGear = async () => {
  console.log("===> loginWithCloudGear 2");
  window.location.href = "http://localhost:8080/cg-login"
}
</script>

<template>
  <h1>LOGIN</h1><hr />
  <div id="oidc-login">
    <button @click="loginWithCloudGear">CloudGearでログイン</button>
    <button disabled>Googleでログイン</button>
  </div>
</template>

<style scoped>
#oidc-login {
  display: flex;
  flex-direction: column;
}

#oidc-login button {
  width: 200px;
  margin: 10px;
}
</style>
