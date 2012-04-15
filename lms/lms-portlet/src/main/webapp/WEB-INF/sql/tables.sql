create table lms_ExamAnswer (
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	answers TEXT null,
	date_ DATE null,
	examConfigId LONG
);

create table lms_ExamConfig (
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	questions TEXT null,
	evaluator TEXT null
);