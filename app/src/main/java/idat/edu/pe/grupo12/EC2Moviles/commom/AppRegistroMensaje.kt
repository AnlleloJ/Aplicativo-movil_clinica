package idat.edu.pe.grupo12.EC2Moviles.commom

import android.view.View
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import idat.edu.pe.grupo12.EC2Moviles.R

object AppRegistroMensaje {

    fun enviarMensaje(vista: View, mensaje: String, tipo: TipoMensaje){

        val snackbar = Snackbar.make(vista, mensaje, Snackbar.LENGTH_LONG)
        val snackbarView: View = snackbar.view

        if(tipo == TipoMensaje.ERROR){
            snackbarView.setBackgroundColor(
                ContextCompat.getColor(MiApp.instance, R.color.snackbarerror)
            )
        }else {
            snackbarView.setBackgroundColor(
                ContextCompat.getColor(MiApp.instance, R.color.snackbarsucces)
            )

        }
        snackbar.show()

    }
}