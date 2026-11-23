
package com.mojalu75.livedata.View

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.mojalu75.livedata.ViewModel.AforoViewModel
import com.mojalu75.livedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val aforoModel: AforoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textViewNum.textSize = 48f

        aforoModel.aforo.observe(this) { model ->
            val complet = aforoModel.esComplet()

            binding.textViewNum.text = model.aforo.toString()
            binding.textViewAforament.text =
                if (complet) "Aforament complet!" else "Disponible"
            binding.textViewAforament.setTextColor(
                resources.getColor(
                    if (complet) com.mojalu75.livedata.R.color.aforo_complet
                    else com.mojalu75.livedata.R.color.aforo_ok,
                    theme
                )
            )
        }

        binding.floatingActionButtonMas.setOnClickListener { aforoModel.sumar() }
        binding.floatingActionButtonMenos.setOnClickListener { aforoModel.restar() }
        binding.floatingActionButtonReset.setOnClickListener { aforoModel.reiniciar() }
    }
}
