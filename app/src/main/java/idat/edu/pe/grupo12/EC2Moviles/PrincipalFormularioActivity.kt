package idat.edu.pe.grupo12.EC2Moviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import idat.edu.pe.grupo12.EC2Moviles.commom.AppRegistroMensaje
import idat.edu.pe.grupo12.EC2Moviles.commom.TipoMensaje
import idat.edu.pe.grupo12.EC2Moviles.databinding.ActivityPrincipalFormularioBinding

class PrincipalFormularioActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPrincipalFormularioBinding
    private val listarformulario = ArrayList<String>()
    private val registrarformulario = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrincipalFormularioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btn2: Button = findViewById(R.id.btnlistarformulario)
        btn2.setOnClickListener{
            val intent : Intent = Intent(this, ListaFormularioActivity::class.java)
            startActivity(intent)
        }

        //botones
        binding.btnresolverformulario.setOnClickListener(this)
        binding.btnlistarformulario.setOnClickListener(this)
        //pregunta 1
        binding.ckbgustoolfato.setOnClickListener(this)
        binding.ckbfiebre.setOnClickListener(this)
        binding.ckbnasal.setOnClickListener(this)
        binding.ckbgarganta.setOnClickListener(this)
        binding.ckbninguno.setOnClickListener(this)
        binding.ckbtos.setOnClickListener(this)
        //pregunta 5
        binding.ckbluz.setOnClickListener(this)
        binding.ckbagua.setOnClickListener(this)
        binding.ckbinternet.setOnClickListener(this)
        binding.ckbcable.setOnClickListener(this)



    }

    override fun onClick(view: View) {

        if(view is CheckBox){
            ModificarSintomayServicio(view)

        }else{
            when(view.id){
                R.id.btnlistarformulario -> irlistaformulario()
                R.id.btnresolverformulario -> irResolverformulario()

            }
        }

    }
// "\r" para salto de linea
    private fun irResolverformulario() {
        if (validarFormulario()) {
            var infoFormulario= obtenerpregunta2()+"\r"+
                    obtenerpregunta3()+"\r"+
                    obtenerpregunta4()+"\r"+
                    listarformulario.toString()

            registrarformulario.add(infoFormulario)

            AppRegistroMensaje.enviarMensaje(binding.root,
                "Registro exitoso.",
                TipoMensaje.SUCCESSFULL)
            setearControles()
        }
    }

    private fun obtenerpregunta4():String  {
        var pregunta4 = ""
        when(binding.RadioGroupP4.checkedRadioButtonId){
            R.id.rbtP4si -> pregunta4 = binding.rbtP4si.text.toString()
            R.id.rbtP4no -> pregunta4 = binding.rbtP4no.text.toString()
        }
        return pregunta4

    }

    private fun obtenerpregunta3():String  {
        var pregunta3 = ""
        when(binding.radioGrouppP3.checkedRadioButtonId){
            R.id.rbtP3si -> pregunta3 = binding.rbtP3si.text.toString()
            R.id.rbtP3no -> pregunta3 = binding.rbtP3no.text.toString()
        }
        return pregunta3

    }

    private fun obtenerpregunta2():String  {
        var pregunta2 = ""
        when(binding.radioGroupP2.checkedRadioButtonId){
            R.id.rbtP2si -> pregunta2 = binding.rbtP2si.text.toString()
            R.id.rbtP2no -> pregunta2 = binding.rbtP2no.text.toString()
        }
        return pregunta2

    }


    private fun setearControles(){

        //checkbutton pregunta 1
        binding.ckbgustoolfato.isChecked = false
        binding.ckbfiebre.isChecked = false
        binding.ckbnasal.isChecked = false
        binding.ckbgarganta.isChecked = false
        binding.ckbtos.isChecked = false
        binding.ckbninguno.isChecked = false
        //checkbutton pregunta 5
        binding.ckbluz.isChecked = false
        binding.ckbagua.isChecked = false
        binding.ckbinternet.isChecked = false
        binding.ckbcable.isChecked = false

        //pregunta 2, 3, 4
        binding.radioGroupP2.clearCheck()
        binding.radioGrouppP3.clearCheck()
        binding.RadioGroupP4.clearCheck()
    }

    //metodo listar formulario del boton "Verificar"
    private fun irlistaformulario() {
        val intentLista = Intent(
            this, ListaFormularioActivity::class.java
        ).apply {
            putExtra("RegistrarFormulario", registrarformulario)
        }
        startActivity(intentLista)

    }


    //modificar sintomas y servicios
    private fun ModificarSintomayServicio(checkBox: CheckBox) {
        if (checkBox.isChecked)
            listarformulario.add(checkBox.text.toString())
        else
            listarformulario.remove(checkBox.text.toString())
    }


   //metodo validación pregunta1
    fun validarSimtoma():Boolean{
        var respuesta = false
        if(binding.ckbnasal.isChecked || binding.ckbtos.isChecked || binding.ckbgarganta.isChecked ||
            binding.ckbgustoolfato.isChecked || binding.ckbfiebre.isChecked || binding.ckbninguno.isChecked)
        {
            respuesta = true
        }
        return respuesta
    }

    //metodo validación pregunta 5
    fun validarServicioBasico():Boolean{
        var respuesta = false
        if(binding.ckbluz.isChecked || binding.ckbinternet.isChecked || binding.ckbcable.isChecked || binding.ckbagua.isChecked)
        {
            respuesta = true
        }
        return respuesta
    }



    //validamos  pregunta 2
    fun validarpregunta2():Boolean{
        var respuesta = true
        if (binding.radioGroupP2.checkedRadioButtonId == -1){
            respuesta = false
        }
        return respuesta
    }

    //validamos pregunta 3
    fun validarpregunta3():Boolean{
        var respuesta = true
        if (binding.radioGrouppP3.checkedRadioButtonId == -1){
            respuesta = false
        }
        return respuesta
    }

    //validamos pregunta 4
    fun validarpregunta4():Boolean{
        var respuesta = true
        if (binding.RadioGroupP4.checkedRadioButtonId == -1){
            respuesta = false
        }
        return respuesta
    }

    //Validamos los registros creados
    fun validarFormulario():Boolean{
        var respuesta = false
        if (!validarServicioBasico()){
            AppRegistroMensaje.enviarMensaje(
                binding.root,
                "Por favor selecciona una opción en la pregunta 5.", TipoMensaje.ERROR)

        }else if (!validarSimtoma()){
            AppRegistroMensaje.enviarMensaje(
                binding.root,
                "Por favor, seleccionar una opción en la pregunta 1.", TipoMensaje.ERROR)

        }else if (!validarpregunta2()) {
            AppRegistroMensaje.enviarMensaje(
                binding.root,
                "Por favor, seleccionar una opción en la pregunta 2.", TipoMensaje.ERROR)
        }else if (!validarpregunta3()){
            AppRegistroMensaje.enviarMensaje(
                binding.root,
                "Por favor, seleccionar una opción en la pregunta 3.", TipoMensaje.ERROR)

        }else if (!validarpregunta4()){
            AppRegistroMensaje.enviarMensaje(
                binding.root,
                "Por favor, seleccionar una opción en la pregunta 4.", TipoMensaje.ERROR)
        }else{
            respuesta= true
        }
        return respuesta

    }

}