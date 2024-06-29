package genetic.utils.ga

import genetic.clusters.state.ClusterStopPolicy
import genetic.ga.GA
import kotlinx.coroutines.CoroutineScope
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

fun CoroutineScope.start(
    ga: GA<*, *>,
    iterationFrom: Int = 0,
    coroutineContext: CoroutineContext = EmptyCoroutineContext,
) = with(ga) { start(iterationFrom, coroutineContext) }

fun CoroutineScope.resume(
    ga: GA<*, *>,
    coroutineContext: CoroutineContext = EmptyCoroutineContext,
) = with(ga) { resume(coroutineContext) }

fun CoroutineScope.restart(
    ga: GA<*, *>,
    iterationFrom: Int = 0,
    coroutineContext: CoroutineContext = EmptyCoroutineContext,
) = with(ga) { restart(iterationFrom, coroutineContext) }

fun CoroutineScope.stop(
    ga: GA<*, *>,
    stopPolicy: ClusterStopPolicy = ClusterStopPolicy.Default,
    coroutineContext: CoroutineContext = EmptyCoroutineContext,
) = with(ga) { stop(stopPolicy, coroutineContext) }