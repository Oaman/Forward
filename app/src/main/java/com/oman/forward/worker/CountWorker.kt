package com.oman.forward.worker

import android.annotation.TargetApi
import android.content.Context
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.lifecycle.Observer
import androidx.work.*
import java.time.Duration
import java.util.concurrent.TimeUnit

/**

 * @author:ZhouJiang
 * @date:2020/3/2 09:56
 * @email:zhoujiang2012@163.com

 */
class CountWorker(context: Context, parameters: WorkerParameters)
    : Worker(context, parameters) {

    @TargetApi(23)
    companion object {
        fun enqueue(context: ComponentActivity) {
            val constraints = Constraints.Builder()
                    .setRequiredNetworkType(NetworkType.CONNECTED)
                    .setRequiresBatteryNotLow(false)
                    .setRequiresCharging(false)
                    .setRequiresDeviceIdle(false)
                    .setRequiresStorageNotLow(false)
                    .build()
            val request = OneTimeWorkRequestBuilder<CountWorker>()
                    .setConstraints(constraints)
                    .addTag("tagCountWorker")
                    .setInputData(Data.Builder().putString("parameter1", "value of parameter1").build())
                    .setBackoffCriteria(BackoffPolicy.EXPONENTIAL, 1, TimeUnit.HOURS)
                    .build()

            //直接执行
            //WorkManager.getInstance(context).enqueue(request)

            //采用uniqueName执行
            WorkManager.getInstance(context).beginUniqueWork("uniqueName", ExistingWorkPolicy.REPLACE, request).enqueue()
            WorkManager.getInstance(context).getWorkInfoByIdLiveData(request.id).observe(context, Observer {
                Log.i("aaa", "workInfo id-- ${it.outputData.getString("result1")} ${it.state}: ")
            })
            WorkManager.getInstance(context).getWorkInfosByTagLiveData("tagCountWorker").observe(context, Observer {
                Log.i("aaa", "workInfo tag-- ${it[0].outputData.getString("result1")} ${it[0].state}: ")
            })
            WorkManager.getInstance(context).getWorkInfosForUniqueWorkLiveData("uniqueName").observe(context, Observer {
                Log.i("aaa", "workInfo uniqueName-- ${it[0].outputData.getString("result1")} ${it[0].state}: ")
            })

            //取消任务
//            WorkManager.getInstance(context).cancelWorkById(request.id)
//            WorkManager.getInstance(context).cancelAllWork()
//            WorkManager.getInstance(context).cancelAllWorkByTag("tag")
//            WorkManager.getInstance(context).cancelUniqueWork("unique")
        }
    }

    override fun doWork(): Result {
        for (i in 1..3) {
            Thread.sleep(500)
            Log.i("aaa", "count: $i parameter: ${inputData.getString("parameter1")}")
        }
        return Result.success(Data.Builder().putString("result1", "value of result1").build())
    }
}