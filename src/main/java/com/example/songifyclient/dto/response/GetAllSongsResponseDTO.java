package com.example.songifyclient.dto.response;

import java.util.Map;

public record GetAllSongsResponseDTO(Map<Integer, SongResponseDto> songs) {
}