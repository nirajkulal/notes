package course.intermediate.notes.notes

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import course.intermediate.notes.R
import kotlinx.android.synthetic.main.fragment_notes_list.*

class NotesListFragment : Fragment() {

    lateinit var buttonTouch: TouchAction;
    lateinit var noteViewModel: NoteViewModel
    lateinit var adapter: NotesAdapter


    override fun onAttach(context: Context) {
        super.onAttach(context)

        context.let {
            if (it is TouchAction) {
                buttonTouch = it
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notes_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = NotesAdapter(
            buttonTouch = buttonTouch
        )
        recyclerView.adapter = adapter
        bindViewModel();
    }

    private fun bindViewModel() {
        val viewModel: NoteViewModel by viewModels()
        this.noteViewModel = viewModel

        noteViewModel.noteListLiveData.observe(this, Observer {
            adapter.updateData(it)
        })

    }

    companion object {
        fun newInstance() = NotesListFragment()
    }

    interface TouchAction {
        fun addButtonClick(value: String)
    }

}
