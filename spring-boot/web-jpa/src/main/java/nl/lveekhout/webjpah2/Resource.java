package nl.lveekhout.webjpah2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Resource {
    @Autowired
    private Repository repository;

    @GetMapping
    public String test() {
        String res = "";
        for (MijnEntiteit e : repository.findAll()) {
            res += ", " + e.naam;
        }
        return res.substring(1);
    }
}
