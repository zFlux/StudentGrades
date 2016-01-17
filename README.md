# StudentGrades
This is a bare bones Spring Boot application to demonstrate database persistence via a web service.

To get set up:

1. Download this source into STS or eclipse as a maven project
2. Download HSQL (http://hsqldb.org/). 
3. Run the create table commands from the <b>setup</b> folder against the default HSQL database server
4. POST the example JSON from the <b>examples</b> folder to the endpoints localhost:8080/student_records, localhost:8080/student, localhost:8080/grade (using Content-Type: application/json)
5. Play around and modify this example
