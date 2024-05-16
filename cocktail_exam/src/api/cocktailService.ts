import axios from "axios";
import { ref, type Ref } from "vue";

const API_URL = "http://localhost:8080/api/cocktails";

export class CocktailService {
  Cocktail: Ref<Cocktail[]> = ref([]);
  isLoading: Ref<boolean> = ref(false);

  /* fonction pour récupérer tous les cocktails */
  async getCocktail(): Promise<any> {
    try {
      this.isLoading.value = true;
      const { data } = await axios.get(API_URL);
      return data;
    } catch (error) {
      console.log(error);
    } finally {
      this.isLoading.value = false;
    }
  }

  /* fonction pour créer un cocktail */
  async createCocktail(cocktail: any) {
    try {
      this.isLoading.value = true;
      await axios.post("http://localhost:8080/api/cocktail", cocktail);
    } catch (error) {
      console.log(error);
    } finally {
      this.isLoading.value = false;
    }
  }
}
