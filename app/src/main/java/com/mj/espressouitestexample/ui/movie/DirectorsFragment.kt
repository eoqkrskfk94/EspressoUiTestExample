package com.mj.espressouitestexample.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mj.espressouitestexample.databinding.FragmentDirectorsBinding

class DirectorsFragment : Fragment(){

    private val directors: ArrayList<String> = ArrayList()
    private lateinit var binding: FragmentDirectorsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { args ->
            directors.addAll(args.get("args_directors") as List<String>)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDirectorsBinding.inflate(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setDirectors()
    }

    private fun setDirectors(){
        binding.directorsText.text = stringBuilderForDirectors(directors)
    }

    companion object{
        fun stringBuilderForDirectors(directors: ArrayList<String>): String{
            val sb = StringBuilder()
            for(director in directors){
                sb.append(director + "\n")
            }
            return sb.toString()
        }
    }
}

















