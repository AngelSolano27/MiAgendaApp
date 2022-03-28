package edu.itsco.miagendaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import edu.itsco.miagendaapp.adapters.ContactosAdapter
import edu.itsco.miagendaapp.modelos.Contactos

class MainActivity : AppCompatActivity() {

    private val adaptadorContactos: ContactosAdapter = ContactosAdapter(ArrayList<Contactos>())



    private val startForResult = registerForActivityResult( ActivityResultContracts.StartActivityForResult()){
        if (it.resultCode== RESULT_OK){
            val intent = it.data
            val contacto:Contactos? = intent?.getParcelableExtra<Contactos>("CONTACTO")
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerContactos: RecyclerView = findViewById(R.id.recyclerView)
        recyclerContactos.adapter = adaptadorContactos
        recyclerContactos.layoutManager = LinearLayoutManager(this)
        recyclerContactos.setHasFixedSize(true)

        val fabAddContacto:FloatingActionButton = findViewById(R.id.fab_add_contacto)
        fabAddContacto.setOnClickListener{
            val intent:Intent = Intent( this, NuevoContactoActivity::class.java)
            startForResult.launch(intent)
        }



    }
}