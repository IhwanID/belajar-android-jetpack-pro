package id.ihwan.jetpackpro.utils

import androidx.test.espresso.IdlingResource
import androidx.test.espresso.idling.CountingIdlingResource

/**
 * Contains a static reference to [IdlingResource], only available in the 'mock' build type.
 */
object EspressoIdlingResource {
    private const val RESOURCE = "GLOBAL"

    private val espressoTestIdlingResource = CountingIdlingResource(RESOURCE)

    internal val espressoIdlingResource: IdlingResource
        get() = espressoTestIdlingResource

    internal fun increment() {
        espressoTestIdlingResource.increment()
    }

    internal fun decrement() {
        espressoTestIdlingResource.decrement()
    }
}