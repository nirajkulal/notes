package course.intermediate.notes.tasks

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import course.intermediate.notes.models.Task
import kotlinx.android.synthetic.main.fragment_tasks_list.view.*

class TasView @kotlin.jvm.JvmOverloads constructor(
    context: Context? = null,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1
) : ConstraintLayout(context, attrs, defStyleAttr) {

    lateinit var onButtonTouch: TasksListFragment.TouchAction
    lateinit var taskListViewViewContract: TaskListViewViewContract
    lateinit var adapter: TaskAdapter

    fun initView(
        onButtonTouch: TasksListFragment.TouchAction,
        taskListViewViewContract: TaskListViewViewContract
    ) {
        setUpDelegate(onButtonTouch, taskListViewViewContract)
        setUpView()
    }

    private fun setUpView() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = TaskAdapter(
            onButtonTouchDelegate = onButtonTouch,
            taskListViewViewContract = taskListViewViewContract
        )
        recyclerView.adapter = adapter
    }

    private fun setUpDelegate(
        onButtonTouch: TasksListFragment.TouchAction,
        taskListViewViewContract: TaskListViewViewContract
    ) {
        this.onButtonTouch = onButtonTouch
        this.taskListViewViewContract = taskListViewViewContract
    }

    fun updateData(list: MutableList<Task>) {
        adapter.updateData(list)
    }

}