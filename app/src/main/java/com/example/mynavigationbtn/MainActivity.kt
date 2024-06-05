package com.example.mynavigationbtn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mynavigationbtn.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var arrayList: ArrayList<dataClass>
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerLayout: DrawerLayout
    lateinit var imghinh: kotlin.Array<Int>
    lateinit var txtname: kotlin.Array<String>
    lateinit var txtage: kotlin.Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter()
        navigatinon()
        btnNav()
    }

    private fun adapter() {
        recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        imghinh = arrayOf(
            R.drawable.xie10,
            R.drawable.xie11,
            R.drawable.xie12,
            R.drawable.xie13,
            R.drawable.xie14,
            R.drawable.xie15,
            R.drawable.xie16,
            R.drawable.xie17,
            R.drawable.xie18,
            R.drawable.xie19,
        )

        txtname = arrayOf(
            "Hinh Xie 10",
            "Hinh Xie 11",
            "Hinh Xie 12",
            "Hinh Xie 13",
            "Hinh Xie 14",
            "Hinh Xie 15",
            "Hinh Xie 16",
            "Hinh Xie 17",
            "Hinh Xie 18",
            "Hinh Xie 19",
        )

        txtage = arrayOf(
            "19 tuoi",
            "23 tuoi",
            "24 tuoi",
            "20 tuoi",
            "13 tuoi",
            "30 tuoi",
            "29 tuoi",
            "17 tuoi",
            "27 tuoi",
            "30 tuoi",
        )


        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        arrayList = arrayListOf<dataClass>()

        listdata()
    }

    private fun listdata(){

        for(i in imghinh.indices){
            val addData = dataClass(imghinh[i], txtname[i], txtage[i])
            arrayList.add(addData)
        }
        recyclerView.adapter = dataAdapter(arrayList)


    }


    private fun btnNav() {
        bottomNavigationView = findViewById<BottomNavigationView>(R.id.btnNavigation)
        bottomNavigationView.setOnItemSelectedListener {item ->
            when(item.itemId){
                R.id.ic_home ->{
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.ic_move ->{
                    openFragment(MoveFragment())
                    true
                }
                R.id.ic_message ->{
                    openFragment(Fragment3())
                    true
                }
                R.id.ic_peson ->{
                    openFragment(Fragment4())
                    true
                }
                R.id.ic_add ->{
                    Toast.makeText(this, "ADD thanh cong", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }

        }
    }

    private fun openFragment(fragment: Fragment){
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment, fragment)
        fragmentTransaction.commit()
    }


    private fun navigatinon() {
        binding.navigation.itemIconTintList = null

        drawerLayout = findViewById<DrawerLayout>(R.id.drawer)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val togle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name)
        drawerLayout.addDrawerListener(togle)
        togle.syncState()


    }
}