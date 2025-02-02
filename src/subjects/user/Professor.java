package subjects.user;

import observer.IObserver;
import strategy.ILoanStrategy;

public class Professor extends User implements IObserver {
    static final int maxLoanDays = 4;
    private int notificationCount = 0;

    public Professor(String id, String name, ILoanStrategy loanStrategy) {
        super(id, name, loanStrategy, maxLoanDays);
    }

    @Override
    public boolean userOnLimit() {
        return false;
    }

    @Override
    public void update() {
        this.notificationCount++;
    }

    public int getNotificationCount() {
        return this.notificationCount;
    }
}
