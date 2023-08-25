package com.example.songifyclient.dto;

import java.util.Map;

public record GetAllSongsResponseDTO(Map<Integer, SongResponseDto> songs) {
}