package org.fedster.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class TodoController {

    @Autowired
    TodoRepository todoRepository;

    @RequestMapping("/")
    public String listTodos(Model model) {
        model.addAttribute("todos", todoRepository.findAll());
        return "todolist";
    }

    @GetMapping("/addtodo")
    public String todoForm(Model model) {
        model.addAttribute("todo", new Todo());
        return "todoform";
    }

    @PostMapping("/processtodo")
    public String processForm(@Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todoform";
        }
        todoRepository.save(todo);
        return ("redirect:/");
    }

    @RequestMapping("/todo-detail/{id}")
    public String showTodo(@PathVariable("id")  long id, Model model) {
        model.addAttribute("todo", todoRepository.findById(id).get());
        return "showtodo";
    }

    @RequestMapping("/todo-update/{id}")
    public String updateTodo(@PathVariable("id")  long id, Model model) {
        model.addAttribute("todo", todoRepository.findById(id).get());
        return "todoform";
    }

    @RequestMapping("/todo-delete/{id}")
    public String delTodo(@PathVariable("id")  long id) {
        todoRepository.deleteById(id);
        return "redirect:/";
    }
}
