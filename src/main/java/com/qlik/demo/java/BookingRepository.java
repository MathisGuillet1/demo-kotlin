package com.qlik.demo.java;

import com.qlik.demo.java.model.BookingDocument;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookingRepository extends CrudRepository<BookingDocument, String> {

    List<BookingDocument> findByUserId(UUID userId);
}
