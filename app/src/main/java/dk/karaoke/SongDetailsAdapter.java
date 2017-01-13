package dk.karaoke;


import android.content.Context;
import android.content.pm.LabeledIntent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kienm on 11/1/2017.
 */

public class SongDetailsAdapter extends ArrayAdapter<Song> {
    private Context mContext;
    private int mResource;
    private List<Song> mObjects;

    public SongDetailsAdapter(Context context, int resource, List<Song> objects) {
        super(context, resource, objects);

        mContext = context;
        mResource = resource;
        mObjects = objects;
    }

    private int getLocation(String chuoi,String key){
        int viTri = 0;
        viTri = chuoi.indexOf(key);
        return viTri;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.custom_layout_listview_song_details, parent, false);
            viewHolder.tvSongId = (TextView) convertView.findViewById(R.id.tv_song_id);
            viewHolder.tvSongName = (TextView) convertView.findViewById(R.id.tv_song_name);
            viewHolder.tvSongLyric = (TextView) convertView.findViewById(R.id.tv_song_lyric);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Song song = mObjects.get(position);
        viewHolder.tvSongId.setText(song.getSongId());
        viewHolder.tvSongLyric.setText(song.getSongName());


        if(MainActivity.keySearch!=null){
            SpannableString spannable = new SpannableString(song.getSongName());
            spannable.setSpan(new BackgroundColorSpan(Color.RED),getLocation(song.getSongName(),MainActivity.keySearch),getLocation(song.getSongName(),MainActivity.keySearch)+MainActivity.keySearch.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            viewHolder.tvSongName.setText(spannable);
        }
        else {
            viewHolder.tvSongName.setText(song.getSongName());
        }


        return convertView;
    }

    public class ViewHolder {
        private TextView tvSongId;
        private TextView tvSongName;
        private TextView tvSongLyric;
    }
}
