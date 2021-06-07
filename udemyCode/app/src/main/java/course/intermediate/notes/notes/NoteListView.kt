package course.intermediate.notes.notes

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import course.intermediate.notes.models.Note
import kotlinx.android.synthetic.main.fragment_notes_list.view.*

class NoteListView @kotlin.jvm.JvmOverloads constructor(
    context: Context? = null,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1
) : ConstraintLayout(context, attrs, defStyleAttr) {

    lateinit var adapter: NotesAdapter
    lateinit var buttonTouch: NotesListFragment.TouchAction


    fun initView(buttonTouch: NotesListFragment.TouchAction) {
        setUpDelegate(buttonTouch)
        setUpView()
    }

    private fun setUpDelegate(buttonTouch: NotesListFragment.TouchAction) {
        this.buttonTouch = buttonTouch
    }

    private fun setUpView() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = NotesAdapter(
            buttonTouch = buttonTouch
        )
        recyclerView.adapter = adapter
    }

    fun updateData(it: MutableList<Note>) {
        adapter.updateData(it)
    }
}