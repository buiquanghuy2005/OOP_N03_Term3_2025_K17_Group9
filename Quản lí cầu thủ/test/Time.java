package test;
public class Time {
    private int hour;
    private int minute;
    private int second;

    // Constructor nhận ba tham số
    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    // Phương thức hiển thị thời gian
    public void displayTime() {
        System.out.println(String.format("Time: %02d:%02d:%02d", hour, minute, second));
    }
}
