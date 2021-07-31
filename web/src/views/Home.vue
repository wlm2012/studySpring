<template>
  <div class="home">
    <a-button type="primary" danger>Primary</a-button>
    <img alt="Vue logo" src="../assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js + TypeScript App"/>
  </div>
</template>

<script lang="ts">
import {defineComponent} from 'vue';
import HelloWorld from '@/components/HelloWorld.vue';
import axios from "axios"; // @ is an alias to /src

export default defineComponent({
  name: 'Home',
  setup() {
    console.log("setup")
    axios.get("").then((response) => {
      console.log(response)
    })
  },
  components: {
    HelloWorld,
  },
});
</script>
