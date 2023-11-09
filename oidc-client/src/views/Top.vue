<script lang="ts" setup>
import { useCounterStore } from '@/stores/sample';
import { storeToRefs } from "pinia";

const store = useCounterStore();
const { increment } = store;
const { count } = storeToRefs(store);
</script>

<template>
  <h1>TOP</h1><hr />
  <div>
    <h1>Count:{{ count }}</h1>
    <button @click="increment">たすよ</button>
  </div>
</template>

<style scoped>
</style>
