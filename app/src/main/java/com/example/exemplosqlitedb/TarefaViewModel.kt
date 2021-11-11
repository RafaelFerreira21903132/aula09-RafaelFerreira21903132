package com.example.exemplosqlitedb

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import layout.TarefaRoomDatabase

class TarefaViewModel(application: Application) : AndroidViewModel(application) {
    // The ViewModel maintains a reference to the repository to get data.
    private val repository: TarefaRepository
    // LiveData gives us updated tarefas when they change.
    val allWords: LiveData<List<Tarefa>>
    init {
// Gets reference to TarefaDao from TarefaRoomDatabase to construct
// the correct TarefaRepository.
        val tarefasDao = TarefaRoomDatabase.getDatabase(application).wordDao()
        repository = TarefaRepository(tarefasDao as LiveData<List<Tarefa>>)
        allWords = repository.allTarefas
    }
    fun insert(word: Tarefa) = viewModelScope.launch {
        repository.insert(word)
    }
}