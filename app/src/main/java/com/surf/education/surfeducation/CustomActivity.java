package com.surf.education.surfeducation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.LinkedList;

public class CustomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        ListView tasks = (ListView) findViewById(R.id.tasks);

        LinkedList<String> numbers = new LinkedList(); //TODO: move to list
        numbers.add("1");
        numbers.add("2");
        numbers.add("3");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, numbers);
        tasks.setAdapter(adapter);

        adapter.add("4");
        adapter.notifyDataSetChanged();

        //TODO: adapter.setOnClickListener

    }
}

/*
AdapterView - ListView, GridView, Spinner(dropdown), Gallery(стар и не нужен)

Для связи с данными используется Adapter-class
new ArreyAdapter(Context context, int resId...

listView.setAdapter(adapter)
R.layout. - стандартный для


Страна с флагом - пример с getView

notifyDataSetChanged() - использовать для обновления списков, если что-то поменялось
*/

/*
GridViev -
AUTO_FIT - задает число столбцов исходя из его ширины


SpinnerView
getDropDownView - getView, но для случая, когда список отрисован
 */