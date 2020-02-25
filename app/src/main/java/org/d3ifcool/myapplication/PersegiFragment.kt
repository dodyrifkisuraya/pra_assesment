package org.d3ifcool.myapplication


import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.fragment_persegi.*
import org.d3ifcool.myapplication.databinding.FragmentPersegiBinding


private const val LUAS = "key_luas"
private const val KLL = "key_kll"

class PersegiFragment : Fragment() {

    private lateinit var binding : FragmentPersegiBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_persegi, container, false)

        if (savedInstanceState != null){
            Log.d("instance","masuk")
                binding.tvHasil.text =
                        "Luas = "+savedInstanceState.getInt(LUAS)+"\n"+
                        "Keliling = "+savedInstanceState.getInt(KLL)
        }

        binding.btnHitung.setOnClickListener {
            binding.tvHasil.text =
                    "Luas = "+hitungLuas()+"\n"+
                    "Keliling = "+hitungKll()
        }

        binding.btnShare.setOnClickListener {
            startActivity(Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Persegi dengan panjang = "+ binding.etAlas.text+ ", Lebar = "+binding.etTinggi.text+ " memiliki \n"+
                        "Luas = "+hitungLuas()+"\n"+
                        "Keliling = "+hitungKll())
                type = "text/plain"
            })
        }


        return binding.root
    }

    private fun hitungLuas() : Int{
        return binding.etAlas.text.toString().toInt() * binding.etTinggi.text.toString().toInt()
    }

    private fun hitungKll() : Int {
        return (binding.etAlas.text.toString().toInt() + binding.etTinggi.text.toString().toInt()) * 2
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(LUAS, hitungLuas())
        outState.putInt(KLL, hitungKll())
        super.onSaveInstanceState(outState)
    }
}
