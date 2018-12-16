package dao;

import java.util.List;
import entities.*;

public interface IPathDAO {

    boolean addPath(Path path);

    Path getPath(int id);

    List<Path> getAllPathsForPackage(int packageID);

    void deletePath(Path p);
}
