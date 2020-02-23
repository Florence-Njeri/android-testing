package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.*
import org.junit.Test

class StatisticsUtilsTest{
    //For
    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero(){
        //GIVEN a list of tasks 1 active task there should be 100% active tasks n 0% complete tasks
        val task= listOf<Task>(Task("title","description",false))

//        WHEN you call getActiveAndCompletedStats
        val result= getActiveAndCompletedStats(task)

        //THEN there are 40% completed tasks and 60% ongoing tasks
        assertThat(result.completedTasksPercent, `is`(0f))
        assertThat(result.activeTasksPercent, `is`(100f))
    }


    @Test
    fun getActiveAndCompletedStats_both_returnsFourtySixty(){
        //GIVEN a list of tasks, 2 active task and 3 completed tasks there should be 60% active tasks n 40% complete tasks
        val task= listOf<Task>(
                Task("title","description",true),
                Task("title","description",true),
                Task("title","description",false),
                Task("title","description",false),
                Task("title","description",false)
                        )
//        WHEN you call getActiveAndCompletedStats
        val result= getActiveAndCompletedStats(task)

        //THEN there are 40% completed tasks and 60% ongoing tasks
        assertThat(result.completedTasksPercent, `is`(40f))
        assertThat(result.activeTasksPercent, `is`(60f))
    }

    @Test
    fun getActiveAndCompletedStats_empty_returnsZeros(){
        //GIVEN a list of tasks is empty
        val task= emptyList<Task>()

//        WHEN you call getActiveAndCompletedStats
        val result= getActiveAndCompletedStats(task)

        //THEN there are 0% completed tasks and 0% ongoing tasks
        assertThat(result.completedTasksPercent, `is`(0f))
        assertThat(result.activeTasksPercent, `is`(0f))
    }

    @Test
    fun getActiveAndCompletedStats_error_returnsZeros(){
        //GIVEN a list of tasks is null
        val task= null

//        WHEN you call getActiveAndCompletedStats
        val result= getActiveAndCompletedStats(task)

        //THEN there are 0% completed tasks and 0% ongoing tasks
        assertThat(result.completedTasksPercent, `is`(0f))
        assertThat(result.activeTasksPercent, `is`(0f))
    }
}