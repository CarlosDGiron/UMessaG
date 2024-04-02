package pruebas.pruebas.pruebas.messaging.Controllers

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pruebas.pruebas.pruebas.R
import pruebas.pruebas.pruebas.messaging.Models.Message
import pruebas.pruebas.pruebas.messaging.Models.User

class MessageAdapter(var messages: MutableList<Message> = mutableListOf(),var users: MutableList<User> = mutableListOf(),
                     private val onItemSelected: (Message) -> Unit
) :

    RecyclerView.Adapter<MessageViewHolder>() {
    fun updateList(messages: MutableList<Message>,users:MutableList<User>) {
        this.messages = messages.sortedBy {it.messageTimestamp
        }.toMutableList()
        this.users=users
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return MessageViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_for_list_chat_room, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val user=users.find{ it.userId == messages[position].senderId}
        holder.render(messages[position],user!!, onItemSelected)
    }

    override fun getItemCount() = messages.size

}