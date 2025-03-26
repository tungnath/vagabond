package com.ravi.vagabond.api.user

import com.ravi.vagabond.api.user.dto.CreateUserRequest
import com.ravi.vagabond.api.user.dto.UpdateUserRequest
import com.ravi.vagabond.base.dto.APIResponse
import com.ravi.vagabond.api.user.dto.UserResponse
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(
    path = ["/users"], produces = [MediaType.APPLICATION_JSON_VALUE], consumes = [MediaType.APPLICATION_JSON_VALUE]
)
@Validated
class UserController(private val userService: UserService) {

    @GetMapping("/")
    @ResponseBody
    fun getUsers(): ResponseEntity<APIResponse<List<UserResponse>>> {

        val udResponse: APIResponse<List<UserResponse>> = APIResponse(
            HttpStatus.OK.value(), "Users fetched successfully", userService.getUsers()
        )

        return ResponseEntity.ok(udResponse)
    }

    @PostMapping("/")
    @ResponseBody
    fun createUser(@RequestBody ud: CreateUserRequest): ResponseEntity<APIResponse<UserResponse>> {

        val cuResponse: APIResponse<UserResponse> = APIResponse(
            HttpStatus.OK.value(), "User created successfully", userService.createUser(ud)
        )

        return ResponseEntity.ok(cuResponse)
    }

    @PutMapping("/")
    @ResponseBody
    fun updateUser(@RequestBody ud: UpdateUserRequest): ResponseEntity<APIResponse<UserResponse>> {
        val cuResponse: APIResponse<UserResponse> = APIResponse(
            HttpStatus.OK.value(), "User updated successfully", userService.updateUser(ud)
        )

        return ResponseEntity.ok(cuResponse)
    }

    @DeleteMapping("/")
    @ResponseBody
    fun deleteUser(@RequestBody email: String): ResponseEntity<APIResponse<Boolean>> {
        val cuResponse: APIResponse<Boolean> = APIResponse(
            HttpStatus.OK.value(), "User deleted successfully", userService.deleteUser(email)
        )

        return ResponseEntity.ok(cuResponse)
    }

}