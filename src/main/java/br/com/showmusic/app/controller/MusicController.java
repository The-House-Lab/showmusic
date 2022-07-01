package br.com.showmusic.app.controller;

import br.com.showmusic.app.model.Music;
import br.com.showmusic.app.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "music")
public class MusicController {

    @Autowired
    MusicRepository musicRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Music>> getAll(){
        return ResponseEntity.ok(musicRepository.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<Music> post (@RequestBody Music music){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(musicRepository.save(music));
    }
}
