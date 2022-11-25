package Taxi;

public class Taxi {

    String TaxiNum;
    int passenger;
    int gas;
    int distance = 2;
    String dest = "서울역";
    int defaultDistance = 1;
    int defaultFee = 3000;
    int totalFee;
    int feePerDistance = 1000;
    String staus = "일반";

    Taxi(String TaxiNum){
        this.TaxiNum = TaxiNum;
    }

    public void gasStaus(int gas){
        this.gas += gas;
        if(this.gas<10){
            System.out.println("주유 필요");
        }
    }

    public String run(){

        if(this.gas >= 10 && this.passenger == 0){
            staus = "일반";
            return staus;
        } else if (this.gas >= 10 && 0<this.passenger) {
            staus = "운행 중";
            return staus;
        }
        else{
            staus = "운행불가";
            return staus;
        }
    }

    public String getPassenger(int passenger) {
        this.passenger = passenger;

        if(0 < passenger && passenger < 5) {
            return "운행중";
        } else {
            return "최대 승객 수 초과";
        }
    }

    public void overPrice() {
        if (this.distance > this.defaultDistance) {
            this.totalFee = (feePerDistance * (distance-1)) + defaultFee;
        }else{
            this.totalFee = defaultFee;
        }
    }

    public int payment(int totalFee){
        this.totalFee = totalFee;
        return totalFee;
    }

    public static void main(String[] args) {
        Taxi mytaxi = new Taxi("a1111"); //버스넘버 입력

        mytaxi.getPassenger(3); //승객 수 입력
        mytaxi.gasStaus(20); // 가스값 입력
        mytaxi.overPrice(); 


        System.out.println("택시넘버: "+ mytaxi.TaxiNum);
        System.out.println("승객수: "+mytaxi.passenger);
        System.out.println("잔여승객수: "+ (4-mytaxi.passenger) );
        System.out.println("목적지 :"+mytaxi.dest);
        System.out.println("목적지까지 거리: " +mytaxi.distance);
        System.out.println("지불할 요금: "+mytaxi.payment(mytaxi.totalFee));
        System.out.println("상태: "+ mytaxi.run());
        System.out.println("주유량: "+mytaxi.gas);

    }
}
