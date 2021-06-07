package course.intermediate.notes.views

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.CompoundButton
import androidx.constraintlayout.widget.ConstraintLayout
import course.intermediate.notes.models.Todo
import kotlinx.android.synthetic.main.view_todo.view.*

class TodoView @JvmOverloads constructor(
    context: Context? = null,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1
) : ConstraintLayout(context, attrs, defStyleAttr) {

    fun initView(todo: Todo, callback: ((isComplete: Boolean) -> Unit)? = null) {
        descriptionView.text = todo.description
        completeCheckBox.isChecked = todo.isComplete
        if (todo.isComplete) {
            createStrikeThrough()
        }
        setUpCheckStateListener(todo, callback )
    }

    fun setUpCheckStateListener(todo: Todo, callBack: ((isComplete: Boolean) -> Unit)? = null) {
        completeCheckBox.setOnCheckedChangeListener { _: CompoundButton?, isChecked: Boolean ->
            todo.isComplete = isChecked
            callBack?.invoke(isChecked)
            if (isChecked) {
                createStrikeThrough()
            } else {
                removeStrikerThrough()
            }
        }
    }

    private fun createStrikeThrough() {
        descriptionView.apply {
            paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }
    }

    private fun removeStrikerThrough() {
        descriptionView.apply {
            paintFlags =
                paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
    }
}