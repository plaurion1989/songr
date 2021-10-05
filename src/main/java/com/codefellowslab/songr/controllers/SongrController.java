package com.codefellowslab.songr.controllers;

import com.codefellowslab.songr.models.Album;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class SongrController
{
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
        Album firstAlbum = new Album("70's Rock", "Various", 12, 14, "unavailable");
        Album secondAlbum = new Album("80's Rock", "Various", 22, 40, "unavailable");
        Album thirdAlbum = new Album("90's Rock", "Various", 18, 31, "unavailable");
        ArrayList<Album> albums = new ArrayList<>();
        albums.add(firstAlbum);
        albums.add(secondAlbum);
        albums.add(thirdAlbum);
        album.addAttribute("albums", albums);
        return "songr/album";
    }
}
