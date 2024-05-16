<script setup lang="ts">
import { onMounted, ref } from "vue";

/* bloc de code pour gérer le texte du btn de déconnexion en fonction de la taille de l'écran */
const logoutButton = ref<HTMLButtonElement | null>(null);
const screenWidth = ref(window.innerWidth);
onMounted(() => {
  window.addEventListener("resize", () => {
    screenWidth.value = window.innerWidth;
  });
});
</script>

<template>
  <nav class="navbar">
    <div class="navbar-logo">
      <a href="/">
        <img src="../images/Le Bar’App.png" alt="Logo" />
      </a>
    </div>
    <div class="info-logout">
      <p>Connecté en tant que client</p>
      <a href="/">
        <button ref="logoutButton">
          <span v-if="screenWidth > 768">Déconnexion</span>
          <font-awesome-icon v-else icon="arrow-right-from-bracket" />
        </button>
      </a>
    </div>
  </nav>
</template>

<style scoped>
.navbar {
  display: flex;
  align-items: center;
  justify-content: space-between;
  background-color: #242424;
}

.navbar-logo img {
  height: 80px;
}

.info-logout {
  display: flex;
  align-items: center;
  gap: 40px;
}

.info-logout p {
  font-size: 14px;
}

.info-logout button {
  color: white !important;
  background: #ff1f00;
}

@media screen and (max-width: 768px) {
  .navbar-logo img {
    height: 60px;
  }
  .info-logout {
    gap: 10px;
  }
}
</style>
