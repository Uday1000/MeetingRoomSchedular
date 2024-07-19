package meeting.schedular;

public class Main {
	private static final String INVALID_TIME = "Invalid Time : ";

	public static void main(String[] args) {
		SchedularClass schedularClass = new SchedularClass();

		// Test valid meeting times
		Meeting meeting1 = new Meeting(1300, 1400);
		Meeting meeting2 = new Meeting(1100, 1200);
		Meeting meeting3 = new Meeting(1500, 1600);
		
		System.out.println("Meeting 1 -" + isMeetScheduled(schedularClass, meeting1));
		System.out.println("Meeting 2 -" + isMeetScheduled(schedularClass, meeting2));
		System.out.println("Meeting 3 -" + isMeetScheduled(schedularClass, meeting3));
		
		// Test overlapping meeting
		Meeting overlappingMeet = new Meeting(1430, 1530);
		System.out.println("OverlappingMeet -" + isMeetScheduled(schedularClass, overlappingMeet));
		

		// Display All scheduled meetings
		System.out.println(schedularClass.getScheduledMeetings());
		
		
		// Test Invalid meeting times
		try {
			Meeting invalidMeetTime1 = new Meeting(2400, 2500);
		}catch (IllegalArgumentException e) {
			System.out.println(INVALID_TIME+e.getMessage());
		}
		
		try {
			Meeting invalidMeetTime2 = new Meeting(1700, 1630);
		}catch (IllegalArgumentException e) {
			System.out.println(INVALID_TIME+e.getMessage());
		}

	}

	private static String isMeetScheduled(SchedularClass schedularClass, Meeting meeting) {
		return schedularClass.scheduleMeeting(meeting) == true ? " is scheduled":" is not scheduled.Due overlapping with already scheduled meeting";
	}
}
