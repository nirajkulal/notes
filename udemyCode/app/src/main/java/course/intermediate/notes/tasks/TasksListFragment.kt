package course.intermediate.notes.tasks

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import course.intermediate.notes.R

class TasksListFragment : Fragment() {

    lateinit var onButtonTouch: TouchAction
    lateinit var taskViewModel: TaskViewModel
    lateinit var taskListView: TasView

    override fun onAttach(context: Context) {
        super.onAttach(context)
        context.let {
            if (it is TouchAction) {
                onButtonTouch = it
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tasks_list, container, false).apply {
            taskListView = this as TasView
        }
    }

    companion object {
        fun newInstance() = TasksListFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViewModel()
        customView()
    }

    private fun customView() {
        taskListView.initView(onButtonTouch, taskViewModel)
    }

    fun bindViewModel() {
        val model: TaskViewModel by viewModels()
        this.taskViewModel = model
        taskViewModel.taskListLiveData.observe(this, Observer {
            taskListView.updateData(it)
        })
    }

    interface TouchAction {
        fun addButtonClick(value: String)
    }
}
