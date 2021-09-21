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
            System.out.println("1.Actualizar id alumno\n2.Actualizar ciudad de alumno\n3.Actualizar ciudad visitada\n4.Eliminar alumno por ciudad\n5.Eliminar alumno por id");
            System.out.println("opcion: ");
            op=sc.nextInt();


            switch (op) {
                case 1:
                    int id;
                    String nombre;

                    System.out.println("Ingrese el nuevo id: ");
                    id=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ingrese el nombre del alumno a modificar: ");
                    nombre=sc.nextLine();

                    try {

                        Connection conn= DriverManager.getConnection(url, user, pwd);
                        Statement st= conn.createStatement();                                           
                        String psql="UPDATE Alumno SET ID='"+id +"' WHERE NOMBRE='"+nombre+"'";                                                
                        st.execute(psql);                                                                                                    
                        conn.close();                                                                                                        
                    }catch(SQLException e){                                                                                                  
                        System.out.println(e.getMessage());                                                                                  
                    }                                                                                                                        
                                                                                                        
                    break;

                case 2:
                    String ciudad;
                    sc.nextLine();
                    System.out.println("Ingrese la nueva ciudad: ");
                    ciudad=sc.nextLine();

                    System.out.println("Ingrese el nombre del alumno a modificar: ");
                    nombre=sc.nextLine();
                    try {

                        Connection conn= DriverManager.getConnection(url, user, pwd);
                        Statement st= conn.createStatement();
                        String psql="UPDATE Alumno SET CIUDADN='"+ ciudad +"' WHERE NOMBRE='"+nombre+"'";
                        st.execute(psql);
                        conn.close();
                    }catch(SQLException e){
                        System.out.println(e.getMessage());

                    }


                    break;
                case 3:

                    int x;
                    sc.nextLine();
                    System.out.println("Ingrese la nueva ciudad: ");
                    ciudad=sc.nextLine();

                    System.out.println("Ingrese el nombre del alumno a modificar: ");
                    nombre=sc.nextLine();
                    System.out.println("Ingrese el numero en el arreglo a modificar: ");
                    x=sc.nextInt();

                    try {

                        Connection conn= DriverManager.getConnection(url, user, pwd);
                        Statement st= conn.createStatement();
                        String psql="UPDATE Alumno SET CIUDADV["+x+"] ='"+ciudad +"' WHERE NOMBRE='"+nombre+"'";
                        st.execute(psql);
                        conn.close();
                    }catch(SQLException e){
                        System.out.println(e.getMessage());

                    }

                    break;
                case 4:

                    System.out.println("Ingrese el nombre del alumno a modificar: ");
                    nombre=sc.nextLine();

                    try {

                        Connection conn= DriverManager.getConnection(url, user, pwd);
                        Statement st= conn.createStatement();
                        String psql="DELETE FROM ALUMNO WHERE ALUMNO.NOMBRE='"+nombre+"'";
                        st.execute(psql);
                        conn.close();
                    }catch(SQLException e){
                        System.out.println(e.getMessage());
                    }

                    break;                                    



            }
        }while(op<=6);

        sc.close();
    }

}
