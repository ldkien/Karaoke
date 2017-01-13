package dk.karaoke;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by kienm on 11/1/2017.
 */

public class DatabaseHelper {

    final static String DATABASE_NAME = "SongDB";

    public static SQLiteDatabase initDatabase(Context context) {
        try {
            String outFileName = context.getApplicationInfo().dataDir + "/databases/" + DATABASE_NAME;
            File f = new File(outFileName);
            if (!f.exists()) {
                InputStream is = context.getAssets().open(DATABASE_NAME);
                File folder = new File(context.getApplicationInfo().dataDir + "/databases/");
                if (!folder.exists()) {
                    folder.mkdir();
                }
                FileOutputStream myOutput = new FileOutputStream(outFileName);
                byte[] buffer = new byte[1024];

                int length;
                while ((length = is.read(buffer)) > 0) {
                    myOutput.write(buffer, 0, length);
                }

                myOutput.flush();
                myOutput.close();
                is.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return context.openOrCreateDatabase(DATABASE_NAME, Context.MODE_PRIVATE, null);
    }
}
