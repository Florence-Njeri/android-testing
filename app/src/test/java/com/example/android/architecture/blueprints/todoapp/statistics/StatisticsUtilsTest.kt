package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.junit.Assert.*
import org.junit.Test

class StatisticsUtilsTest{
    //For 1 active task there should be 100% active tasks n 0% complete tasks
    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero(){
        val task= listOf<Task>(Task("title","description",false))

        val result= getActiveAndCompletedStats(task)
        assertEquals(0f,result.completedTasksPercent)
        assertEquals(100f,result.activeTasksPercent)
    }


    @Test
    fun getActiveAndCompletedStats_both_returnsFourtySixty(){
        val task= listOf<Task>(
                Task("title","description",true),
                Task("title","description",true),
                Task("title","description",false),
                Task("title","description",false),
                Task("title","description",false)
                        )

        val result= getActiveAndCompletedStats(task)
        assertEquals(40f,result.completedTasksPercent)
        assertEquals(60f,result.activeTasksPercent)
    }

    @Test
    fun getActiveAndCompletedStats_empty_returnsZeros(){
        val task= emptyList<Task>()

        val result= getActiveAndCompletedStats(task)
        assertEquals(0f,result.completedTasksPercent)
        assertEquals(0f,result.activeTasksPercent)
    }

    @Test
    fun getActiveAndCompletedStats_error_returnsZeros(){
        val task= null

        val result= getActiveAndCompletedStats(task)
        assertEquals(0f,result.completedTasksPercent)
        assertEquals(0f,result.activeTasksPercent)
    }
}