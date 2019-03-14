package org.fedster.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner{

    @Autowired
    TodoRepository repository;

    @Override
    public void run(String... strings) throws Exception {
        Todo todo = new Todo("Email team for updates.", "Don't forget to do this before sunset." );
        repository.save(todo);
        todo = new Todo("Create meeting agenda.", "Create meeting agenda to design the next electric race car." );
        repository.save(todo);
        todo = new Todo("Contact service center.", "Make sure the parts are ordered before midnight." );
        repository.save(todo);
        todo = new Todo("Update project plan.", "Update project plan to include the new turbo engine." );
        repository.save(todo);
    }
}
