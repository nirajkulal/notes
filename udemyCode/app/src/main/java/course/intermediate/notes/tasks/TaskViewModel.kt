package course.intermediate.notes.tasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import course.intermediate.notes.models.Task
import course.intermediate.notes.models.Todo

class TaskViewModel : ViewModel(), TaskListViewViewContract {

    private val _taskLiveData: MutableLiveData<MutableList<Task>> = MutableLiveData()
    val taskListLiveData: LiveData<MutableList<Task>> = _taskLiveData

    init {
        _taskLiveData.postValue(getFakeData())
    }

    fun getFakeData(): MutableList<Task> {
        return mutableListOf(
            Task(
                "one", mutableListOf(
                    Todo("test data"),
                    Todo("test data 2", true)
                )
            ),
            Task(
                "two", mutableListOf(
                    Todo("test data 3", true),
                    Todo("test data 4")
                )
            )
        )
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