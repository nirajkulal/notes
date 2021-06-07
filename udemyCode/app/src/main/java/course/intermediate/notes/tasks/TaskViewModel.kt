package course.intermediate.notes.tasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import course.intermediate.notes.models.Task

class TaskViewModel : ViewModel(), TaskListViewViewContract {

    private var model: TaskModel = TaskModel()

    private val _taskLiveData: MutableLiveData<MutableList<Task>> = MutableLiveData()
    val taskListLiveData: LiveData<MutableList<Task>> = _taskLiveData

    init {
        _taskLiveData.postValue(model.getTaskData())
    }


    override fun onTodoUpdated(taskIndex: Int, todoIndex: Int, isComplete: Boolean) {
        _taskLiveData.value?.get(taskIndex)?.todos?.get(todoIndex)?.isComplete = isComplete
        _taskLiveData.value?.get(taskIndex)?.apply {
            this.isComplete = isTaskComplete(this)
        }
    }

    private fun isTaskComplete(task: Task): Boolean =
        task.todos.filter {
            it.isComplete
        }.size == task.todos.size
}