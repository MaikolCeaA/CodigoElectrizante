package com.example.codigoelectrizante

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.codigoelectrizante.databinding.ActivityMainBinding
import com.example.codigoelectrizante.vistas.HomeFragment
import com.example.codigoelectrizante.vistas.IngresarFragment
import com.example.codigoelectrizante.vistas.InventarioFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //por defecto cargara un fragment
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, HomeFragment()).commit()

        }


        binding.bottomNavigation.setOnItemSelectedListener{
            when (it.itemId) {
                R.id.nav_inicio -> {
                    // indicarnos que hacer ->mostrar el fragmen de home
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, HomeFragment()).commit()
                    true
                }

                R.id.nav_cuenta -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, IngresarFragment()).commit()
                    // Respond to navigation item 1 click
                    true
                }

                R.id.nav_inventario -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, InventarioFragment()).commit()
                    // Respond to navigation item 1 click
                    true
                }
                else -> false
            }
        }
        binding.bottomNavigation.setOnItemReselectedListener {
            when (it.itemId) {
                    R.id.nav_inicio -> Toast.makeText(this, "Ya estas en la vista Inicio", Toast.LENGTH_SHORT).show()
                    R.id.nav_cuenta -> Toast.makeText(this, "Ya estas en la vista Cuenta", Toast.LENGTH_SHORT).show()
                    R.id.nav_inventario -> Toast.makeText(this, "Ya estas en la vista Inventario", Toast.LENGTH_SHORT).show()
                    else -> false
            }
        }
    }
}
