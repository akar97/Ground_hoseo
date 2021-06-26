package com.uitlab.ground_hoseo.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.*
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.kakao.sdk.auth.model.OAuthToken
import com.uitlab.ground_hoseo.R
import com.uitlab.ground_hoseo.databinding.LoginLayoutBinding
import kotlinx.android.synthetic.main.activity_second.view.*
import java.util.*
import com.kakao.sdk.common.model.AuthErrorCause.*
import com.kakao.sdk.user.UserApiClient
import com.uitlab.ground_hoseo.mainActivityGroup.MainPageActivity

class Login: AppCompatActivity() {

    val binding by lazy { LoginLayoutBinding.inflate(layoutInflater) }
    lateinit var mAuth: FirebaseAuth
    lateinit var googleSignInClient: GoogleSignInClient //구글 로그인을 관리하는 클래스
    val RC_SIGN_IN = 10


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        mAuth = FirebaseAuth.getInstance() //파이어베이스 인증객체 생성

        var gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN) //GoogleSignInOptions 옵션을관리해주는 클래스 API 키값과 요청할 값이 저장되어 있다.
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)

        binding.run {
            //kakaoLoginButton.setOnClickListener(kakoLogin()) //카카오톡 로그인
            GoogleLogin.setOnClickListener(googleLogin()) //구글 로그인 이벤트
        }
/*
        UserApiClient.instance.logout { error -> //카카오 로그인 로그아웃 부분 / 나중에 함수화 해야함
            if(error != null){
                Log.e("카카오 로그아웃","로그아웃 실패, SDK에서 토큰 삭제됨", error)
            }else{
                Log.e("카카오 로그아웃","로그아웃 성공, SDK에서 토근 삭제됨")
            }
        }

        UserApiClient.instance.me { user, error -> //카카오 사용자 정보 요청 / 나중에 함수화 해야함
            if(error != null){
                Log.e("사용자 정보 요청", "사용자 정보 요청 실패", error)
            }else if (user != null){
                   Log.d("사용자 정보 요청", "회원번호 ${user.id}" + "이메일 ${user.kakaoAccount?.email}")
            }
        }
*/
    }

    override fun onStart() {
        super.onStart()
        val currentUser = mAuth.currentUser //로그인되어 있는지 확인
    }

    inner class kakoLogin(): View.OnClickListener{
        override fun onClick(v: View?) {
            val callback:(OAuthToken?, Throwable?) -> Unit = { token, error ->
                if (error != null && v != null) {
                    when {
                        error.toString() == AccessDenied.toString() -> {
                            Toast.makeText(v.context, "접근이 거부 됨(동의 취소)", Toast.LENGTH_SHORT).show()
                        }
                        error.toString() == InvalidClient.toString() -> {
                            Toast.makeText(v.context, "유효하지 않은 앱", Toast.LENGTH_SHORT).show()
                        }
                        error.toString() == InvalidGrant.toString() -> {
                            Toast.makeText(v.context, "인증 수단이 유효하지 않아 인증할 수 없는 상태", Toast.LENGTH_SHORT).show()
                        }
                        error.toString() == InvalidRequest.toString() -> {
                            Toast.makeText(v.context, "요청 파라미터 오류", Toast.LENGTH_SHORT).show()
                        }
                        error.toString() == InvalidScope.toString() -> {
                            Toast.makeText(v.context, "유효하지 않은 scope ID", Toast.LENGTH_SHORT).show()
                        }
                        error.toString() == Misconfigured.toString() -> {
                            Toast.makeText(v.context, "설정이 올바르지 않음(android key hash)", Toast.LENGTH_SHORT).show()
                        }
                        error.toString() == ServerError.toString() -> {
                            Toast.makeText(v.context, "서버 내부 에러", Toast.LENGTH_SHORT).show()
                        }
                        error.toString() == Unauthorized.toString() -> {
                            Toast.makeText(v.context, "앱이 요청 권한이 없음", Toast.LENGTH_SHORT).show()
                        }
                        else -> { // Unknown
                            Toast.makeText(v.context, "기타 에러", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                else if (token != null) {
                    if (v != null) {
                        Toast.makeText(v.context, "로그인에 성공하였습니다.", Toast.LENGTH_SHORT).show()
                        val intent: Intent = Intent(this@Login, MainPageActivity::class.java)
                        startActivity(intent)
                    }
                }
            }

            if (v != null) {
                if (UserApiClient.instance.isKakaoTalkLoginAvailable(v.context)){ // 카카오톡 설치 여부 확인
                    UserApiClient.instance.loginWithKakaoTalk(v.context, callback = callback) //카카오톡으로 로그인
                } else{
                    UserApiClient.instance.loginWithKakaoAccount(v.context, callback = callback) //카카오계정으로 로그인
                }
            }
        }
    }


    inner class googleLogin(): View.OnClickListener{
        override fun onClick(v: View?) {
            singIn()
        }
    }

    private fun singIn(){
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == RC_SIGN_IN){
           val result: GoogleSignInResult = Auth.GoogleSignInApi.getSignInResultFromIntent(data)
            if(result.isSuccess){
                val account : GoogleSignInAccount = result.signInAccount!!
                Log.d("구분줄", "--------------------------------------------------")
                Log.d("구글 정보 필드", "구글정보 출력")
                Log.d("구글 정보", "${account.displayName}")
                Log.d("구글 정보", "${account.email}")
                Log.d("구글 정보", "${account.id}")
                Log.d("구글 정보", "${account.account}")
                Log.d("구글 정보", "${account.idToken}")
                Log.d("", "")
                firebaseAuthWithGoogle(account)
            }else{
                Log.d("에러", "구글 로그인 실패")
            }
        }else{
            Log.d("확인용", "에러")
        }
    }

    private fun firebaseAuthWithGoogle(acct: GoogleSignInAccount){ //구글정보를 파이어베이스로 값 넘기기
        val credential: AuthCredential = GoogleAuthProvider.getCredential(acct.idToken, null)
        mAuth.signInWithCredential(credential).addOnCompleteListener(this, OnCompleteListener<AuthResult> {
            if(it.isSuccessful){
                Log.d("구분줄", "--------------------------------------------------")
                Log.d("파이어베이스 등록", "등록 성공")
                Log.d("", "")
                val intent: Intent = Intent(this@Login, MainPageActivity::class.java)
                startActivity(intent)
            }else{
                Log.d("구분줄", "--------------------------------------------------")
                Log.d("파이어베이스 등록", "등록 실패")
                Log.d("", "")
            }
        })
    }
}
