package com.pizzeria.premstattner.activity


import android.os.Handler
import android.os.Looper
import com.pizzeria.premstattner.R
import com.pizzeria.premstattner.base.BaseActivity
import com.pizzeria.premstattner.utils.Common
import com.pizzeria.premstattner.utils.SharePreference
import com.pizzeria.premstattner.utils.SharePreference.Companion.getBooleanPref


class SplashActivity : BaseActivity(){
    override fun setLayout(): Int {
       return R.layout.activity_splash
    }

    override fun InitView() {
        Common.getCurrentLanguage(this@SplashActivity, false)
        Handler(Looper.getMainLooper()).postDelayed({
            if(!getBooleanPref(this@SplashActivity,SharePreference.isTutorial)){
                openActivity(TutorialActivity::class.java)
                finish()
            }else{
                openActivity(DashboardActivity::class.java)
                finish()
            }
        },3000)
    }

    override fun onResume() {
        super.onResume()
        Common.getCurrentLanguage(this@SplashActivity, false)
    }
}