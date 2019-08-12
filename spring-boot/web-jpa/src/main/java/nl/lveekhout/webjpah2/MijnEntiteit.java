package nl.lveekhout.webjpah2;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "MIJNENTITEIT")
public class MijnEntiteit implements Serializable {
    @Id
    public String naam;
}
