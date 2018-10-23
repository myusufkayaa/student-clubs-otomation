<template>
  <div class="about">
    <h1>This is an about page</h1>
    <hello-world msg="Here we are !"></hello-world>
  </div>
</template>
<script>
import HelloWorld from '../components/hello-world.component.vue'

export default {
  name: 'About',
  components: { HelloWorld }
}
</script>
<style lang="scss" scoped>

</style>
