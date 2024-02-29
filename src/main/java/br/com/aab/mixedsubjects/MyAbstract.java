package br.com.aab.mixedsubjects;

public class MyAbstract {

    public static void main(String[] args) {
        MySonAbstract mySon = new MySonAbstract();
        mySon.execute();

        MyAbstract myAbstract = new MyAbstract();
        myAbstract.execute();

        MyAbstract myAbstract2 = new MySonAbstract();
        myAbstract2.execute();

    }
    void execute() {
        System.out.printf("execute() - %s %s %n",
                this.getClass().descriptorString(),
                this.getClass().getName());
    }
}

class MySonAbstract extends MyAbstract {

}

