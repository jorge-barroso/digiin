package com.digiin.api.database.repository

import com.digiin.api.database.model.Companies
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CompaniesRepository: JpaRepository<Companies, Long> {
    fun findCompaniesByName(name: String): Companies
}