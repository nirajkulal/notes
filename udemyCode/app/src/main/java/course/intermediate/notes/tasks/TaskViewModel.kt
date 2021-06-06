package course.intermediate.notes.tasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import course.intermediate.notes.models.Task
import course.intermediate.notes.models.Todo

class TaskViewModel : ViewModel() {

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
}