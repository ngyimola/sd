package wsserver;

import com.google.gson.Gson;
import com.sun.xml.bind.v2.runtime.reflect.Lister;
import dao.*;
import entities.Package;
import org.hibernate.cfg.Configuration;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import entities.Path;
import entities.User;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class Admin {
    /*
    private IPackageDAO packageDAO= new PackageDAO(new Configuration().configure().buildSessionFactory());
    private IUserDAO userDAO= new UserDAO(new Configuration().configure().buildSessionFactory());
    private IPathDAO pathDAO= new PathDAO(new Configuration().configure().buildSessionFactory());
*/

    private IPackageDAO packageDAO;
    private IUserDAO userDAO;
    private IPathDAO pathDAO;

    public Admin() {
        //SessionFactory factory = new Configuration().configure().buildSessionFactory();
        this.packageDAO= new PackageDAO(new Configuration().configure().buildSessionFactory());
        this.pathDAO= new PathDAO(new Configuration().configure().buildSessionFactory());
        this.userDAO= new UserDAO(new Configuration().configure().buildSessionFactory());
    }

    @WebMethod
    public Package addPackage(String userBySender, String userByReceiver, String name, String description, String senderCity, String destinationCity) {

        User sender = userDAO.getUser(Integer.parseInt(userBySender));
        User receiver = userDAO.getUser(Integer.parseInt(userByReceiver));
        Package pack = new Package(
                name,
                description,
                senderCity,
                destinationCity,
                (byte)0,
                sender,
                receiver);
        return packageDAO.addPackage(pack);
    }

    public void deletePackage(String id) {
        List<Path> paths = pathDAO.getAllPathsForPackage(Integer.parseInt(id));
        for (Path p: paths) {
            pathDAO.deletePath(p);
        }
        packageDAO.deletePackage(Integer.parseInt(id));
    }

    @WebMethod
    public void trackPackage(String id) {
        // get the package you want to track
        Package p = packageDAO.getPackage(Integer.parseInt(id));
        p.setTracking((byte) 1);

        // first path element will be the sending city and the current timestamp
        Path path = new Path(Timestamp.valueOf(LocalDateTime.now()), p.getSenderCity(), p);
        pathDAO.addPath(path);
        packageDAO.updatePackage(p);
    }

    @WebMethod
    public void addPath(String cityName, String packageID) {
        Package p = packageDAO.getPackage(Integer.parseInt(packageID));
        Path path = new Path(Timestamp.valueOf(LocalDateTime.now()), cityName, p);
        pathDAO.addPath(path);
    }

    @WebMethod
    public User loginControl(String username, String password) {
        return userDAO.loginUser(username, password);
    }

    @WebMethod
    public User addUser(String username, String password) {
        return userDAO.addUser(new User(username, password, (byte) 0));
    }

    @WebMethod
    public User getUser(String id) {

        return userDAO.getUser(Integer.parseInt(id));
    }

    @WebMethod
    public Package[] getAllPackages() {
        //ArrayList<Package> pack = new ArrayList<>(packageDAO.getAllPackages());
        //return pack;
        return packageDAO.getAllPackages().toArray(new Package[0]);
    }

    @WebMethod
    public User[] getAllUsers() {
        return userDAO.getAllUsers().toArray(new User[0]);
    }

    @WebMethod
    public void dummyOp() {
        userDAO.dummyOp();
    }

    @WebMethod
    public String getPathForPackage(String packageId) {
        List<Path> p = pathDAO.getAllPathsForPackage(Integer.parseInt(packageId));
        p.sort(Comparator.comparing(Path::getTimestamp));
        String path ="";
        int i = 1;
        for (Path j: p) {
            path += i + ". " + j.getCity() + " / " + j.getTimestamp().toString() + "\n";
            i++;
        }

        Package pack = packageDAO.getPackage(Integer.parseInt(packageId));
        if(p.get(i-2).getCity().equals(pack.getDestinationCity())) {
            path += "The package reached the desrination";
        }

        return path;
    }
}
