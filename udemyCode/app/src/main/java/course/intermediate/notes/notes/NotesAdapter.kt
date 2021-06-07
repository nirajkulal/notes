package course.intermediate.notes.notes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import course.intermediate.notes.R
import course.intermediate.notes.foundations.BaseRecyclerAdapter
import course.intermediate.notes.models.Note
import course.intermediate.notes.navigation.NavigationActivity.Companion.FRAGMENT_VALUE_NOTE
import course.intermediate.notes.views.NoteView
import kotlinx.android.synthetic.main.view_add_button.view.*

class NotesAdapter(
    val list: MutableList<Note> = mutableListOf(),
    val buttonTouch: NotesListFragment.TouchAction

) : BaseRecyclerAdapter<Note>(list) {
    override fun onCreateViewHolder(parent: ViewGroup, type: Int): RecyclerView.ViewHolder =
        if (type == TYPE_INFO)
            ViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_notes, parent, false)
            )
        else {
            ButtonViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.view_add_button, parent, false)
            )
        }


    class ViewHolder(itemView: View) : BaseViewHolder<Note>(itemView) {
        override fun onBind(data: Note, listIndex: Int) {
            (itemView as NoteView).initView(data)
        }
    }

    inner class ButtonViewHolder(itemView: View) : BaseButtonViewHolder(itemView) {
        override fun onBind(data: Unit, listIndex: Int) {
            itemView.button.text = itemView.context.getString(R.string.add_button_text)
            itemView.setOnClickListener {
                buttonTouch.addButtonClick(FRAGMENT_VALUE_NOTE)
            }
        }
    }
}


