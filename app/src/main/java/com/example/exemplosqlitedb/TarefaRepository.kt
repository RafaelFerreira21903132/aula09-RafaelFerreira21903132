package com.example.exemplosqlitedb

import androidx.lifecycle.LiveData

class TarefaRepository(val allTarefas: LiveData<List<Tarefa>>) {
    fun insert(word: Tarefa) {

    }

    class WordRepository(private val tarefaDao: TarefaDAO) {
        val allTarefas: LiveData<List<Tarefa>> = tarefaDao.getAlphabetizedTarefas()
        suspend fun insert(tarefa: Tarefa) {
            tarefaDao.insert(tarefa)
        }
    }
}