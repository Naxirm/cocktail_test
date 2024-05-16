import { createRouter, createWebHistory } from "vue-router";
import Home from "../components/Home.vue";
import Cocktail from "../views/Cocktail.vue";
import Cocktails from "../views/Cocktails.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "Home",
      component: Home,
    },
    {
      path: "/cocktail",
      name: "Cocktail",
      component: Cocktail,
    },
    {
      path: "/cocktails",
      name: "cocktails",
      component: Cocktails,
    },
  ],
});

export default router;
