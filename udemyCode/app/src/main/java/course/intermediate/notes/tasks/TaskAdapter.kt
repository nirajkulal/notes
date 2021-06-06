package course.intermediate.notes.tasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import course.intermediate.notes.R
import course.intermediate.notes.foundations.BaseRecyclerAdapter
import course.intermediate.notes.models.Task
import course.intermediate.notes.navigation.NavigationActivity.Companion.FRAGMENT_VALUE_TASK
import course.intermediate.notes.views.TaskListView
import kotlinx.android.synthetic.main.view_add_button.view.*

class TaskAdapter(
    val taskList: MutableList<Task> = mutableListOf(),
    val onButtonTouchDelegate: TasksListFragment.TouchAction
) : BaseRecyclerAdapter<Task>(taskList) {
    override fun onCreateViewHolder(parent: ViewGroup, type: Int): RecyclerView.ViewHolder =
        if (type == TYPE_INFO)
            TaskViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
            );
        else {
            ButtonViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.view_add_button, parent, false)
            )
        }

    class TaskViewHolder(itemView: View) : BaseViewHolder<Task>(itemView) {
        override fun onBind(data: Task) {
            (itemView as TaskListView).init(data)
        }
    }

    inner class ButtonViewHolder(itemView: View) : BaseButtonViewHolder(itemView) {
        override fun onBind(data: Unit) {
            itemView.button.text = itemView.context.getString(R.string.add_button_text)
            itemView.setOnClickListener {
                onButtonTouchDelegate.addButtonClick(FRAGMENT_VALUE_TASK)
            }

        }
    }
}