package ATM;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ATM_testing {
    private ATM atm;

    @BeforeEach
    public void setUp() {
        atm = new ATM(100.0); // starting with $100
    }

    @Test
    public void testInitialBalance() {
        assertEquals(100.0, atm.checkBalance());
    }

    @Test
    public void testDeposit() {
        atm.deposit(50.0);
        assertEquals(150.0, atm.checkBalance());
    }

    @Test
    public void testWithdraw() {
        atm.withdraw(30.0);
        assertEquals(70.0, atm.checkBalance());
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            atm.withdraw(200.0);
        });
        assertEquals("Insufficient funds.", exception.getMessage());
    }

    @Test
    public void testNegativeDeposit() {
        Exception exception =
            assertThrows(IllegalArgumentException.class, () -> {
                atm.deposit(-20.0);
            });
        assertEquals("Deposit amount must be positive.", exception.getMessage());
    }

    @Test
    public void testNegativeWithdraw() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            atm.withdraw(-10.0);
        });
        assertEquals("Withdrawal amount must be positive.", exception.getMessage());
    }
}

