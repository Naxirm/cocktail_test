<script setup lang="ts"></script>
<template>
  <img class="home-logo" src="../images/Le Bar’App.png" alt="bar'app logo" />
  <div class="connexion-btns">
    <a href="/cocktails"><button class="customer-btn">Client</button></a>
    <a href="/cocktails"><button class="barmaker-btn">Barmaker</button></a>
  </div>
</template>
<style scoped>
.connexion-btns {
  display: flex;
  justify-content: center;
  gap: 60px;
}

.customer-btn,
.barmaker-btn {
  transition: 0.3s ease;
  width: 280px;
  height: 60px;
  &:hover {
    background-color: transparent;
  }
}

.customer-btn {
  background: #00ff75;
  &:hover {
    color: #00ff75;
    border: 1px solid #00ff75;
  }
}

.barmaker-btn {
  background: #ffa800;
  &:hover {
    color: #ffa800;
    border: 1px solid #ffa800;
  }
}
@media screen and (max-width: 768px) {
  .home-logo {
    width: 240px;
  }
  .connexion-btns {
    flex-direction: column;
    gap: 20px;
  }
}
</style>
