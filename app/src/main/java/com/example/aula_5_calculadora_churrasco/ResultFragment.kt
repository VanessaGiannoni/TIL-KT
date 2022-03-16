package com.example.aula_5_calculadora_churrasco

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

private var TOTAL_MEN: Int = 0
private var TOTAL_WOMEN: Int = 0
private var TOTAL_CHILDREN: Int = 0

class ResultFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun amountMeet(totalMen: Int, totalWomen: Int, totalChildren: Int): Double {
        return 0
            .plus(totalMen.times(200))
            .plus(totalWomen.times(180))
            .plus(totalChildren.times(100))
            .toDouble()
    }

    private fun amountSausage(totalMen: Int, totalWomen: Int, totalChildren: Int): Double {
        return 0
            .plus(totalMen.times(200))
            .plus(totalWomen.times(180))
            .plus(totalChildren.times(100))
            .toDouble()
    }

    private fun amountBeer(totalMen: Int, totalWomen: Int): Double {
        return 0
            .plus(totalMen.times(1500))
            .plus(totalWomen.times(1000))
            .toDouble()
    }

    private fun amountSoda(totalMen: Int, totalWomen: Int, totalChildren: Int): Double {
        return 0
            .plus(totalMen.times(250))
            .plus(totalWomen.times(450))
            .plus(totalChildren.times(300))
            .toDouble()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inflate = inflater.inflate(R.layout.fragment_result, container, false)
        val inputMeat = inflate.findViewById<EditText>(R.id.txtMeat)
        val inputSausage = inflate.findViewById<EditText>(R.id.txtSausage)
        val inputBeer = inflate.findViewById<EditText>(R.id.txtBeer)
        val inputSoda = inflate.findViewById<EditText>(R.id.txtSoda)

        inputMeat.setText(String.format("%.2f", amountMeet(TOTAL_MEN, TOTAL_WOMEN, TOTAL_CHILDREN)))
        inputMeat.isFocusable = false
        inputMeat.isFocusableInTouchMode = false

        inputSausage.setText(String.format("%.2f", amountSausage(TOTAL_MEN, TOTAL_WOMEN, TOTAL_CHILDREN)))
        inputSausage.isFocusable = false
        inputSausage.isFocusableInTouchMode = false

        inputBeer.setText(String.format("%.2f", amountBeer(TOTAL_MEN, TOTAL_WOMEN)))
        inputBeer.isFocusable = false
        inputBeer.isFocusableInTouchMode = false

        inputSoda.setText(String.format("%.2f", amountSoda(TOTAL_MEN, TOTAL_WOMEN, TOTAL_CHILDREN)))
        inputSoda.isFocusable = false
        inputSoda.isFocusableInTouchMode = false

        val btnBack = inflate.findViewById<Button>(R.id.btnBack)

        btnBack.setOnClickListener {
            val frManager = fragmentManager

            frManager!!.beginTransaction()
                .replace(
                    R.id.mainLayout,
                    FormFragment.newInstance(),
                    "ResultFragment"
                )
                .addToBackStack(null)
                .commit()
        }

        return inflate
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: Int, param2: Int, param3: Int) =
            ResultFragment().apply {
                arguments = Bundle().apply {
                    TOTAL_MEN = param1
                    TOTAL_WOMEN = param2
                    TOTAL_CHILDREN = param3
                }
            }
    }
}