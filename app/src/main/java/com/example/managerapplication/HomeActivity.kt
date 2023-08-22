package com.example.managerapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.managerapplication.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var Binding : ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        Binding= ActivityHomeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(Binding.root)

        initview()
    }

    private fun initview() {

        Binding.imgDrawer.setOnClickListener {
            Binding.Drawer.openDrawer(Binding.navigationDrawer)
        }
        Binding.HomeNavigation.setOnClickListener {

            var I = Intent(this,HomeActivity::class.java)
            startActivity(I)

        }


        Binding.CalenderNavigation.setOnClickListener {

            var I = Intent(this,CalenderActivity::class.java)
            startActivity(I)

        }

        Binding.PaymentNavigation.setOnClickListener {

            var I = Intent(this,PaymentActivity::class.java)
            startActivity(I)

        }

        Binding.CategoryNavigation.setOnClickListener {

            var I = Intent(this,CategoryActivity::class.java)
            startActivity(I)
        }
        Binding.calenderHome.setOnClickListener {

            var I = Intent(this,CalenderActivity::class.java)
            startActivity(I)
        }


        Binding.cardviewAddIncome.setOnClickListener {

            var I = Intent(this,IncomeActivity::class.java)
            startActivity(I)
        }
        Binding.cardviewAddExpense.setOnClickListener {

            var I = Intent(this,ExpensesActivity::class.java)
            startActivity(I)
        }

        Binding.cardviewAlltransaction.setOnClickListener {

            var I = Intent(this,AllTranjectionActivity::class.java)
            startActivity(I)
        }
        Binding.RateNavigation.setOnClickListener {

            var I = Intent(this,RateActivity::class.java)
            startActivity(I)
        }
        Binding.TermsOfServiceNavigation.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.google.com/")
            startActivity(openURL)

            var I = Intent(this,TermsOfServiceActivity::class.java)
            startActivity(I)

        }
        Binding.SharewithFriendNavigation.setOnClickListener {

            var I = Intent(this,ShareActivity::class.java)
            startActivity(I)
        }





    }

}