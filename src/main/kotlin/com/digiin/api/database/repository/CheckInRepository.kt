package com.digiin.api.database.repository

import com.digiin.api.database.model.CheckIn
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CheckInRepository : JpaRepository<CheckIn, Long> {
}