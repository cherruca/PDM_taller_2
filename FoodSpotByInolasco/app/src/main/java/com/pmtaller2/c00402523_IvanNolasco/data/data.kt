package com.pmtaller2.c00402523_IvanNolasco.data

import kotlinx.serialization.Serializable

@Serializable
data class Dish(
    val id: Int,
    val name: String,
    val description: String,
    val imageUrl: String
)

@Serializable
data class Restaurant(
    val id: Int,
    val name: String,
    val description: String,
    val imageUrl: String,
    val categories: List<String>,
    val menu: List<Dish>
)

data class Category(
    val id: Int,
    val name: String,
    val restaurants: List<Restaurant>
)



val mexicanFood = listOf(
    Dish(1,"Tacos al Pastor","Tacos de cerdo marinado en achiote, cocidos en trompo con piña y cilantro.","https://s3.amazonaws.com/static.realcaliforniamilk.com/media/recipes_2/tacos-al-pastor.jpg"),
    Dish(2,"Enchiladas Suizas","Tortillas rellenas de pollo bañadas en salsa verde y gratinadas con queso.","https://cdn7.kiwilimon.com/recetaimagen/26245/640x640/38984.jpg.jpg"),
    Dish(3,"Mole Poblano","Pollo cubierto con una salsa espesa de chiles, chocolate y especias.","https://mmmole.com/wp-content/uploads/2019/01/mole-poblano-11-500x500.jpg"),
    Dish(4,"Chiles en Nogada","Chiles poblanos rellenos de picadillo, cubiertos con salsa de nuez y granada.","https://osojimix.mx/wp-content/uploads/2022/10/CHILES-EN-NOGADA.jpg"),

    Dish(22,"Margarita","Tequila, triple sec y jugo de lima con borde de sal.","https://assets.tmecosys.com/image/upload/t_web_rdp_recipe_584x480_1_5x/img/recipe/ras/Assets/3412D77E-76BE-44B1-8663-3BECCFA1FA79/Derivates/ACB48D20-161F-490E-B4F4-6B502165D823.jpg"),
    Dish(21,"Mojito","Cóctel refrescante con ron, menta, lima, azúcar y soda.","https//example.com/mojito.jpg"),

    Dish(23,"Café Frappé","Café frío batido con hielo y leche, coronado con crema batida.","https//example.com/frappe.jpg"),
    Dish(24,"Agua de Jamaica","Bebida refrescante hecha con flor de jamaica, endulzada al gusto.","https//cdn7.kiwilimon.com/recetaimagen/31783/640x640/36556.jpg"),
)

val italianFood = listOf(
    Dish(5,"Pizza Margherita","Pizza clásica con salsa de tomate, mozzarella y albahaca fresca.","https://www.elespectador.com/resizer/v2/D2KL4RRCRJA7RJC5TNULFZEKR4.jpg?auth=a0183c8d1446b9e01eaae717179a0b2d52646e7be97600a983f12574a90d6a6b&width=920&height=613&smart=true&quality=60"),
    Dish(6,"Lasagna","Pasta en capas con carne, queso y salsa boloñesa, horneada al gratén.","https://www.recetasdesbieta.com/wp-content/uploads/2018/10/lasagna-original..jpg"),
    Dish(7,"Risotto de Champiñones","Arroz cremoso cocinado con champiñones, vino blanco y queso parmesano.","https//example.com/risotto.jpg")
)

val desserts = listOf(
    Dish(8,"Tiramisú","Postre italiano con capas de bizcocho, café, mascarpone y cacao.","https//example.com/tiramisu.jpg"),
    Dish(9,"Cheesecake de Fresa","Tarta de queso cremosa con cubierta de fresas frescas.","https//example.com/cheesecake-fresa.jpg"),
    Dish(10,"Brownie de Chocolate","Postre denso de chocolate con nueces, servido caliente.","https//example.com/brownie.jpg"),
    Dish(11,"Churros con Chocolate","Palitos de masa frita acompañados de chocolate caliente espeso.","https//7diasdesabor.com/wp-content/uploads/2022/05/churros-con-salsa-de-chocolate.jpg"),
    Dish(12,"Croissant de Mantequilla","Pan hojaldrado francés con aroma a mantequilla.","https//example.com/croissant.jpg"),
    Dish(13,"Bagel con Queso Crema","Pan en forma de anillo con queso crema y salmón ahumado.","https//example.com/bagel.jpg")
)

val fastFood = listOf(
    Dish(14,"Hamburguesa Clásica","Carne de res, queso, lechuga, tomate y salsa especial en pan suave.","https//example.com/hamburguesa-clasica.jpg"),
    Dish(15,"Hot Dogs","Jumbo hot dog con tocino, cebolla caramelizada y mostaza-miel.","https//example.com/hot-dogs.jpg"),
    Dish(16,"Alitas BBQ","Alitas de pollo bañadas en salsa barbacoa, servidas con apio y aderezo.","https//cdn7.kiwilimon.com/recetaimagen/33623/960x640/39037.jpg.jpg"),
)

val healthyFood = listOf(
    Dish(17,"Ensalada César","Lechuga romana, croutones, parmesano y aderezo cremoso.","https//example.com/ensalada-cesar.jpg"),
    Dish(18,"Bowl de Quinoa","Quinoa, aguacate, garbanzos, espinacas y aderezo de limón.","https//example.com/quinoa-bowl.jpg"),
    Dish(19,"Hummus con Pan Pita","Puré de garbanzos con tahini, ajo y aceite de oliva.","https//newmansown.com/wp-content/uploads/2022/07/Garlic-Hummus.jpg"),
    Dish(20,"Salmón a la Parrilla","Salmón con glaseado de miel y mostaza, acompañado de espárragos.","https//example.com/salmon-parrilla.jpg")
)

//val drinks = listOf(
//
//)

val asianFood = listOf(
    Dish(25,"Sushi Nigiri","Piezas de arroz con pescado fresco (salmón, atún o camarón).","https//example.com/sushi-nigiri.jpg"),
    Dish(26,"Pad Thai","Fideos de arroz salteados con camarones, huevo y cacahuates.","https//www.spicescave.com/blog/wp-content/uploads/2016/03/Pad_thai_700x500.jpg"),
    Dish(27,"Ramen Tonkotsu","Fideos en caldo de cerdo con huevo marinado y cerdo chashu.","https//example.com/ramen-tonkotsu.jpg")
)

val pizzaHotCategories = listOf("italian")
val taquitosCategories = listOf("mexican", "drinks")

val restaurants = listOf(
    Restaurant(1, "Pizza Hot", "Pizzas bien calientes \uD83E\uDD75", "https://www.novachef.es/media/images/pizza-pepperoni.jpg", pizzaHotCategories, italianFood),
)

val mexicanRestaurants = listOf(
    Restaurant(2, "Taquito Brothers", "Comida mexicana", "https://www.recetasnestlecam.com/sites/default/files/2023-08/platos-ingredientes-comida-mexicana_0.jpg", taquitosCategories, mexicanFood),
    Restaurant(3, "Laca Lacatrina", "Comida mexicana", "https://www.visitstaugustine.com/sites/default/files/styles/meta_4x3/public/2023-10/la-catrina-food-25x15-WEB.jpg?itok=YJ2X0kbd", taquitosCategories, mexicanFood),
    Restaurant(4, "Tapatías", "Comida mexicana", "https://gran.luchito.com/wp-content/uploads/2021/07/BBQ-Corn-Hero-660x500.jpg", taquitosCategories, mexicanFood),
)

val italianRestaurants = listOf(
    Restaurant(5, "El Padrini", "Un platillo al que no te puedes rehusar", "https://www.travelsphere.co.uk/media/5mpbkpmc/istock_italy_food_spaghetti_800x500.png?rmode=max&width=500&format=webp", taquitosCategories, italianFood)
)

val bakeryRestaurants = listOf(
    Restaurant(6, "Dulce Diabetes", "Explosión dulce en tu corazón", "https://hips.hearstapps.com/hmg-prod/images/fruit-tart-index-65ef54d972bb1.jpg?crop=0.505xw:1.00xh;0.495xw,0&resize=640:*", taquitosCategories, desserts)
)

val healthyRestaurants = listOf(
    Restaurant(6, "Veggie palace", "Comida insipida", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS2w5OJiz3w7y1d79GHbh0PfS0CkMl-kpfgAg&s", taquitosCategories, healthyFood)
)

val categories = listOf(
    Category(1, "Comida méxicana", mexicanRestaurants),
    Category(2, "Comida rápida", restaurants),
    Category(3, "Comida italiana", italianRestaurants),
    Category(4, "Postres", bakeryRestaurants),
    Category(5, "Comida saludable", healthyRestaurants)
)

val categoriesRestaurantMap = mapOf(
    1 to restaurants
)


