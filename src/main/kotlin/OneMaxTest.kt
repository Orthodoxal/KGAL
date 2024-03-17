import genetic.chromosome.ChromosomeIntArray
import genetic.ga.panmictic.operators.crossover.crossoverOnePointIntArray
import genetic.ga.panmictic.operators.mutation.mutationFlipBitIntArray
import genetic.ga.panmictic.operators.selection.selectionTournament
import genetic.ga.simplePanmicticGA
import kotlinx.coroutines.runBlocking


/*fun PanmicticGABuilder<IntArray, Int>.gaCluster() = simpleCluster<IntArray, Int> {
    randomSeed = 42
    fitnessFunction = { value -> value.sum() }
    comparator = comparator { c1, c2 -> c1.fitness!! - c2.fitness!! }
    clone = { Chromosome(value.copyOf(), fitness) }
    population = Array(200) { Chromosome(value = IntArray(100) { random.nextInt(0, 2) }) }
    maxGeneration = 50
    populationSize = 200

    lifecycle {
        selectionTournament(this@gaCluster, tournamentSize = 3)
        crossoverOnePointIntArray(this@gaCluster, chance = 0.9)
        mutationFlipBitIntArray(this@gaCluster, chance = 0.1)
        fitnessAll()
    }
}*/

/*data class MyChromosome(
    override var value: IntArray,
    override var fitness: Int? = null,
): Chromosome<IntArray, Int> {
    override fun clone(): Chromosome<IntArray, Int> = copy(value = value.copyOf())
    override fun compareTo(other: Chromosome<IntArray, Int>): Int = fitness!! - other.fitness!!

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MyChromosome

        if (!value.contentEquals(other.value)) return false
        return fitness == other.fitness
    }

    override fun hashCode(): Int {
        var result = value.contentHashCode()
        result = 31 * result + (fitness ?: 0)
        return result
    }
}*/

fun oneMax() {
    /*val ga = panmicticGA<IntArray, Int> {
        +simpleCluster<IntArray, Int> {
            randomSeed = 42
            fitnessFunction = { value -> value.sum() }
            comparator = comparator { c1, c2 -> c1.fitness!! - c2.fitness!! }
            clone = { Chromosome(value.copyOf(), fitness) }
            population = Array(200) { Chromosome(value = IntArray(100) { random.nextInt(0, 2) }) }
            maxGeneration = 50
            populationSize = 200

            lifecycle {
                selectionTournament(this@panmicticGA, tournamentSize = 3)
                crossoverOnePointIntArray(this@panmicticGA, chance = 0.9)
                mutationFlipBitIntArray(this@panmicticGA, chance = 0.1)
                fitnessAll()
            }
        }
    }*/

    val c1 = ChromosomeIntArray(value = intArrayOf(12, 15, 16), fitness = 15)
    val c2 = ChromosomeIntArray(value = intArrayOf(12, 15, 16), fitness = 15)
    val equal = c1 == c2

    val ga = simplePanmicticGA<IntArray, Int> {
        randomSeed = 42
        fitnessFunction = { value -> value.sum() }
        population = Array(200) { ChromosomeIntArray(value = IntArray(100) { random.nextInt(0, 2) }) }
        maxGeneration = 50
        populationSize = 200

        lifecycle {
            selectionTournament(it, tournamentSize = 3)
            crossoverOnePointIntArray(it, chance = 0.9)
            mutationFlipBitIntArray(it, chance = 0.01)
        }
    }

    runBlocking {
        ga.start()
    }

    println("XXX")
}