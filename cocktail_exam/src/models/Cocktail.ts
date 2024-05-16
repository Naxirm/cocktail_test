interface Category {
  category_id: number;
  name: string;
}

interface Ingredient {
  ingredient_id: number;
  name: string;
}

interface Cocktail {
  cocktail_id: number;
  name: string;
  price_s: number;
  price_m: number;
  price_l: number;
  image: string;
  categories: Category[];
  ingredients: Ingredient[];
}
