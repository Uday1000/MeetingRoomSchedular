package meeting.schedular;

import java.util.ArrayList;
import java.util.List;

public class SchedularClass {

	private List<Meeting> meetings;

	public SchedularClass() {
		this.meetings = new ArrayList<>();
	}
	
	/**
	 * To schedule new meeting
	 * @param meeting
	 * @return true if the meeting is scheduled otherwise false if meet overlap to previous schedule meet
	 */
	public boolean scheduleMeeting(Meeting meeting) {
        for (Meeting meet : meetings) {
            if (isOverlapping(meet, meeting)) {
                return false;
            }
        }
        meetings.add(meeting);
        return true;
    }

    /**
     * @return to return all schedule meetings list
     */
    public List<Meeting> getScheduledMeetings() {
        return meetings;
    }

   
    /**
     * To validate two meetings is overlapping or not
     * @param meet1
     * @param meet2
     * @return true if meetings overlap , otherwise false
     */
    private boolean isOverlapping(Meeting meet1, Meeting meet2) {
        return meet1.getStart() < meet2.getEnd() && meet2.getStart() < meet1.getEnd();
    }
	
}
