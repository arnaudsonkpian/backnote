package bj.highfiveuniversity.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bj.highfiveuniversity.backnote.Models.Note;
import bj.highfiveuniversity.backnote.Repository.NoteRepository;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Note getNoteById(Long id) {
        return noteRepository.findById(id).orElse(null);
    }

    public Note saveNote(Note note) {
        return noteRepository.save(note);
    }

    public void deleteNoteById(Long id) {
        noteRepository.deleteById(id);
    }

    public List<Note> getNotesByCategory(String category) {
        return noteRepository.findByCategory_Name(category);
    }

    public List<Note> searchNotes(String query) {
        return noteRepository.findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(query, query);
    }
}



