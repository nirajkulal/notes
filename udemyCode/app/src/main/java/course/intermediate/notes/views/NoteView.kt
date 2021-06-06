package course.intermediate.notes.views

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import course.intermediate.notes.models.Note
import kotlinx.android.synthetic.main.item_notes.view.*

class NoteView @JvmOverloads constructor(
    context: Context? = null,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1
) : ConstraintLayout(context, attrs, defStyleAttr) {
    fun initView(note: Note) {
        textViewNote.text = note.description
    }
}