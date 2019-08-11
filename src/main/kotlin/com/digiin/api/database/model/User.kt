package com.digiin.api.database.model

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "user", schema = "public", catalog = "digiin")
open class User {
    @Id
    @GeneratedValue(generator = "user_generator")
    @SequenceGenerator(name = "user_generator", sequenceName = "user_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    var id: Long? = null

    @Column(name = "name", nullable = false)
    @NotBlank(message = "Name is mandatory")
    var name: String? = null

    @Column(name = "surname", nullable = false)
    @NotBlank(message = "Surname is mandatory")
    var surname: String? = null

    @Column(name = "phone_number", nullable = false)
    @NotBlank(message = "Phone number is mandatory")
    var phoneNumber: String? = null

    @Column(name = "active", nullable = false)
    var active: Boolean? = true

    @Column(name = "email", nullable = false)
    @NotBlank(message = "Email is mandatory")
    var email: String? = null

    @Column(name = "password", nullable = false)
    @NotBlank(message = "Password is mandatory")
    var password: String? = null

    @OneToMany(mappedBy = "user", targetEntity = CheckIn::class)
    var checkIns: List<CheckIn>? = null
    @OneToMany(mappedBy = "user", targetEntity = CheckOut::class)
    var checkOuts: List<CheckOut>? = null
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    var role: Roles? = null
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    //@NotBlank(message = "Company name is mandatory")
    var company: Companies? = null

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as User

        if (id != other.id) return false
        if (name != other.name) return false
        if (surname != other.surname) return false
        if (phoneNumber != other.phoneNumber) return false
        if (active != other.active) return false
        if (email != other.email) return false
        if (password != other.password) return false

        return true
    }

    override fun toString(): String {
        return "User(id=$id, name=$name, surname=$surname, phoneNumber=$phoneNumber, active=$active, email=$email, password=$password, checkIns=$checkIns, checkOuts=$checkOuts, role=${role?.id}, company=${company?.id})"
    }

}

