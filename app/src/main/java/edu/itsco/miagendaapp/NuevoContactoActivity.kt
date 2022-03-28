package edu.itsco.miagendaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import edu.itsco.miagendaapp.modelos.Contactos

class NuevoContactoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuevo_contacto)

        val txtNombre: EditText = findViewById(R.id.txt_nombre)
        val txtTelefono: EditText = findViewById(R.id.txt_telefono)
        val txtEmail: EditText = findViewById(R.id.txt_email)

        val btnAddcontacto: Button = findViewById(R.id.btn_add_contactos)

        btnAddcontacto.setOnClickListener {
            val nombre = txtNombre.text.toString()
            val telefono = txtTelefono.text.toString()
            val email = txtEmail.text.toString()
            val contacto = Contactos(nombre, telefono, email)
            //ASIGNAMOS EL CONTACTO EN EL INTENT
            intent.putExtra("CONTACTO",contacto)

            setResult(RESULT_OK, intent)
            Toast.makeText(this.applicationContext, "Contacto Agregado Correctamente",
                Toast.LENGTH_SHORT).show()
            //Finalizo El Activity

            finish()
        }



    }
}