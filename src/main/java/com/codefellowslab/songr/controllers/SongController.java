package com.codefellowslab.songr.controllers;

import com.codefellowslab.songr.models.Album;
import com.codefellowslab.songr.models.Song;
import com.codefellowslab.songr.repositories.AlbumRepository;
import com.codefellowslab.songr.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SongController
{
    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    SongRepository songRepository;

    @PostMapping("/add-song")
    RedirectView addSongToAlbum(String songTitle, int songLength, int songTrackNumber, String albumTitle)
    {
        Album album = albumRepository.findByTitle(albumTitle);
        Song newSong = new Song(songTitle, songLength, songTrackNumber, album);
        songRepository.save(newSong);

        return new RedirectView("/album");
    }

}
