package course.intermediate.notes.notes

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import course.intermediate.notes.R

class NotesListFragment : Fragment() {

    lateinit var buttonTouch: TouchAction;
    lateinit var noteViewModel: NoteViewModel
    lateinit var customView: NoteListView;


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
        return inflater.inflate(R.layout.fragment_notes_list, container, false).apply {
            customView = this as NoteListView
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViewModel();
        customViewUpdate();
    }

    private fun customViewUpdate() {
        customView.initView(buttonTouch,noteViewModel)
    }

    private fun bindViewModel() {
        val viewModel: NoteViewModel by viewModels()
        this.noteViewModel = viewModel
        noteViewModel.noteListLiveData.observe(this, Observer {
            customView.updateData(it)
        })
    }

    companion object {
        fun newInstance() = NotesListFragment()
    }

    interface TouchAction {
        fun addButtonClick(value: String)
    }

}
