<script setup lang="ts">
import { ref, onMounted } from "vue";
import CocktailModal from "../components/CocktailModal.vue";
import { CocktailService } from "../api/cocktailService";
import { Cocktail } from "../models/Cocktail";

const cocktails = ref<Cocktail[]>([]);
const showModal = ref(false);
const selectedCocktail = ref<Cocktail | null>(null);

const cocktailService = new CocktailService();

const selectedSize = ref<string>("S");

const formatIngredients = (ingredients: Ingredient[]): string => {
  return ingredients.map((ingredient) => ingredient.name).join(", ");
};

const formatCategories = (categories: Category[]): string => {
  return categories.map((category) => category.name).join(", ");
};

const selectCocktail = (cocktail: Cocktail) => {
  selectedCocktail.value = cocktail;
  showModal.value = true;
  selectedSize.value = "S";
};

onMounted(async () => {
  const data = await cocktailService.getCocktail();
  cocktails.value = data;
});

const getPrice = (size: string): number | undefined => {
  if (!selectedCocktail.value) return;
  switch (size) {
    case "S":
      return selectedCocktail.value.price_s;
    case "M":
      return selectedCocktail.value.price_m;
    case "L":
      return selectedCocktail.value.price_l;
  }
};
</script>

<template>
  <div>
    <h1>Liste des Cocktails</h1>
    <div class="cocktail-grid">
      <div
        v-for="cocktail in cocktails"
        :key="cocktail.cocktail_id"
        class="cocktail-card"
        @click="selectCocktail(cocktail)"
      >
        <p>{{ cocktail.name }}</p>
        <div class="overlay">
          <img
            :src="cocktail.image"
            :alt="cocktail.name"
            class="cocktail-image"
          />
          <div class="overlay-content">
            <svg
              width="60"
              height="60"
              viewBox="0 0 60 60"
              fill="none"
              xmlns="http://www.w3.org/2000/svg"
            >
              <circle
                cx="27.5"
                cy="27.5"
                r="17.5"
                stroke="white"
                stroke-width="2"
              />
              <path
                d="M27.5 20C26.5151 20 25.5398 20.194 24.6299 20.5709C23.7199 20.9478 22.8931 21.5003 22.1967 22.1967C21.5003 22.8931 20.9478 23.7199 20.5709 24.6299C20.194 25.5398 20 26.5151 20 27.5"
                stroke="white"
                stroke-width="2"
                stroke-linecap="round"
              />
              <path
                d="M50 50L42.5 42.5"
                stroke="white"
                stroke-width="2"
                stroke-linecap="round"
              />
            </svg>
          </div>
        </div>
      </div>
    </div>

    <CocktailModal v-if="showModal" @close="showModal = false">
      <div v-if="selectedCocktail" class="cocktail-info">
        <div class="cocktail-name-picture">
          <h2>{{ selectedCocktail.name }}</h2>
          <img :src="selectedCocktail.image" :alt="selectedCocktail.name" />
        </div>

        <div class="ingredients-size-price">
          <h3>Ingrédients</h3>
          <p class="ingredient-list">
            {{ formatIngredients(selectedCocktail.ingredients) }}
          </p>

          <h3>
            Catégorie<span v-if="selectedCocktail.categories.length > 1"
              >s</span
            >
          </h3>
          <p class="ingredient-list">
            {{ formatCategories(selectedCocktail.categories) }}
          </p>

          <div class="price-size">
            <div>
              <label for="size">Taille: </label>
              <select id="size" v-model="selectedSize">
                <option value="S">S</option>
                <option value="M">M</option>
                <option value="L">L</option>
              </select>
            </div>
            <p>Prix: {{ getPrice(selectedSize) }} €</p>
          </div>
          <button>Commander<font-awesome-icon icon="martini-glass" /></button>
        </div>
      </div>
    </CocktailModal>
  </div>
</template>

<style scoped>
.cocktail-grid {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-evenly;
  gap: 40px;
}

.cocktail-card {
  cursor: pointer;
  display: flex;
  flex-direction: column;
  position: relative;
}

.cocktail-image {
  width: 180px;
  height: 200px;
  object-fit: cover;
  border-radius: 4px;
  transition: transform 0.2s;
}

.overlay {
  position: relative;
  width: inherit;
  height: inherit;
}

.overlay .overlay-content {
  position: absolute;
  top: 0;
  left: 0;
  width: 180px;
  height: 200px;
  display: flex;
  align-items: center;
  justify-content: center;
  background: rgba(0, 0, 0, 0.5);
  opacity: 0;
  border-radius: 4px;
  transition: opacity 0.3s ease;
}

.overlay:hover .overlay-content {
  opacity: 1;
}

.overlay-content i {
  color: #fff;
  font-size: 24px;
}

.cocktail-info {
  display: flex;
}

.cocktail-name-picture h2 {
  margin-top: 4px;
}

.cocktail-name-picture img {
  width: 400px;
  border-radius: 8px;
}

.ingredient-list {
  font-style: italic;
}

.ingredients-size-price select {
  background-color: white;
  color: black;
  border-radius: 4px;
  border: none;
  padding: 4px 8px;
}

.price-size {
  display: flex;
  gap: 20px;
  margin-bottom: 20px;
}

.price-size p {
  margin: 0;
}

.price-size label,
.price-size p {
  font-weight: 700;
  font-size: 20px;
  color: white;
}

.ingredients-size-price button {
  background: #00ff75;
  width: 280px;
  display: flex;
  align-items: center;
  gap: 10px;
  justify-content: center;
}

/* media queries */
@media screen and (min-width: 768px) {
  .cocktail-name-picture h2 {
    text-align: left;
  }
  .ingredients-size-price {
    padding-top: 60px;
    width: 320px;
  }
  .cocktail-info {
    gap: 20px;
  }
  .ingredient-list {
    margin-bottom: 40px;
  }
}
@media screen and (max-width: 768px) {
  .cocktail-grid {
    gap: 10px;
  }
  .cocktail-image {
    width: 139px;
    height: 180px;
  }
  .overlay .overlay-content {
    width: 139px;
    height: 180px;
  }
  .cocktail-info {
    flex-direction: column;
  }
  .cocktail-name-picture img {
    width: 200px;
  }
  .ingredient-list {
    text-align: left;
    font-size: 14px;
  }
  .ingredients-size-price h3 {
    margin: 8px 0;
    text-align: left;
  }
  .price-size {
    flex-direction: column;
    text-align: left;
  }
  .price-size p {
    font-size: 28px;
  }
}
</style>
