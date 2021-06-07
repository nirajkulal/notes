package course.intermediate.notes.views

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import course.intermediate.notes.R
import course.intermediate.notes.models.Task
import kotlinx.android.synthetic.main.item_task.view.*

class TaskListView @JvmOverloads constructor(
    context: Context? = null,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1
) : ConstraintLayout(context, attrs, defStyleAttr) {

    lateinit var task: Task

    fun init(task: Task, todoCallback: ((todoIndex: Int, isComplete: Boolean) -> Unit)? = null) {
        this.task = task
        titleView.text = task.title
        task.todos.forEachIndexed { index, todo ->
            val todoView = (LayoutInflater.from(context)
                .inflate(R.layout.view_todo, todoContainer, false) as TodoView).apply {
                initView(todo) { isComplete ->
                    todoCallback?.invoke(index, isComplete)
                    if (todo.isComplete) {
                        createStrikeThrough()
                    } else {
                        removeStrikerThrough()
                    }
                }
            }
            todoContainer.addView(todoView)
        }
    }

    private fun createStrikeThrough() {
        titleView.apply {
            paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }
    }

    private fun removeStrikerThrough() {
        titleView.apply {
            paintFlags =
                paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

}