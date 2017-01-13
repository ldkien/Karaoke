package dk.karaoke;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kienm on 11/1/2017.
 */

public class SQLDataSource {

    private SQLiteDatabase db;
    private DatabaseHelper databaseHelper;


    public SQLiteDatabase createDatabase(Context context) throws SQLException{
        db=DatabaseHelper.initDatabase(context);
        return db;
    }

    public List<Song> getListSongDetails(){
        List<Song> listSong = new ArrayList<Song>();
        String[] column={"_id","song_name","song_lyric"};

        Cursor cursor = db.query("song",column,null,null,null,null,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Song song = new Song();
            song.setSongId(cursor.getString(0));
            song.setSongName(cursor.getString(1));
            song.setSongLyric(cursor.getString(2));
            listSong.add(song);

            cursor.moveToNext();
        }
        Log.d("ket qua:", listSong.get(0).getSongName());

        return listSong;
    }

    public List<Song> getListSongByName(String name){
        List<Song> listSong = new ArrayList<Song>();
        String sql = "select _id, song_name, song_lyric from Song where song_name like '%"+name+"%'";

        Cursor cursor = db.rawQuery(sql,null);
        while (cursor.moveToNext()){
            Song song = new Song();
            song.setSongId(cursor.getString(0));
            song.setSongName(cursor.getString(1));
            song.setSongLyric(cursor.getString(2));
            listSong.add(song);
        }

        return listSong;
    }

}
