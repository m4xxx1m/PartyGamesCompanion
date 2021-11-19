package ru.maximivanov.projects.partygamescompanion.adapters

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import ru.maximivanov.projects.partygamescompanion.R
import ru.maximivanov.projects.partygamescompanion.models.Player
import java.lang.Exception

class AddPlayersAdapter:
    RecyclerView.Adapter<AddPlayersAdapter.AddPlayersViewHolder>() {

    private val players: ArrayList<Player> = arrayListOf(Player(0), Player(1))

    inner class AddPlayersViewHolder(itemView: View, val etListenerName: NameETListener,
    val etListenerMoney: MoneyETListener) : RecyclerView.ViewHolder(itemView) {
        val numberTV: TextView = itemView.findViewById(R.id.num)
        val nameET: TextInputEditText = itemView.findViewById(R.id.et_1)
        val moneyET: TextInputEditText = itemView.findViewById(R.id.et_2)
        init {
            nameET.addTextChangedListener(etListenerName)
            moneyET.addTextChangedListener(etListenerMoney)
        }
    }

    abstract inner class ETListener: TextWatcher {
        protected var position: Int? = null
        fun updatePosition(position: Int) {
            this.position = position
        }
        override fun beforeTextChanged(
            s: CharSequence?, start: Int, count: Int,
            after: Int) {}
        override fun afterTextChanged(s: Editable?) {}
    }

    inner class NameETListener: ETListener() {
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            players[position!!].name = s.toString()
        }
    }

    inner class MoneyETListener: ETListener() {
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            players[position!!].moneyStr = s.toString()
        }
    }

    fun addPlayer() {
        players.add(Player(players.size))
        notifyItemInserted(players.size - 1)
    }

    fun getAllPlayers(): ArrayList<Player> {
        for (player in players) {
            if (player.name == " " || player.moneyStr == " ") {
                return ArrayList()
            }
            else {
                try {
                    player.money = player.moneyStr!!.toInt()
                }
                catch (e: Exception) {
                    return ArrayList()
                }
            }
        }
        return players
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddPlayersViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.add_player_item, parent, false)
        return AddPlayersViewHolder(itemView, NameETListener(), MoneyETListener())
    }

    override fun onBindViewHolder(holder: AddPlayersViewHolder, position: Int) {
        holder.etListenerName.updatePosition(holder.adapterPosition)
        holder.etListenerMoney.updatePosition(holder.adapterPosition)
        holder.nameET.setText(players[holder.adapterPosition].name)
        holder.moneyET.setText(players[holder.adapterPosition].moneyStr)
        holder.numberTV.text = "${holder.adapterPosition+1})"
    }

    override fun getItemCount() = players.size
}
