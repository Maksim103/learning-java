package org.example.Tasks.MessageService;

public class Salary implements Sendable<Integer> {
    private final String from;
    private final String to;
    private final int content;

    public Salary(String from, String to, int content) {
        this.from = from;
        this.to = to;
        this.content = content;
    }

    @Override
    public String getFrom() {
        return from;
    }

    @Override
    public String getTo() {
        return to;
    }

    @Override
    public Integer getContent() {
        return content;
    }
}
