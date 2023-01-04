package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class LogService {
    public List<String> readLogs(int page, int size) {
        List<String> logs = new ArrayList<>();
        // odczytanie logów z pliku lub bazy danych
        try {
            // pobranie logów z danej strony i o danej wielkości
            int start = (page - 1) * size;
            int end = start + size;
            List<String> allLogs = readAllLogs();
            if (start < allLogs.size()) {
                logs = allLogs.subList(start, Math.min(end, allLogs.size()));
            }
        } catch (IOException e) {
            log.error("Error while reading logs", e);
        }
        return logs;
    }

    private List<String> readAllLogs() throws IOException {
        List<String> logs = new ArrayList<>();
        // odczytanie wszystkich logów z pliku lub bazy danych
        return logs;
    }
}