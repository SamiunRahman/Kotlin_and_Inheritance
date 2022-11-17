import kotlin.math.PI
import kotlin.math.sqrt
fun main(){
    val squareCabin = SquareCabin(6,50.0)

    println("\nSquare Cabin\n===============")
    println("Capasity: ${squareCabin.capacity}")
    println("Material: ${squareCabin.buildingMaterials}")
    println("Has room? ${squareCabin.hasRoom()}")
    println("Floor area: ${squareCabin.floorArea()}")


    // Using with statement

    with(squareCabin){
        println("Square Cabin with \"with\" keyword\n===================")
        println("Capasity: $capacity")
        println("Materials: $buildingMaterials")
        println("Has room? ${hasRoom()}")
        println("Floor area: %.2f".format(floorArea()))
    }

    val roundHut = RoundHut(3,10.0)

    with(roundHut){
        println("\nRound Hut\n===========")
        println("Materials: $buildingMaterials")
        println("Capasity: ${capacity}")
        println("Has Room ? ${hasRoom()}")
//        println("Floor area: ${floorArea()}")
        getroom()
        println("Has room ? ${hasRoom()}")
        getroom()
        println("Floor area: %.2f".format(floorArea()))
        println("Carpet Length: %.2f".format(calculateMaxCarpetLength()))


    }
    val roundTower = RoundTower(12,12.0)
    with(roundTower){
        println("\nRound Tower\n===========")
        println("Materials: $buildingMaterials")
        println("Capasity: ${capacity}")
        println("Has Room ? ${hasRoom()}")
        println("Floor area: %.2f".format(floorArea()))
        println("Carpet Length: %.2f".format(calculateMaxCarpetLength()))



    }
}
abstract class Dwelling(private var residents: Int){
    abstract val buildingMaterials: String
    abstract val capacity : Int

    abstract fun floorArea(): Double

    fun hasRoom(): Boolean {  return residents < capacity }
    // Get room function added for checking and adding resident to a room
    fun getroom(){
        if(capacity>residents){
            residents++
            println("You got a room!")
        }
        else{
            println("Sorry, at capacity and no room left.")
        }
    }

}
// Creating subclass or Dwelling class

// Created SquareCabin in this part
class SquareCabin(residents: Int, val length: Double): Dwelling(residents){
    override val buildingMaterials: String = "Wood"
    override val capacity: Int = 6
    override fun floorArea(): Double {
        return length*length
    }

}

// Created RoundHut in this part

open class RoundHut(residents: Int, val radius: Double): Dwelling(residents){
    override val buildingMaterials: String = "Straw"
    override val capacity: Int = 4

    override fun floorArea(): Double {
        return PI * radius * radius
    }
     open fun calculateMaxCarpetLength(): Double{
        return sqrt(2.0)*radius
    }
}

//created roundtower here
 class RoundTower(residents: Int,radius: Double, val floor: Int=2) : RoundHut(residents, radius){
     override val buildingMaterials: String = "Stone"
     override val capacity: Int = 4*floor
    // calculation of floor area in roundtower class
     override fun floorArea(): Double {
         return super.calculateMaxCarpetLength()* floor
     }
     override fun calculateMaxCarpetLength(): Double {
         return super.calculateMaxCarpetLength()*floor
     }

 }
