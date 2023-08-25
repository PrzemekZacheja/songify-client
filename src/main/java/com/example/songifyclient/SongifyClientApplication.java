package com.example.songifyclient;

import com.example.songifyclient.dto.SongRequestDto;
import com.example.songifyclient.feign.SongFeignClient;
import feign.FeignException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableFeignClients
@Log4j2
@AllArgsConstructor
public class SongifyClientApplication {

    SongFeignClient songFeignClient;

    public static void main(String[] args) {
        SpringApplication.run(SongifyClientApplication.class, args);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void doSomethingAfterStartup() {
        try {
            log.info("Application started");
            log.info(songFeignClient.createSong(new SongRequestDto("111", "2")));
            log.info(songFeignClient.getSongs());
            log.info(songFeignClient.updateSong(new SongRequestDto("[ut", "put"), 1));
            log.info(songFeignClient.deleteSong(1));
        } catch (FeignException e) {
            log.error(e.getMessage());
            log.error(e.getClass());
        }
    }
}