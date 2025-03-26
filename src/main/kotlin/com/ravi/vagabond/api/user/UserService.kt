package com.ravi.vagabond.api.user

import com.ravi.vagabond.api.user.dto.CreateUserRequest
import com.ravi.vagabond.api.user.dto.UpdateUserRequest
import com.ravi.vagabond.api.user.dto.UserResponse
import com.ravi.vagabond.api.user.model.UserModel
import org.springframework.beans.BeanUtils
import org.springframework.stereotype.Service

// TODO update the code to use real database

@Service
class UserService(
    private val userRepository: UserRepository, private var allUsers: MutableList<UserResponse>
) {

    init {
        allUsers = mutableListOf()

        allUsers.addAll(
            listOf(
                UserResponse(name = "Robin", email = "robin@gmail.com", mobile = "9188098978"),
                UserResponse(name = "Maven", email = "maven@gmail.com", mobile = "9288098978")
            )
        )
    }

    fun getUsers(): MutableList<UserResponse> {

        val userResponses = ArrayList<UserResponse>()
        val users = userRepository.findAll()

        // change the mapping
        for (usr in users) {
            val userResponse = UserResponse()
            BeanUtils.copyProperties(usr, userResponse)
            userResponses.add(userResponse)
        }

        return userResponses
    }

    fun createUser(userData: CreateUserRequest): UserResponse {

        val email = userData.email

        val userModel = UserModel(
            name = userData.name, email = userData.email, mobile = userData.mobile, pass = userData.pass
        )

        // save it in the database
        userRepository.save(userModel)

        // fetch it by email
        val userFound = userRepository.findFirstByEmail(email = email)
        val userRes = UserResponse()

        userFound?.let {
            BeanUtils.copyProperties(userFound, userRes)
        }

        return userRes
    }


    fun updateUser(userData: UpdateUserRequest): UserResponse {

        val email = userData.email
        val userFound: UserModel? = userRepository.findFirstByEmail(email)

        userFound?.let {

            BeanUtils.copyProperties(userData, userFound)
            // Update the user
            userRepository.save(userFound)
        }


        // fetch it by email after
        val updatedUser = userRepository.findFirstByEmail(email = email)
        val userRes = UserResponse()

        updatedUser?.let {
            BeanUtils.copyProperties(updatedUser, userRes)
        }

        return userRes
    }

    fun deleteUser(email: String): Boolean {
        val userFound: UserModel? = userRepository.findFirstByEmail(email)
        var success = false

        userFound?.let {
            // delete the user
            val id = userRepository.deleteByEmail(email)
            println("Deleted user $id")
            success = id > 0
        }


        return success
    }

}