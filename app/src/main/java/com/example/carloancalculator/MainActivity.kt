package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      buttonCalculate.setOnClickListener{
          calculateLoan()
      }
    }

    private fun calculateLoan(){

        if(editTextCarPrice.text.isEmpty()){
            editTextCarPrice.setError(getString(R.string.error_input))
            return
        }

        val currency = (Currency.getInstance(Locale.getDefault()).getSymbol())


        val carPrice: Int = editTextCarPrice.text.toString().toInt()
        val downPayment: Int = editTextDownPayment.text.toString().toInt()
        val loan:Int = carPrice - downPayment

        textViewLoan.setText(getString(R.string.loan) + currency + "${loan}")

        val interestRate:Float = editTextIncreaseRate.text.toString().toFloat()
        val loanPeriod:Float = editTextLoanPeriod.text.toString().toFloat()
        val interest: Float = loan*interestRate*loanPeriod

        textViewInterest.setText(getString(R.string.interest) + currency + "${interest}")

        val monthlyPayment:Float = (loan + interest) / loanPeriod /12

        textViewMOnthlyPaymemt.setText((getString(R.string.monthly_payment)) + currency + "${monthlyPayment}")

        Toast.makeText(this, "Calculate Loan", Toast.LENGTH_SHORT).show()
    }

  fun reset(view: View){

     editTextCarPrice.setText("")
     editTextDownPayment.setText("")
     editTextLoanPeriod.setText("")
     editTextIncreaseRate.setText("")

      textViewLoan.setText("")
      textViewInterest.setText("")
      textViewMOnthlyPaymemt.setText("")


     Toast.makeText(this, "Reset",Toast.LENGTH_SHORT).show()

 }

}
