package meeting.schedular;

public class Meeting {
	
	private int start;
	private int end;

	public Meeting(int start, int end) throws IllegalArgumentException {
		if (!isValidTime(start) || !isValidTime(end)) {
			throw new IllegalArgumentException("Start and end times must be in 24-hour format (0000 to 2359).");
		}
		if (start >= end) {
			throw new IllegalArgumentException("Start time must be earlier than end time");
		}
		this.start = start;
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	private boolean isValidTime(int time) {
		if (time < 0 || time > 2359) {
			return false;
		}
		int hours = time / 100;
		int minutues = time % 100;
		return hours >= 0 && hours < 24 && minutues >= 0 && minutues < 60;
	}

	@Override
	public String toString() {
		return "Meeting [start=" + start + ", end=" + end + "]";
	}

}
