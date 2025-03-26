package com.ravi.vagabond.api.user

import com.ravi.vagabond.api.user.model.UserModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<UserModel, Long> {

    fun findFirstByEmail(email: String) : UserModel?
    fun deleteByEmail(email:String) : Int

    override fun findAllById(ids: MutableIterable<Long>): MutableList<UserModel>
}