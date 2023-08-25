package com.example.songifyclient.client;

import com.example.songifyclient.dto.request.SongPatchRequestDto;
import com.example.songifyclient.dto.request.SongPostRequestDto;
import com.example.songifyclient.dto.request.SongPutRequestDto;
import com.example.songifyclient.dto.response.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "songify")
@Component
public interface SongFeignClient {


    @GetMapping("/songs")
    GetAllSongsResponseDTO getSongs();

    @PostMapping("/songs")
    SongPostResponseDto createSong(@RequestBody SongPostRequestDto songRequestDto);

    @PutMapping("/songs")
    SongPutResponseDto updateSong(@RequestBody SongPutRequestDto songRequestDto,
                                  @RequestParam Integer id);

    @DeleteMapping("/songs/{id}")
    SongDeleteResponseDto deleteSong(@PathVariable Integer id);

    @PatchMapping("/songs{id}")
    SongPatchResponseDto patchSongs(@PathVariable Integer id,
                                    @RequestBody SongPatchRequestDto songRequestDto);
}