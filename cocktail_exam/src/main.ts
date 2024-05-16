import "./style.css";
import { createApp } from "vue";
import App from "./App.vue";
import router from "../../cocktail_exam/src/router";
import FontAwesomeIcon from "../fontawesome.ts";

const app = createApp(App);

app.component("font-awesome-icon", FontAwesomeIcon);

app.use(router);

app.mount("#app");
