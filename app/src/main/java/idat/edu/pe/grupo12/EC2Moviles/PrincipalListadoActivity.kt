package idat.edu.pe.grupo12.EC2Moviles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import idat.edu.pe.grupo12.EC2Moviles.Adaptador.libroadapter
import idat.edu.pe.grupo12.EC2Moviles.Clase.Libros
import kotlinx.android.synthetic.main.activity_principal_listado.*

class PrincipalListadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal_listado)

        val libro1 = Libros("Anatomía",
            "El esqueleto y el sistema muscular, los nervios y las glándulas endocrinas," +
                " el sistema respiratorio y digestivo, la circulación sanguínea, la piel, los órganos reproductores.",
            "19/01/2010", R.drawable.anatomia)

        val libro2 = Libros("Diagnostico médico en pediatría",
            "La obra, desarrollada en 88 capítulos, expone en cada uno de ellos un caso clínico en un lenguaje amigable y fácil de entender. " +
                "Cada caso inicia con el motivo principal de consulta, antecedentes de la enfermedad, antecedentes médicos, exploración física, consideraciones diagnósticas.",
            "30/08/2022",R.drawable.diagnostico_medico_pediatra)

        val libro3 = Libros("El año de la pandemia",
            "Transcurrido un tiempo prudencial y superada una de las peores crisis sanitarias de la historia, toca hacer balance y dar cuenta.",
            "07/09/2022", R.drawable.a_o_de_la_pandemia)

        val libro4 = Libros("Psicofarmacología",
            "Su objetivo es facilitar el estudio a todos los que se enfrentan por primera vez a la psicofarmacología. " +
                    "Primeramente, se explican de forma sencilla los conceptos básicos de la farmacología ilustrándolos con ejemplos de psicofármacos y su acción en el cerebro. ",
            "21/09/2022", R.drawable.psicofarmacologia)

        val libro5 = Libros("Pocket del médico de guardia",
            "Ha sido por solicitud de muchos médicos NO MIR que entendían que la utilidad de este libro no tiene límites." +
                " El éxito y aceptación de la primera edición motivó aún más a los autores," +
                " que han trabajado y conseguido mejorar la nueva edición.",
            "02/09/2021", R.drawable.pocket_el_medico_de_guardia)

        val libro6 = Libros("Medicina de Ur y Em 6",
            "En esta 6ª edición vuelve a primar el enfoque práctico ofreciendo a los lectores soluciones a la diversidad de situaciones a las que tienen que hacer frente día tras día los profesionales de urgencias",
            "15/05/2021", R.drawable.urgencia_y_emergencia)

        val libro7 = Libros("Radiologo", "Radiología Fundamental es el libro que contempla todas las técnicas (RM, TC, RX, Eco)," +
                " moderno y didáctico, distinguiéndose por no sólo ser para radiólogos. ",
            "05/08/2022", R.drawable.radiologia)

        val libro8 = Libros("Dermatología en AP 2da edición",
            "La importante carga asistencial que representan las alteraciones de la piel unida a la relativa escasez" +
                    " de fuentes de información orientadas al médico no dermatólogo convierten la atención de la patología cutánea.",
            "03/05/2022", R.drawable.dermatologia)

        val libro9 = Libros("Oxígeno, un paradigma",
            "Oxígeno, un nuevo paradigma es una obra única en su tipo del aclamado autor Dr. Paul Marino (El libro de la UCI y El manual de la UCI)" +
                " que desafía la noción tradicional de que el cuerpo humano se nutre de oxígeno y que favorecer la oxigenación de los tejidos es necesario. ",
            "09/07/2022", R.drawable.oxigeno)

        val libro10 = Libros("Manual de ICTUS(3ra edición)",
            "Este término contribuyó a promover la idea de que los pacientes con ictus eran víctimas y que, de alguna manera," +
                    " el trastorno era providencial; por lo tanto, no era algo que estuviera sujeto a intervención de médicos o científicos.",
            "15/08/2022",R.drawable.ictus)

        val listaLibro = listOf(libro1,libro2,libro3,libro4,libro5,libro6,libro7,libro8,libro9,libro10)

        val adapter = libroadapter(this, listaLibro )

        lvprincipal.adapter = adapter



    }
}