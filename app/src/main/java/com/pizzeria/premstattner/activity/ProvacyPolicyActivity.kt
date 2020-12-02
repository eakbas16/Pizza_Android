package com.pizzeria.premstattner.activity

import android.view.View
import android.webkit.WebViewClient
import com.pizzeria.premstattner.R
import com.pizzeria.premstattner.api.ApiClient
import com.pizzeria.premstattner.base.BaseActivity
import kotlinx.android.synthetic.main.activity_privacy_policy.*

class ProvacyPolicyActivity:BaseActivity() {
    override fun setLayout(): Int = R.layout.activity_privacy_policy

    override fun InitView() {
        ivBack.setOnClickListener {
            finish()
        }
        webView.setWebViewClient(WebViewClient())
        webView.getSettings().setLoadsImagesAutomatically(true)
        webView.getSettings().setJavaScriptEnabled(true)
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY)
        webView.loadUrl(ApiClient.PrivicyPolicy)
    }
}