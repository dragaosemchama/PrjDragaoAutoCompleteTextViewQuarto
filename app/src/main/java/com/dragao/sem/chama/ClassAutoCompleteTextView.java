// Dragão sem Chama: http://dragaosemchama.com.br/2016/10/android-autocompletetextview/
//Código: Quarto Exemplo do componente AutoCompleteTextView
//Autor: Márcio Albuquerque
//Email: o.marcio.albu@gmail.com
//Data: Junho/2016
package com.dragao.sem.chama;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;

import java.util.HashMap;

public class ClassAutoCompleteTextView extends AutoCompleteTextView {

    public ClassAutoCompleteTextView(Context context, AttributeSet attrs) {
       super(context, attrs);
   }
    //Retorna o nome do mês correspondente ao item selecionado
    protected CharSequence convertSelectionToString(Object selectedItem) {
        // Cada item na lista de sugestões AutoCompleteTextView é um hashmap objeto.
        HashMap<String, String> hm = (HashMap<String, String>) selectedItem;
        return hm.get("mestxt");
    }
}
