package com.digiin.api.database.repository

import com.digiin.api.database.model.Roles
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RoleRepository : JpaRepository<Roles, Long> {
    fun getRoleByRoleName(roleName: String): Roles
}