INSERT INTO `osk`.`student` (`STUDENT_ID`, `BIRTHDATE`, `EMAIL`, `FIRST_NAME`, `LAST_NAME`, `PHONE_NUMBER`) VALUES ('1', '2017-01-01', 'ww@ww.pl', 'jan', 'jan', '32');
INSERT INTO `osk`.`student` (`STUDENT_ID`, `BIRTHDATE`, `EMAIL`, `FIRST_NAME`, `LAST_NAME`, `PHONE_NUMBER`) VALUES ('2', '2012-01-01', 'ww@ww.pl', 'dzban', 'dzban', '33');


INSERT INTO `osk`.`teacher` (`TEACHER_ID`, `EMAIL`, `FIRST_NAME`, `LAST_NAME`, `PHONE_NUMBER`) VALUES ('1', 'ww@ww.pl', 'janek', 'kowalski', '442');
INSERT INTO `osk`.`teacher` (`TEACHER_ID`, `EMAIL`, `FIRST_NAME`, `LAST_NAME`, `PHONE_NUMBER`) VALUES ('2', 'ww@wsw,ok', 'murzyn', 'janusz', '4423');


INSERT INTO `osk`.`driving_lesson` (`LESSON_ID`, `LESSON_START_DAY`, `LESSON_START_TIME`, `LESSON_STOP_TIME`, `STUDENT_ID`, `TEACHER_ID`) VALUES ('1', '2018-04-12', '12:00:00', '14:00:00', '1', '2');
INSERT INTO `osk`.`driving_lesson` (`LESSON_ID`, `LESSON_START_DAY`, `LESSON_START_TIME`, `LESSON_STOP_TIME`, `STUDENT_ID`, `TEACHER_ID`) VALUES ('2', '2019-11-20', '14:00:00', '15:30:00', '2', '1');