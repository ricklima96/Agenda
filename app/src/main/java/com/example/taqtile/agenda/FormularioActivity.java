package com.example.taqtile.agenda;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.taqtile.agenda.dao.AlunoDAO;
import com.example.taqtile.agenda.modelo.Aluno;

public class FormularioActivity extends AppCompatActivity {

    private FormularioHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        helper = new FormularioHelper(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Infla o xml da opcão de salvar um aluno no menu superior
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_formulario, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Caso o item do menu de salvar o aluno seja pressionado, cria um aluno, um dao, e insere no banco.
        switch (item.getItemId()) {
            case R.id.menu_formulario_ok:
                Aluno aluno = helper.pegaAluno();
                AlunoDAO alunoDAO = new AlunoDAO(this);
                alunoDAO.insere(aluno);
                alunoDAO.close();
                Toast.makeText(FormularioActivity.this, "Aluno " + aluno.getNome() + " salvo!", Toast.LENGTH_SHORT).show();
                //Mata a activity atual e volta para a lista
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);

    }


}