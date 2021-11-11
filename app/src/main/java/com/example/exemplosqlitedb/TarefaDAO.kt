package com.example.exemplosqlitedb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TarefaDAO {
    @Query("SELECT * from tabela_tarefas ORDER BY designacao ASC")
        fun getAlphabetizedTarefas(): LiveData<List<Tarefa>>
        @Insert(onConflict = OnConflictStrategy.IGNORE)
        suspend fun insert(t: Tarefa)
        @Query("DELETE FROM tabela_tarefas")
        suspend fun deleteAll()
}