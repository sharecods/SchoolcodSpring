<template>
  <div class="home">
    <router-link :to="{ name: 'Home' }" class="nav-link" active-class="active">
      Home
    </router-link>
    <router-link :to="{ name: 'About' }" class="nav-link" active-class="active">
      About Us
    </router-link>
    <router-link :to="{ name: 'Test' }" class="nav-link" active-class="active">
      Test
    </router-link>
    <router-link :to="{ name: 'Todo' }" class="nav-link" active-class="active">
      Todo
    </router-link>
  </div>
</template>

<script>

export default {
  name: "Home",
  components: {
  }
};
</script>
