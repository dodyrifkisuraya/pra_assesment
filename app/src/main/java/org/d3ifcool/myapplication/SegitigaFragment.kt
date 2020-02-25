package org.d3ifcool.myapplication


import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import org.d3ifcool.myapplication.databinding.FragmentSegitigaBinding
import java.lang.Math.pow
import java.text.DecimalFormat
import kotlin.math.pow
import kotlin.math.sqrt

private const val LUAS = "key_luas"
private const val KLL = "key_kll"

class SegitigaFragment : Fragment() {

    private lateinit var binding : FragmentSegitigaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_segitiga, container, false)

        if (savedInstanceState != null){
            binding.tvHasil.text =
                "Luas = "+savedInstanceState.getInt(LUAS)+"\n"+
                        "Keliling = "+savedInstanceState.getInt(KLL)
        }

        binding.btnHitung.setOnClickListener {
            binding.tvHasil.text = "Luas = "+hitungLuas()+"\n"+"Keliling = " + hitungKll()

        }

        binding.btnShare.setOnClickListener {
            startActivity(Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(
                    Intent.EXTRA_TEXT, "Segitiga dengan alas = "+ binding.etAlas.text+ ", Tinggi = "+binding.etTinggi.text+ " memiliki \n"+
                            "Luas = "+hitungLuas()+"\n"+
                            "Keliling = "+hitungKll())
                type = "text/plain"
            })
        }

        return binding.root
    }

    private fun hitungLuas() : Int{
        return (binding.etAlas.text.toString().toInt() * binding.etTinggi.text.toString().toInt() ) / 2
    }

    private fun hitungKll() : Int{
        val sisiMiring = sqrt(binding.etAlas.text.toString().toDouble().pow(2) + binding.etTinggi.text.toString().toDouble().pow(2))
        val hasil = binding.etAlas.text.toString().toInt() + binding.etTinggi.text.toString().toInt() + sisiMiring.toString().toDouble().toInt()

        return hasil
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(LUAS, hitungLuas())
        outState.putInt(KLL, hitungKll())
        super.onSaveInstanceState(outState)
    }


}
