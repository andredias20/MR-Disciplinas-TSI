import com.sun.jdi.Value

class Person(name : String) {
    var Name :String = name
}
class Viagem(date : String, persons : List<Person>) {
     var Date : String = date
     var Persons = persons
}

fun calcValueForDay(persons: List<Person>, dayValue: Double) : Double  =  dayValue / persons.size

fun main(args: Array<String>) {
    val p2 = Person("Suellen")
    val p3 = Person("Victor")
    val p4 = Person("Matheus")

    val list = listOf(p2, p3, p4)
    var total = calcValueForDay(list, 60.00)

    print("O valor da viagem foi R$ ${total} !! ")

    for(c in 'z' downTo 'b'){

    }

}