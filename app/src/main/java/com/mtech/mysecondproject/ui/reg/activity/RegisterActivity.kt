package com.mtech.mysecondproject.ui.reg.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mtech.mysecondproject.R
import com.mtech.mysecondproject.ui.reg.viewModel.RegisterViewModel
import kotlinx.android.synthetic.main.activity_register.*
import org.koin.android.ext.android.inject

class RegisterActivity : AppCompatActivity() {

    private val regViewModel: RegisterViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        clickListener()
        setObserver()
    }

    private fun setObserver() {
        regViewModel.regObserver.observe(this, {
            if (it.user.status == "1") {
                edt_name.setText("")
                edt_mobile.setText("")
                edt_email.setText("")
                edt_password.setText("")
                edt_password_confirm.setText("")
                Toast.makeText(
                    this,
                    getString(R.string.successfully_registered),
                    Toast.LENGTH_SHORT
                ).show()

                Log.e("my_token", "setObserver: token: ${it.token}", )

            } else Toast.makeText(
                this,
                getString(R.string.something_went_wrong),
                Toast.LENGTH_SHORT
            ).show()
        })

        regViewModel.loaderObserver.observe(this, {
            if (it) loader.visibility = View.VISIBLE
            else loader.visibility = View.GONE
        })
    }

    private fun clickListener() {
        button_submit.setOnClickListener {
            val name = edt_name.text.toString()
            val mobile = edt_mobile.text.toString()
            val email = edt_email.text.toString()
            val password = edt_password.text.toString()
            val password_confirm = edt_password_confirm.text.toString()

            if (validateEdt(edt_name,name,getString(R.string.enter_your_name))
                && validateEdt(edt_mobile,mobile,getString(R.string.enter_your_mobile))
                && validateEdt(edt_email,email,getString(R.string.enter_your_email))
                && validateEdt(edt_password,password,getString(R.string.enter_your_password))
                && validateEdt(edt_password_confirm,password_confirm,getString(R.string.retype_your_password))
                && isPassMatched(password,password_confirm)){
                regViewModel.registerUser(name,mobile,email,password)
            }


        }
    }

    private fun validateEdt(edt: EditText, value: String, warningMessage: String): Boolean{
        if (value.isEmpty()){
            edt.requestFocus()
            Toast.makeText(this,warningMessage,Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    private fun isPassMatched(pass: String,passConfirm: String): Boolean{

        if (pass != passConfirm) {
            Toast.makeText(this,getString(R.string.pass_not_matched),Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }
}