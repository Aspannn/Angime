package kz.aspan.angime.repositories

import com.google.firebase.auth.AuthResult
import kz.aspan.angime.other.Resource

class DefaultAuthRepository : AuthRepository {
    override suspend fun register(
        email: String,
        username: String,
        password: String
    ): Resource<AuthResult> {
        TODO("Not yet implemented")
    }

    override suspend fun login(email: String, password: String): Resource<AuthResult> {
        TODO("Not yet implemented")
    }
}