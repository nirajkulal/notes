package course.intermediate.notes.notes

import course.intermediate.notes.models.Note

class NoteModel {
    fun getNotesData(): MutableList<Note> {
        return mutableListOf(
            Note("a1"),
            Note("a2")
        )
    }

}