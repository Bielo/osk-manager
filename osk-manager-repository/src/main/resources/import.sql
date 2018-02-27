INSERT INTO `osk`.`account` (`ACCOUNT_ID`, `EMAIL`, `PASSWORD`, `ROLE`) VALUES ('1', 'admin@admin.pl', 'admin', 'ROLE_ADMIN');
INSERT INTO `osk`.`account` (`ACCOUNT_ID`, `EMAIL`, `PASSWORD`, `ROLE`) VALUES ('2', 'kursant1@kursant.pl', 'kursant1', 'ROLE_STUDENT');
INSERT INTO `osk`.`account` (`ACCOUNT_ID`, `EMAIL`, `PASSWORD`, `ROLE`) VALUES ('3', 'kursant2@kursant.pl', 'kursant2', 'ROLE_STUDENT');
INSERT INTO `osk`.`account` (`ACCOUNT_ID`, `EMAIL`, `PASSWORD`, `ROLE`) VALUES ('4', 'instr1@instr.pl', 'instruktor1', 'ROLE_TEACHER');
INSERT INTO `osk`.`account` (`ACCOUNT_ID`, `EMAIL`, `PASSWORD`, `ROLE`) VALUES ('5', 'instr2@instr.pl', 'instruktor2', 'ROLE_TEACHER');
INSERT INTO `osk`.`account` (`ACCOUNT_ID`, `EMAIL`, `PASSWORD`, `ROLE`) VALUES ('6', 'instr3@instr.pl', 'instruktor3', 'ROLE_TEACHER');
INSERT INTO `osk`.`account` (`ACCOUNT_ID`, `EMAIL`, `PASSWORD`, `ROLE`) VALUES ('7', 'kursant3@kursant.pl', 'kursant3', 'ROLE_STUDENT');



INSERT INTO `osk`.`student` (`STUDENT_ID`, `BIRTHDATE`, `FIRST_NAME`, `LAST_NAME`, `PHONE_NUMBER`, `LATEST_VERSION`, `ACCOUNT_ID`) VALUES ('1', '1992-07-01', 'Wojciech', 'Mazurek', '0700880774', '0', '2');
INSERT INTO `osk`.`student` (`STUDENT_ID`, `BIRTHDATE`, `FIRST_NAME`, `LAST_NAME`, `PHONE_NUMBER`, `LATEST_VERSION`, `ACCOUNT_ID`) VALUES ('2', '1990-05-28', 'Mariusz', 'Pudzianowski', '666000888', '0', '3');
INSERT INTO `osk`.`student` (`STUDENT_ID`, `BIRTHDATE`, `FIRST_NAME`, `LAST_NAME`, `PHONE_NUMBER`, `LATEST_VERSION`, `ACCOUNT_ID`) VALUES ('3', '1992-02-23', 'Monica', 'Bellucci', '4243234', '0', '7');

INSERT INTO `osk`.`teacher` (`TEACHER_ID`, `FIRST_NAME`, `LAST_NAME`, `PHONE_NUMBER`, `LATEST_VERSION`, `ACCOUNT_ID`) VALUES ('1', 'Jakub', 'Kotyński', '666666666', '0', '4');
INSERT INTO `osk`.`teacher` (`TEACHER_ID`, `FIRST_NAME`, `LAST_NAME`, `PHONE_NUMBER`, `LATEST_VERSION`, `ACCOUNT_ID`) VALUES ('2', 'Mateusz', 'Gryzio', '458754268', '0', '5');
INSERT INTO `osk`.`teacher` (`TEACHER_ID`, `FIRST_NAME`, `LAST_NAME`, `PHONE_NUMBER`, `LATEST_VERSION`, `ACCOUNT_ID`) VALUES ('3', 'Jan', 'Dzban', '664445', '0', '6');

INSERT INTO `osk`.`driving_lesson` (`LESSON_ID`, `LESSON_START_DAY`, `LESSON_START_TIME`, `LESSON_STOP_TIME`, `STUDENT_ID`, `TEACHER_ID`) VALUES ('1', '2016-05-04', '11:00:00', '13:00:00', '1', '1');
INSERT INTO `osk`.`driving_lesson` (`LESSON_ID`, `LESSON_START_DAY`, `LESSON_START_TIME`, `LESSON_STOP_TIME`, `STUDENT_ID`, `TEACHER_ID`) VALUES ('2', '2015-02-05', '12:42:00', '15:22:33', '2', '2');
INSERT INTO `osk`.`driving_lesson` (`LESSON_ID`, `LESSON_START_DAY`, `LESSON_START_TIME`, `LESSON_STOP_TIME`, `STUDENT_ID`, `TEACHER_ID`) VALUES ('3', '2019-02-02', '11:23:00', '14:42:32', '1', '1');
INSERT INTO `osk`.`driving_lesson` (`LESSON_ID`, `LESSON_START_DAY`, `LESSON_START_TIME`, `LESSON_STOP_TIME`, `STUDENT_ID`, `TEACHER_ID`) VALUES ('4', '2019-11-12', '02:03:00', '23:00:22', '2', '2');
INSERT INTO `osk`.`driving_lesson` (`LESSON_ID`, `LESSON_START_DAY`, `LESSON_START_TIME`, `LESSON_STOP_TIME`, `STUDENT_ID`, `TEACHER_ID`) VALUES ('5', '2020-11-11', '12:12:12', '13:13:13', '1', '3');
INSERT INTO `osk`.`driving_lesson` (`LESSON_ID`, `LESSON_START_DAY`, `LESSON_START_TIME`, `LESSON_STOP_TIME`, `STUDENT_ID`, `TEACHER_ID`) VALUES ('6', '2021-12-12', '11:11:11', '12:12:12', '3', '3');
INSERT INTO `osk`.`driving_lesson` (`LESSON_ID`, `LESSON_START_DAY`, `LESSON_START_TIME`, `LESSON_STOP_TIME`, `STUDENT_ID`, `TEACHER_ID`) VALUES ('7', '2021-12-13', '11:11:11', '12:12:12', '3', '3');
