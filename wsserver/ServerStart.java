package wsserver;

import dao.IPathDAO;
import dao.IUserDAO;
import dao.PathDAO;
import dao.UserDAO;
import entities.Path;
import entities.User;
import org.hibernate.cfg.Configuration;

import javax.xml.ws.Endpoint;
import java.util.List;

public class ServerStart {
    public static void main(String[] args) {
        String url = "http://localhost:9001/";
        //Endpoint.publish(url + "hello", new Hello());
        Endpoint ep = Endpoint.create(new Admin());
                ep.publish(url + "admin");
        System.out.println("Service started @ " + url);
    }
}
