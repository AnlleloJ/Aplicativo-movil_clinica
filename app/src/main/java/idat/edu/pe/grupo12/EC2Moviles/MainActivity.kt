package idat.edu.pe.grupo12.EC2Moviles


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn1: Button = findViewById(R.id.btnregistro)
        btn1.setOnClickListener{
            val intent : Intent = Intent(this, PrincipalRegistroActivity::class.java)
            startActivity(intent)
        }

        val btn2: Button = findViewById(R.id.btnformulario)
        btn2.setOnClickListener{
            val intent : Intent = Intent(this, PrincipalFormularioActivity::class.java)
            startActivity(intent)
        }

        val btn3: Button = findViewById(R.id.btnlistado)
        btn3.setOnClickListener{
            val intent : Intent = Intent(this, PrincipalListadoActivity::class.java)
            startActivity(intent)
        }




    }


}