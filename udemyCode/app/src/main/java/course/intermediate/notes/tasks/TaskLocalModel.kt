package course.intermediate.notes.tasks

import course.intermediate.notes.models.Task
import course.intermediate.notes.models.Todo
import javax.inject.Inject

class TaskLocalModel @Inject constructor() : ITaskModel {
    override fun getTaskData(): MutableList<Task> {
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

    override fun addTask(task: Task, callback: SuccessCallback) {
        TODO("Not yet implemented")
    }

    override fun updateTask(task: Task, callback: SuccessCallback) {
        TODO("Not yet implemented")
    }

    override fun deleteTask(task: Task, callback: SuccessCallback) {
        TODO("Not yet implemented")
    }

    override fun retrieveTasks(): List<Task> {
        TODO("Not yet implemented")
    }
}