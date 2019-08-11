package com.digiin.api.database.repository

import com.digiin.api.database.model.CheckOut
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CheckOutRepository : JpaRepository<CheckOut, Long> {
}