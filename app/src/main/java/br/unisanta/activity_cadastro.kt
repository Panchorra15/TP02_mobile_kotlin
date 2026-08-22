package br.unisanta

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class activity_cadastro : AppCompatActivity(R.layout.activity_cadastro) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txtNome = findViewById<TextView>(R.id.txt_titulo)
        val txtDescricao = findViewById<TextView>(R.id.txt_descricao)
        val txtAutor = findViewById<TextView>(R.id.txt_autor)
        val txtEditora = findViewById<TextView>(R.id.txt_editora)

        val valueNome = intent.getStringExtra("nome_livro")
        val valueDescricao = intent.getStringExtra("descricao_livro")
        val valueAutor = intent.getStringExtra("autor_livro")
        val valueEditora = intent.getStringExtra("editora_livro")
        
        txtNome.setText("Título: $valueNome")
        txtDescricao.setText("Descrição: $valueDescricao")
        txtAutor.setText("Autor: $valueAutor")
        txtEditora.setText("Editora: $valueEditora")

        val btn_voltar = findViewById<Button>(R.id.btn_voltar)

        btn_voltar.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}