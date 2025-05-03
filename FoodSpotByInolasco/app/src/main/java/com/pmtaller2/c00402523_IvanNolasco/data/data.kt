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
    Dish(1,"Tacos al Pastor","Tacos de cerdo marinado en achiote, cocidos en trompo con piña y cilantro.","https//comedera.com/wp-content/uploads/sites/9/2017/08/tacos-al-pastor-receta.jpg"),
    Dish(2,"Enchiladas Suizas","Tortillas rellenas de pollo bañadas en salsa verde y gratinadas con queso.","https//example.com/enchiladas-suizas.jpg"),
    Dish(3,"Mole Poblano","Pollo cubierto con una salsa espesa de chiles, chocolate y especias.","https//example.com/mole-poblano.jpg"),
    Dish(4,"Chiles en Nogada","Chiles poblanos rellenos de picadillo, cubiertos con salsa de nuez y granada.","https//example.com/chiles-nogada.jpg"),

    Dish(21,"Mojito","Cóctel refrescante con ron, menta, lima, azúcar y soda.","https//example.com/mojito.jpg"),
    Dish(22,"Margarita","Tequila, triple sec y jugo de lima con borde de sal.","https//example.com/margarita.jpg"),
    Dish(23,"Café Frappé","Café frío batido con hielo y leche, coronado con crema batida.","https//example.com/frappe.jpg"),
    Dish(24,"Agua de Jamaica","Bebida refrescante hecha con flor de jamaica, endulzada al gusto.","https//cdn7.kiwilimon.com/recetaimagen/31783/640x640/36556.jpg"),
)

val italianFood = listOf(
    Dish(5,"Pizza Margherita","Pizza clásica con salsa de tomate, mozzarella y albahaca fresca.","https//assets.tmecosys.com/image/upload/t_web_rdp_recipe_584x480/img/recipe/ras/Assets/5802fab5-fdce-468a-a830-43e8001f5a72/Derivates/c00dc34a-e73d-42f0-a86e-e2fd967d33fe.jpg"),
    Dish(6,"Lasagna","Pasta en capas con carne, queso y salsa boloñesa, horneada al gratén.","https//example.com/lasagna.jpg"),
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
    Restaurant(3, "Laca Lacatrina", "Comida mexicana", "https//example.com/ramen-tonkotsu.jpg", taquitosCategories, mexicanFood),
    Restaurant(4, "Tapatías", "Comida mexicana", "https//example.com/ramen-tonkotsu.jpg", taquitosCategories, mexicanFood),
)

val categories = listOf(
    Category(1, "Comida méxicana", mexicanRestaurants),
    Category(2, "Comida rápida", restaurants),
//    Category(3, "Comida italiana"),
//    Category(4, "Postres"),
//    Category(5, "Comida saludable")
)

val categoriesRestaurantMap = mapOf(
    1 to restaurants
)


