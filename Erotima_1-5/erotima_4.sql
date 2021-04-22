
INSERT INTO `private_school`.`trainers` (`firstname`, `lastname`, `Subject`) VALUES ( 'John', 'Moutzouris', 'Maths');
INSERT INTO `private_school`.`trainers` (`firstname`, `lastname`, `Subject`) VALUES ( 'Katerina', 'Sk', 'Maths1');
INSERT INTO `private_school`.`trainers` (`firstname`, `lastname`, `Subject`) VALUES ( 'Panagiotis', 'Sidiris', 'Maths2');

INSERT INTO `private_school`.`courses` (`title`, `stream`, `type`, `startdate`, `enddate`) VALUES ('Java', 'part', 'part', '2015-02-10', '2015-02-10');
INSERT INTO `private_school`.`courses` (`title`, `stream`, `type`, `startdate`, `enddate`) VALUES ('Java1', 'part', 'part', '2015-02-10', '2015-02-10');
INSERT INTO `private_school`.`courses` (`title`, `stream`, `type`, `startdate`, `enddate`) VALUES ('Java2', 'part', 'part', '2015-02-10', '2015-02-10');

INSERT INTO `private_school`.`assignments` ( `description`, `subDateTime`) VALUES ('maths', '2015-02-03 12:00');
INSERT INTO `private_school`.`assignments` ( `description`, `subDateTime`) VALUES ('History', '2015-02-03 12:0');
INSERT INTO `private_school`.`assignments` ( `description`, `subDateTime`) VALUES ('maths2', '2015-02-03 12:00');

INSERT INTO `private_school`.`students` (`firstName`, `lastName`, `dob`, `tuitionFees`) VALUES ('Bill', 'Moutzouris', '1987-10-14', '1000');
INSERT INTO `private_school`.`students` (`firstName`, `lastName`, `dob`, `tuitionFees`) VALUES ('Pablo ', 'Souza', '1987-12-08', '100');

INSERT INTO `private_school`.`trainers_courses` (`trainer_id`, `course_id`) VALUES ('1', '1');
INSERT INTO `private_school`.`trainers_courses` (`trainer_id`, `course_id`) VALUES ('2', '1');

INSERT INTO `private_school`.`assignments_courses` (`Course_id`, `assignment_id`) VALUES ('1', '1');
INSERT INTO `private_school`.`assignments_courses` (`Course_id`, `assignment_id`) VALUES ('1', '2');

INSERT INTO `private_school`.`students_courses` (`student_id`, `Course_id`) VALUES ('1', '1');
INSERT INTO `private_school`.`students_courses` (`student_id`, `Course_id`) VALUES ('2', '1');
INSERT INTO `private_school`.`students_courses` (`student_id`, `Course_id`) VALUES ('2', '2');

INSERT INTO `private_school`.`assignmentpercourseperstudent` ( `enrollment_id`,`assignment_id`, `oralMark`, `totalMark`) VALUES ('1', '1', '10', '100');
INSERT INTO `private_school`.`assignmentpercourseperstudent` (`enrollment_id`,`assignment_id`, `oralMark`, `totalMark`) VALUES ( '2','1', '10', '100');


