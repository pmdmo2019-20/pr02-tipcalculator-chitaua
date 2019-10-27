package es.iessaladillo.pedrojoya.tipcalculator.ui.main

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import es.iessaladillo.pedrojoya.tipcalculator.R
import es.iessaladillo.pedrojoya.tipcalculator.model.TipCalculator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViews()
    }

    private fun setupViews() {
        txtBill.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                checkEmptyField(txtBill)
                val calculator = TipCalculator(
                    txtBill.text.toString().toFloat(),
                    txtPercentage.text.toString().toFloat(),
                    txtDiners.text.toString().toInt()
                )
                setFields(calculator)
            }

        })
        txtPercentage.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                checkEmptyField(txtPercentage)
                val calculator = TipCalculator(
                    txtBill.text.toString().toFloat(),
                    txtPercentage.text.toString().toFloat(),
                    txtDiners.text.toString().toInt()
                )
                setFields(calculator)
            }

        })

        txtDiners.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                checkEmptyField(txtDiners)
                val calculator = TipCalculator(
                    txtBill.text.toString().toFloat(),
                    txtPercentage.text.toString().toFloat(),
                    txtDiners.text.toString().toInt()
                )
                setFields(calculator)
            }

        })

        btnResetTip.setOnClickListener{ resetTip() }
        btnResetDiners.setOnClickListener { resetDiners() }

    }

       private fun checkEmptyField(editText: EditText) {

            if (editText.text.isEmpty()) {
                if (editText == txtDiners)
                    editText.setText(R.string.defaultDinersValue)
                else if (editText == txtPercentage)
                    editText.setText(R.string.defaultPercent)
                else
                    editText.setText(R.string.defaultFieldsValue)
            }

        }

        private fun setFields(calculator: TipCalculator) {
            txtTip.setText(String.format("%.2f", calculator.calculateTip()))
            txtTotal.setText(String.format("%.2f", calculator.calculateTotal()))
            txtPerDiner.setText(String.format("%.2f", calculator.calculatePerDiner()))
            txtPerDinerRounded.setText(String.format("%.2f", calculator.calculatePerDinerRounded()))
        }

        private fun resetTip() {
            txtBill.setText(R.string.defaultFieldsValue)
            txtPercentage.setText(R.string.defaultPercent)
        }

        private fun resetDiners() {
            txtDiners.setText(R.string.defaultDinersValue)
        }
}
