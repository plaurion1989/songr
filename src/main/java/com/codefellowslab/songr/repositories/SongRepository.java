package com.codefellowslab.songr.repositories;

import com.codefellowslab.songr.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long>
{
    public Song findByTitle(String title);
}
