<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js + TypeScript App"/>
  </div>
</template>

<script>
import HelloWorld from '../components/hello-world.component.vue' // @ is an alias to /src

export default {
  name: 'Home',
  components: { HelloWorld }
}
</script>
