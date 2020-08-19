package com.usetada.whitelabel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.urbanairship.UAirship

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        UAirship.shared().namedUser.id = "+6281100000000" //used after login, set to null when logout
    }
}