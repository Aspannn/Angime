package kz.aspan.angime.repositories

import com.google.firebase.auth.AuthResult
import kz.aspan.angime.other.Resource

interface AuthRepository {
    suspend fun register(email: String, username: String, password: String): Resource<AuthResult>

    suspend fun login(email: String, password: String): Resource<AuthResult>
}