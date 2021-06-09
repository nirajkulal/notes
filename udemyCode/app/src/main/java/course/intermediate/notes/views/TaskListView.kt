package course.intermediate.notes.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import course.intermediate.notes.R
import course.intermediate.notes.foundations.removeStrikeThrough
import course.intermediate.notes.foundations.setStrikeThrough
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
                        this@TaskListView.titleView.setStrikeThrough()
                    } else {
                        this@TaskListView.titleView.removeStrikeThrough()
                    }
                }
            }
            todoContainer.addView(todoView)
        }
    }


}