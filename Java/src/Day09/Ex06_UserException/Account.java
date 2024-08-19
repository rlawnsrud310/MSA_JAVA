package Day09.Ex06_UserException;

public class Account {

	private long balance;
	
	public Account() {
		
	}

	public long getValance() {
		return balance;
	}
	// 입금
	public void deposit(int money) {
		balance += money;
	}
	
	// 출금
	public void withdraw(int money) throws BalanceException {
		// (잔고) < (출금액)
		// - throw new ???Exception();
		if( balance < money) {
			// 예외 강제 발생
			// throws 
			throw new BalanceException("잔고가 부족합니다." + (money-balance));
		}
		balance -= money;
	}
	
	
}
