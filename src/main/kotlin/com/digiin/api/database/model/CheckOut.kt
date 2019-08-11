package com.digiin.api.database.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "check_out", schema = "public", catalog = "digiin")
open class CheckOut {

    @Column(name = "user_id", nullable = false, insertable = false, updatable = false)
    var userId: Int? = null

    @Column(name = "checkout_time", nullable = false)
    var checkoutTime: LocalDateTime? = null

    @Id

    @GeneratedValue(generator = "check_out_generator")
    @SequenceGenerator(name = "check_out_generator", sequenceName = "check_out_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User::class)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    var user: User? = null

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as CheckOut

        if (userId != other.userId) return false
        if (checkoutTime != other.checkoutTime) return false
        if (id != other.id) return false

        return true
    }

    override fun toString(): String {
        return "CheckOut(userId=$userId, checkoutTime=$checkoutTime, id=$id, refUser=$user)"
    }

}

