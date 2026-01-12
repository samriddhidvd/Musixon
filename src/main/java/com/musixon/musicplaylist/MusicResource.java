package com.musixon.musicplaylist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.musixon.musicplaylist.model.Music;
import com.musixon.musicplaylist.service.MusicService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/music")
public class MusicResource {
    @Autowired
    private final MusicService musicService;

    public MusicResource(MusicService musicService) {
        this.musicService = musicService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Music>> getallMusics(){
        List<Music> musics = musicService.findAllMusics();
        return new ResponseEntity<>(musics, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Music> getMusicById(@PathVariable("id")Long id) throws Throwable {
        Music music = musicService.findMusicById(id);
        return new ResponseEntity<>(music, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Music> addMusic(@RequestBody Music music){
        Music newMusic = musicService.addMusic(music);
        return new ResponseEntity<>(newMusic, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Music> updateMusic(@RequestBody Music music){
        Music updateMusic = musicService.updateMusic(music);
        return new ResponseEntity<>(updateMusic, HttpStatus.OK);
    }

    @DeleteMapping("/delete{id}")
    public ResponseEntity<?> deleteMusic(@PathVariable("id")Long id){
        musicService.deleteMusic(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
