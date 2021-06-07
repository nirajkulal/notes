package course.intermediate.notes.tasks

import course.intermediate.notes.models.Task
import course.intermediate.notes.models.Todo

class TaskModel {
    fun getTaskData(): MutableList<Task> {
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