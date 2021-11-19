package ru.maximivanov.projects.partygamescompanion.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import ru.maximivanov.projects.partygamescompanion.adapters.AddPlayersAdapter
import ru.maximivanov.projects.partygamescompanion.R
import ru.maximivanov.projects.partygamescompanion.activities.StartGameActivity

class AddPlayersFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_players, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view_add_players)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = AddPlayersAdapter()
        val addFAB: FloatingActionButton = view.findViewById(R.id.add_fab)
        addFAB.setOnClickListener {
            if ((recyclerView.adapter as AddPlayersAdapter).itemCount < 10)
                (recyclerView.adapter as AddPlayersAdapter).addPlayer()
            else {
                Snackbar.make((activity as StartGameActivity).findViewById(R.id.coordinator),
                    R.string.only_10_players, Snackbar.LENGTH_SHORT).show()
            }
        }
        val doneFAB: FloatingActionButton = view.findViewById(R.id.done_fab)
        doneFAB.setOnClickListener {
            val players = (recyclerView.adapter as AddPlayersAdapter).getAllPlayers()
            if (players.size != 0) {
                // navigate to settings
            }
            else {
                Snackbar.make((activity as StartGameActivity).findViewById(R.id.coordinator),
                R.string.check_entered_data, Snackbar.LENGTH_SHORT).show()
            }
        }
        return view
    }

    override fun onStart() {
        (activity as StartGameActivity).setToolbarTitle(getString(R.string.add_players))
        super.onStart()
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
////        arguments?.let {
////            param1 = it.getString(ARG_PARAM1)
////            param2 = it.getString(ARG_PARAM2)
////        }
//    }
//    companion object {
//        @JvmStatic
//        fun newInstance() =
//            AddPlayersFragment().apply {
//                arguments = Bundle().apply {
//
//                }
//            }
//    }
}