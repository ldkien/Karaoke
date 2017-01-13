package dk.karaoke;

import android.app.SearchManager;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private SQLDataSource db;

    private List<Song> listSong;
    private ListView lvSongInfo;
    public static String keySearch="";

    private SongDetailsAdapter songDetailsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();

        db = new SQLDataSource();
        db.createDatabase(getApplicationContext());
        listSong=db.getListSongDetails();

        songDetailsAdapter = new SongDetailsAdapter(this,R.layout.custom_layout_listview_song_details,listSong);
        lvSongInfo.setAdapter(songDetailsAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setOnQueryTextListener(this);
        return true;
    }

    public void initWidget(){
        lvSongInfo= (ListView) findViewById(R.id.lv_song_info);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        listSong=db.getListSongByName(newText);
        songDetailsAdapter = new SongDetailsAdapter(this,R.layout.custom_layout_listview_song_details,listSong);
        lvSongInfo.setAdapter(songDetailsAdapter);
        songDetailsAdapter.notifyDataSetChanged();
        keySearch=newText;
        return true;
    }
}
