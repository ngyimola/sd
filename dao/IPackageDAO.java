package dao;

import java.util.List;
import entities.Package;

public interface IPackageDAO {

    public List<Package> getAllPackages();

    public Package getPackage(int id);

    public void updatePackage(Package pack);

    public void deletePackage(int id);

    public Package addPackage(Package pack);
}
