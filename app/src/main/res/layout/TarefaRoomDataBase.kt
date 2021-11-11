package layout

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.exemplosqlitedb.Tarefa
import com.example.exemplosqlitedb.TarefaDAO

@Database(entities = arrayOf(Tarefa::class), version = 1, exportSchema = false)
public abstract class TarefaRoomDatabase : RoomDatabase() {
    abstract fun tarefaDao(): TarefaDAO
    abstract fun wordDao(): Any

    companion object {
        // Singleton prevents multiple instances of database opening at the
// same time.
        @Volatile
        private var INSTANCE: TarefaRoomDatabase? = null
        fun getDatabase(context: Context): TarefaRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TarefaRoomDatabase::class.java, "tarefa_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}