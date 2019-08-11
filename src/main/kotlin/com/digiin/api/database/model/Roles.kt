package com.digiin.api.database.model

import javax.persistence.*

@Entity
@Table(name = "roles", schema = "public", catalog = "digiin")
open class Roles {
    @Id
    @GeneratedValue(generator = "roles_generator")
    @SequenceGenerator(name = "roles_generator", sequenceName = "roles_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    var id: Long? = null

    @Column(name = "role_name", nullable = false)
    var roleName: String? = null

    @OneToMany(mappedBy = "role", targetEntity = User::class)
    var users: List<User>? = null

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Roles

        if (id != other.id) return false
        if (roleName != other.roleName) return false

        return true
    }

    override fun toString(): String {
        return "Roles(id=$id, roleName=$roleName, users=$users)"
    }

}

