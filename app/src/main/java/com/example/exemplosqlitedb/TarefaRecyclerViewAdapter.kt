package layout

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exemplosqlitedb.R
import com.example.exemplosqlitedb.Tarefa

abstract class TarefaRecyclerViewAdapter internal constructor(context: Context) : RecyclerView.Adapter<TarefaRecyclerViewAdapter.TarefaViewHolder>() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var tarefas = emptyList<Tarefa>() // Cached copy of tarefas

    inner class TarefaViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val tarefaItemView: TextView = itemView.findViewById(R.id.textView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            TarefaViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent,
            false)
        return TarefaViewHolder(itemView)

    }
    override fun onBindViewHolder(holder: TarefaViewHolder, position: Int) {
        val current = tarefas[position]
        holder.tarefaItemView.text = current.designacao // designacao da tarefa
    }
    internal fun setTarefas(tarefas: List<Tarefa>) {
        this.tarefas= tarefas
        notifyDataSetChanged()
    }
    override fun getItemCount() = tarefas.size
}

