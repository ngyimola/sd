using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;

namespace ClientService
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "Client" in code, svc and config file together.
    // NOTE: In order to launch WCF Test Client for testing this service, please select Client.svc or Client.svc.cs at the Solution Explorer and start debugging.
    public class Client : IClient
    {
        public Client()
        {
        }

        public string GetData(int value)
        {
            return string.Format("You entered: {0}", value);
        }

        public CompositeType GetDataUsingDataContract(CompositeType composite)
        {
            if (composite == null)
            {
                throw new ArgumentNullException("composite");
            }
            if (composite.BoolValue)
            {
                composite.StringValue += "Suffix";
            }
            return composite;
        }

        public void AddUser(string userName, string password)
        {
            DBConnect dBConnect = new DBConnect();
            dBConnect.InsertUser(userName, password);
        } 

        string[] IClient.FindPackageById(int packageId)
        {
            DBConnect dBConnect = new DBConnect();
            return dBConnect.getPackageById(packageId);
        }

        List<string>[] IClient.GetSentPackages(int userId)
        {
            DBConnect dBConnect = new DBConnect();
            return dBConnect.getSentPackages(userId);
        }

        List<string>[] IClient.GetOrederedPackages(int userId)
        {
            DBConnect dBConnect = new DBConnect();
            return dBConnect.getOrderedPackages(userId);
        }

        string IClient.GetPathForPackage(int packageId)
        {
            DBConnect dBConnect = new DBConnect();
            return dBConnect.getPathForPackage(packageId);
        }
    }
}
