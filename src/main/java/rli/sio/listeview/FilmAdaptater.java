package rli.sio.listeview;

import java.util.LinkedList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class FilmAdaptater extends ArrayAdapter<Film> {
    private final Context _context;
    private LinkedList<Film> _movies;

    public FilmAdaptater(Context context, int resource, LinkedList<Film> films) {
        super(context, resource, films);
        _context = context;
        _movies = films;
    }

    public FilmAdaptater(@NonNull Context context, int resource) {
        super(context, resource);
        _context = null;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.champsliste, parent, false);
        } else {
            convertView = (LinearLayout) convertView;
        }

        ImageView imageView = (ImageView) convertView.findViewById(R.id.cover);
        imageView.setBackgroundResource(_movies.get(position).getCover());

        TextView viewTitle = (TextView) convertView.findViewById(R.id.title);
        viewTitle.setText(_movies.get(position).getTitle());
        
        viewTitle.setTag(_movies.get(position).getTitle());

        return convertView;
    }
}