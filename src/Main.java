import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String url ="jdbc:postgresql://localhost:5432/postgres";
        String user="postgres";
        String pwd= "steven";

        Scanner sc= new Scanner(System.in);
        int op;
        do{
            System.out.println("1.Agregar alumno\n2.Actualizar ciudad de alumno\n3.Actualizar ciudad visitada\n4.Eliminar alumno\n5.Actualizar id\n6.Visualizar tabla alumnos");
            System.out.println("opcion: ");
            op=sc.nextInt();


            switch (op) {
                case 1:

                    try {

                        Connection conn= DriverManager.getConnection(url, user, pwd);
                        Statement st= conn.createStatement();
                        String psql="INSERT INTO Alumno(ID, NOMBRE, SEXO, EDAD,CIUDADN, CIUDADV)VALUES(203462, 'alfredo', 'masculino', 18, 'chiapas', '{cdmx, puebla}'),(203423, 'cesar', 'masculino', 18, 'chiapas', '{morelia, chiapas, cdmx}'),(203424, 'gabo', 'masculino', 18, 'edomex', '{chiapas, cdmx}'),(203426, 'steven', 'masculino', 18, 'chiapas', '{chiapas, cdmx}'),(203404, 'alejandro', 'masculino', 18, 'tabasco', '{tabasco, chiapas}')";
                        st.execute(psql);
                        conn.close();
                    }catch(SQLException e){
                        System.out.println(e.getMessage());
                    }

                    break;


                case 2:
                    try {

                        Connection conn= DriverManager.getConnection(url, user, pwd);
                        Statement st= conn.createStatement();
                        String psql="UPDATE Alumno SET CIUDADN='CDMX' WHERE NOMBRE='steven'";
                        st.execute(psql);
                        conn.close();
                    }catch(SQLException e){
                        System.out.println(e.getMessage());

                    }


                    break;
                case 3:
                    try {
                        Connection conn= DriverManager.getConnection(url, user, pwd);
                        Statement st= conn.createStatement();
                        String psql="UPDATE Alumno SET CIUDADV[1] ='tabasco' WHERE NOMBRE='steven'";
                        st.execute(psql);
                        conn.close();
                    }catch(SQLException e){
                        System.out.println(e.getMessage());

                    }

                    break;
                case 4:

                    try {

                        Connection conn= DriverManager.getConnection(url, user, pwd);
                        Statement st= conn.createStatement();
                        String psql="DELETE FROM ALUMNO WHERE ALUMNO.NOMBRE='steven'";
                        st.execute(psql);
                        conn.close();
                    }catch(SQLException e){
                        System.out.println(e.getMessage());
                    }

                    break;

                case 5:
                    try {

                        Connection conn= DriverManager.getConnection(url, user, pwd);
                        Statement st= conn.createStatement();
                        String psql="UPDATE Alumno SET ID='123' WHERE NOMBRE='cesar'";
                        st.execute(psql);
                        conn.close();
                    }catch(SQLException e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case 6:
                    try {

                        Connection conn= DriverManager.getConnection(url, user, pwd);
                        Statement st= conn.createStatement();
                        String psql="Select * from alumno";
                        ResultSet result= st.executeQuery(psql);
                        while (result.next()){
                            System.out.println(result.getString(1) );
                        }
                        conn.close();
                    }catch(SQLException e){
                        System.out.println(e.getMessage());
                    }

                    break;
            }
        }while(op<=7);

        sc.close();
    }

}
