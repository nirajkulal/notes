package course.intermediate.notes.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import course.intermediate.notes.foundations.ApplicationsScope
import course.intermediate.notes.models.Note
import course.intermediate.notes.tasks.ITaskModel
import toothpick.Toothpick
import toothpick.config.Module
import javax.inject.Inject

class NoteViewModel : ViewModel(), NotesListviewContract {

    @Inject
    lateinit var model: INoteModel
    private val _noteListLiveData: MutableLiveData<MutableList<Note>> = MutableLiveData()
    val noteListLiveData: LiveData<MutableList<Note>> = _noteListLiveData

    init {
        var scope = Toothpick.openScope(this)
       /* scope.installModules(Module().apply {
            bind(INoteModel::class.java).toInstance(NoteLocalModel())
        })*/
        Toothpick.inject(this, ApplicationsScope.scope)
        _noteListLiveData.postValue(model.getNotesData())
    }

}

