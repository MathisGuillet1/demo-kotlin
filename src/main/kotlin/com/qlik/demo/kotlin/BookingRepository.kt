package com.qlik.demo.kotlin

import com.qlik.demo.kotlin.model.BookingDocument
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface BookingRepository : CrudRepository<BookingDocument, String> {

    fun findByUserId(userId: UUID): List<BookingDocument>
}
