package hellojpa;

        import java.util.Random;
        import java.util.Scanner;

class Play {
    Scanner sc = new Scanner(System.in);
    String num[] = new String[4];
    int totalWin = 0;
    int playCnt = 0;
    int maxCnt = 10;

    public void makeNum() {
        Random rd = new Random();
        num[0] = Integer.toString(rd.nextInt(9) + 1);

        String imsi = "";
        boolean check = true;
        for (int i = 1; i < num.length;) {
            imsi = Integer.toString(rd.nextInt(9) + 1);
            for (int j = 0; j < i; j++)	if(imsi.equals(num[j])) check = false;
            if(check)	num[i++] = imsi;
            else		check = true;
        }
    }

    public void game() {
        String checkImsiNum = "";
        String checkNum[] = new String[5];
        int checkCnt = 0;

        System.out.println("\n\nSTART GAME!\n");

        while(checkCnt++ < maxCnt) {
            int strike = 0;
            int ball = 0;

            System.out.print("INSERT 4 NUMBER(1 ~ 9)\nEX) 1234\n> ");
            checkImsiNum = sc.next();
            checkNum = checkImsiNum.split("");

            for (int i = 0; i < num.length; i++)
                for (int j = 0; j < checkNum.length; j++)
                    if(num[i].equals(checkNum[j])) {
                        if(i == j)	strike++;
                        else		ball++;
                    }

            if(strike == 4) {
                totalWin++;
                playCnt++;
                printResult(checkCnt);
                break;
            } else {
                System.out.println(strike + " S / " + ball + " B");
                if(checkCnt == maxCnt) {
                    System.out.print("\nYOU LOSE\nTHE ANSWER IS\n> ");
                    for (int i = 0; i < num.length; i++)	System.out.print(num[i]);
                    playCnt++;
                } else {
                    System.out.println("LEFT " + (maxCnt - checkCnt) + " CHANCE\n");
                }
            }
        }
    }

    public void printResult(int checkCnt) {
        System.out.println("\n\n@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("@@@@@@@@@ YOU WIN @@@@@@@@@");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("@@@@@@@ ONLY " + checkCnt + " TURN @@@@@@@");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@\n\n");

    }

    public void playGame(int playCnt) {
        while(this.playCnt != playCnt) {
            makeNum();
            game();
        }

        System.out.println("\n\n***************************\n******* best match! *******\n***************************\n\nGOOD BYE...");
    }
}




public class Baseball {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Play set = new Play();
        int cnt = 0;

        System.out.print("###########################\nDo you want to play a game?\n###########################\nYES : 1 / NO : 0\n> ");

        if(sc.nextInt() == 1) {
            System.out.print("\nHow many?\n1 ~ 10\n> ");
            cnt = sc.nextInt();

            if(cnt > 0 && cnt < 11)	set.playGame(cnt);
        } else	System.out.println("\n\nOK GOOD BYE...");
    }
}