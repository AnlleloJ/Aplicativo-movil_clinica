package idat.edu.pe.grupo12.EC2Moviles.commom

import android.app.Application

class MiApp : Application() {

    companion object{
        lateinit var instance: MiApp
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }





}