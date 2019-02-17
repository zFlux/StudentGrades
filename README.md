[![Build Status](https://travis-ci.org/zFlux/StudentGrades.svg?branch=master)](https://travis-ci.org/zFlux/StudentGrades)

# Student Grades
This is a toy Spring Boot application to demonstrate persisting data to a file database (HSQL) via a web service that receives and responds in JSON. Data persistence happens on an HSQL database file populated with some example data.

**Setup**

1. Install Java v1.8 and Apache Maven >=3.5.4 
2. Download the source: 
```
git clone https://github.com/zFlux/StudentGrades
```
3. Build and run the project: 
```
mvn compile exec:java
```
4. That's it! See below for example requests


**Example curl GET requests**

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
