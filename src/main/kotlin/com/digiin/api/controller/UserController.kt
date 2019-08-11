package com.digiin.api.controller

import com.digiin.api.database.model.CheckIn
import com.digiin.api.database.model.CheckOut
import com.digiin.api.database.model.User
import com.digiin.api.database.model.enum.UserRoles
import com.digiin.api.database.repository.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
import javax.persistence.NoResultException
import javax.validation.Valid

@RestController
class UserController @Autowired constructor(val userRepository: UserRepository, val checkInRepository: CheckInRepository, val checkOutRepository: CheckOutRepository, val roleRepository: RoleRepository, val companiesRepository: CompaniesRepository) {

    @GetMapping("/user/in/{id}")
    fun checkUserIn(@PathVariable id: Long): HttpStatus
    {
        val checkIn = CheckIn()
        try {
            checkIn.user = userRepository.getOne(id)
        }  catch (e: NoResultException) {
            return HttpStatus.NOT_FOUND
        }

        checkIn.checkinTime = LocalDateTime.now()
        
        checkInRepository.save(checkIn)
        
        return HttpStatus.OK
    }
    
    @GetMapping("/user/out/{id}")
    fun userCheckOut(@PathVariable id: Long): HttpStatus
    {
        val checkOut = CheckOut()
        try {
            checkOut.user = userRepository.getOne(id)
        }  catch (e: NoResultException) {
            return HttpStatus.NOT_FOUND
        }

        checkOut.checkoutTime = LocalDateTime.now()

        checkOutRepository.save(checkOut)

        return HttpStatus.OK
    }

    @PostMapping("/user/add")
    fun addUser(@Valid @RequestBody user: User)
    {
        user.role = roleRepository.getRoleByRoleName(UserRoles.USER.toString())
        user.company = companiesRepository.findCompaniesByName("Test Company")

        userRepository.save(user)
    }
}