package id.ihwan.jetpackpro.utils

import androidx.paging.PagedList
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.stubbing.Answer

fun <T> mockPagedList(list: List<T>): PagedList<T> {
    val pagedList: PagedList<*> = Mockito.mock(PagedList::class.java)

    val answer: Answer<T> = Answer { invocation ->
        val index = invocation.arguments[0] as Int
        list[index]
    }

    `when`<T>(pagedList[anyInt()] as T).thenAnswer(answer)
    `when`(pagedList.size).thenReturn(list.size)
    return pagedList as PagedList<T>
}