package com.musixon.musicplaylist.repo;

import com.musixon.musicplaylist.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MusicRepo extends JpaRepository<Music, Long> {
    void deleteMusicById(Long id);

    Optional<Music> findMusicById(Long id);
}
