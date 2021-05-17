package kz.aspan.angime.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import kz.aspan.angime.R
import kz.aspan.angime.ui.main.MainActivity

@AndroidEntryPoint
class AuthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

//        if (FirebaseAuth.getInstance().currentUser != null) {
//            Intent(this, MainActivity::class.java).also {
//                startActivity(it)
//                finish()
//            }
//        }
    }
}