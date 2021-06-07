package course.intermediate.notes.tasks

interface TaskListViewViewContract {
    fun onTodoUpdated(taskIndex: Int, todoIndex: Int, isComplete: Boolean)
}