
use private_school;


-- A list of all the students
select * from students ;

-- A list of all the trainers
select * from trainers ;


-- A list of all the assignments
select * from assignments ;


-- A list of all the courses
select * from courses ;


-- all the students per course

SELECT Students.* FROM students_courses INNER JOIN students on students_courses.Course_id=1 and  students_courses.student_id=students.student_id;

-- all the trainers  per course
SELECT trainers.* FROM trainers INNER JOIN trainers_courses on trainers_courses.Course_id=1 and  trainers_courses.trainer_id=trainers.trainer_id;

-- all the assignments per course
SELECT assignments.* FROM assignments INNER JOIN assignments_courses on assignments_courses.Course_id=1 and  assignments_courses.assignment_id=assignments.assignment_id;



-- All the assignments per course per student
select  st.student_id, st.firstName,st.lastName, st.dob, assign.description, assign.subDateTime , assign_per_course.oralMark, assign_per_course.totalMark 
from assignments assign
inner join   assignmentpercourseperstudent  assign_per_course on assign_per_course.enrollment_id=1 and assign_per_course.assignment_id=assign.assignment_id
inner join students_courses  st_courses on assign_per_course.enrollment_id=st_courses.enrollment_id
inner join students  st on st.student_id=st_courses.student_id;

-- A list of students that belong to more than one courses

SELECT students.student_id, students.firstName,students.lastName FROM students  INNER JOIN students_courses ON students.student_id = students_courses.student_id GROUP BY students.student_id HAVING COUNT(students_courses.Course_id) > 1;