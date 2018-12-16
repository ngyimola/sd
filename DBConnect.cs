using System;
using System.Collections.Generic;
using MySql.Data.MySqlClient;
using System.Linq;
using System.Web;

namespace ClientService
{
    public class DBConnect
    {
        private MySqlConnection connection;
        private string server;
        private string database;
        private string uid;
        private string password;

        //Constructor
        public DBConnect()
        {
            Initialize();
        }

        //Initialize values
        private void Initialize()
        {
            server = "localhost";
            database = "packagetracking";
            uid = "root";
            password = "root";
            string connectionString;
            connectionString = "SERVER=" + server + ";" + "DATABASE=" + database + ";" + "UID=" + uid + ";" + "PASSWORD=" + password + ";";
            connection = new MySqlConnection("Data Source = localhost; port = 3306; Initial Catalog = packagetracking; User Id = root; password = root;CharSet=utf8");

            //connection = new MySqlConnection(connectionString);
        }

        //open connection to database
        private bool OpenConnection()
        {
            try
            {
                connection.Open();
                return true;
            }
            catch (MySqlException ex)
            {
                //When handling errors, you can your application's response based 
                //on the error number.
                //The two most common error numbers when connecting are as follows:
                //0: Cannot connect to server.
                //1045: Invalid user name and/or password.
                switch (ex.Number)
                {
                    case 0:
                        Console.WriteLine("Cannot connect to server.  Contact administrator");
                        break;

                    case 1045:
                            Console.WriteLine("Invalid username/password, please try again");
                        break;
                }
                return false;
            }
        }

        //Close connection
        private bool CloseConnection()
        {
            try
            {
                connection.Close();
                return true;
            }
            catch (MySqlException ex)
            {
                Console.WriteLine(ex.Message);
                return false;
            }
        }

        //Insert statement
        public void InsertUser(String username, String password)
        {
            string query = "INSERT INTO User (username, password, is_Admin) VALUES(" + "'" + username + "', '" + password +"', 0)";

            //open connection
            if (this.OpenConnection() == true)
            {
                //create command and assign the query and connection from the constructor
                MySqlCommand cmd = new MySqlCommand(query, connection);

                //Execute command
                cmd.ExecuteNonQuery();

                //close connection
                this.CloseConnection();
            }
        }

        //Select statement
        public string[] getPackageById(int packageId)
        {
            string query = "SELECT * FROM Package WHERE id = " + packageId;

            //Create a list to store the result
            List<List<string>> list = new List<List<string>>();

            //Open connection
            if (this.OpenConnection() == true)
            {
                //Create Command
                MySqlCommand cmd = new MySqlCommand(query, connection);
                //Create a data reader and Execute the command
                MySqlDataReader dataReader = cmd.ExecuteReader();

                //Read the data and store them in the list
                while (dataReader.Read())
                {
                    List<string> l = new List<string>();
                    l.Add(dataReader["id"] + "");
                    l.Add(dataReader["name"] + "");
                    l.Add(dataReader["description"] + "");
                    l.Add(dataReader["sender_city"] + "");
                    l.Add(dataReader["destination_city"] + "");
                    l.Add(dataReader["tracking"] + "");
                    l.Add(dataReader["sender"] + "");
                    l.Add(dataReader["receiver"] + "");
                    list.Add(l);
                }

                //close Data Reader
                dataReader.Close();

                //close Connection
                this.CloseConnection();

                //return list to be displayed
                return list.First().ToArray();
            }
            else
            {
                return list.First().ToArray();
            }
        }

        public List<string>[] getSentPackages(int userId)
        {
            string query = "SELECT * FROM Package p WHERE p.sender = " + userId;

            //Create a list to store the result
            List<List<string>> list = new List<List<string>>();

            //Open connection
            if (this.OpenConnection() == true)
            {
                //Create Command
                MySqlCommand cmd = new MySqlCommand(query, connection);
                //Create a data reader and Execute the command
                MySqlDataReader dataReader = cmd.ExecuteReader();

                //Read the data and store them in the list
                while (dataReader.Read())
                {
                    List<string> l = new List<string>();
                    l.Add(dataReader["id"] + "");
                    l.Add(dataReader["name"] + "");
                    l.Add(dataReader["description"] + "");
                    l.Add(dataReader["sender_city"] + "");
                    l.Add(dataReader["destination_city"] + "");
                    l.Add(dataReader["tracking"] + "");
                    l.Add(dataReader["sender"] + "");
                    l.Add(dataReader["receiver"] + "");
                    list.Add(l);
                }

                //close Data Reader
                dataReader.Close();

                //close Connection
                this.CloseConnection();

                //return list to be displayed
                return list.ToArray();
            }
            else
            {
                return list.ToArray();
            }
        }


        public List<string>[] getOrderedPackages(int userId)
        {
            string query = "SELECT * FROM Package WHERE receiver = " + userId;

            //Create a list to store the result
            List<List<string>> list = new List<List<string>>();

            //Open connection
            if (this.OpenConnection() == true)
            {
                //Create Command
                MySqlCommand cmd = new MySqlCommand(query, connection);
                //Create a data reader and Execute the command
                MySqlDataReader dataReader = cmd.ExecuteReader();

                //Read the data and store them in the list
                while (dataReader.Read())
                {
                    List<string> l = new List<string>();
                    l.Add(dataReader["id"] + "");
                    l.Add(dataReader["name"] + "");
                    l.Add(dataReader["description"] + "");
                    l.Add(dataReader["sender_city"] + "");
                    l.Add(dataReader["destination_city"] + "");
                    l.Add(dataReader["tracking"] + "");
                    l.Add(dataReader["sender"] + "");
                    l.Add(dataReader["receiver"] + "");
                    list.Add(l);
                }

                //close Data Reader
                dataReader.Close();

                //close Connection
                this.CloseConnection();

                //return list to be displayed
                return list.ToArray();
            }
            else
            {
                return list.ToArray();
            }
        }

        public string getPathForPackage(int packageId)
        {
            string query = "SELECT * FROM Path WHERE package_id = " + packageId;

            //Create a list to store the result
            List<List<string>> list = new List<List<string>>();
            
            //Open connection
            if (this.OpenConnection() == true)
            {
                //Create Command
                MySqlCommand cmd = new MySqlCommand(query, connection);
                //Create a data reader and Execute the command
                MySqlDataReader dataReader = cmd.ExecuteReader();

                //Read the data and store them in the list
                while (dataReader.Read())
                {
                    List<string> l = new List<string>();
                    l.Add(dataReader["id"] + "");
                    l.Add(dataReader["timestamp"] + "");
                    l.Add(dataReader["city"] + "");
                    list.Add(l);
                }

                List<List<string>> olist = list.OrderBy(o => o.ElementAt(1)).ToList();
                    
                //close Data Reader
                dataReader.Close();

                //close Connection
                this.CloseConnection();

                string returnString = "";

                int i = 1;

                //return list to be displayed
                foreach(List<string> li in olist)
                {
                    returnString += i + " / " + li[1] + " / " + li[2] + "\n";
                    i++;
                }

                string destCity = getPackageById(packageId)[4];

                if(olist.Last()[2].Equals(destCity))
                {
                    returnString += "The package reached it's destination.";
                }

                return returnString;
            }
            else
            {
                return "";
            }
        }

    }
}