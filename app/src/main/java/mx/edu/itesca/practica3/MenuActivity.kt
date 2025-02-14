package mx.edu.itesca.practica3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var btn_antojitos:Button=findViewById(R.id.btn_cold_drinks) as Button
        var btn_sopas:Button=findViewById(R.id.btn_combos) as Button
        var btn_tortas:Button=findViewById(R.id.btn_salties) as Button
        var btn_bebidas:Button=findViewById(R.id.btn_custom) as Button

        btn_antojitos.setOnClickListener {
            var intent:Intent =Intent(this,ProductActivity::class.java)
            intent.putExtra("menuType","Antojitos")
            startActivity(intent)
        }

        btn_sopas.setOnClickListener {
            var intent:Intent =Intent(this,ProductActivity::class.java)
            intent.putExtra("menuType","Sopas")
            startActivity(intent)
        }

        btn_tortas.setOnClickListener {
            var intent:Intent =Intent(this,ProductActivity::class.java)
            intent.putExtra("menuType","Tortas")
            startActivity(intent)
        }

        btn_bebidas.setOnClickListener {
            var intent:Intent =Intent(this,ProductActivity::class.java)
            intent.putExtra("menuType","Bebidas")
            startActivity(intent)
        }
    }
}