package com.lugares.adapter


import androidx.lifecycle.LiveData
import androidx.room.*
import com.lugares.model.Lugar


@Dao
    interface LugarDao{
        @Query("SELECT * FROM LUGAR")
        fun getAllData() : LiveData<List<Lugares>>

        @Insert(onConflict =OnConflictStrategy.IGNORE)
        suspend fun addLugar (lugar: Lugar)

        @Update(onConflict =OnConflictStrategy.IGNORE)
        suspend fun updateLugar (lugar: Lugar)


         @Delete
          suspend fun deleteLugar (lugar: Lugar)

    }

}