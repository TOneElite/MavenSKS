-- --------------------------------------------------------
SET MODE MSSQLServer;
--
-- Table structure for table `approved_tasks`
--

CREATE TABLE IF NOT EXISTS `approved_tasks` (
  `email` varchar(45) NOT NULL,
  `subject_code` varchar(45) NOT NULL,
  `task_nr` int(11) NOT NULL,
  `approved_date` date NOT NULL,
  `approved_by` varchar(45) NOT NULL,
  PRIMARY KEY (`email`,`subject_code`,`task_nr`)
);

-- --------------------------------------------------------

--
-- Table structure for table `permissions`
--

CREATE TABLE IF NOT EXISTS `permissions` (
  `rolename` varchar(45) NOT NULL,
  PRIMARY KEY (`rolename`)
);

-- --------------------------------------------------------

--
-- Table structure for table `queue`
--

CREATE TABLE IF NOT EXISTS `queue` (
  `queue_id` int(11) NOT NULL AUTO_INCREMENT,
  `subject_code` varchar(45) NOT NULL,
  `comment` varchar(100) DEFAULT NULL,
  `status` varchar(45) NOT NULL,
  `location` varchar(45) DEFAULT NULL,
  `timestamp` timestamp NOT NULL,
  PRIMARY KEY (`queue_id`)
);

-- --------------------------------------------------------

--
-- Table structure for table `queue_group`
--

CREATE TABLE IF NOT EXISTS `queue_group` (
  `queue_id` int(11) NOT NULL,
  `email` varchar(45) NOT NULL,
  `task_nr` int(11) NOT NULL,
  PRIMARY KEY (`queue_id`,`email`,`task_nr`)
);

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE IF NOT EXISTS `room` (
  `room_code` varchar(45) NOT NULL,
  `tablecount` int(11) NOT NULL,
  `picturelink` varchar(45) DEFAULT NULL,
  `description` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`room_code`)
);

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE IF NOT EXISTS `subject` (
  `subject_code` varchar(45) NOT NULL,
  `subject_name` varchar(45) NOT NULL,
  `status` int(4) NOT NULL,
  `nr_of_tasks` int(11) NOT NULL,
  `rulestring` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`subject_code`)
);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `email` varchar(45) NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `enabled` int(11) NOT NULL,
  `registerdate` date NOT NULL,
  PRIMARY KEY (`email`)
);

-- --------------------------------------------------------

--
-- Table structure for table `user_subject`
--

CREATE TABLE IF NOT EXISTS `user_subject` (
  `email` varchar(45) NOT NULL,
  `subject_code` varchar(45) NOT NULL,
  `rolename` varchar(45) NOT NULL,
  PRIMARY KEY (`email`,`subject_code`,`rolename`)
);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `approved_tasks`
--
ALTER TABLE `approved_tasks`
  ADD CONSTRAINT `approved_tasks_subjectCode_fk` FOREIGN KEY (`approved_by`) REFERENCES `user_subject` (`email`);
ALTER TABLE approved_tasks
  ADD CONSTRAINT `approved_tasks_user_subject_fk` FOREIGN KEY (`email`, `subject_code`) REFERENCES `user_subject` (`email`, `subject_code`);

--
-- Constraints for table `queue`
--
ALTER TABLE `queue`
  ADD CONSTRAINT `queue_subject_code_fk` FOREIGN KEY (`subject_code`) REFERENCES `subject` (`subject_code`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `queue_group`
--
ALTER TABLE `queue_group`
  ADD CONSTRAINT `queue_tasks_queue_id_fk` FOREIGN KEY (`queue_id`) REFERENCES `queue` (`queue_id`) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE queue_group
  ADD CONSTRAINT `queue_tasks_email_fk` FOREIGN KEY (`email`) REFERENCES `users` (`email`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `user_subject`
--
ALTER TABLE `user_subject`
  ADD CONSTRAINT `user_subject_rolename_fk` FOREIGN KEY (`rolename`) REFERENCES `permissions` (`rolename`) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE user_subject
  ADD CONSTRAINT `user_subject_email_fk` FOREIGN KEY (`email`) REFERENCES `users` (`email`) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE user_subject
  ADD CONSTRAINT `user_subject_subject_code_fk` FOREIGN KEY (`subject_code`) REFERENCES `subject` (`subject_code`) ON DELETE NO ACTION ON UPDATE NO ACTION;