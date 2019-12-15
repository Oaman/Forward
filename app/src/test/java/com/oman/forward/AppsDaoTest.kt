package com.oman.forward

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.oman.forward.db.AppDatabase
import com.oman.forward.db.dao.AppsDao
import com.oman.forward.db.entity.AppEntity
import org.junit.*
import org.junit.Assert.assertEquals
import org.junit.runner.RunWith
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
//@RunWith(AndroidJUnit4::class)
//class AppsDaoTest {
//    private var database: AppDatabase? = null
//    private var appsDao: AppsDao? = null
//
//    @Rule
//    var instantTaskExecutorRule = InstantTaskExecutorRule()
//
//    @Before
//    fun initDb() {
//        database = Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(), AppDatabase::class.java)
//                .allowMainThreadQueries()
//                .build()
//        appsDao = database!!.appsDao()
//    }
//
//    @Ignore
//    fun testNoAppsWhenNoInsert() {
//        val apps: List<AppEntity> = getValue(appsDao!!.loadApps())
//        assertEquals(0, apps.size)
//    }
//
//    private fun <T> getValue(liveData: LiveData<T>): T {
//        val objects = arrayOfNulls<Any>(1)
//        val latch = CountDownLatch(1)
//        val observer = object : Observer<T> {
//            override fun onChanged(t: T) {
//                objects[0] = t
//                latch.countDown()
//                liveData.removeObserver(this)
//            }
//        }
//        liveData.observeForever(observer)
//        latch.await(1, TimeUnit.MINUTES)
//        return objects[0] as T
//    }

//    @After
//    fun close() {
//        database!!.close()
//    }

//}