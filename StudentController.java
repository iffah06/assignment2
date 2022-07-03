package assign2;

import java.sql.*;

public class StudentController {

	private static StudentModel model = new StudentModel();
	private StudentView view;

	public StudentController(StudentModel model, StudentView view) {
		this.model = model;
		this.view = view;
	}

	public void read(int studentid) throws SQLException {
		// Connect to database
		Connection conn = null;
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?" +
                "user=root&password=iffah&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" );	

		// Create a statement to retrieve objects
		Statement s = conn.createStatement();

		// Retrieve results from the table
		ResultSet rs = s.executeQuery("select * from db1.student");

		// Print columns headers
		ResultSetMetaData rsmd = rs.getMetaData();
		int i = rsmd.getColumnCount();

		// Update data
		while(rs.next( ) ) { 
			for(int j=1; j<=i; j++) 
			{ 
				if(Integer.valueOf(rs.getString( 1)) == studentid) {
					if(j == 1)
						model.setID(Integer.valueOf(rs.getString(j)));
					else if(j == 2)
						model.setName(rs.getString( j));
					else if(j == 3)
						model.setDepartment(rs.getString( j));
					else if(j == 4)
						model.setMathMark(Double.valueOf(rs.getString(j)));
					else if(j == 5)
						model.setScienceMark(Double.valueOf(rs.getString(j)));
					else if( j==6)
						model.setEnglishMark(Double.valueOf(rs.getString(j)));
			}}
		}
		
		update();
	}

	public void update() {
		view.printStudentMarks(model.getID(), model.getName(), model.getDepartment(), model.getMathMark(),
				model.getScienceMark(), model.getEnglishMark());
	}

	public void save(int id, String name, String department, double math_mark, double science_mark, double english_mark)
			throws SQLException {

		Connection conn = null;
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?" +
                "user=root&password=iffah&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" );	

		// Create a statement to retrieve objects
		Statement s = conn.createStatement();

		s.executeUpdate("insert into db1.student values (" + id + ", '" + name + "', '" + department + "', " + math_mark
				+ ", " + science_mark + ", " + english_mark + ")");

	}

}
