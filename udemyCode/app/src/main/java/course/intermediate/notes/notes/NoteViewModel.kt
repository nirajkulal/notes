package course.intermediate.notes.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import course.intermediate.notes.models.Note

class NoteViewModel : ViewModel(), NotesListviewContract {

    private var model: NoteModel = NoteModel()

    private val _noteListLiveData: MutableLiveData<MutableList<Note>> = MutableLiveData()
    val noteListLiveData: LiveData<MutableList<Note>> = _noteListLiveData

    init {
        _noteListLiveData.postValue(model.getNotesData())
    }

}