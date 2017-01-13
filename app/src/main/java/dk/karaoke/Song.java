package dk.karaoke;

/**
 * Created by kienm on 11/1/2017.
 */

public class Song {
    private String songId;
    private String songName;
    private String songName2;
    private String songLyric;
    private String songLyric2;
    private String mArtist;

    public String getmArtist() {
        return mArtist;
    }

    public void setmArtist(String mArtist) {
        this.mArtist = mArtist;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSongLyric2() {
        return songLyric2;
    }

    public void setSongLyric2(String songLyric2) {
        this.songLyric2 = songLyric2;
    }

    public String getSongLyric() {
        return songLyric;
    }

    public void setSongLyric(String songLyric) {
        this.songLyric = songLyric;
    }

    public String getSongName2() {
        return songName2;
    }

    public void setSongName2(String songName2) {
        this.songName2 = songName2;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    private String mArtist2;

    public String getmArtist2() {
        return mArtist2;
    }

    public void setmArtist2(String mArtist2) {
        this.mArtist2 = mArtist2;
    }
}
