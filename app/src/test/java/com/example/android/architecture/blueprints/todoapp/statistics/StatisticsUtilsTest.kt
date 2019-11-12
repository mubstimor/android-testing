package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.*
import org.junit.Test

class StatisticsUtilsTest {

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnHundredZero() {
        // create an active task
        val tasks = listOf<Task>(
                Task("title", "desc", isCompleted = false)
        )

        // call your function
        val result = getActiveAndCompletedStats(tasks)

        // check the result
        assertEquals(result.completedTasksPercent, 0f)
        assertEquals(result.activeTasksPercent, 100f)

        assertThat(result.activeTasksPercent, `is`(100f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }

    @Test
    fun getActiveAndCompletedStats_empty_returnsZeros(){

        // call your function
        val result =  getActiveAndCompletedStats(emptyList())

        // check the result
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }

    @Test
    fun getActiveAndCompletedStats_noActive_returnsZeroHundred(){
        // create an active task
        val tasks = listOf<Task>(
                Task("title", description = "desc", isCompleted = true)
        )

        // call your function
        val result =  getActiveAndCompletedStats(tasks)

        // check the result
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(100f))
    }

    @Test
    fun getActiveAndCompletedStats_error_returnsZeros(){

        // call your function
        val result =  getActiveAndCompletedStats(null)

        // check the result
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero(){
        // create an active task
        val tasks = listOf<Task>(
                Task("title", description = "desc", isCompleted = false)
        )

        // call your function
        val result =  getActiveAndCompletedStats(tasks)

        // check the result
        assertThat(result.activeTasksPercent, `is`(100f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }

    @Test
    fun getActiveAndCompletedStats_both_returnsFortySixty(){
        // create an active task
        val tasks = listOf<Task>(
                Task("title", description = "desc", isCompleted = true),
                Task("title", description = "desc", isCompleted = true),
                Task("title", description = "desc", isCompleted = true),
                Task("title", description = "desc", isCompleted = false),
                Task("title", description = "desc", isCompleted = false)
        )

        // call your function
        val result =  getActiveAndCompletedStats(tasks)

        // check the result
        assertThat(result.activeTasksPercent, `is`(40f))
        assertThat(result.completedTasksPercent, `is`(60f))
    }
}