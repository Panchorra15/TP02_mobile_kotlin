package br.unisanta

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtNomeLivro = findViewById<EditText>(R.id.edt_nome)
        val edtDescricaoLivro = findViewById<EditText>(R.id.edt_descricao)
        val edtAutorLivro = findViewById<EditText>(R.id.edt_autor)
        val edtEditoraLivro = findViewById<EditText>(R.id.edt_editora)

        val btn_cadastrar_livro = findViewById<Button>(R.id.btn_cadastrar_llivro)

        btn_cadastrar_livro.setOnClickListener{

            val intent = Intent(this, activity_cadastro::class.java)
            intent.putExtra("nome_livro", edtNomeLivro.text.toString())
            intent.putExtra("descricao_livro", edtDescricaoLivro.text.toString())
            intent.putExtra("autor_livro", edtAutorLivro.text.toString())
            intent.putExtra("editora_livro", edtEditoraLivro.text.toString())
            startActivity(intent)

            edtNomeLivro.text.clear()
            edtDescricaoLivro.text.clear()
            edtAutorLivro.text.clear()
            edtEditoraLivro.text.clear()

        }
    }
}