package com.lama.roadmap.controller;

import com.lama.roadmap.dto.PerformanceNoteRequest;
import com.lama.roadmap.model.PerformanceNote;
import com.lama.roadmap.service.PerformanceNoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class PerformanceNoteController {

    private final PerformanceNoteService noteService;

    public PerformanceNoteController(PerformanceNoteService noteService) {
        this.noteService = noteService;
    }

    // ADD NOTE
    @PostMapping
    public PerformanceNote addNote(@RequestBody PerformanceNoteRequest request) {
        return noteService.addNote(request);
    }

    // GET NOTES
    @GetMapping("/{assignmentId}")
    public List<PerformanceNote> getNotes(@PathVariable Long assignmentId) {
        return noteService.getNotes(assignmentId);
    }
}