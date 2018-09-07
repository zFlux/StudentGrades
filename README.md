# Student Grades
This is a small Spring Boot application to demonstrate database persistence of relational 
data via a web service that receives and responds in JSON. Data persistence happens via 
an existing HSQL database file populated with some example data.

**Setup**

1. Download this source into Intellij, STS or Eclipse as a maven project
2. Build and run the StudentGradesApp class

**Example GET requests**

Retrieve all students and their related grades

```
curl --header "Content-Type: application/json" http://localhost:8080/student_records
```
Retrieve a specific student by student ID

```
curl --header "Content-Type: application/json" http://localhost:8080/student/UOT-001-1
```

Retrieve a specific grade by student ID

```
curl --header "Content-Type: application/json" http://localhost:8080/grade/UOT-001-1
```

**POST endpoints**

To add a grade, student or a set of student records, POST something similar to what is in the "examples" directory 
to these endpoints: 

```
http://localhost:8080/grade
http://localhost:8080/student
http://localhost:8080/student_records
```

Please feel free to modify this example!
