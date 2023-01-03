package kr.codesquad;


import java.util.*;

import static kr.codesquad.Lotto_Info.LOTTO_PRICE;

public class Main {
    public static int money, cnt;

    // todo list 1
    public static int retLottoCnt(int money) {
        return money / LOTTO_PRICE.getValue();
    }

    public static void buyLottoByMoney() {
        System.out.println("구입 금액을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        money = sc.nextInt();
        cnt = retLottoCnt(money);
        System.out.printf("%d개를 구매했습니다.\n", cnt);
    }

    public static void main(String[] args) {
        Jackpot_Handler jh = new Jackpot_Handler();
        Utility ut = new Utility();

        buyLottoByMoney();
        generateMyLottoByCount gm = new generateMyLottoByCount();
        gm.generate(cnt);
        jh.setJackpotNum();
        jh.searchJackpotsInMyLottoList(gm);
        ut.printProfit(jh.PRIZE_CNT, money);
    }
}
