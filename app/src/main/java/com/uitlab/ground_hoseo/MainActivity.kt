package com.uitlab.ground_hoseo

import android.content.pm.PackageManager
import android.net.Uri.encode
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.kakao.sdk.common.util.Utility
import com.uitlab.ground_hoseo.databinding.ActivityMainBinding
import com.uitlab.ground_hoseo.intro.IntroAdapter
import com.uitlab.ground_hoseo.intro.IntroPageTransformer
import java.net.URLEncoder.encode
import java.security.MessageDigest
import java.util.*


class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.viewpager?.adapter = IntroAdapter(supportFragmentManager)
        binding.viewpager?.setPageTransformer(false, IntroPageTransformer(binding.viewpager))

    }
}