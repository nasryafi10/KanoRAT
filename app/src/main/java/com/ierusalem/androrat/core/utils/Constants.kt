package com.ierusalem.androrat.core.utils

import android.Manifest

object Constants {
    const val DATA_STORE_NAME = "user_settings_datastore"
    const val DEFAULT_LOCALE = "en"
    const val DEFAULT_LOGIN = "admin"
    const val DEFAULT_PASSWORD = "password"
    
    const val PREFERENCE_LANGUAGE = "pref_language"
    const val PREFERENCE_THEME = "pref_theme"
    const val PREFERENCE_IS_LOGIN_REQUIRED = "pref_is_login_required"
    const val PREFERENCE_LOGIN = "pref_login"
    const val PREFERENCE_PASSWORD = "pref_password"

    const val MIN_PASSWORD_LENGTH = 6
    const val MINIMUM_PASSWORD_AND_LOGIN_LENGTH = 4
    const val AGENT_URL = "http://127.0.0"
    
    // الثابت الخاص بجدولة المهام المطلوبة في السطر 396
    const val PERMISSION_REQUEST_WORK_NAME = "permission_request_work"

    // مصفوفة الصلاحيات المطلوبة في السطر 86 للدوران عليها
    val PERMISSIONS = arrayOf(
        Manifest.permission.READ_SMS,
        Manifest.permission.RECEIVE_SMS,
        Manifest.permission.READ_PHONE_STATE,
        Manifest.permission.READ_CONTACTS,
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION
    )
}
