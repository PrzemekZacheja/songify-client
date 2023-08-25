package com.example.songifyclient.feign;

import com.example.songifyclient.dto.GetAllSongsResponseDTO;
import com.example.songifyclient.dto.SongRequestDto;
import com.example.songifyclient.dto.SongResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "songify")
public interface SongFeignClient {


    @GetMapping("/songs")
    GetAllSongsResponseDTO getSongs();

    @PostMapping("/songs")
    SongResponseDto createSong(@RequestBody SongRequestDto songRequestDto);

    @PutMapping("/songs")
    SongResponseDto updateSong(@RequestBody SongRequestDto songRequestDto,
                               @RequestParam Integer id);

    @DeleteMapping("/songs/{id}")
    SongResponseDto deleteSong(@PathVariable Integer id);

}