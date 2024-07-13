package com.example.studentlistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.studentlistapp.ui.theme.StudentListAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudentListAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    StudentList(
                        students = getStudentList(),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    private fun getStudentList(): List<Student> {
        return listOf(
            Student("VIVI INDRIYANI MA", "SSI202202839"),
            Student("WAHYU TRI HANAFI", "SSI202202840"),
            Student("FITROH RONDIYAH", "SSI202202841"),
            Student("LEILA KANNA", "SSI202202843"),
            Student("MEISYA FIKRIANA K", "SSI202202844"),
            Student("NUR FITRIANI", "SSI202202845"),
            Student("SALSA SAHROTUL FII'RIA", "SSI202202848"),
            Student("ULFAH ADE JULIA", "SSI202202850"),
            Student("YULIYANA ZAKIYATUL F", "SSI202202851"),
            Student("FINA AGUSTINA", "SSI202202852"),
            Student("AMELIA PUSPITASARI", "SSI202202853")

        )
    }
}

@Composable
fun StudentList(students: List<Student>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(students) { student ->
            val color = when {
                students.indexOf(student) % 11 == 0 -> Color.Red
                students.indexOf(student) % 11 == 1 -> Color.Red
                students.indexOf(student) % 11 == 2 -> Color.Red
                students.indexOf(student) % 11 == 3 -> Color.Red
                students.indexOf(student) % 11 == 4 -> Color.Red
                students.indexOf(student) % 11 == 5 -> Color.Blue
                students.indexOf(student) % 11 == 6 -> Color.Green
                students.indexOf(student) % 11 == 7 -> Color.Green
                students.indexOf(student) % 11 == 8 -> Color.Green
                students.indexOf(student) % 11 == 9 -> Color.Green
                students.indexOf(student) % 11 == 10 -> Color.Green
                else -> Color.Cyan
            }
            StudentItem(student, color)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun StudentItem(student: Student, color: Color, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        Text(text = student.name, style = MaterialTheme.typography.headlineSmall, color = color)
        Text(text = student.id, style = MaterialTheme.typography.bodyMedium, color = color)
    }
}

@Preview(showBackground = true)
@Composable
fun StudentListPreview() {
    StudentListAppTheme {
        StudentList(
            students = listOf(
                Student("Sample Name", "Sample ID")
            )
        )
    }
}

data class Student(val name: String, val id: String)
