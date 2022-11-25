package Bus;

public class Bus {
    String busNum;
    int passenger;
    final int maxPassenger = 30;
    int fee = 1000;
    int gas;
    int speed;
    String status = "운행";

    Bus(String busNum){
        this.busNum = busNum;
    }

  public int gasStaus(int gas){
        this.gas += gas;
        return gas;
    }


    public String run(){
        if(this.gas > 0 && this.status.equals("운행")){
            status = "운행";
            return status;
        }else{
            status = "차고지행";
            return status;
        }
    }

    public String busStatus(int gas){
        this.gas = gas;
        if(this.gas == 0 && run() != "운행"){
            status = "차고지행";
            return status;
        } else if (0 < this.gas && this.gas < 10) {
            status ="주유가 필요합니다.";
            return status;
        } else{
            status = "운행 중";
            return status;
        }
    }

    public void setPassenger(int passenger){
        this.passenger = passenger;
        if(this.passenger <= maxPassenger && run() == "운행") {
            this.passenger += passenger;
            System.out.println("탑승이 가능합니다.");
        }else{
            System.out.println("최대 승객 수 초과");
        }
    }

    public int getFee(int passenger) {
        this.fee = fee * passenger;
        return fee;
    }

    public void getSpeed(int speed, int gas){
        this.gas = gas;
        if(this.gas < 10){
            System.out.println("주유 필요");
        }else {
            this.speed = speed;
        }
    }

    public static void main(String[] args) {
     Bus mybus = new Bus("a1111"); //차량 넘버 입력
     mybus.gasStaus(20); // 주유량 입력
     mybus.setPassenger(6); // 승객수 입력
     mybus.getSpeed(20, mybus.gas); //속력입력

        System.out.println("버스넘버 :" + mybus.busNum);
        System.out.println("탑승 승객 수: "+ mybus.passenger);
        System.out.println("잔여 승객 수: "+ (30 - mybus.passenger));
        System.out.println("요금 확인: " + mybus.getFee(mybus.passenger));
        System.out.println("주유량: " + mybus.gas);
        System.out.println("상태: " + mybus.busStatus(mybus.gas));

    }
}
