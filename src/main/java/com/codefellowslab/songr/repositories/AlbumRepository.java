package com.codefellowslab.songr.repositories;

import com.codefellowslab.songr.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long>
{
    public Album findByTitle(String title);
}
