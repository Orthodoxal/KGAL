package genetic.chromosome.base_instances

import genetic.chromosome.Chromosome

data class ChromosomeByteArray<F : Comparable<F>>(
    override var value: ByteArray,
    override var fitness: F? = null,
    private val clone: (ChromosomeByteArray<F>.() -> ChromosomeByteArray<F>)? = null,
) : Chromosome<ByteArray, F> {
    override fun compareTo(other: Chromosome<ByteArray, F>): Int = compareValues(fitness, other.fitness)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ChromosomeByteArray<*>

        if (!value.contentEquals(other.value)) return false
        return fitness == other.fitness
    }

    override fun hashCode(): Int {
        var result = value.contentHashCode()
        result = 31 * result + (fitness?.hashCode() ?: 0)
        return result
    }

    override fun clone(): Chromosome<ByteArray, F> = clone?.let { it() } ?: copy(value = value.copyOf())
}