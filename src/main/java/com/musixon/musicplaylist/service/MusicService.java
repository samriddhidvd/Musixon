package com.musixon.musicplaylist.service;
import com.musixon.musicplaylist.exception.UserNotFoundException;
import com.musixon.musicplaylist.model.Music;
import com.musixon.musicplaylist.repo.MusicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service

public class MusicService {
    private final MusicRepo musicRepo;
    @Autowired
    public MusicService(MusicRepo musicRepo) {
        this.musicRepo = musicRepo;
    }
    public Music addMusic(Music music){
        music.setMusicCode(UUID.randomUUID().toString());
        return musicRepo.save(music);
    }
    public List<Music> findAllMusics(){
        return musicRepo.findAll();
    }
    public Music updateMusic(Music music) {
        return musicRepo.save(music);
    }
    public Music findMusicById(Long id){
        return musicRepo.findMusicById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id"+id+"was not found"));
    }
    public void deleteMusic(Long id){
        musicRepo.deleteMusicById(id);
    }
}
