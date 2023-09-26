package com.example.restaurantsapp.db.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.restaurantsapp.data.model.Restaurant
import com.example.restaurantsapp.db.Dao.RestaurantDao

@Database(
    entities = [Restaurant::class],
    version = 1,
    exportSchema = false
)
abstract class RestaurantDb : RoomDatabase() {
    abstract val dao: RestaurantDao

    companion object {

        @Volatile
        private var INSTANCE: RestaurantDao? = null

        fun getDaoInstance(context: Context): RestaurantDao {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = buildDatabase(context).dao
                    INSTANCE = instance
                }
                return instance
            }
        }

        private fun buildDatabase(context: Context): RestaurantDb {

            return Room.databaseBuilder(
                context.applicationContext,
                RestaurantDb::class.java,
                "restaurants_database"
            )
                .fallbackToDestructiveMigration()
                .build()
        }

    }
}