package idat.edu.pe.grupo12.EC2Moviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import android.widget.Button
import android.widget.CheckBox
import idat.edu.pe.grupo12.EC2Moviles.commom.AppRegistroMensaje
import idat.edu.pe.grupo12.EC2Moviles.commom.TipoMensaje
import idat.edu.pe.grupo12.EC2Moviles.databinding.ActivityPrincipalRegistroBinding


class PrincipalRegistroActivity : AppCompatActivity(), View.OnClickListener{


    private lateinit var binding: ActivityPrincipalRegistroBinding
    private val listardatos = ArrayList<String>()
    private val listaregistro = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrincipalRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btn1: Button = findViewById(R.id.btnlistarregistro)
        btn1.setOnClickListener{
            val intent : Intent = Intent(this, ListaRegistroActivity::class.java)
            startActivity(intent)
        }

        binding.btnaccederregistro.setOnClickListener(this)
        binding.btnlistarregistro.setOnClickListener(this)
        binding.chkdeporte.setOnClickListener(this)
        binding.chkpintura.setOnClickListener(this)
        binding.chkotro.setOnClickListener(this)

    }

    override fun onClick(view: View) {

        if(view is CheckBox){
            modificarpreferencia(view)

        }else{
            when(view.id){
                R.id.btnlistarregistro -> irlistaRegistro()
                R.id.btnaccederregistro -> RegistrarUsuario()

            }
        }

    }

    private fun RegistrarUsuario() {
        if (validarFormularioRegistro()) {
            var infousuario=binding.etDNIRegistro.text.toString()+"\r"+
                    binding.etApellidoRegistro.text.toString()+"\r"+
                    binding.etNombreRegstro.text.toString()+"\r"+
                    binding.etemailRegistro.text.toString()+"\r"+
                    binding.etpaswRegistro.text.toString()+"\r"+
                    obtenergeneroseleccionado() +"\r"+
                    listardatos.toString()

            listaregistro.add(infousuario)

            AppRegistroMensaje.enviarMensaje(binding.root,
            "Registro exitoso.",
                TipoMensaje.SUCCESSFULL)
                setearControles()
        }

    }
    private fun setearControles(){
        binding.etDNIRegistro.setText("")
        binding.etNombreRegstro.setText("")
        binding.etApellidoRegistro.setText("")
        binding.etemailRegistro.setText("")
        binding.etpaswRegistro.setText("")
        binding.chkdeporte.isChecked = false
        binding.chkpintura.isChecked = false
        binding.chkotro.isChecked = false
        binding.etotrohobby.setText("")
        binding.RadioGroupGenero.clearCheck()
        binding.etDNIRegistro.isFocusableInTouchMode = true
        binding.etDNIRegistro.requestFocus()

    }

    //metodo listar registro del boton listar
    private fun irlistaRegistro() {
        val intentLista = Intent(
            this, ListaRegistroActivity::class.java
        ).apply {
            putExtra("Listaregistro", listaregistro)
        }
        startActivity(intentLista)

    }


//modificar preferencia
    private fun modificarpreferencia(checkBox: CheckBox) {
    if (checkBox.isChecked)
        listardatos.add(checkBox.text.toString())
    else
        listardatos.remove(checkBox.text.toString())
    }


//metodo preferencia de hobby
    fun validarPreferencia():Boolean{
        var respuesta = false
        if(binding.chkdeporte.isChecked || binding.chkpintura.isChecked || binding.chkotro.isChecked || binding.etotrohobby.text.toString().trim().isEmpty())
        {
            respuesta = true
        }
        return respuesta
    }


//obtener genero
    fun obtenergeneroseleccionado(): String {
        var genero = ""
        when(binding.RadioGroupGenero.checkedRadioButtonId){
            R.id.rbtmujer -> genero = binding.rbtmujer.text.toString()
            R.id.rbthombre -> genero = binding.rbthombre.text.toString()
        }
        return genero
    }


//validamos  genero
    fun validarGenero():Boolean{
        var respuesta = true
        if (binding.RadioGroupGenero.checkedRadioButtonId == -1){
            respuesta = false
        }
        return respuesta
    }



//Validamos los datos del primer campo de registro
    fun validardatosregistro() :Boolean {
        var respuesta = true
        if(binding.etDNIRegistro.text.toString().trim().isEmpty()){
            binding.etDNIRegistro.isFocusableInTouchMode = true
            binding.etDNIRegistro.requestFocus()
            respuesta=false

        }else if(binding.etNombreRegstro.text.toString().trim().isEmpty()){
            binding.etNombreRegstro.isFocusableInTouchMode = true
            binding.etNombreRegstro.requestFocus()
            respuesta=false

        }else if(binding.etApellidoRegistro.text.toString().trim().isEmpty()){
            binding.etApellidoRegistro.isFocusableInTouchMode = true
            binding.etApellidoRegistro.requestFocus()
            respuesta = false

        }else if(binding.etemailRegistro.text.toString().trim().isEmpty()){
            binding.etemailRegistro.isFocusableInTouchMode = true
            binding.etemailRegistro.requestFocus()
            respuesta = false

        }else if(binding.etpaswRegistro.text.toString().trim().isEmpty()){
            binding.etpaswRegistro.isFocusableInTouchMode = true
            binding.etpaswRegistro.requestFocus()
            respuesta = false

        }
        return respuesta

    }


    //Validamos los registros creados
    fun validarFormularioRegistro():Boolean{
        var respuesta = false
        if(!validardatosregistro()){
            AppRegistroMensaje.enviarMensaje(
                binding.root,
            "Datos personales obligatorios.", TipoMensaje.ERROR)

        }else if (!validarGenero()){
            AppRegistroMensaje.enviarMensaje(
                binding.root,
            "Por favor, seleccionar un genero", TipoMensaje.ERROR)

        }else if (!validarPreferencia()){
            AppRegistroMensaje.enviarMensaje(
                binding.root,
            "Por favor, seleccionar una opción.", TipoMensaje.ERROR)

        }else{
            respuesta= true
        }
        return respuesta

    }



}