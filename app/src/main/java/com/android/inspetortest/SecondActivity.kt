package com.android.inspetortest

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import com.inspetor.Inspetor
import android.util.Log

class SecondActivity : AppCompatActivity() {

    var arrayRequest: ArrayList<String> = arrayListOf(
        "Account Login",
        "Account Logout",
        "Account Creation",
        "Account Update",
        "Account Deletion",
        "Event Creation",
        "Event Update",
        "Event Deletion",
        "Transfer Creation",
        "Transfer Update",
        "Sale Creation",
        "Sale Update",
        "Password Recovery",
        "Password Reset",
        "Pageview Track"
    )

    private var requestCode: Int = 12345
    lateinit var spinner: Spinner
    lateinit var button: Button
    lateinit var buttonAll: Button

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            12345 -> if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.i("INSPETOR", "Permission granted")
            } else {
                Log.i("INSPETOR", "Permission not granted")
            }
            else -> super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.btnSubmit)
        buttonAll = findViewById(R.id.btnSubmit2)
        spinner = findViewById(R.id.spinner)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
                checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this, arrayOf<String>(
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    ), requestCode
                )
            } else {
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    override fun onResume() {
        super.onResume()

        val arrayAdpt: ArrayAdapter<String> = ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, arrayRequest)
        arrayAdpt.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        this.spinner.adapter = arrayAdpt

        this.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                button.setOnClickListener {
                    when (arrayRequest[position]) {
                        "Account Login" -> if (Inspetor.sharedInstance().isConfigured()) {
                            Inspetor.sharedInstance().trackLogin("email@email.com", "123")
                        }
                        "Account Logout" -> if (Inspetor.sharedInstance().isConfigured()) {
                            Inspetor.sharedInstance().trackLogout("email@email.com", "")
                        }
                        "Account Creation" -> if (Inspetor.sharedInstance().isConfigured()) {
                            Inspetor.sharedInstance().trackAccountCreation("123")
                        }
                        "Account Update" -> if (Inspetor.sharedInstance().isConfigured()) {
                            Inspetor.sharedInstance().trackAccountUpdate("123")
                        }
                        "Account Deletion" -> if (Inspetor.sharedInstance().isConfigured()) {
                            Inspetor.sharedInstance().trackAccountDeletion("123")
                        }
                        "Event Creation" -> if (Inspetor.sharedInstance().isConfigured()) {
                            Inspetor.sharedInstance().trackEventCreation("123")
                        }
                        "Event Update" -> if (Inspetor.sharedInstance().isConfigured()) {
                            Inspetor.sharedInstance().trackEventCreation("123")
                        }
                        "Event Deletion" -> if (Inspetor.sharedInstance().isConfigured()) {
                            Inspetor.sharedInstance().trackEventDeletion("123")
                        }
                        "Transfer Creation" -> if (Inspetor.sharedInstance().isConfigured()) {
                            Inspetor.sharedInstance().trackItemTransferCreation("123")
                        }
                        "Transfer Update" -> if (Inspetor.sharedInstance().isConfigured()) {
                            Inspetor.sharedInstance().trackItemTransferUpdate("123")
                        }
                        "Sale Creation" -> if (Inspetor.sharedInstance().isConfigured()) {
                            Inspetor.sharedInstance().trackSaleCreation("123")
                        }
                        "Sale Update" -> if (Inspetor.sharedInstance().isConfigured()) {
                            Inspetor.sharedInstance().trackSaleUpdate("123")
                        }
                        "Password Recovery" -> if (Inspetor.sharedInstance().isConfigured()) {
                            Inspetor.sharedInstance().trackPasswordRecovery("email@email")
                        }
                        "Password Reset" -> if (Inspetor.sharedInstance().isConfigured()) {
                            Inspetor.sharedInstance().trackPasswordReset("email@email")
                        }
                        "Pageview Track" -> if (Inspetor.sharedInstance().isConfigured()) {
                            Inspetor.sharedInstance().trackPageView("Page Track")
                        }
                    }
                }
                findViewById<Button>(R.id.btnSubmit)
            }
        }

        buttonAll.setOnClickListener {
            if (Inspetor.sharedInstance().isConfigured()){
                for(i in arrayRequest.indices) {
                    when (arrayRequest[i]) {
                        "Account Login" -> if (Inspetor.sharedInstance().isConfigured()) {
                            Inspetor.sharedInstance().trackLogin("email@email.com", "123")
                        }
                        "Account Logout" -> if (Inspetor.sharedInstance().isConfigured()) {
                            Inspetor.sharedInstance().trackLogout("email@email.com", "")
                        }
                        "Account Creation" -> if (Inspetor.sharedInstance().isConfigured()) {
                            Inspetor.sharedInstance().trackAccountCreation("123")
                        }
                        "Account Update" -> if (Inspetor.sharedInstance().isConfigured()) {
                            Inspetor.sharedInstance().trackAccountUpdate("123")
                        }
                        "Account Deletion" -> if (Inspetor.sharedInstance().isConfigured()) {
                            Inspetor.sharedInstance().trackAccountDeletion("123")
                        }
                        "Event Creation" -> if (Inspetor.sharedInstance().isConfigured()) {
                            Inspetor.sharedInstance().trackEventCreation("123")
                        }
                        "Event Update" -> if (Inspetor.sharedInstance().isConfigured()) {
                            Inspetor.sharedInstance().trackEventCreation("123")
                        }
                        "Event Deletion" -> if (Inspetor.sharedInstance().isConfigured()) {
                            Inspetor.sharedInstance().trackEventDeletion("123")
                        }
                        "Transfer Creation" -> if (Inspetor.sharedInstance().isConfigured()) {
                            Inspetor.sharedInstance().trackItemTransferCreation("123")
                        }
                        "Transfer Update" -> if (Inspetor.sharedInstance().isConfigured()) {
                            Inspetor.sharedInstance().trackItemTransferUpdate("123")
                        }
                        "Sale Creation" -> if (Inspetor.sharedInstance().isConfigured()) {
                            Inspetor.sharedInstance().trackSaleCreation("123")
                        }
                        "Sale Update" -> if (Inspetor.sharedInstance().isConfigured()) {
                            Inspetor.sharedInstance().trackSaleUpdate("123")
                        }
                        "Password Recovery" -> if (Inspetor.sharedInstance().isConfigured()) {
                            Inspetor.sharedInstance().trackPasswordRecovery("email@email")
                        }
                        "Password Reset" -> if (Inspetor.sharedInstance().isConfigured()) {
                            Inspetor.sharedInstance().trackPasswordReset("email@email")
                        }
                        "Pageview Track" -> if (Inspetor.sharedInstance().isConfigured()) {
                            Inspetor.sharedInstance().trackPageView("Page Track")
                        }
                    }
                }
            }
        }
    }
}