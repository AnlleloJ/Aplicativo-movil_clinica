package idat.edu.pe.grupo12.EC2Moviles.Adaptador

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import idat.edu.pe.grupo12.EC2Moviles.Clase.Libros
import idat.edu.pe.grupo12.EC2Moviles.R
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.item_libro.view.*


class libroadapter(private val mContext: Context, private val listaLibros: List<Libros>): ArrayAdapter<Libros>(mContext,0, listaLibros ) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.item_libro, parent, false)

        val libro = listaLibros[position]

        layout.txtTitulo.text = libro.titulo
        layout.txtDescripcion.text = libro.descripcion
        layout.txtFecha.text = libro.fecha
        layout.imgLibro.setImageResource(libro.imagen)

        return layout
    }
}