package org.example.Tasks.MessageService;

import java.util.*;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<Sendable<T>> {
    private final Map<String, List<T>> mailBox = new HashMap<>() {
        @Override
        public List<T> get(Object key) {
            return super.getOrDefault(key, Collections.emptyList());
        }
    };

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }

    @Override
    public void accept(Sendable<T> sendable) {
        if (mailBox.containsKey(sendable.getTo())) {
            List<T> list = mailBox.get(sendable.getTo());
            list.add(sendable.getContent());

            mailBox.put(sendable.getTo(), list);
        } else {
            List<T> list = new ArrayList<>();
            list.add(sendable.getContent());

            mailBox.put(sendable.getTo(), list);
        }
    }
}

