package mx.edu.itesca.practica3

import Product
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProductActivity : AppCompatActivity() {

    var menu:ArrayList<Product> = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_product)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var menuOption:String? = intent.getStringExtra("menuType")

        agregarProductos(menuOption)

        var list:ListView =findViewById(R.id.lv) as ListView

        var iv:ImageView = findViewById(R.id.iv) as ImageView

        when(menuOption){
            "Antojitos" -> iv.setImageResource(R.drawable.antojitos)
            "Sopas" -> iv.setImageResource(R.drawable.sopas)
            "Tortas" -> iv.setImageResource(R.drawable.tortas)
            "Bebidas" -> iv.setImageResource(R.drawable.drinks)

        }

        var adaptador:AdatadorProductos = AdatadorProductos(this,menu)

        list.adapter = adaptador

    }

    fun agregarProductos(option:String?){
        when(option){
            "Antojitos" -> {
                menu.add(Product("Quesadillas", R.drawable.quesadillas, "Rellenas con su carne favorita - Filled with your choice of meat, served with salad.",5.99))
                menu.add(Product("Huaraches", R.drawable.huaraches, "Tortilla gruesa con frijoles, tu carne favorita, lechuga, queso fresco y crema - Big Thick tortilla with beans, your choice of meat, fresh cheese, and sour cream.",10.99))
                menu.add(Product("Gringas", R.drawable.gringas, "Tortilla de harina con queso, carne al pastor y piña - Flour tortilla filled with cheese, marinated pork and pineapple.",7.99))
                menu.add(Product("Sincronizadas", R.drawable.sincronizadas, "Tortilla de harina rellena con queso y jamón. Acompañada de lechuga, crema y guacamole - Two four tortillas filled with ham and cheese. Served with lettuce, sour cream, and guacamole.",7.99))
                menu.add(Product("Sopes", R.drawable.sopes, "Tortilla gruesa cubierta de frijoles, tu carne favorita, lechuga, queso fresco y crema - Fried thick tortilla with beans, your choice of meat, lettuce, fresh cheese, and sour cream.",3.79))
                menu.add(Product("Tostadas", R.drawable.tostadas, "Tortilla frita con frijoles, tu carne favorita, lechuga, queso fresco, crema y jitomate - Fried tortilla with beans, your choice of meat, lettuce, fresh cheese, sour cream and tomatoes.",4.59))
            }
            "Sopas" -> {
                menu.add(Product("Pozole", R.drawable.pozole, "Weekends only",5.99))
                menu.add(Product("Menudo", R.drawable.menudo, "Wednesday to Sunday",5.99))
                menu.add(Product("Caldo de Res", R.drawable.caldores, "",5.99))
                menu.add(Product("Caldo de Camarón", R.drawable.caldocamaron, "Shrimp soup",13.99))
                menu.add(Product("Sopa de Mariscos", R.drawable.sopamariscos, "Seafood soup",19.79))
            }
            "Tortas" -> {
                menu.add(Product("Torta Regular", R.drawable.torta, "All tortas come with lettuce, onions, tomatoes, avocado, sour cream, jalapeno pepper and your choice of meat.",12.99))
                menu.add(Product("Torta de Milanesa", R.drawable.tortamilanesa, "Breaded Steak or Chicken",13.99))
                menu.add(Product("Torta Cubana", R.drawable.tortacubana, "Chorizo, asada, jamon, pastor y queso Mexican sausage, steak, marinated pork, ham, and cheese",13.99))
                menu.add(Product("Torta Mixta", R.drawable.tortamixta, "Chorizo, asada y pastor./ Mexican sausage, steak and marinated pork.",13.99))
            }
            "Bebidas"->{
                menu.add(Product("Jarritos", R.drawable.jarritos, "",2.75))
                menu.add(Product("Caguama", R.drawable.caguama, "",2.75))


            }
        }

    }

    private class AdatadorProductos: BaseAdapter{
        var productos = ArrayList<Product>()
        var context:Context?=null
        constructor(context:Context,productos:ArrayList<Product>){
            this.productos = productos
            this.context = context
        }

        override fun getCount(): Int {
            return productos.size
        }

        override fun getItem(position: Int): Any {
            return productos[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var prod = productos[position]
            var inflador = LayoutInflater.from(context)
            var vista=inflador.inflate(R.layout.product_view,null)

            var img = vista.findViewById(R.id.iv_product) as ImageView
            var name = vista.findViewById(R.id.tv_product_name) as TextView
            var desc = vista.findViewById(R.id.tv_product_description) as TextView
            var price = vista.findViewById(R.id.tv_product_price) as TextView

            img.setImageResource(prod.image)
            name.setText(prod.name)
            desc.setText(prod.description)
            price.setText("$${prod.price}")

            return vista
        }
    }

}