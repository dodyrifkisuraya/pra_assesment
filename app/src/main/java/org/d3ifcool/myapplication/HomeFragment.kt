package org.d3ifcool.myapplication


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import org.d3ifcool.myapplication.databinding.ActivityMainBinding
import org.d3ifcool.myapplication.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        binding.btnPersegi.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment2_to_persegiFragment2)
        }

        binding.btnSegitiga.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment2_to_segitigaFragment)
        }

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.about, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.btnAbout -> findNavController().navigate(R.id.action_homeFragment2_to_aboutFragment)
        }
        return super.onOptionsItemSelected(item)
    }
}
