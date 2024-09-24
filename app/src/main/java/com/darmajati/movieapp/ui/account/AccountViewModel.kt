package com.darmajati.movieapp.ui.account

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AccountViewModel : ViewModel() {

    private val _accountInfo = MutableLiveData<String>().apply {
        value = "Account Info: Darma" // Boleh diubah untuk Account Infonya.
    }
    val accountInfo: LiveData<String> = _accountInfo

}
