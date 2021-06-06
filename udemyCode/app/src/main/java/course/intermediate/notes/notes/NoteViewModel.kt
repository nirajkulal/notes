package course.intermediate.notes.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import course.intermediate.notes.models.Note

class NoteViewModel : ViewModel() {

    private val _noteListLiveData: MutableLiveData<MutableList<Note>> = MutableLiveData()

    val noteListLiveData: LiveData<MutableList<Note>> = _noteListLiveData

    init {
        _noteListLiveData.postValue(getFakeData())
    }

    fun getFakeData(): MutableList<Note> {
        return mutableListOf(
            Note("a1"), Note("a2")
        )
    }
}