package com.codefellowslab.songr.controllers;

import com.codefellowslab.songr.models.Album;
import com.codefellowslab.songr.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SongrController
{
    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/")
    public String splashPage(Model m)
    {
        m.addAttribute("title", "Songr Java Application");
        m.addAttribute("description", "My web page is designed to ROCK your Socks off!");
        m.addAttribute("baseImage", "images/rock-gesture.jpeg");
        return "songr/album";
    }
    @GetMapping("/albums")
    public String getAlbums(Model album) {
        Album firstAlbum = new Album("70's Rock", "Various", 12, 14, "images/rock-gesture.jpeg");
        Album secondAlbum = new Album("80's Rock", "Various", 22, 40, "images/rock-gesture.jpeg");
        Album thirdAlbum = new Album("90's Rock", "Various", 18, 31, "images/rock-gesture.jpeg");
        ArrayList<Album> albums = new ArrayList<>();
        albums.add(firstAlbum);
        albums.add(secondAlbum);
        albums.add(thirdAlbum);


        albumRepository.saveAll(albums);
        List<Album> dbAlbums = albumRepository.findAll();
        album.addAttribute("albums", albums);

        Album albumOne = albumRepository.findByTitle("70's Rock");

        return "songr/album";
    }
    @PostMapping
    public RedirectView createAlbum(String title, String artist, int songCount, int length, String imageUrl)
    {
        Album newAlbum = new Album(title, artist, songCount, length, imageUrl);
        albumRepository.save(newAlbum);
            return new RedirectView("songr/album");
    }

    @DeleteMapping("/delete")
    public RedirectView deleteAlbum(String title)
    {
            Album albumToDelete = albumRepository.findByTitle(title);
            albumRepository.delete(albumToDelete);
            return new RedirectView("songr/album");
    }
}
