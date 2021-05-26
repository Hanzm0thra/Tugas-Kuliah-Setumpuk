import javax.naming.Context

data class PersonDataClass (val name: String, val age: Int)
class PersonClass(val name: String, val age: Int) {
   /* companion object {
        @Volatile
        private var INSTANCE: PersonClass? = null

        @Synchronized
        fun getInstance(name: String, age: Int) = INSTANCE?: PersonClass(name, age).also { INSTANCE = it }
    }*/
}

fun main() {
    val personDataClass1 = PersonDataClass("A", 1)
    val personDataClass2 = PersonDataClass("B", 2)

    val personClass1 = PersonClass("A", 1)
    val personClass2 = PersonClass("B", 2)

    println("""
        Data Class: 
        $personDataClass1, $personDataClass2
        
        Class:
        $personClass1, $personClass2
    """.trimIndent())
}
