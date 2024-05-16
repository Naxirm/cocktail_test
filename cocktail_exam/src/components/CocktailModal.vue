<script setup lang="ts">
import { defineEmits } from "vue";

const emit = defineEmits(["close"]);
const close = () => {
  emit("close");
};
</script>

<template>
  <div class="modal-mask" @click.self="close">
    <div class="modal-wrapper">
      <div class="modal-container">
        <button class="modal-close" @click="close">
          <font-awesome-icon icon="arrow-left" />Retour
        </button>
        <slot></slot>
      </div>
    </div>
  </div>
</template>

<style scoped>
/* fond noir pour la modale */
.modal-mask {
  position: fixed;
  z-index: 9998;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  display: flex;
  align-items: center;
  justify-content: center;
}
.modal-wrapper {
  display: flex;
  align-items: center;
  justify-content: center;
}
.modal-container {
  width: fit-content;
  padding: 20px;
  background: #242424;
  border-radius: 8px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.3);
  border: 1px solid #62eb5f;
}
.modal-close {
  background: transparent;
  border: none;
  cursor: pointer;
  gap: 10px;
  display: flex;
  align-items: center;
  padding: 0;
  transition: 0.2s ease;

  &:hover {
    color: #ffa800;
  }
}

@media screen and (max-width: 768px) {
  .modal-mask {
    top: 10px;
    align-items: baseline;
  }
}
</style>
