package course.intermediate.notes.tasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import course.intermediate.notes.foundations.ApplicationsScope
import course.intermediate.notes.models.Task
import course.intermediate.notes.models.Todo
import toothpick.Toothpick
import toothpick.config.Module
import javax.inject.Inject

class TaskViewModel : ViewModel(), TaskListViewViewContract {

    @Inject
    lateinit var model: ITaskModel
    private val _taskLiveData: MutableLiveData<MutableList<Task>> = MutableLiveData()
    val taskListLiveData: LiveData<MutableList<Task>> = _taskLiveData

    init {
       /* var scope = Toothpick.openScopes(this,ApplicationsScope.scope)
        scope.installModules(Module().apply {
            bind(ITaskModel::class.java).toInstance(TestModel())
        })*/
        Toothpick.inject(this, ApplicationsScope.scope)

        //Toothpick.inject(this, scope)
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

