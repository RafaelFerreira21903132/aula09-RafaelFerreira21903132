package com.example.exemplosqlitedb

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabela_tarefas")
data class Tarefa(
    @PrimaryKey @ColumnInfo(name="idTarefa") val id: Int,
    @NonNull @ColumnInfo(name="designacao")val designacao: String?
)