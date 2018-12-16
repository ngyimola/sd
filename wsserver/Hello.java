package wsserver;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(name = "Hello")
@SOAPBinding(style= SOAPBinding.Style.DOCUMENT)
public class Hello {
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
