package rli.sio.listeview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.LinkedList;
import rli.sio.listeview.Film;


public class MainActivity extends AppCompatActivity {
    private Button quitter = null;
    LinkedList<Film> films = new LinkedList<Film>();
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            Film f1 = new Film("Independence day", R.drawable.independence_day);

            films.add(f1);
            films.add(new Film("The fifth element", R.drawable.the_fifth_element));
            films.add(new Film("The last samurai", R.drawable.the_last_samurai));

            FilmAdaptater adapter = new FilmAdaptater(getApplicationContext(), R.layout.champsliste, films);

            ListView list_films = (ListView) findViewById(R.id.liste_films);

            list_films.setAdapter(adapter);

            list_films.setOnItemClickListener(listview_listerner);
            this.quitter = (Button) findViewById(R.id.quitter);
            this.quitter.setOnClickListener(quitterListener);
        }

         AdapterView.OnItemClickListener listview_listerner = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                View titleView = view.findViewById(R.id.title);
                String title = (String) titleView.getTag();
                Toast.makeText(getApplicationContext(), title, Toast.LENGTH_SHORT).show();
            }
        };

    private View.OnClickListener quitterListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            System.exit(0);
        }
    };
    }
