package tech.codefinity.mysql.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/api/users")
public class UserController {
  @Autowired private UserRepository repository;

  @PostMapping(path = "/")
  public @ResponseBody String add(@RequestParam String name, @RequestParam String email) {
    User user = new User();

    user.setName(name);
    user.setEmail(email);

    repository.save(user);
    return "Added User";
  }

  @GetMapping(path = "/")
  public @ResponseBody Iterable<User> index() {
    return repository.findAll();
  }
}
