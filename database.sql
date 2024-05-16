DROP DATABASE my_cocktail_bdd;
CREATE DATABASE my_cocktail_bdd;
USE my_cocktail_bdd;

CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255),
    password VARCHAR(255),
    user_type VARCHAR(255)
);

CREATE TABLE categories (
    category_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE cocktails (
    cocktail_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    image VARCHAR(255),
    price_s DECIMAL(5,2),
    price_m DECIMAL(5,2),
    price_l DECIMAL(5,2)
);

CREATE TABLE ingredients (
    ingredient_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE cocktails_ingredients (
    cocktail_id INT,
    ingredient_id INT,
    FOREIGN KEY (cocktail_id) REFERENCES cocktails(cocktail_id),
    FOREIGN KEY (ingredient_id) REFERENCES ingredients(ingredient_id),
    PRIMARY KEY (cocktail_id, ingredient_id)
);

CREATE TABLE cocktail_category (
	cocktail_id INT,
    category_id INT,
	FOREIGN KEY (cocktail_id) REFERENCES cocktails(cocktail_id),
    FOREIGN KEY (category_id) REFERENCES categories(category_id),
    PRIMARY KEY (cocktail_id, category_id)
);

CREATE TABLE orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    status VARCHAR(50),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE ordersCocktailsDetail (
    order_id INT,
    cocktail_id INT,
    status VARCHAR(50),
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (cocktail_id) REFERENCES cocktails(cocktail_id),
    PRIMARY KEY (order_id, cocktail_id)
);

/*J'ai créé ci-dessous des isertions pour populer la database afin d'avoir des cocktails sur ma page /cocktails */
INSERT INTO users (email, password, user_type) VALUES
('user1@example.com', 'password1', 'client'),
('user2@example.com', 'password2', 'barmaker');

INSERT INTO categories (name) VALUES
('Alcoolisé'),
('Sans alcool'),
('Classique'),
('Fruité'),
('Épicé');

INSERT INTO cocktails (name, image, price_s, price_m, price_l) VALUES
('Mojito', 'https://www.thecocktaildb.com/images/media/drink/metwgh1606770327.jpg', 8.50, 10.50, 12.50),
('Vampiro', 'https://www.thecocktaildb.com/images/media/drink/yfhn371504374246.jpg', 6.50, 8.50, 10.50),
('Cosmopolitan', 'https://www.thecocktaildb.com/images/media/drink/kpsajh1504368362.jpg', 9.50, 11.50, 13.50),
('Margarita', 'https://www.thecocktaildb.com/images/media/drink/5noda61589575158.jpg', 9.50, 11.50, 13.50),
('Piña Colada', 'https://www.thecocktaildb.com/images/media/drink/upgsue1668419912.jpg', 10.50, 12.50, 14.50),
('Cocktail Horse’s Neck', 'https://www.thecocktaildb.com/images/media/drink/4vobt21643844913.jpg', 9.50, 11.50, 13.50);

INSERT INTO ingredients (name) VALUES
('Rhum'),
('Jus de citron vert'),
('Feuilles de menthe'),
('Sucre de canne'),
('Eau gazeuse'),
('Glaçons'),
('Jus de cranberry'),
('Liqueur d''orange'),
('Jus de citron jaune'),
('Triple sec'),
('Tequila'),
('Jus de lime'),
('Sel'),
('Ananas'),
('Crème de coco'),
('Cognac'),
('Ginger Beer'),
('Angostura Bitter');

INSERT INTO cocktails_ingredients (cocktail_id, ingredient_id) VALUES
(1, 1), (1, 2), (1, 3), (1, 4), (1, 5), (1, 6),
(2, 2), (2, 3), (2, 4), (2, 5), (2, 6),
(3, 1), (3, 7), (3, 8), (3, 9), (3, 10),
(4, 11), (4, 12), (4, 13),
(5, 11), (5, 14), (5, 15),
(6, 16), (6, 17), (6, 18);

INSERT INTO cocktail_category (cocktail_id, category_id) VALUES
(1, 1), (1 ,4), (2, 2), (3, 1), (4, 1), (5, 4), (6, 5);
