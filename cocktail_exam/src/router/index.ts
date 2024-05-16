import { createRouter, createWebHistory } from "vue-router";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "Home",
      component: () => import("../views/Home.vue"),
    },
    {
      path: "/cocktail",
      name: "Cocktail",
      component: () => import("../views/Cocktail.vue"),
    },
    {
      path: "/cocktails",
      name: "cocktails",
      component: () => import("../views/Cocktails.vue"),
    },
  ],
});

export default router;
