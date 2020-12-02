package com.pizzeria.premstattner.fragment

import android.content.Intent
import android.view.View
import com.pizzeria.premstattner.BuildConfig
import com.pizzeria.premstattner.R
import com.pizzeria.premstattner.activity.*
import com.pizzeria.premstattner.base.BaseFragmnet
import com.pizzeria.premstattner.utils.Common.getCurrentLanguage
import com.pizzeria.premstattner.utils.SharePreference
import kotlinx.android.synthetic.main.fragment_home.ivMenu
import kotlinx.android.synthetic.main.fragment_setting.*


class SettingFragment: BaseFragmnet() {
    override fun setView(): Int {
        return R.layout.fragment_setting
    }
    override fun Init(view: View) {
        getCurrentLanguage(activity!!, false)
        ivMenu.setOnClickListener {
            (activity as DashboardActivity?)!!.onDrawerToggle()
        }

        cvBtnEditProfile.setOnClickListener {
            if(SharePreference.getBooleanPref(activity!!,SharePreference.isLogin)){
                openActivity(EditProfileActivity::class.java)
            }else {
                openActivity(LoginActivity::class.java)
                activity!!.finish()
                activity!!.finishAffinity()
            }
        }

        cvBtnPassword.setOnClickListener {
            if(SharePreference.getBooleanPref(activity!!,SharePreference.isLogin)){
                openActivity(ChangePasswordActivity::class.java)
            }else {
                openActivity(LoginActivity::class.java)
                activity!!.finish()
                activity!!.finishAffinity()
            }
        }
        cvPolicy.setOnClickListener {
            openActivity(ProvacyPolicyActivity::class.java)
        }
        llArabic.setOnClickListener {
            SharePreference.setStringPref(activity!!, SharePreference.SELECTED_LANGUAGE,activity!!.resources.getString(R.string.language_hindi))
            getCurrentLanguage(activity!!, true)
        }
        llEnglish.setOnClickListener {
            SharePreference.setStringPref(activity!!, SharePreference.SELECTED_LANGUAGE,activity!!.resources.getString(R.string.language_english))
            getCurrentLanguage(activity!!, true)
        }
        cvShare.setOnClickListener {
            try {
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Food App")
                var shareMessage = "\nLet me recommend you this application\n\n"
                shareMessage = "${shareMessage}https://play.google.com/store/apps/details?id=${BuildConfig.APPLICATION_ID}".trimIndent()
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
                startActivity(Intent.createChooser(shareIntent, "choose one"))
            } catch (e: Exception) {
            }
        }
    }

    override fun onResume() {
        super.onResume()
        getCurrentLanguage(activity!!, false)
    }


}