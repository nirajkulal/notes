package course.intermediate.notes.notes

import course.intermediate.notes.models.Note
import javax.inject.Inject

class NoteLocalModel @Inject constructor() : INoteModel {
    override fun getNotesData(): MutableList<Note> {
        return mutableListOf(
            Note("a1"),
            Note("a2")
        )
    }

    override fun addNote(note: Note, callback: SuccessCallback) {
        TODO("Not yet implemented")
    }

    override fun updateNote(note: Note, callback: SuccessCallback) {
        TODO("Not yet implemented")
    }

    override fun deleteNote(note: Note, callback: SuccessCallback) {
        TODO("Not yet implemented")
    }

    override fun retrieveNotes(): List<Note> {
        TODO("Not yet implemented")
    }
}