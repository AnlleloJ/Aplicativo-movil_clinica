package idat.edu.pe.grupo12.EC2Moviles

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import idat.edu.pe.grupo12.EC2Moviles.databinding.ActivityListaFormularioBinding

class ListaFormularioActivity : AppCompatActivity() {
    private lateinit var binding : ActivityListaFormularioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaFormularioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listaformulario = intent.getSerializableExtra("RegistrarFormulario")
                as ArrayList<String>
        val adapter = ArrayAdapter(this, R.layout.simple_list_item_1,
            listaformulario)



        binding.lvformulario.adapter = adapter


    }
}