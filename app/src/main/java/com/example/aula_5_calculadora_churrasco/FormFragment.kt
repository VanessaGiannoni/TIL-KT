package com.example.aula_5_calculadora_churrasco

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar

class FormFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inflate = inflater.inflate(R.layout.fragment_form, container, false);
        val btnResult = inflate.findViewById<Button>(R.id.btnResult)

        btnResult.setOnClickListener {
            if ((inflate.findViewById<EditText>(R.id.txtTotalMen)).text.isEmpty()) {
                Snackbar.make(
                    requireView(), "Informe o total de homens!",
                    Snackbar.LENGTH_LONG
                ).setAction("Action", null).show()

                return@setOnClickListener
            }

            if ((inflate.findViewById<EditText>(R.id.txtTotalWomen)).text.isEmpty()) {
                Snackbar.make(
                    requireView(), "Informe o total de mulheres!",
                    Snackbar.LENGTH_LONG
                ).setAction("Action", null).show()

                return@setOnClickListener
            }

            if ((inflate.findViewById<EditText>(R.id.txtTotalChildren)).text.isEmpty()) {
                Snackbar.make(
                    requireView(), "Informe o total de crianças!",
                    Snackbar.LENGTH_LONG
                ).setAction("Action", null).show()

                return@setOnClickListener
            }

            val totalMen = inflate.findViewById<EditText>(R.id.txtTotalMen).text.toString().toInt()
            val totalWomen = inflate.findViewById<EditText>(R.id.txtTotalWomen).text.toString().toInt()
            val totalChildren = inflate.findViewById<EditText>(R.id.txtTotalChildren).text.toString().toInt()

            val frManager = fragmentManager

            frManager!!.beginTransaction()
                .replace(R.id.mainLayout, ResultFragment.newInstance(
                    totalMen,
                    totalWomen,
                    totalChildren,
                ),"ResultadoFragment").addToBackStack(null).commit()
        }

        return inflate
    }

    companion object {
        @JvmStatic
        fun newInstance() = FormFragment().apply { }
    }
}