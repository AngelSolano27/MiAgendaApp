package edu.itsco.miagendaapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.itsco.miagendaapp.R
import edu.itsco.miagendaapp.modelos.Contactos

class ContactosAdapter(private val ListaContactos: ArrayList<Contactos>):
   RecyclerView.Adapter<ContactosAdapter.ViewHolder>()
{
    class ViewHolder(View: View): RecyclerView.ViewHolder(View){
        val lbNombre: TextView
        val lbTelefono: TextView

        init {
           lbNombre = View.findViewById(R.id.lb_nombre)
            lbTelefono= View.findViewById(R.id.lb_telefono)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactosAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contactos_item,
        parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactosAdapter.ViewHolder, position: Int) {
        holder.lbNombre.text = ListaContactos [position].nombre
        holder.lbTelefono.text = ListaContactos [position].telefono
    }

    override fun getItemCount(): Int {
        return ListaContactos.size
    }

     fun addcontacto(contacto:Contactos){
         ListaContactos.add(contacto)
         notifyDataSetChanged()
     }

}