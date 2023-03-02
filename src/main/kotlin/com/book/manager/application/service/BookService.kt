package com.book.manager.application.service

import com.book.manager.domain.model.BookWithRental
import com.book.manager.domain.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(
    private val bookRepository: BookRepository
) {
    fun getList(): List<BookWithRental> {
        return bookRepository.findAllWithRental() // [BookWithRental(book=Book(id=100, title=Kotolin beginners, author=Kotlin Taro, releaseDate=1950-10-01), rental=null),...]
    }

    fun getDetail(bookId: Long): BookWithRental {
        return bookRepository.findWithRental(bookId) ?: throw IllegalArgumentException("存在しない書籍ID: $bookId") // BookWithRental(book=Book(id=100, title=Kotolin beginners, author=Kotlin Taro, releaseDate=1950-10-01), rental=null)
    }
}