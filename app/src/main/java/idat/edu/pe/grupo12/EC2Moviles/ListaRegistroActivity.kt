package idat.edu.pe.grupo12.EC2Moviles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import idat.edu.pe.grupo12.EC2Moviles.databinding.ActivityListaRegistroBinding
import android.R

class ListaRegistroActivity : AppCompatActivity() {
    private lateinit var binding : ActivityListaRegistroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listasregistro = intent.getSerializableExtra("Listaregistro")
                    as ArrayList<String>
         val adapter = ArrayAdapter(this, R.layout.simple_list_item_1,
             listasregistro)



        binding.lvregistro.adapter = adapter


    }
}