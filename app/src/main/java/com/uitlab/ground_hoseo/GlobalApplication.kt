package com.uitlab.ground_hoseo

import android.app.Application
import com.kakao.sdk.common.KakaoSdk
import java.lang.IllegalStateException

class GlobalApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // 다른 초기화 코드들

        // Kakao SDK 초기화
        KakaoSdk.init(this, "df76105f104673f0c8c4052534d35167")
    }
}