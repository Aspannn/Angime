package kz.aspan.angime.data.entities

import com.google.firebase.firestore.Exclude
import com.google.firebase.firestore.IgnoreExtraProperties
import kz.aspan.angime.other.Constants.DEFAULT_PROFILE_PICTURE_URL


@IgnoreExtraProperties
data class User(
    val uid: String = "",
    val username: String = "",
    val profilePictureUrl: String = DEFAULT_PROFILE_PICTURE_URL,
    val description: String = "",
    var follows: List<String> = listOf(),
    @Exclude
    var isFollowing: Boolean = false
)
