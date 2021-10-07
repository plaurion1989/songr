package com.codefellowslab.songr.models;

import javax.persistence.*;

@Entity
public class Song
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String title;
    int trackNumber;
    int length;
    @ManyToOne Album myAlbum;


    protected Song()
    {

    }

    public Song(String title, int length, int trackNumber, Album album ) {
        this.title = title;
        this.length = length;
        this.trackNumber = trackNumber;
        myAlbum = album;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Album getMyAlbum() {
        return myAlbum;
    }

    public void setMyAlbum(Album myAlbum) {
        this.myAlbum = myAlbum;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
