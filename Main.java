import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Code newCode = new Code(5);
        newCode.codeCreater();
        newCode.printCode();

    }
}

class Code {
    private Object[] data;

    public Code(int size) {
        data = new Object[size];
    }

    public void codeCreater() {
        Random random = new Random();
        for (int i = 0; i < data.length; i++) {// whole code
            int letterOrNumber = random.nextInt(3);// if its even its a number if odd its a letter
                if (letterOrNumber % 2 == 0){
                    int randomNumber = random.nextInt(10);
                    data[i] = randomNumber; // Assigning randomLetter to data array element
                }
                else {// letters
                    int randomNumber = random.nextInt(27);
                    char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
                            'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
                    for (int ii = 0; ii < randomNumber; ii++) {
                        data[i] =  alphabet[ii];
                    }

        }
    }
}

    public void printCode (){
        for (int x = 0; x < data.length; x++) {
            System.out.print(data[x]);
        }
    }

        }


