import java.util.Scanner;

public class Main {

    // 재귀적으로 각 자리 숫자의 합을 구하는 메서드
    private static String isMultipleOfThree(String number) {
        // 재귀적으로 각 자리 숫자의 합을 구함
        if (number.length() == 1) {
            char lastDigit = number.charAt(0);
            // 3, 6, 9일 때는 3의 배수
            return (lastDigit == '0' || lastDigit == '3' || lastDigit == '6' || lastDigit == '9') ? "3의 배수" : "3의 배수가 아님";
        }
        
        String newNumber = "";
        for (char digit : number.toCharArray()) {
            newNumber += digit;
        }
        // 재귀적으로 다시 검사
        return isMultipleOfThree(newNumber);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 사용자로부터 숫자 입력받기
        System.out.print("숫자를 입력하세요: ");
        String number = scanner.nextLine();
        
        // 3의 배수인지 확인
        String result = isMultipleOfThree(number);
        
        // 결과 출력
        System.out.println(result);
        
        scanner.close();
    }
}
