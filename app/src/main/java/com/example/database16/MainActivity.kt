package com.example.database16

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.io.InputStream

class MainActivity : AppCompatActivity() {
     lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sbtn = findViewById<Button>(R.id.btnSignUp)
        val etName = findViewById<TextInputEditText>(R.id.etName)
        val etMail = findViewById<TextInputEditText>(R.id.etMail)
        val pass   = findViewById<TextInputEditText>(R.id.etPass)

        sbtn.setOnClickListener {
            val name = etName.text.toString()
            val mail = etMail.text.toString()
            val pass =  pass.text.toString()

            val user = Users(name , mail , pass)
            database = FirebaseDatabase.getInstance().getReference("Users")
            database.child(name).setValue(user).addOnSuccessListener {
                Toast.makeText( this,"userResgiterd", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener(){
                Toast.makeText( this,"failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}