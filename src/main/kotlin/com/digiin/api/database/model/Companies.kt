package com.digiin.api.database.model

import javax.persistence.*

@Entity
@Table(name = "companies", schema = "public", catalog = "digiin")
open class Companies {
    @Id
    @GeneratedValue(generator = "companies_generator")
    @SequenceGenerator(name = "companies_generator", sequenceName = "companies_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    var id: Long? = null

    @Column(name = "name", nullable = false)
    var name: String? = null

    @Column(name = "address", nullable = false)
    var address: String? = null

    @Column(name = "phone_number", nullable = false)
    var phoneNumber: String? = null

    @Column(name = "active", nullable = false)
    var active: Boolean? = null

    @OneToMany(mappedBy = "company", targetEntity = User::class)
    var users: List<User>? = null

    override fun toString(): String =
            "Entity of type: ${javaClass.name} ( " +
                    "id = $id " +
                    "name = $name " +
                    "address = $address " +
                    "phoneNumber = $phoneNumber " +
                    "active = $active " +
                    ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Companies

        if (id != other.id) return false
        if (name != other.name) return false
        if (address != other.address) return false
        if (phoneNumber != other.phoneNumber) return false
        if (active != other.active) return false

        return true
    }

}

