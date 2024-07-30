package com.qlik.demo.kotlin

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface BookingRepository : CrudRepository<com.qlik.demo.kotlin.model.BookingDocument, String> {

    fun findByUserId(userId: UUID): List<com.qlik.demo.kotlin.model.BookingDocument>
}
