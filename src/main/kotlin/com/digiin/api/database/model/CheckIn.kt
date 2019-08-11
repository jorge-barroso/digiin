package com.digiin.api.database.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "check_in", schema = "public", catalog = "digiin")
open class CheckIn {

    @Id
    @GeneratedValue(generator = "check_in_generator")
    @SequenceGenerator(name = "check_in_generator", sequenceName = "check_in_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @Column(name = "checkin_time", nullable = false)
    var checkinTime: LocalDateTime? = null

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User::class)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    var user: User? = null

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        return when{
            (this === other) ||
            (javaClass != other?.javaClass) ||
            checkinTime != (other as CheckIn).checkinTime ||
            id != (other as CheckIn).id -> false

            else -> true

        }
    }

    override fun toString(): String {
        return "CheckIn(id=$id, userId=${user?.id}, checkinTime=$checkinTime, user=$user)"
    }

}

