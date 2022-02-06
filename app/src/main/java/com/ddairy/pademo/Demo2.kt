package com.ddairy.pademo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.ddairy.pademo.ui.theme.PADemoTheme

data class Person(
    var name: String,
    var age: Int
)

class PersonViewModel : ViewModel() {

    var people = mutableStateListOf<Person>()
        private set

    fun removePerson(person: Person) {
        people.remove(person)
    }

    fun initialisePeople(newPeople: List<Person>) {
        people.addAll(newPeople)
    }
}

@Composable
fun PersonScreen(viewModel: PersonViewModel) {
    PersonInformation(
        people = viewModel.people,
        removePerson = { person ->
            viewModel.removePerson(person)
        }
    )
}

@Composable
fun PersonInformation(
    people: List<Person>,
    removePerson: (person: Person) -> Unit
) {
    Column(modifier = Modifier.padding(10.dp)) {
        for (person in people) {
            Card(modifier = Modifier.padding(10.dp)) {
                Column {
                    Text(text = "Name: " + person.name)
                    Text(text = "Age: " + person.age.toString())
                    Button(onClick = { removePerson(person) }) {
                        Text("Remove Person")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val viewModel = PersonViewModel()
    viewModel.initialisePeople(
        listOf(
            Person(name = "James", age = 30),
            Person(name = "Jane", age = 35)
        )
    )
    PADemoTheme {
        PersonScreen(viewModel)
    }
}