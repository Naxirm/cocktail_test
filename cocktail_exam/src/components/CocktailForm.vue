<script setup lang="ts">
import { ref } from "vue";
import { CocktailService } from "../api/cocktailService";

const newCocktail = ref({
  name: "",
  image: "",
  price_s: 0,
  price_m: 0,
  price_l: 0,
  ingredients: [{ name: "" }],
  categories: [{ name: "" }],
});

const cocktailService = new CocktailService();

const createCocktail = async () => {
  try {
    await cocktailService.createCocktail(newCocktail.value);
    alert("Cocktail créé avec succès!");
  } catch (error) {
    console.error("Erreur lors de la création du cocktail:", error);
    alert(
      "Une erreur est survenue lors de la création du cocktail. Veuillez réessayer."
    );
  }
};

const addIngredient = () => {
  newCocktail.value.ingredients.push({ name: "" });
};

const removeIngredient = (index: number) => {
  newCocktail.value.ingredients.splice(index, 1);
};

const addCategory = () => {
  newCocktail.value.categories.push({ name: "" });
};

const removeCategory = (index: number) => {
  newCocktail.value.categories.splice(index, 1);
};
</script>

<template>
  <div>
    <h2>Créer un nouveau cocktail</h2>
    <form @submit.prevent="createCocktail">
      <div>
        <label for="name">Nom:</label>
        <input type="text" id="name" v-model="newCocktail.name" required />
      </div>
      <div>
        <label for="image">Image URL:</label>
        <input type="text" id="image" v-model="newCocktail.image" required />
      </div>
      <div>
        <label for="price_s">Prix (S):</label>
        <input
          type="number"
          id="price_s"
          v-model="newCocktail.price_s"
          required
        />
      </div>
      <div>
        <label for="price_m">Prix (M):</label>
        <input
          type="number"
          id="price_m"
          v-model="newCocktail.price_m"
          required
        />
      </div>
      <div>
        <label for="price_l">Prix (L):</label>
        <input
          type="number"
          id="price_l"
          v-model="newCocktail.price_l"
          required
        />
      </div>
      <div>
        <label for="ingredients">Ingrédients:</label>
        <div
          v-for="(ingredient, index) in newCocktail.ingredients"
          :key="index"
        >
          <input
            type="text"
            v-model="ingredient.name"
            placeholder="Nom de l'ingrédient"
            required
          />
          <button type="button" @click="removeIngredient(index)">
            Supprimer
          </button>
        </div>
        <button type="button" @click="addIngredient">
          Ajouter un ingrédient
        </button>
      </div>
      <div>
        <label for="categories">Catégories:</label>
        <div v-for="(category, index) in newCocktail.categories" :key="index">
          <input
            type="text"
            v-model="category.name"
            placeholder="Nom de la catégorie"
            required
          />
          <button type="button" @click="removeCategory(index)">
            Supprimer
          </button>
        </div>
        <button type="button" @click="addCategory">
          Ajouter une catégorie
        </button>
      </div>
      <button type="submit">Créer</button>
    </form>
  </div>
</template>
