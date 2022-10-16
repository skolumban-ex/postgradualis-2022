public class Main {
    public static void main(String[] args) {
        boolean balKezesVagyok = false;
        int tojasokAHutoben = 55;
        int palacsintahozKelloTojasokSzama = 12;

        if (tojasokAHutoben < palacsintahozKelloTojasokSzama) {
            System.out.println("Tojast kell venni.");
        }

        System.out.println("Kezdodhet a sutes.");

        boolean fakanalJobbKezben;
        boolean fakanalBalKezben;
        boolean palacsintaSutoJobbKezben;
        boolean palacsintaSutoBalKezben;


        if (balKezesVagyok) {
            fakanalJobbKezben = true;
            fakanalBalKezben = false;
            palacsintaSutoJobbKezben = false;
            palacsintaSutoBalKezben = true;
        } else {
            fakanalJobbKezben = false;
            fakanalBalKezben = true;
            palacsintaSutoJobbKezben = true;
            palacsintaSutoBalKezben = false;
        }

        if (fakanalJobbKezben)
            System.out.println("Fakanal a jobb kezben.");

        if (fakanalBalKezben) {
            System.out.println("Fakanal a bal kezben.");
        }
        if (palacsintaSutoJobbKezben) {
            System.out.println("Palacsintasuto a jobb kezben.");
        } else if (palacsintaSutoBalKezben) {
            System.out.println("Palacsintasuto a jobb kezben.");
        } //else if (felt3) {
        //    ....
        // }


        int iSzulNap = 5;
        switch (iSzulNap){
            case 1:
                System.out.println("Hetfoi szuletes");
                break;
            case 2:
                System.out.println("Keddi szuletes");
                break;
            case 3:
                System.out.println("Szerdai szuletes");
                break;
            case 4:
            case 5:
            case 6:
            case 7:
                System.out.println("Piacnap utani nap.");
                break;
            default:
                System.out.println("Olyan nincs!");
                break;
        }

        // gyors elagazo ertekadas
        int iVevendoTojasokSzama;
        if (tojasokAHutoben < palacsintahozKelloTojasokSzama) {
            iVevendoTojasokSzama =
                    palacsintahozKelloTojasokSzama - tojasokAHutoben;
        }
        else{
            iVevendoTojasokSzama = 0;
        }

        int iVevendoTojasokSzama2 = (tojasokAHutoben < palacsintahozKelloTojasokSzama)?
                palacsintahozKelloTojasokSzama - tojasokAHutoben:
                0;

        System.out.println("Vege");
    }
}