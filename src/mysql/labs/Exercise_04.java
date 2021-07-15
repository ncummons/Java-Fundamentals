package mysql.labs;
import java.sql.*;


/*
*  MySQL Exercise 4:
*
*   Now that you have mastered your air travel database, it's time to connect this DB to a Java application
*   using JDBC. You can start simple here and build your way up. Within a Java application, using JDBC, please
*   demonstrate how to:
*
*   Note: CRUD means (Create, Read, Update, Delete)
*
*       1.) CRUD new flights
*       2.) CRUD new passengers
*       3.) Bonus: flex those JDBC muscles! How nice, clean, useful can you make this? Show us what you've got!
*
 */

public class Exercise_04 {

    public static void main(String[] args) {
        /*
        Just as a casual example - each of these operations should be in it's own method. Feel free to
        create all required classes/methods to accomplish this.

        createFlight(...);
        queryFlight(...);
        updateFlight(...);
        deleteFlight(...);

        createPassenger(...);
        queryPassenger(...);
        updatePassenger(...);
        deletePassenger(...);

        ...
         */

        int rowsAffected;
        Flight myFlight;
        Passenger myPassenger;

        rowsAffected = Flight.createFlight(7,"2021-07-15", "16:45:00", 3, 2, 5, 2, 1);
        System.out.println(rowsAffected);
        rowsAffected = Flight.updateFlightDateTime(7, "2021-07-16", "18:45:00");
        System.out.println(rowsAffected);
        myFlight = Flight.queryFlight(7);
        System.out.println(myFlight.toString());
        rowsAffected = Flight.deleteFlight(7);
        System.out.println(rowsAffected);

        rowsAffected = Passenger.createPassenger(10, "Economy", "Jude", "Laww", 42, 6, 5);
        System.out.println(rowsAffected);
        rowsAffected = Passenger.updatePassengerGroupTicket(10, "Jeremy", "Lewis");
        System.out.println(rowsAffected);
        myPassenger = Passenger.queryPassenger(10);
        System.out.println(myPassenger.toString());
        rowsAffected = Passenger.deletePassenger(10);
        System.out.println(rowsAffected);


    }
}

class Flight {

    private int flight_num;
    private String flight_date;
    private String flight_time;
    private int pilot_num;
    private int airline_num;
    private int plane_num;
    private int destination_airport_id;
    private int origin_airport_id;

    public static int createFlight(int flight_num, String flight_date,
                             String flight_time, int pilot_num, int airline_num, int plane_num,
                             int destination_airport_id, int origin_airport_id){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        // ResultSet resultSet = null; (kept here for reference)
        int x = 0;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            String connectionString = "jdbc:mysql://localhost/air_travel?"
                    + "user=root&password=p@ssw3rd"
                    + "&useSSL=false&allowPublicKeyRetrieval=true";
            connection = DriverManager.getConnection(connectionString);

            preparedStatement = connection.prepareStatement("insert into flights (flight_num, flight_date, " +
                    "flight_time, pilot_num, airline_num, plane_num, destination_airport_id, origin_airport_id)" +
                    " values (?, ?, ?, ?, ?, ?, ?, ?);");

            preparedStatement.setInt(1, flight_num);
            preparedStatement.setString(2, flight_date);
            preparedStatement.setString(3, flight_time);
            preparedStatement.setInt(4, pilot_num);
            preparedStatement.setInt(5, airline_num);
            preparedStatement.setInt(6, plane_num);
            preparedStatement.setInt(7, destination_airport_id);
            preparedStatement.setInt(8, origin_airport_id);
            x = preparedStatement.executeUpdate();

        } catch (SQLException exc) {
            System.out.println("Exception occurred");
            exc.printStackTrace();
        } catch (ClassNotFoundException e){
            System.out.println("Exception occurred - driver not found on classpath");
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                // resultSet.close(); (reference)
                connection.close();
                System.out.println("Flight created.");
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return x;

    }

    public static Flight queryFlight(int flight_num){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Flight flight = new Flight();

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            String connectionString = "jdbc:mysql://localhost/air_travel?"
                    + "user=root&password=p@ssw3rd"
                    + "&useSSL=false&allowPublicKeyRetrieval=true";
            connection = DriverManager.getConnection(connectionString);

            preparedStatement = connection.prepareStatement("select * from flights where flight_num = ?;");

            preparedStatement.setInt(1, flight_num);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println("flight number: " + resultSet.getInt("flight_num"));
                flight.flight_num = resultSet.getInt("flight_num");
                System.out.println("date of flight: " + resultSet.getString("flight_date"));
                flight.flight_date = resultSet.getString("flight_date");
                System.out.println("time of flight: " + resultSet.getString("flight_time"));
                flight.flight_time = resultSet.getString("flight_time");
                System.out.println("pilot number: " + resultSet.getInt("pilot_num"));
                flight.pilot_num = resultSet.getInt("pilot_num");
                System.out.println("airline number: " + resultSet.getInt("airline_num"));
                flight.airline_num = resultSet.getInt("airline_num");
                System.out.println("plane number: " + resultSet.getInt("plane_num"));
                flight.plane_num = resultSet.getInt("plane_num");
                System.out.println("destination airport id: " + resultSet.getInt("destination_airport_id"));
                flight.destination_airport_id = resultSet.getInt("destination_airport_id");
                System.out.println("origin airport id: " + resultSet.getInt("origin_airport_id"));
                flight.origin_airport_id = resultSet.getInt("origin_airport_id");
            }

        } catch (SQLException exc) {
            System.out.println("Exception occurred");
            exc.printStackTrace();
        } catch (ClassNotFoundException e){
            System.out.println("Exception occurred - driver not found on classpath");
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                resultSet.close();
                connection.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return flight;
    }

    public static int updateFlightDateTime(int flight_num, String flight_date, String flight_time){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        // ResultSet resultSet = null; (kept here for reference)
        int x = 0;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            String connectionString = "jdbc:mysql://localhost/air_travel?"
                    + "user=root&password=p@ssw3rd"
                    + "&useSSL=false&allowPublicKeyRetrieval=true";
            connection = DriverManager.getConnection(connectionString);

            preparedStatement = connection.prepareStatement("update flights set flight_date = ?, " +
                                                                 "flight_time = ? where flight_num = ?;");

            preparedStatement.setString(1, flight_date);
            preparedStatement.setString(2, flight_time);
            preparedStatement.setInt(3, flight_num);

            x = preparedStatement.executeUpdate();

        } catch (SQLException exc) {
            System.out.println("Exception occurred");
            exc.printStackTrace();
        } catch (ClassNotFoundException e){
            System.out.println("Exception occurred - driver not found on classpath");
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                // resultSet.close(); (reference)
                connection.close();
                System.out.println("Flight updated.");
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return x;

    }

    public static int deleteFlight(int flight_num){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        // ResultSet resultSet = null; (kept here for reference)
        int x = 0;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            String connectionString = "jdbc:mysql://localhost/air_travel?"
                    + "user=root&password=p@ssw3rd"
                    + "&useSSL=false&allowPublicKeyRetrieval=true";
            connection = DriverManager.getConnection(connectionString);

            preparedStatement = connection.prepareStatement("delete from flights where flight_num = ?;");

            preparedStatement.setInt(1, flight_num);

            x = preparedStatement.executeUpdate();

        } catch (SQLException exc) {
            System.out.println("Exception occurred");
            exc.printStackTrace();
        } catch (ClassNotFoundException e){
            System.out.println("Exception occurred - driver not found on classpath");
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                // resultSet.close(); (reference)
                connection.close();
                System.out.println("Flight deleted.");
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return x;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flight_num=" + flight_num +
                ", flight_date='" + flight_date + '\'' +
                ", flight_time='" + flight_time + '\'' + "\n" +
                ", pilot_num=" + pilot_num +
                ", airline_num=" + airline_num +
                ", plane_num=" + plane_num + "\n" +
                ", destination_airport_id=" + destination_airport_id +
                ", origin_airport_id=" + origin_airport_id +
                '}';
    }
}

class Passenger {

    private int passenger_num;
    private String passenger_class;
    private String first_name;
    private String last_name;
    private int age;
    private int group_num;
    private int ticket_num;

    public static int createPassenger(int passenger_num, String passenger_class,
                                      String first_name, String last_name, int age,
                                      int group_num, int ticket_num){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        // ResultSet resultSet = null;
        int x = 0;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            String connectionString = "jdbc:mysql://localhost/air_travel?"
                    + "user=root&password=p@ssw3rd"
                    + "&useSSL=false&allowPublicKeyRetrieval=true";
            connection = DriverManager.getConnection(connectionString);

            preparedStatement = connection.prepareStatement("insert into passengers (passenger_num, class," +
                    "first_name, last_name, age, group_num, ticket_num) values (?, ?, ?, ?, ?, ?, ?);");

            preparedStatement.setInt(1, passenger_num);
            preparedStatement.setString(2, passenger_class);
            preparedStatement.setString(3, first_name);
            preparedStatement.setString(4, last_name);
            preparedStatement.setInt(5, age);
            preparedStatement.setInt(6, group_num);
            preparedStatement.setInt(7, ticket_num);


            x = preparedStatement.executeUpdate();

        } catch (SQLException exc) {
            System.out.println("Exception occurred");
            exc.printStackTrace();
        } catch (ClassNotFoundException e){
            System.out.println("Exception occurred - driver not found on classpath");
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                // resultSet.close(); (reference)
                connection.close();
                System.out.println("Passenger created.");
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return x;
    }

    public static Passenger queryPassenger(int passenger_num){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Passenger passenger = new Passenger();

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            String connectionString = "jdbc:mysql://localhost/air_travel?"
                    + "user=root&password=p@ssw3rd"
                    + "&useSSL=false&allowPublicKeyRetrieval=true";
            connection = DriverManager.getConnection(connectionString);

            preparedStatement = connection.prepareStatement("select * from passengers where passenger_num = ?;");

            preparedStatement.setInt(1, passenger_num);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println("passenger number: " + resultSet.getInt("passenger_num"));
                passenger.passenger_num = resultSet.getInt("passenger_num");
                System.out.println("passenger class: " + resultSet.getString("class"));
                passenger.passenger_class = resultSet.getString("class");
                System.out.println("first name: " + resultSet.getString("first_name"));
                passenger.first_name = resultSet.getString("first_name");
                System.out.println("last name: " + resultSet.getString("last_name"));
                passenger.last_name = resultSet.getString("last_name");
                System.out.println("passenger age: " + resultSet.getInt("age"));
                passenger.age = resultSet.getInt("age");
                System.out.println("group number: " + resultSet.getInt("group_num"));
                passenger.group_num = resultSet.getInt("group_num");
                System.out.println("ticket number: " + resultSet.getInt("ticket_num"));
                passenger.ticket_num = resultSet.getInt("ticket_num");
            }

        } catch (SQLException exc) {
            System.out.println("Exception occurred");
            exc.printStackTrace();
        } catch (ClassNotFoundException e){
            System.out.println("Exception occurred - driver not found on classpath");
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                resultSet.close();
                connection.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return passenger;
    }

    public static int updatePassengerGroupTicket(int passenger_num, String first_name, String last_name){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        // ResultSet resultSet = null;
        int x = 0;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            String connectionString = "jdbc:mysql://localhost/air_travel?"
                    + "user=root&password=p@ssw3rd"
                    + "&useSSL=false&allowPublicKeyRetrieval=true";
            connection = DriverManager.getConnection(connectionString);

            preparedStatement = connection.prepareStatement("update passengers set first_name = ?, last_name = ?" +
                                                            " where passenger_num = ?;");

            preparedStatement.setInt(3, passenger_num);
            preparedStatement.setString(1, first_name);
            preparedStatement.setString(2, last_name);


            x = preparedStatement.executeUpdate();

        } catch (SQLException exc) {
            System.out.println("Exception occurred");
            exc.printStackTrace();
        } catch (ClassNotFoundException e){
            System.out.println("Exception occurred - driver not found on classpath");
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                // resultSet.close(); (reference)
                connection.close();
                System.out.println("Passenger updated.");
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return x;
    }

    public static int deletePassenger(int passenger_num){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        // ResultSet resultSet = null; (kept here for reference)
        int x = 0;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            String connectionString = "jdbc:mysql://localhost/air_travel?"
                    + "user=root&password=p@ssw3rd"
                    + "&useSSL=false&allowPublicKeyRetrieval=true";
            connection = DriverManager.getConnection(connectionString);

            preparedStatement = connection.prepareStatement("delete from passengers where passenger_num = ?;");

            preparedStatement.setInt(1, passenger_num);

            x = preparedStatement.executeUpdate();

        } catch (SQLException exc) {
            System.out.println("Exception occurred");
            exc.printStackTrace();
        } catch (ClassNotFoundException e){
            System.out.println("Exception occurred - driver not found on classpath");
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                // resultSet.close(); (reference)
                connection.close();
                System.out.println("Passenger deleted.");
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return x;
    }


    @Override
    public String toString() {
        return "Passenger{" +
                "passenger_num=" + passenger_num +
                ", passenger_class='" + passenger_class + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' + "\n" +
                ", age=" + age +
                ", group_num=" + group_num +
                ", ticket_num=" + ticket_num +
                '}';
    }
}