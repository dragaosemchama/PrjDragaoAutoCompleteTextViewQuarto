// Dragão sem Chama: http://dragaosemchama.com.br/2016/07/android-autocompletetextview/
//Código: Quarto Exemplo do componente AutoCompleteTextView
//Autor: Márcio Albuquerque
//Email: o.marcio.albu@gmail.com
//Data: Junho/2016
package com.dragao.sem.chama;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Vetor de inteiros de onde estão localizadas as imagens
    int[] imagensMes = new int[]{
           R.drawable.janeiro,
           R.drawable.fevereiro,
           R.drawable.marco,
           R.drawable.abril,
           R.drawable.maio,
           R.drawable.junho,
           R.drawable.julho,
           R.drawable.janeiro,
           R.drawable.agosto,
           R.drawable.setembro,
           R.drawable.novembro,
           R.drawable.dezembro,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Nomes do Hashmap
        String[] objAqui = { "imagensMes", "mestxt"};

        // Ids da views de autocomplete_layout.xml
        int[] objPara = { R.id.imaViewMes,R.id.mesTexto};

        //Colocar o ícone (ic_launcher) na action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.ic_launcher);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Criação de um vetor com todos os meses do ano,
        // usando os valores contido no arquivo strings.xml.
        String[] MesesVetor = getResources().getStringArray(R.array.MesesLista);

        // Cria uma variável lista para armazenar, o mês e sua imagem
        List<HashMap<String,String>> armListMesIma =
                new ArrayList<HashMap<String,String>>();

        // Função para colocar em uma lista a associação da imagem com texto
        for(int i=0;i<imagensMes.length;i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("mestxt", MesesVetor[i]);
            hm.put("imagensMes", Integer.toString(imagensMes[i]) );
            armListMesIma.add(hm);
        }

        //  Criando um adapter para armazenar cada um dos itens
        SimpleAdapter adapter =
                new SimpleAdapter(getBaseContext(), armListMesIma,
                        R.layout.autocomplete_layout, objAqui, objPara);

        //Obter uma referência para AutoCompleteTextView
        // personalizada do activity_main.xml arquivo de layout
        ClassAutoCompleteTextView acObjText =
                (ClassAutoCompleteTextView) findViewById(R.id.acTexto);

        //Definição do evento de click lista do autocompletetextview
        AdapterView.OnItemClickListener itemClickListener
                = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick
                    (AdapterView<?> arg0, View arg1, int position, long id) {

                // Cada item no adapter é um objeto HashMap.
                // Essa instrução cria o objeto hashmap atualmente clicado
                HashMap<String,String> hm =
                        (HashMap<String,String>)arg0.getAdapter().getItem(position);

               // Obtendo uma referência para o TextView
                // da activity_main arquivo de layout.
                TextView viewSelMes = (TextView) findViewById(R.id.seleMes) ;

                // Obtendo o mês da HashMap e definir em um o TextView.
                viewSelMes.setText("Mês selecionado: " + hm.get("mestxt"));
            }
        };

        acObjText.setOnItemClickListener(itemClickListener);

        // Definir o adapter em uma lista.
        acObjText.setAdapter(adapter);
    }
}// Fim da classe MainActivity
