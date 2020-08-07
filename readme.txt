Thai Bui, 824642670
Time spent on this project: 7 hours
Description: This program helps create and display schedule for a day by chronologically organizing them. 
	     It will issue a warning if the user tries to add an activity that conflicts with other tasks 
	     in the schedule. The program can also be used in helping student adding new course in their schedule.
Summary:+AbstractActivity: an abstract class that has name of the task you want to add, the time it starts,ends, and
			   setter,getter methods, and constructor. It also has an abstract String method name HowLong.
	+Activity: this class extends the abstract class above. It has a variable to store the duration of an activity, an getter method, 
		   and constructor. This class override the method HowLong and returns a string that informs the user about an activity's duration.
		   It also has method name add that basically assist me in creating the schedule.
	+Schedule: an interface that has two methods name AddToSchedule and Generate.
	+Daily: this class implements the interface above. It has the day of a schedule, an activity that needs to be considered, two static linked list that store the start
		time and end time of an activity if we add it to the schedule and one last static Linked List that stores an activity in if it is qualified. 
		Beside from the getter, setter methods, and the constructor, this class has a method name isConflict that return false if an activity does not conflict
		with any other activities in the schedule and returns true if opposite. This class also overrides the two methods of the interface it implements.
		It also implements an sorting algorithm to chronologically organize the schedule.
	+Display: this class is used to display a schedule after the user done adding activity.
	+UnitTest: There are four tests in this class. The first test is used to check what happens if the user tries to add an time-conflict activity to the schedule.
		   The second test checks the size of the schedule after the user finishes adding activities. The third test checks the sorting algorithm and the fourth
		   test checks if the binary search method works.
	+ScheduleDEMO: this class prompts the user to create the schedule for any day and displays it on the screen.          
				