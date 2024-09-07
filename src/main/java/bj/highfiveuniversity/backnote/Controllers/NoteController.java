package bj.highfiveuniversity.backnote.Controllers;
import bj.highfiveuniversity.Service.NoteService;
import bj.highfiveuniversity.backnote.Models.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    // Méthode pour obtenir toutes les notes - retourne une liste
    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes() {
        List<Note> notes = noteService.getAllNotes();
        return ResponseEntity.ok(notes);
    }

    // Méthode pour obtenir une note par ID - retourne un seul objet Note
    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
        Note note = noteService.getNoteById(id);
        if (note != null) {
            return ResponseEntity.ok(note);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Méthode pour créer une nouvelle note - retourne l'objet Note créé
    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        Note newNote = noteService.saveNote(note);
        return ResponseEntity.ok(newNote);
    }

    // Méthode pour mettre à jour une note existante - retourne l'objet Note mis à jour
    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNoteById(@PathVariable Long id, @RequestBody Note note) {
        Note existingNote = noteService.getNoteById(id);
        if (existingNote != null) {
            note.setId(id);
            Note updatedNote = noteService.saveNote(note);
            return ResponseEntity.ok(updatedNote);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Méthode pour supprimer une note par ID - retourne un message de confirmation
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNoteById(@PathVariable Long id) {
        noteService.deleteNoteById(id);
        return ResponseEntity.ok("Note with id " + id + " deleted successfully!");
    }

    // Méthode pour obtenir des notes par catégorie - retourne une liste de notes
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Note>> getNotesByCategory(@PathVariable String category) {
        List<Note> notes = noteService.getNotesByCategory(category);
        return ResponseEntity.ok(notes);
    }

    // Méthode pour rechercher des notes par titre ou contenu - retourne une liste de notes
    @GetMapping("/search")
    public ResponseEntity<List<Note>> searchNotes(@RequestParam String query) {
        List<Note> notes = noteService.searchNotes(query);
        return ResponseEntity.ok(notes);
    }
}
